/**
 * Created by IntelliJ IDEA.
 * User: Justin Arieltan
 * Date: 2017-11-09
 * Time: 08:29
 * To change this template use File | Settings | File Templates.
 */
import static java.lang.Math.*;

//collections of formulas to calculate things related to triangle
public class Triangle
{
    //Triangle area from input base and height
    public static double triangleAreaLA(double length, double altitude)
    {
        return(length * altitude) / 2;
    }// redundant ish

    //Triangle perimeter from input 3 sides
    public static double trianglePerimeter3Sides(double side1, double side2, double side3)
    {
        return side1 + side2 + side3;
    }

    //Triangle area from input 3 sides
    public static double triangleArea3Sides(double a, double b, double c)
    {
        /*double a = side1;
        double b = side2;
        double c = side3; */ //redundant

        double s = ((a + b + c) / 2);

        //return pow(s * (s - a) * (s - b) * (s - c), (1 / 2)); // issue because int division no decimal can be fixed with 1.0/2
        //return pow(s * (s - a) * (s - b) * (s - c), 0.5);
        return sqrt(s * (s - a) * (s - b) * (s - c));
    }

    /*//Triangle bisector from input 2 sides and angle
    public static double triangleBisector2SidesAngle(double b, double c, double angle)
    {
        /*double b = side1;
        double c = side2;//redundant

        return(2 * b * c * cos(angle / 2) / (b + c));
    }*/

    //Angle from input 2 sides
    public static double triangleAngle2Sides (double adj, double hyp)
    //cah cos a = adj/hyp
    {
        return cos(adj / hyp);
    }

    //Triangle median from input
    //public static double triangleMedian

    //Triangle bisector from input 2 sides
    public static double triangleBisector2Sides(double b, double c)
    {
        double angle = triangleAngle2Sides(b, c);

        return(2 * b * c * cos(angle / 2) / (b + c));
    }// redundant ish

    //Triangle bisector length
    public static double triangleBisectorLength2Sides(double a, double b, double c)
    {
        return (sqrt((b * c) / pow(b + c, 2) * (pow(b + c, 2) - pow(a, 2))));
        //check proof wiki length of angle bisector
    }// redundant ish

    //Triangle circumcircle radius from input 3 sides
    public static double triangleCircumcircle(double a, double b, double c)
    {
        return((a * b * c) / sqrt((a + b + c) * (b + c - a) * (c + a - b) * (a + b - c)));
        //check math open reference circumcircle of a triangle
    }

    //Triangle incricle radius from input 3 sides
    public static double triangleIncircle(double a, double b, double c)
    {
        double area = triangleArea3Sides(a, b, c);

        double perimeter = trianglePerimeter3Sides(a, b, c);
        double s = perimeter / 2;

        return area / s;
    }
}
