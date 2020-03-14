import static java.lang.System.out;
import java.util.Random;

public class Test {

    public  static  final  Random     rand = new  Random  ();
    public  static  final  int         NOF_POLYLINES = 10;

    public static void main(String[] args)
    {
        Polyline []     polylines = new  Polyline[NOF_POLYLINES ];
        for (int i = 0; i < NOF_POLYLINES; i++)
            polylines[i] = randomPolyline  (); // makes 10 polylines

        out.println(randomPolyline());
    }

    public static Point randomPoint()
    {
        String     n = "" + (char) (65 + rand.nextInt  (26));
        int     x = rand.nextInt  (11); //bound exclusive therefore only to ten
        int     y = rand.nextInt  (11);
        return  new  Point (n, x, y);
    }

    public static Polyline randomPolyline()
    {
        Polyline poly = new Polyline();
        for(int x = 0; x < 10; x++)
        {
            poly.addLast(randomPoint());
        }
        return poly;
    }
}
