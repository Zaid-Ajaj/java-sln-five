/** The entry point of the application 
 * @author Zaid Ajaj - s4807561
 */
public class SquareRoot extends UnaryOperation
{
    public SquareRoot(Expression operand)
    {
        super(operand, UnaryOperationType.SquareRoot);
    }

    @Override
    public String toString()
    {
        return "sqrt(" + operand.toString() + ")";
    }
}