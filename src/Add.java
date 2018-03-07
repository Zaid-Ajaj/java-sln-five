/** The entry point of the application 
 * @author Zaid Ajaj - s4807561
 */
public class Add extends BinaryOperation 
{
    public Add(Expression leftOperand, Expression rightOperand)
    {
        super(leftOperand, rightOperand, BinaryOperationType.Add);
    }

    @Override
    public String toString()
    {
        return "(" + leftOperand.toString() + " + " + rightOperand.toString() + ")";
    }
}