/** The entry point of the application 
 * @author Zaid Ajaj - s4807561
 */
public class Multiply extends BinaryOperation
{
    public Multiply(Expression leftOperand, Expression rightOperand)
    {
        super(leftOperand, rightOperand, BinaryOperationType.Multiply);
    }

    @Override
    public String toString()
    {
        return "(" + leftOperand.toString() + " * " + rightOperand.toString() + ")";
    }
}