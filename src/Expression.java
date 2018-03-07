/** The entry point of the application 
 * @author Zaid Ajaj - s4807561
 */
public abstract class Expression 
{
    abstract boolean isConstant();
    abstract boolean isVariable();
    abstract boolean isUnaryOperation();
}