/** The entry point of the application 
 * @author Zaid Ajaj - s4807561
 */
public class BinaryOperation extends Expression 
{
    public final Expression leftOperand;
    public final Expression rightOperand;
    public final BinaryOperationType operation; 

    public BinaryOperation(Expression leftOperand, Expression rightOperand, BinaryOperationType operation)
    {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operation = operation;
    }

    public boolean isConstant() 
    {
        return false;
    }

    public boolean isVariable()
    {
        return false;
    }

    public boolean isUnaryOperation() 
    {
        return false;
    }
}