import java.util.Random;
import static java.lang.System.out;

public class Test {

    public static Random rand = new Random();
    public static final int NOF_POLYLINES = 10;

    public  static  Point  randomPoint  ()//makes random point
    {
        String     n = "" + (char) (65 + rand.nextInt  (26));
        int     x = rand.nextInt  (11); //bound exclusive therefore only to ten from 0
        int     y = rand.nextInt  (11);
        return  new  Point (n, x, y);
    }

    public  static  VPolyline  randomVPolyline  () //needs to make 1 polyline
    {
//  Create  an empty  polyline  and  add  vertices
        VPolyline     polyline = new  VPolyline(); //can i just use vpolyline??
        int     nofVertices = 2 + rand.nextInt  (7);
        int     nofSelectedVertices = 0;
        boolean []     selectedNames = new  boolean [26]; // use this to check if letter is used
// Two  vertices  can  not  have  the  same  name
        Point     chosenPoint = null;
        char      chosenChar = 0;

        while (nofSelectedVertices  < nofVertices) //adds random amount of points in polyline
        {
            Point point = randomPoint();

            int pos = point.getName().charAt(0) - 65; //converts name to value to check with boolean array

            if(selectedNames[pos] == false)//if random point has different name than the previous points, add the point and mark it else reroll.
            {
                polyline.add(point);
                selectedNames[pos] = true;
                nofSelectedVertices++;
            }

            nofSelectedVertices++;
        }
//  Assign a colour

        int colorPicker = rand.nextInt(3);
        String[] colorChooser = {"blue", "red", "yellow"};
        polyline.setColour(colorChooser[colorPicker]);

        return polyline;
    }

    public  static  NPolyline  randomNPolyline  () //needs to make 1 polyline
    {
//  Create  an empty  polyline  and  add  vertices
        NPolyline     polyline = new  NPolyline(); //can i just use vpolyline??
        int     nofVertices = 2 + rand.nextInt  (7);
        int     nofSelectedVertices = 0;
        boolean []     selectedNames = new  boolean [26]; // use this to check if letter is used
// Two  vertices  can  not  have  the  same  name
        Point     chosenPoint = null;
        char      chosenChar = 0;

        while (nofSelectedVertices  < nofVertices) //adds random amount of points in polyline
        {
            Point point = randomPoint();

            int pos = point.getName().charAt(0) - 65; //converts name to value to check with boolean array

            if(selectedNames[pos] == false)//if random point has different name than the previous points, add the point and mark it else reroll.
            {
                polyline.add(point);
                selectedNames[pos] = true;
                nofSelectedVertices++;
            }

            nofSelectedVertices++;
        }
//  Assign a colour

        int colorPicker = rand.nextInt(3);
        String[] colorChooser = {"blue", "red", "yellow"};
        polyline.setColour(colorChooser[colorPicker]);

        return polyline;
    }

    /*public  static  Polyline  randomPolyline  () //needs to make 1 polyline
    {
//  Create  an empty  polyline  and  add  vertices
        Polyline     polyline = new  Polyline(); //can i just use vpolyline??
        int     nofVertices = 2 + rand.nextInt  (7);
        int     nofSelectedVertices = 0;
        boolean []     selectedNames = new  boolean [26]; // use this to check if letter is used
// Two  vertices  can  not  have  the  same  name
        Point     chosenPoint = null;
        char      chosenChar = 0;

        while (nofSelectedVertices  < nofVertices) //adds random amount of points in polyline
        {
            Point point = randomPoint();

            int pos = point.getName().charAt(0) - 65; //converts name to value to check with boolean array

            if(selectedNames[pos] == false)//if random point has different name than the previous points, add the point and mark it else reroll.
            {
                polyline.add(point);
                selectedNames[pos] = true;
                nofSelectedVertices++;
            }

            nofSelectedVertices++;
        }
//  Assign a colour

        int colorPicker = rand.nextInt(3);
        String[] colorChooser = {"blue", "red", "yellow"};
        polyline.setColour(colorChooser[colorPicker]);

        return polyline;
    }*/

    public static void main(String[] args)
    {
        int ammount = rand.nextInt(10) + 1;
        boolean[] nameCheck = new boolean[26];
        Point[] points = new Point[ammount];

        int x1 = 0;
        int name = 0;
        String nameString = "";
        while(x1 < ammount)
        {
            name = rand.nextInt(26);
            nameString = Character.toString((char) (name + 97));
            if(!nameCheck[name])// checking the wrong thing change if [x1]
            {
                //name = rand.nextInt(27);
                //nameString = Character.toString((char) (name + 97));
                points[x1] = new Point(nameString.toUpperCase(), rand.nextInt(51), rand.nextInt(51));
                nameCheck[name] = true;
                x1++;
            }
        }

        VPolyline vPolyline = new VPolyline(points);
        out.println(vPolyline);
        out.println("length: " + vPolyline.length());

        Polyline  polyline = null;
        //comment out depending on test
          //polyline = new  VPolyline  (points); // (1)
          polyline = new  NPolyline  (points); // (2)

        for (Point  vertex : polyline)
        {
            System.out.println (vertex );
        }

        out.println(polyline);
        out.println("getVertices: " + polyline.getVertices());
        out.println("getColour: " + polyline.getColour());
        out.println("getWidth: " + polyline.getWidth());
        out.println("length: " + polyline.length());

        out.println("color test");
        vPolyline.setColour("blue");
        polyline.setColour("blue");
        out.println("V " + vPolyline.getColour());
        out.println("N " + polyline.getColour());

        out.println("width test");
        vPolyline.setWidth(2);
        polyline.setWidth(2);
        out.println("V " + vPolyline.getWidth());
        out.println("N " + polyline.getWidth());

        Point point1 = new Point("A", 0, 0);
        Point point2 = new Point("B", 1, 1);
        Point point3 = new Point("C", 5, 3);
        Point point4 = new Point("D" , 8 ,1);
        Point point5 = new Point("E", 2, 3);

        Point[] newPoints = {point1, point2, point3};

        NPolyline newNPolyline = new NPolyline(newPoints);
        VPolyline newVPolyline = new VPolyline(newPoints);

        out.println(newVPolyline);
        out.println(newNPolyline);

        newVPolyline.add(point4);
        newNPolyline.add(point4); //issue

        out.println(newVPolyline);
        out.println(newNPolyline);

        newVPolyline.insertBefore(point5, "B");
        newNPolyline.insertBefore(point5, "B");

        out.println(newVPolyline);
        out.println(newNPolyline);

        newVPolyline.remove("C");
        newNPolyline.remove("C");

        out.println(newVPolyline);
        out.println(newNPolyline);

        out.println("start");

        newVPolyline.insertBefore(point3, "A");
        newNPolyline.insertBefore(point3, "A");

        out.println(newVPolyline);
        out.println(newNPolyline);

        newVPolyline.remove("C");
        newNPolyline.remove("C");

        out.println(newVPolyline);
        out.println(newNPolyline);

        /*NPolyline test = new NPolyline();

        test.add(point1);
        test.add(point2);

        out.println(test);*/

        for (Point  vertex : newNPolyline)
        {
            System.out.println (vertex );
        }

        VPolyline []     vPolylines = new  VPolyline[NOF_POLYLINES ];
        for (int i = 0; i < NOF_POLYLINES; i++)
            vPolylines[i] = randomVPolyline  (); // makes 10 polylines

        NPolyline[] nPolylines = new NPolyline[NOF_POLYLINES];
        for (int i = 0; i < NOF_POLYLINES; i++)
            nPolylines[i] = randomNPolyline  ();

        /*NPolyline[] nPolylines = new NPolyline[NOF_POLYLINES];
        for (int i = 0; i < NOF_POLYLINES; i++) {
            nPolylines[i] = NPolyline(randomVPolyline().getVertices());
            //Point[] pointTest = randomVPolyline().getVertices();
            //out.println(pointTest);
            for (int j = 0; j < pointTest.length; j++) {
                //nPolylines[i].add(pointTest[j]);
                nPolylines[i]
                out.println(pointTest[j]);
            }
        }
        for (int i = 0; i < NOF_POLYLINES; i++)
        {
            Point[] tempPoints = randomVPolyline().getVertices();
            Point[] pointsTemp = new Point[tempPoints.length];
            for (int j = 0; j < tempPoints.length; j++)
            {
                out.println(tempPoints[j]);
                //pointsTemp[j] = tempPoints[j];
                //out.println(pointsTemp[j]);
            }
        }*/


        Polyline[] pnPolyline = new Polyline[NOF_POLYLINES];
        for(int x = 0; x < NOF_POLYLINES; x++)
        {
            pnPolyline[x] = nPolylines[x];
        }

        Polyline[] pvPolyline = new Polyline[NOF_POLYLINES];
        for(int x = 0; x < NOF_POLYLINES; x++)
        {
            //pvPolyline[x] = vPolylines[x];
            pvPolyline[x] = vPolylines[x];
        }

        Polyline[] pbPolyline = new Polyline[NOF_POLYLINES];
        for(int x = 0; x < NOF_POLYLINES / 2; x++)
        {
            pbPolyline[x] = pnPolyline[x];
        }
        for(int x = NOF_POLYLINES - 1; x >= NOF_POLYLINES / 2; x--)
        {
            pbPolyline[x] = pvPolyline[x];
        }

        out.println(vPolylines);
        out.println("vpolylines");
        for(int i = 0; i < vPolylines.length; i++)
        {
            out.println(vPolylines[i]);
        }

        out.println("shortest yellow vpolyline");
        Polyline ans1 = Polylines.findShortestYellow(pvPolyline);
        out.println(ans1);

        out.println(nPolylines);
        out.println("npolylines");
        for(int i = 0; i < nPolylines.length; i++)
        {
            out.println(nPolylines[i]);
        }

        out.println("shortest yellow npolyline");
        Polyline ans2 = Polylines.findShortestYellow(pnPolyline);
        out.println(ans2);

        out.println(pbPolyline);
        out.println("pbpolyline");
        for(int i = 0; i < pbPolyline.length; i++) {
            out.println(pbPolyline[i]);
        }

        out.println("shortest yellow of first 5 elements of npolyline and last 5 of vpolyline");
        Polyline ans3 = Polylines.findShortestYellow(pbPolyline);
        out.println(ans3);
    }
}
