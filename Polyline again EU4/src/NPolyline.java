import java.util.Iterator;
import static java.lang.System.out;

public  class  NPolyline  implements  Polyline
{
    private  static  class  Node
    {//ah not using arrays but nodes to store vertices.
        public  Point  vertex;
        public  Node   nextNode;
        public  Node (Point  vertex)
        {
            this.vertex = vertex;
            nextNode = null;
        }
    }
    private  Node    vertices;
    private  String  colour = "black";
    private  int     width = 1; //  pixels
    public  NPolyline  ()
    {
        this.vertices = null;
    } //default constructor
    public  NPolyline (Point  []  vertices) //first node is set in vertices
    {
        if (vertices.length  > 0)
        {
            Node  node = new  Node (new  Point (vertices [0]));
            this.vertices = node;
            int  pos = 1;
            while (pos < vertices.length)
            {
                node.nextNode = new  Node (new  Point (vertices[pos ++]));
                node = node.nextNode;
            }
        }
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        Node node = this.vertices;
        sb.append("([");
        while(node!=null)
        {
            sb.append("(" + node.vertex + ")");
            node=node.nextNode;
        }
        sb.append("], " + getColour() + ", " + getWidth() + ")");

        return sb.toString();
        //should look like ([(A 3 4), points, ...], color, width)
    }

    public Point[] getVertices()
    {//how to find point array length???. can use counter so 2 iterators first to count second to put it in
        Node node = vertices;
        int counter = 0;

        while(node != null)//find ho many nodes exist
        {
            counter++;
            node = node.nextNode;
        }

        Node copyPoint = vertices;
        Point[] copy = new Point[counter]; //make array as long as many nodes exist

        for(int x = 0; x < counter; x++)
        {
            copy[x] = copyPoint.vertex; //put point into array
            copyPoint = copyPoint.nextNode; //got to next point
        }

        return copy;
    }

    public String getColour()
    {//immutable no need to copy
        return colour;
    }

    public int getWidth()
    {//return copy or not? seems like no need as the data itself is copied and not address
        return width;
    }

    public double length()//staggered counter again? so second one is ahead by one? better if before where main in ahead
    {//or just use get vertices...
        //this one is broken...
        // node method
        /*double sum = 0;
        Node node = vertices;
        Node nodeSecond = vertices;
        int counter = 0;

        while(node.nextNode != null)//iterate over the different nodes
        {
            if(counter > 0)
            {
                sum += node.vertex.distance(nodeSecond.vertex); //start adding when there are 2 points in play and stop when there is one left. don't add before as it might skip a node before
                //changing
                nodeSecond = nodeSecond.nextNode; //iterate 1 step behind the main iteration
            }
            counter++;
            node = nodeSecond;
        }

        return sum;*/

        //getVertices method

        double sum = 0;
        Point[] points = getVertices();

        for(int x = 0; x < getVertices().length - 1; x++)
        {
            sum += points[x].distance(points[x + 1]);
        }

        return sum;

    }

    public void setColour(String colour)
    {
        this.colour = colour;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public void add(Point vertex)
    {
        Point vertexCopy = new Point(vertex);
        Node node = vertices; //start of it, the first node

        //while(node.nextNode != null)//redundant, no it's not
        /*if(node == null)
        {
            node = new Node(vertexCopy);
        }*/

        /*if(node.nextNode == null)
        {
            node.nextNode = new Node(vertexCopy);
        }*/
        if(node == null)
        {
            node = new Node(vertexCopy);
            this.vertices = node;
        }
        else {
            while (node != null) {
                if (node.nextNode == null) {
                    break;
                }
                node = node.nextNode;
                //System.out.println("test");
            }
            node.nextNode = new Node(vertexCopy);
        }

        //node.nextNode = new Node(vertexCopy); // this makes the new new get the correct thing but not the actual thing. nope nvm wrong it is adding it correctly

        /*if(node.nextNode == null) //why always true? (node == null or node.nextNode == null???)
        {
            node.nextNode = new Node(vertex);
        }*/

    }

    public void insertBefore(Point vertex, String vertexName)//TODO special case when first element changes
    {
        Point vertexCopy = new Point(vertex);
        Node node = vertices; //first node
        Node anotherNode = vertices;

        int counter = 0;
        while(!node.vertex.getName().equals(vertexName))//iterates over the nodes and finds the name
        {
            node = node.nextNode;
            if(counter > 0)
            {
               anotherNode = anotherNode.nextNode;
            }
            //System.out.println(counter);
            counter++;
        }
        /*if(counter == 1)
        {
            anotherNode = anotherNode.nextNode;
            out.println(anotherNode.vertex);
        }*/ // this causes issues

        if(vertices.vertex.getName().equals(vertexName))//if first element is changed
        {
            //anotherNode = anotherNode.nextNode;
            vertices = new Node(new Point(vertex));
            Node moreNode = vertices;
            if(anotherNode.nextNode != null)
            {
                moreNode.nextNode = anotherNode;
                anotherNode = anotherNode.nextNode;
            }
        }
        else if(node.vertex.getName().equals(vertexName)) //when found check if it is last node
        {
            if(node.nextNode == null) // if last node just add the point into node and join the last node to new last node
            {
                node.nextNode = new Node(new Point(vertex));
                //out.println("second if triggered");
            }
            else // if not unlink, add new node point, and link the new node point with the rest of the node point.
            {
                //out.println(anotherNode.vertex);
                Node nodeCopy = node.nextNode; //make the address to next link in between the new point next link
                anotherNode.nextNode = new Node(new Point(vertex)); //link node choice before to point choice new
                //out.println(nodeCopy.vertex);

                anotherNode = anotherNode.nextNode; //move it to new node
                //out.println(anotherNode.vertex);
                anotherNode.nextNode = node; //add node flagged add before
                anotherNode = anotherNode.nextNode;//move to node flagged add before
                //out.println(anotherNode.vertex);
                while(nodeCopy != null) //check if there are still more links
                {
                    anotherNode.nextNode = nodeCopy; //link node to the unlinked next node so after the new node
                    nodeCopy = nodeCopy.nextNode; //move the node (ahead of node)
                    anotherNode = anotherNode.nextNode;// move the node to the node recently added
                }//before all another node = node
            }

        }

    }

    public void remove(String vertexName)//TODO special case when first element is removed !!! and when last one is removed
    {
        Node node = vertices;
        Node nodeBefore = vertices;

        int counter = 0;
        while(!node.vertex.getName().equals(vertexName)) //hmm but it is on that node and not on the one before it, maybe make staggered double iterator
        {
            node = node.nextNode;
            if(counter > 0) // starts when it iterates the second time and so on
            {
                nodeBefore = nodeBefore.nextNode;
            }
            counter++;
        }

        if(counter == 0) // if first element just change the starting element
        {
            vertices = node.nextNode;
        }

        if(node.vertex.getName().equals(vertexName)) //check if name actually exist
        {
            nodeBefore.nextNode = node.nextNode; //skip the node with the search name
        }
    }

    /*@Override
    public java.util.Iterator<Point> iterator() {
        return null; // used to return an inner class of iterator
    }//calls it by specifying the type so Point*/

    public java.util.Iterator<Point> iterator() {
        return new NPolylineIterator();// used to return an inner class of iterator
    }//calls it by specifying the type so Point

    //copy iterator from OU5 and change fit node

    public  class  NPolylineIterator implements Iterator<Point>
    {
        private  int     current =  -1;
        Node node = vertices;
        public  NPolylineIterator  ()
        {
            if (node != null)
                current = 0;
        }
        public  boolean  hasNext  ()
        {
            return  node != null;
        }
        public  Point  vertex  ()
                throws  java.util.NoSuchElementException
        {
            if (node == null)
                throw  new  java.util.NoSuchElementException (
                        "end of  iteration");
                        //Point     vertex = Polyline.this.vertices[current ];

            //Point vertex = node.vertex;
            return  node.vertex;
        }
        public  Point  next  ()
        {//node.nextNode != null
            Node copy = node;
            if (hasNext())
            {
                node = node.nextNode;
                current ++;
            }
            else
            {
                current =  -1;
            }
            return new Point(copy.vertex);
        }
    }


   /* public  class  PolylineIterator
    {
        private  int     current =  -1;
        public  PolylineIterator  ()
        {
            if (Polyline.this.vertices.length  > 0)
                current = 0;
            //System.out.println(current);
        }
        public  boolean  hasVertex  ()
        {
            return  current  !=  -1;
        }
        public  Point  vertex  ()
                throws  java.util.NoSuchElementException
        {
            if (!this.hasVertex  ())
                throw  new  java.util.NoSuchElementException (
                        "end of  iteration");
            Point     vertex = Polyline.this.vertices[current ];
            return  vertex;
        }
        public  void  advance  ()
        {
            if (current  >= 0   &&
                    current  < Polyline.this.vertices.length  - 1)
                current ++;
            else
                current =  -1;
        }
    }*?

    //@Override
    /*public Iterator<Point> iterator() {
        public Point hasNext()

        public boolean hasNext()
        {
            boolean answer = false;


            return answer;
        }

        public Point next()
        {
            if(iterator().hasNext())
            {
            }
        }

        return ;
    }*/

    //can use like ou5 iterator but is it correct implementation?
    //public class Iterator<Point> ex

    // ***  MORE  CODE  HERE  ***

   /* public double test()
    {
        double dist = 0;
        Point point1 = new Point("A", 0, 0);
        Point point2 = new Point("B", 0, 1);

        Node node1 = new Node(point1);
        node1.nextNode = point2;

        return dist;
    }*/
}
