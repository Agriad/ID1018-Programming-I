/**
 * Created by IntelliJ IDEA.
 * User: Justin Arieltan
 * Date: 2017-11-09
 * Time: 09:00
 * To change this template use File | Settings | File Templates.
 */
import static java.lang.System.*;
import java.util.*;

//3 prerequisites to create packages. IDE makes it easier

public class Test
{
    public static void main (String [] args)
    {
        Scanner in = new Scanner(System.in);

        out.println("length: ");
        double length = in.nextDouble();

        out.println("altitude: ");
        double altitude = in.nextDouble();

        out.println("side 1: ");
        double side1 = in.nextDouble();

        out.println("side 2: ");
        double side2 = in.nextDouble();

        out.println("side 3: ");
        double side3 = in.nextDouble();

        //Triangle tri = new Triangle();
        out.println("Area: " + Triangle.triangleAreaLA(length, altitude));

        out.println("Perimeter: " + Triangle.trianglePerimeter3Sides(side1, side2, side3));

        out.println("Area: " + Triangle.triangleArea3Sides(side1, side2, side3));

        //out.println("Bisector 1: " + Triangle.triangleBisector2SidesAngle());
    }
}

