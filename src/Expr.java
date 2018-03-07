import java.util.*;
import java.lang.*;

/** The entry point of the application 
 * @author Zaid Ajaj - s4807561
 */
public class Expr
{
    public static Expression Const(double value)
    {
        return new Constant(value);
    }

    public static Expression Add(Expression left, Expression right)
    {
        return new Add(left, right);
    }

    public static Expression Mul(Expression left, Expression right)
    {
        return new Multiply(left, right);
    }

    public static Expression Var(String name)
    {
        return new Variable(name);
    }

    public static Expression Neg(Expression operand)
    {
        return new Negate(operand);
    }

    public static Expression Sqrt(Expression operand)
    {
        return new SquareRoot(operand);
    }

    /** Tries to evaluate the given expression using the provided store of variables. 
     * Returns empty if evaluation fails, for example when evaluating sqrt(-1)  */
    public static Optional<Double> Evaluate(Expression expr, HashMap<String, Double> store)
    {
        if (expr.isConstant())
        {
            Constant constant = (Constant)expr; 
            return Optional.of(constant.value); 
        }
        else if (expr.isVariable())
        {
            Variable var = (Variable)expr; 
            
            if (!store.containsKey(var.variableName))
            {
                // store does not contain the given variable
                // fail
                return Optional.empty();
            }

            double value = store.get(var.variableName);
            return Optional.of(value);
        }
        else if (expr.isUnaryOperation())
        {
            UnaryOperation unaryOperation = (UnaryOperation)expr;
            Expression innerExpr = unaryOperation.operand; 

            if (unaryOperation.unaryOperationType == UnaryOperationType.Negate)
            {
                // Negation is simply multiplication
                return Evaluate(Mul(Const(-1.0), innerExpr), store);
            }
            else /* if (unaryOperation.unaryOperationType == UnaryOperationType.SquareRoot) */
            {
                // evaluate inner expression and if the result is negative then fail
                Optional<Double> evaluatedInnerExpr = Evaluate(innerExpr, store);
                if (!evaluatedInnerExpr.isPresent() || evaluatedInnerExpr.get() < 0) 
                {
                    // fail
                    return Optional.empty();
                }
                
                // now return the square root
                Double innerExprValue = evaluatedInnerExpr.get();
                return Optional.of(Math.sqrt(innerExprValue));
            }
        }
        else 
        {
            BinaryOperation binaryOperation = (BinaryOperation)expr; 
            // evaluate inner left and right operands and then apply the operation
            // fail if either operands have failed
            Optional<Double> evaluatedLeftOperand = Evaluate(binaryOperation.leftOperand, store);
            Optional<Double> evaluatedRightOperand =  Evaluate(binaryOperation.rightOperand, store);
            
            if (!evaluatedLeftOperand.isPresent() || !evaluatedRightOperand.isPresent())
            {
                return Optional.empty(); 
            }

            Double leftOperandValue = evaluatedLeftOperand.get();
            Double rightOperandValue = evaluatedRightOperand.get();

            if (binaryOperation.operation == BinaryOperationType.Add)
            {
                return Optional.of(leftOperandValue + rightOperandValue);
            }
            else /* if (binaryOperation.operation == Operation.Multiply) */ 
            { 
                return Optional.of(leftOperandValue * rightOperandValue);
            }
        }
    }
}