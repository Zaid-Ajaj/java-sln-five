/** The entry point of the application 
 * @author Zaid Ajaj - s4807561
 */
public class Negate extends UnaryOperation
{
    public Negate(Expression operand)
    {
        super(operand, UnaryOperationType.Negate);
    }

    @Override
    public String toString()
    {
        return "(-" + operand.toString() + ")";
    }
}