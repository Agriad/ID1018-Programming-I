import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import static java.lang.System.out;

public class Lab4Question4
{
    public class Edge implements Comparable<Edge>
    {
        private final int v; // one vertex
        private final int w; // the other vertex
        private final double weight; // edge weight
        public Edge(int v, int w, double weight)
        {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }
        public double weight()
        { return weight; }
        public int either()
        { return v; }
        public int other(int vertex)
        {
            if (vertex == v) return w;
            else if (vertex == w) return v;
            else throw new RuntimeException("Inconsistent edge");
        }
        public int compareTo(Edge that)  //compares 2 edges
        {
            if (this.weight() < that.weight()) return -1;
            else if (this.weight() > that.weight()) return +1;
            else return 0;
        }
        public String toString()
        { return String.format("%d-%d %.2f", v, w, weight); }
    }

    public class Bag<Item> implements Iterable<Item>
    {
        private Node first; // first node in list
        private class Node  // uses node to store items in bag
        {
            Item item;  // stores the item
            Node next;  // what the next item is so it can iterate
        }
        public void add(Item item)
        { // same as push() in Stack
            Node oldfirst = first;
            first = new Node();
            first.item = item;
            first.next = oldfirst;
        }
        public Iterator<Item> iterator()  //basic iterator
        { return new ListIterator(); }
        private class ListIterator implements Iterator<Item>  //specific iterator for this type
        {
            private Node current = first;
            public boolean hasNext()
            { return current != null; }
            public void remove() { }
            public Item next()
            {
                Item item = current.item;
                current = current.next;
                return item;
            }
        }
    }

    public class Graph
    {
        private final int V; // number of vertices
        private int E; // number of edges
        private Bag<Edge>[] adj; // adjacency lists
        public Graph(int V)  //constructor
        {
            this.V = V; this.E = 0;
            adj = (Bag<Edge>[]) new Bag[V]; // Create array of lists.
            for (int v = 0; v < V; v++) // Initialize all lists
                adj[v] = new Bag<Edge>(); // to empty.
        }

        public int V() { return V; }
        public int E() { return E; }

        public void addEdge(Edge e)  //add's an edge
        {
            int v = e.either();
            int w = e.other(v);
            adj[v].add(e); // Add w to v’s list.
            adj[w].add(e); // Add v to w’s list.
            E++;
        }
        public Iterable<Edge> adj(int v)
        { return adj[v]; }

        public Iterable<Edge> edges()
        {
            Bag<Edge> b = new Bag<Edge>();
            for (int v = 0; v < V; v++)
                for (Edge e : adj[v])
                    if (e.other(v) > v) b.add(e);
            return b;
        }
    }

    public class Queue<Item> implements Iterable<Item>
    {
        private Node first; // link to least recently added node
        private Node last; // link to most recently added node
        private int N; // number of items on the queue
        private class Node
        { // nested class to define nodes
            Item item;
            Node next;
        }
        public boolean isEmpty() { return first == null; } // Or: N == 0.
        public int size() { return N; }
        public void enqueue(Item item)
        { // Add item to the end of the list.
            Node oldlast = last;
            last = new Node();
            last.item = item;
            last.next = null;
            if (isEmpty()) first = last;
            else oldlast.next = last;
            N++;
        }
        public Item dequeue()
        { // Remove item from the beginning of the list.
            Item item = first.item;
            first = first.next;
            if (isEmpty()) last = null;
            N--;
            return item;
        }

        public Iterator<Item> iterator()
        { return new ListIterator(); }
        private class ListIterator implements Iterator<Item>
        {
            private Node current = first;
            public boolean hasNext()
            { return current != null; }
            public void remove() { }
            public Item next()
            {
                Item item = current.item;
                current = current.next;
                return item;
            }
        }
// See page 155 for iterator() implementation.
// See page 150 for test client main().
    }

    public class IndexMinPQ//<Item> //Question 3
    {
        //structure:  null<--1<-->2<-->3-->null
        //where 1 is the smallest data entered and 3 is the largest
        private Node first = null;  //smallest value
        private Node last = null;  //largest value
        private int size = 0;

        private class Node {
            //Item item = null;  //data storage
            int item;
            double distance;
            Node next = null;  //pointer to the next node
            Node before = null;  //pointer to the previous node
        }

        public boolean isEmpty()  //checks, if first == null, true else false
        {
            return (first == null);
        }

        public void insert(int item, double length)  //adds the item to the "last" node and links it
        {
            System.out.println("insert insert");
            Node temp = new Node();  //makes a new node for the new data
            temp.item = item;
            temp.distance = length;

            if (size == 0)  //if empty add as first one
            {
                last = temp;
                first = last;
                out.println("first");
            }
            else {
                System.out.println("insert else");
                Node pointer = last;
                int check1 = (int) (item);
                int check2 = (int) (pointer.item);

                while ((check1 < check2) && (pointer.before != null))  //from last if the number added before if bigger go
                {  //to the before node
                    pointer = pointer.before;
                }

                if (pointer == first)  //if it is the largest make it first
                {
                    pointer.before = temp;
                    temp.next = pointer;
                    first = temp;
                } else if (pointer == last)  //if it is the smallest make it last
                {
                    pointer.next = temp;
                    temp.before = pointer;
                    last = temp;
                } else  //splice it in between the 2 nodes
                {
                    pointer.next.before = temp;
                    temp.next = pointer.next.before;
                    pointer.next = temp;
                    temp.before = pointer;

                }
            }

            size++;
        }

        public int delMin()  //removes the node from the "first" node and returns the item
        {
            int item = first.item;  //grabs item from the oldest entry
            first = first.next;  //cycles it for the next call

            Node pointer  = first;
            while (pointer != null)
            {
                if (pointer.item == item)
                {
                    break;
                }
                pointer = pointer.next;
            }

            if (pointer != null)
            {
                remove(pointer.item);
            }

            size--;
            return (item);  //returns the data inside
        }

        public boolean contains(int item)
        {
            System.out.println("contains");
            Node pointer  = first;
            for (int i = 0; i < size; i++)
            {
                System.out.println("contains loop");
                if (pointer == null)
                {
                    return (false);
                }
                if (pointer.item == item)
                {
                    return (true);
                }
                pointer = pointer.next;
            }
            return (false);

            /*
            System.out.println("contains");
            Node pointer  = first;
            while (pointer != null)
            {
                System.out.println("contains loop");
                if (pointer.item == item)
                {
                    return (true);
                }
                pointer = pointer.next;
            }
            return (false);*/
        }

        public void remove(int item)
        {
            Node pointer  = first;
            while (pointer != null)
            {
                if (pointer.item == item)
                {
                    break;
                }
                pointer = pointer.next;
            }

            if (size == 1)
            {
                first = null;
                last = null;
                size--;
            }
            else if (size == 2)
            {
                if (pointer.next == null)
                {
                    last = pointer.before;
                    pointer.before.next = null;
                    pointer.before = null;
                }
                else
                {
                    first = pointer.next;
                    pointer.next.before = null;
                    pointer.next = null;
                }
                size--;
            }
            else if (pointer.before == null)
            {
                pointer.next = first;
                pointer.next.before = null;
                pointer.next = null;
                size--;
            }
            else if (pointer.next == null)
            {
                pointer.before = last;
                pointer.before.next = null;
                pointer.before = null;
                size--;
            }
            else
            {
                pointer.next.before = pointer.before.before;
                pointer.before.next = pointer.next.next;
                pointer.next = null;
                pointer.before = null;
                size--;
            }
        }

        public void change(int item, double length)
        {
            remove(item);
            insert(item, length);
        }

        public String toString()  //makes a String interpretation of the way the data is stored
        {
            String drawing = "";
            Node pointer = first;
            StringBuilder sb = new StringBuilder();

            while (pointer != null)  //if a node exist
            {
                sb.append('[').append(pointer.item).append(']');  //adds the item
                if (pointer.next != null) {
                    sb.append(", ");
                }
                pointer = pointer.next;  //go to next node
            }

            drawing = sb.toString();

            return (drawing);
        }
    }

    /*
    public class LazyPrimMST
    {
        private boolean[] marked; // MST vertices
        private Queue<Edge> mst; // MST edges
        private IndexMinPQ<Edge> pq; // crossing (and ineligible) edges
        public LazyPrimMST(Graph G)
        {
            pq = new IndexMinPQ<Edge>();
            marked = new boolean[G.V()];
            mst = new Queue<Edge>();
            visit(G, 0); // assumes G is connected (see Exercise 4.3.22)
            while (!pq.isEmpty())
            {
                Edge e = pq.delMin(); // Get lowest-weight
                int v = e.either(), w = e.other(v); // edge from pq.
                if (marked[v] && marked[w]) continue; // Skip if ineligible.
                mst.enqueue(e); // Add edge to tree.
                if (!marked[v]) visit(G, v); // Add vertex to tree
                if (!marked[w]) visit(G, w); // (either v or w).
            }
        }
        private void visit(Graph G, int v)
        { // Mark v and add to pq all edges from v to unmarked vertices.
            marked[v] = true;
            for (Edge e : G.adj(v))
                if (!marked[e.other(v)]) pq.insert(e);
        }
        public Iterable<Edge> edges()
        { return mst; }
        public double weight() // See Exercise 4.3.31.
    }*/

    public static void main(String[] args) throws IOException
    {
        Scanner in = new Scanner(new File("Text.txt"));  //input file
        Lab4Question4 lab = new Lab4Question4();  //instantiate class
        int limit = 49;  //limit of input for array
        String[] indexName = new String[limit];  //array of states with index as input (symbol table)
        Lab4Question4.Graph graph = lab.new Graph(limit);  //instantiate inner class
        int count = 0;  //left input marker
        int count2 = 0;  //right input marker
        int counter = 0;  //array counter
        int state1 = 0;  //int for the left input state
        int state2 = 0;  //int for the right input state
        int weight = 1;

        while (in.hasNext())
        {
            String[] inputs = in.nextLine().split(" ");

            for (int i = 0; i < indexName.length; i++)
            {
                if (inputs[0].equals(indexName[i]))  //checks for duplicate
                {
                    count++;
                }
                if (inputs[1].equals(indexName[i]))
                {
                    count2++;
                }
            }

            if (count == 0)  //if unique put into array
            {
                indexName[counter] = inputs[0];
                //state1 = counter;
                counter++;
            }
            if (count2 == 0)
            {
                indexName[counter] = inputs[1];
                //state2 = counter;
                counter++;
            }
            count2 = 0;
            count = 0;

            for (int i = 0; i < counter; i++)  //finds index with corresponding name
            {
                if (inputs[0].equals(indexName[i]))
                {
                    state1 = i;
                }
                if (inputs[1].equals(indexName[i]))
                {
                    state2 = i;
                }
            }

            Lab4Question4.Edge edge = lab.new Edge(state1, state2, weight);
            graph.addEdge(edge);  //put into graph
            weight++;
        }
    }
}
