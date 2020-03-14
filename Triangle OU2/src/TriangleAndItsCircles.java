/**
 * Created by IntelliJ IDEA.
 * User: Justin Arieltan
 * Date: 2017-11-09
 * Time: 10:11
 * To change this template use File | Settings | File Templates.
 */
import java.util.*;
import static java.lang.System.*;

public class TriangleAndItsCircles
{
    public static void main (String [] args)
    {
        //intro
        out.println("Welcome to the triangle incircle and circumcircle calculator");
        out.println("Please type in the triangle's length with numbers");

        //input of 3 sides
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);
        out.print("Side 1: ");
        double side1 = in.nextDouble();

        out.print("Side 2: ");
        double side2 = in.nextDouble();

        out.print("Side 3: ");
        double side3 = in.nextDouble();

        //calculation
        double r1 = Triangle.triangleCircumcircle(side1, side2, side3);
        double r2 = Triangle.triangleIncircle(side1, side2, side3);

        //output
        out.println("The radius of the circumcircle is: " + r1 + " l.u");
        out.println("The radius of the incircle is: " + r2 + " l.u");

        //check using wolfram alpha ((/s)circle of triangle with sides x, y, z)
        //can't check if triangle or not

        /*for(int i = 0; i < 3; i++)
        {
            out.println("");
        }*/
    }
}
