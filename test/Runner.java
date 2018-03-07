import java.lang.*;
import java.util.*;

public class Runner 
{
    public static void main(String[] args)
    {
        Test.Case("Testing works", () ->
        {
            Test.AreEqual(1, 1);
        });

        Test.Report();
    }
}