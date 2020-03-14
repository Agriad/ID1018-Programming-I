import java.util.Iterator;

//public  class  VPolyline //i need to implement Polyline for it to work
public  class  VPolyline implements Polyline
{
    private  Point[]     vertices;
    private  String      colour = "black";
    private  int          width = 1;
    public  VPolyline  ()
    {
        this.vertices = new  Point [0];
    }


    public  VPolyline (Point []  vertices)
    {
        this.vertices = new  Point[vertices.length ];
        for (int i = 0; i < vertices.length; i++)
            this.vertices[i] = new  Point (vertices[i]);
    }

    @Override //Overrides Object.toString so that it prints out the polyline contents.
    public  String  toString  ()
    {
        StringBuilder sbPoints = new StringBuilder();

        for(int x = 0; x < vertices.length; x++)
        {
            sbPoints.append("(" + vertices[x] + ")");
        }

        return ("{[" + sbPoints + "], " + getColour() + ", " + getWidth() + "}"); // maybe getX instead of just X
    }

    // how to call getVertices
    //loop stringbuilder?

    public  Point []  getVertices  () {
        //return a copy else it can get changed from outside

        Point[] points = new Point[vertices.length];

        for(int x = 0; x < vertices.length; x++)
        {
            points[x] = new Point(vertices[x]);
        }
        return points;
    }

    public  String  getColour  () {
        return colour;
    }

    public  int  getWidth  () {
        return width;
    }

    public  void  setColour (String  colour) {
        this.colour = colour;
    }

    public  void  setWidth (int  width) {
        this.width = width;
    }

    public  double  length  () {//note because using object from point class and length has been set there. you can just use that instead of creating the method again.
        //just like using stringbuilder instead of making a method like it again in this class.
        double distance = 0;

        for(int x = 0; x < vertices.length - 1; x++) //or just x = 1
        {
            distance += vertices[x].distance(vertices[x + 1]);
        }
        return distance;
    }

    public  void  add (Point  vertex)
    {
        Point[]     h = new  Point[this.vertices.length + 1];
        int     i = 0;
        for (i = 0; i < this.vertices.length; i++)
            h[i] = this.vertices[i];
        h[i] = new  Point (vertex );
        this.vertices = h;
    }

    public  void  insertBefore (Point  vertex , String  vertexName) {
        //new array to fit the result
        Point[] h = new Point[this.vertices.length + 1];

        //finding the point to add before
        int pos = 0;
        for(int i = 0; i < vertices.length; i++)
        {
            if(vertices[i].getName().equals(vertexName))
            {
                pos = i;
                //System.out.println("Break!");
                break;

            }
            else if(i == vertices.length)
            {
                pos = -1;
            }
            else
            {
                pos++;
            }
        }
        //System.out.println("Pos = "+pos);

        //check if the point is found if not don't change
        if(pos == -1)
        {
            this.vertices = vertices; //should stop the rest of the method from running
        }//need else or else it would keep running
        /*else if(pos == 0)
        {
            Point copy = new Point(vertex);
            int x = 0;

            h[x] = copy;

            while (x < h.length) {
                h[x] = vertices[x - 1];
                x++;
            }

        }*/
        else {
            //copying object to prevent value changes redundant
            Point copy = new Point(vertex);
            //System.out.println("Copy made");

            //copying the points before the insertion
            int x = 0;
            //System.out.println(x);
            while (x < pos) {
                h[x] = vertices[x];
                x++;
            }

            //inserting the point
            h[pos] = copy;

            //inserting the rest of the points
            x += 1;
            while (x < h.length) {
                h[x] = vertices[x - 1];
                x++;
            }

            //changing the vertices into the new one
            this.vertices = h;
        }
    }
    public  void  remove (String  vertexName) {
        //finding the searched name
        int x = 0;
        int pos = 0;
        while(x < vertices.length)
        {
            if(vertices[x].getName().equals(vertexName))
            {
                pos = x;
                break;
            }
            else if(x == vertices.length - 1)//if not found flag it
            {
                pos = -1;
            }
            else
            {
                pos++;
                x++;
            }
        }

        //removing the point
        Point[] h = new Point[vertices.length - 1];

        //if not found return the same thing
        if(pos == -1)
        {
            this.vertices = vertices;
        }
        else {
            //putting the points before the one to be removed
            for (int i = 0; i < pos; i++) {
                h[i] = vertices[i];
            }

            //skips the point and puts the rest in their position
            for (int i = 1 + pos; i < vertices.length; i++) {
                h[i - 1] = vertices[i];
            }

            //return the changed array
            this.vertices = h;
        }
    }

    public java.util.Iterator<Point> iterator() {
        return new PolylineIterator();// used to return an inner class of iterator
    }

    public  class  PolylineIterator implements Iterator<Point>
    {
        private  int     current =  -1;
        public  PolylineIterator  ()
        {
            if (VPolyline.this.vertices.length  > 0)
                current = 0;
            //System.out.println(current);
        }
        public  boolean  hasNext  ()
        {
            return  current  !=  -1;
        }
        public  Point  vertex  ()
                throws  java.util.NoSuchElementException
        {
            if (!this.hasNext  ())
                throw  new  java.util.NoSuchElementException (
                        "end of  iteration");
            Point     vertex = VPolyline.this.vertices[current ];
            return  vertex;
        }
        public Point next()
        {
            if (current  >= 0   &&
                    current  < VPolyline.this.vertices.length  - 1)
                current ++;
            else
                current =  -1;
            //Point copy = new Point();
            //copy = vertices[current];
            return new Point(vertices[current]);
        }
    }
}

