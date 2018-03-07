import java.lang.*;

/** The entry point of the application 
 * @author Zaid Ajaj - s4807561
 */
public class Constant extends Expression 
{
    public final double value;

    public Constant(double value)
    {
        this.value = value;
    }

    public boolean isConstant() 
    {
        return true;
    }

    public boolean isVariable() 
    {
        return false;
    }

    public boolean isUnaryOperation() 
    {
        return false;
    }

    @Override
    public String toString()
    {
        return "" + value;
    }
}