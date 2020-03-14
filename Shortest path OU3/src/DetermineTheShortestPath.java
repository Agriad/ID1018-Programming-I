import static java.lang.System.out;
import java.util.Scanner;

public class DetermineTheShortestPath
{
    public static void main(String [] args)
    {
        // intro input

        //out.println("Welcome to the ");
        out.println("Please input the amount of station(s) U in zone 2: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        out.println("Please input the amount of station(s) V in zone 3: ");
        int m = in.nextInt();
        out.println("Please input the distances between the stations" + System.lineSeparator());

        //out.println("Welcome to the ");
        /*out.println("n value: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        out.println("m value: ");
        int m = in.nextInt();*/
        // change input method

        double[] dist1 = new double[n];
        double[][] dist2 = new double[n][m];
        double[] dist3 = new double[m];

        for(int x = 0; x < n; x++)
        {
            out.println("Distance X to U" + (x + 1) + ": ");
            dist1[x] = in.nextDouble();
        }// x to u distances

        for(int x = 0; x < n; x++)
        {
            for(int y = 0; y < m; y++)
            {
                out.println("Distance U" + (x + 1) + " to V" + (y + 1) + ": ");
                dist2[x][y] = in.nextDouble();
            }
        }//u to v distances

        for(int x = 0; x < m; x++)
        {
            out.println("Distances V" + (x + 1) + " to Y: ");
            dist3[x] = in.nextDouble();
        }

        // calculation
        double shortestPath = TheShortestPath.length(dist1, dist2, dist3); //kinda redundant
        int[] shortestStations = TheShortestPath.intermediateStations(dist1, dist2, dist3);

        // output
        out.println("The shortest path is X to U" + shortestStations[0] + " to V" + shortestStations[1] + " to Y");
        out.println("The shortest distance is: " + shortestPath + " l.u");
        out.println("Safe travels!");
    }
}
