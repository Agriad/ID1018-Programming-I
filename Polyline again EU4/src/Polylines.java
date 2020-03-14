public class Polylines {
    public static Polyline findShortestYellow(Polyline[] polylines) {
        int nofPolyline = polylines.length;
        Polyline shortest = null;

        double min = 0;
        for(int x = 0; x < nofPolyline; x++)
        {
            if(polylines[x].getColour().equals("yellow"))
            {
                double dist = polylines[x].length();
                //double min = 0;
                if(shortest == null)
                {
                    dist = polylines[x].length();
                    shortest = polylines[x];
                    min = dist;
                }
                if(min > dist)
                {
                    min = dist;
                    shortest = polylines[x];
                }
            }
        }

        /*int nofPolyline = polylines.length;
        Polyline shortest = polylines[0];
        //String minName = polylines[0].toString();
        double minDist = polylines[0].length();// bad if the first one is smaller than the smallest yellow
        //double minDist = 0;

        for (int x = 0; x < nofPolyline; x++)// fixed the issue
        {
            if (polylines[x].getColour().equals("yellow")) {
                minDist = polylines[x].length();
                break;
            }
        }

        double sum = 0;
        for (int x = 0; x < nofPolyline; x++)//goes through polyline
        {
            //double sum = 0;
            if (polylines[x].getColour().equals("yellow"))//checks if it is yellow
            {
                sum = polylines[x].length();

                /*for(int y = 0; y < polylines[x].getVertices().length; y++)
                {
                    sum += polylines[x].length();
                }

                if (sum < minDist) {
                    shortest = polylines[x];
                }
            }

        }*/

        return shortest;
    }
}
