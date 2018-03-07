/** The entry point of the application 
 * @author Zaid Ajaj - s4807561
 */
public class Variable extends Expression 
{
    public final String variableName; 

    public Variable(String variableName)
    {
        this.variableName = variableName;
    }

    public boolean isConstant() 
    {
        return false;
    }

    public boolean isVariable()
    {
        return true;
    }

    public boolean isUnaryOperation() 
    {
        return false;
    }

    @Override
    public String toString()
    {
        return variableName;
    }
}