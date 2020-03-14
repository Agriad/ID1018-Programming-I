public class CircularLinkedList<Item>
{
    //structure:  1-->2-->3-->null
    //where 1 is the first data entered
    //now null<-->1<-->2<-->3<-->null
    private Node first;  //oldest node
    private Node last;  //newest node

    private class Node
    {
        Item item;  //data storage
        Node next;  //pointer to the next node
    }

    public void enqueue(Item item)
    {
        Node oldlast = last;  //adds the last recent node to oldlast
        last = new Node();  //makes new node for this data
        last.item = item;  //puts data into the node
        last.next = first;  //we point the next part of this node to null

        if(!(first == last))  //if this is the first ie. if first == null
        {

            first = last;  //put this node into as first
            //System.out.println("first = last");
        }
        else
        {
            oldlast.next = last;  //points the previous entry to the new one added
            //System.out.println("next");
        }
    }

    public Item dequeue()
    {
        Item item = first.item;  //grabs item from the oldest entry
        first = first.next;  //cycles it for the next call
        last.next = first;

        if(first == last)  //if at the end null
        {
            last = null;
            //System.out.println("last");
            return(item);
        }

        return(item);  //returns the data inside
    }
}
