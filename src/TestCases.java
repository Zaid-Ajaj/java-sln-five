import java.util.*;
import java.lang.*;

/** The entry point of the application 
 * @author Zaid Ajaj - s4807561
 */
public class TestCases 
{
    static void log(String input) 
    {
        System.out.println(input);
    }

    public static void Run()
    {
        HashMap<String, Double> store = new HashMap();
        store.put("a", 3.0);
        store.put("b", 2.0);
        store.put("x", -1.5);

        ArrayList<Expression> expressions = new ArrayList();

        expressions.add(Expr.Const(1.0));
        expressions.add(Expr.Mul(Expr.Var("a"), Expr.Var("b"))); // a * b
        expressions.add(Expr.Neg(Expr.Mul(Expr.Const(-5.0), Expr.Const(-5.0)))); // -(-5 * -5)
        expressions.add(Expr.Add(Expr.Const(-1.0), Expr.Const(10))); // -1.0 + 10
        expressions.add(Expr.Sqrt(Expr.Const(100))); // sqrt(100)
        expressions.add(Expr.Sqrt(Expr.Var("x"))); // sqrt(x) = sqrt(-1.5) = invalid
        
        log("a = 3.0");
        log("b = 2.0");
        log("x = -1.5");
        log("============");
        for (Expression expr : expressions)
        {
            Optional<Double> result = Expr.Evaluate(expr, store);
            String resultStr = result.isPresent() ? "" + result.get() : "<invalid>";
            log(expr.toString() + " = " + resultStr);
        }
    }
}