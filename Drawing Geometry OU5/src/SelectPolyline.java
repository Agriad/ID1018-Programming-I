import java.util.Random;
import static java.lang.System.out;

class  SelectPolyline
{
    public  static  final  Random     rand = new  Random  ();
    public  static  final  int         NOF_POLYLINES = 10;
    public  static  void  main (String [] args)
    {
//  Create a random  number  of  polylines
        Polyline []     polylines = new  Polyline[NOF_POLYLINES ];
        for (int i = 0; i < NOF_POLYLINES; i++)
            polylines[i] = randomPolyline  (); // makes 10 polylines
// Show  the  polylines
//  Determine  the  shortest  yellow  polyline
// Show  the  selected  polyline

        //showing the polylines created.
        out.println("The polylines are: ");
        for(int x = 0; x < NOF_POLYLINES; x++)
        {
            out.println(polylines[x]);
        }

        String minName = polylines[0].toString();
        double minDist = polylines[0].length();// bad if the first one is smaller than the smallest yellow
        //double minDist = 0;

        for(int x = 0; x < NOF_POLYLINES; x++)// fixed the issue
        {
            if(polylines[x].getColour().equals("yellow"))
            {
                minDist = polylines[x].length();
                break;
            }
        }

        double sum = 0;
        for(int x = 0; x < NOF_POLYLINES; x++)//goes through polyline
        {
            //double sum = 0;
            if(polylines[x].getColour().equals("yellow"))//checks if it is yellow
            {
                sum = polylines[x].length();

                /*for(int y = 0; y < polylines[x].getVertices().length; y++)
                {
                    sum += polylines[x].length();
                }*/
                if(sum < minDist)
                {
                    minName = polylines[x].toString();
                }
            }
            /*if(sum < minDist)
            {
                minName = polylines[x].toString();
            }*/
        }

        out.print("\n");
        //out.println();
        out.println("Shortest yellow polyline is: ");
        out.println(minName);
    }
    // The  randomPoint  method  returns a new  Point  with a name
//  randomly  chosen  from  the  single  letters A--Z. Coordinates
// are  random.
    public  static  Point  randomPoint  ()//makes random point
    {
        String     n = "" + (char) (65 + rand.nextInt  (26));
        int     x = rand.nextInt  (11); //bound exclusive therefore only to ten from 0
        int     y = rand.nextInt  (11);
        return  new  Point (n, x, y);
    }
    // The  method  randomPolyline  returns a random  polyline ,
// with a colour  either  blue , red , or  yellow. The  names
// of the  vertices  are  single  letters  from  the  set A--Z.
// Two  vertices  can  not  have  the  same  name.
    public  static  Polyline  randomPolyline  () //needs to make 1 polyline
    {
//  Create  an empty  polyline  and  add  vertices
        Polyline     polyline = new  Polyline  ();
        int     nofVertices = 2 + rand.nextInt  (7);
        int     nofSelectedVertices = 0;
        boolean []     selectedNames = new  boolean [26]; // use this to check if letter is used
// Two  vertices  can  not  have  the  same  name
        Point     chosenPoint = null;
        char      chosenChar = 0;

        while (nofSelectedVertices  < nofVertices) //adds random amount of points in polyline
        {
            Point point = randomPoint();
            //int pos = Character.getNumericValue(point.getName().charAt(0)); // just use (int) 'A'
            // it's doing 'A' = char - 48;
            int pos = point.getName().charAt(0) - 65; //converts name to value to check with boolean array

            /*System.out.println(point.getName());
            System.out.println(point.getName().charAt(0));
            System.out.println(pos);*/

            if(selectedNames[pos] == false)//if random point has different name than the previous points, add the point and mark it else reroll.
            {
                polyline.addLast(point);
                selectedNames[pos] = true;
                nofSelectedVertices++;
            }

            nofSelectedVertices++;

            //previous terrible implementation attempt
            /*for(int x = 0; x < nofVertices; x++)
            {
                Point point = randomPoint();
                String name = point.getName();
                char letter = (name.charAt(0));
                int value = letter - 65;

                if(selectedNames[value])

                for(int y = 0; y < x + 1; y++)
                {
                    if()
                }

            }

            polyline.addLast(randomPoint());

            nofSelectedVertices++;*/
        }
//  Assign a colour
        /*int colorPicker = rand.nextInt(3);
        String[] colorChooser = {"blue", "red", "yellow"};
        polyline.setColour(colorChooser[colorPicker]);*/

        int colorPicker = rand.nextInt(3);
        String[] colorChooser = {"blue", "red", "yellow"};
        polyline.setColour(colorChooser[colorPicker]);

        return polyline;
    }
}