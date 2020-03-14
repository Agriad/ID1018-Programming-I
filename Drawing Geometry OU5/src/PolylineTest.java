import static java.lang.System.out;

public class PolylineTest {
    public static void main(String[] args)
    {
        //making a new polyline
        Point p1 = new Point("A", 3, 4);
        Point p2 = new Point("B", 5, 6);
        Point p3 = new Point("C", 8, 2);

        Point[] points = {p1, p2, p3};

        Polyline poly1 = new Polyline(points);

        //printing the polyline
        out.println(poly1);
        Point[] vertices = poly1.getVertices();
        for(int x = 0; x < vertices.length; x++)
        {
            out.println(vertices[x]);
        }
        out.println(poly1.getColour());
        out.println(poly1.getWidth());
        out.println(poly1.length());

        //changing the polyline
        poly1.setColour("Blue");
        out.println(poly1.getColour());
        poly1.setWidth(2);
        out.println(poly1.getWidth());

        Point p4 = new Point("D", 11, 19);
        poly1.addLast(p4);
        out.println(poly1);

        Point p5 = new Point("E", 0, 0);
        poly1.addBefore(p5, "A");
        out.println(poly1);

        Polyline.PolylineIterator poly1Iter = poly1.new PolylineIterator();

        out.println(poly1Iter);
        out.println(poly1Iter.hasVertex());
        out.println(poly1Iter.vertex());

        for(int x = 0; x < poly1.getVertices().length; x++)// add one to length to get false for the next
        {
            out.println(poly1Iter.hasVertex());
            out.println(poly1Iter.vertex());
            poly1Iter.advance();
        }

        poly1.remove("A");
        out.println(poly1);

        //out.println(poly1.getVertices().length);
    }
}
