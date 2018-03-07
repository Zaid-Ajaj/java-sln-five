/** The entry point of the application 
 * @author Zaid Ajaj - s4807561
 */
public class UnaryOperation extends Expression
{
    public final Expression operand;
    public final UnaryOperationType unaryOperationType; 

    public UnaryOperation(Expression operand, UnaryOperationType unaryOperationType)
    {
        this.operand = operand;
        this.unaryOperationType = unaryOperationType;
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
        return true;
    }
}