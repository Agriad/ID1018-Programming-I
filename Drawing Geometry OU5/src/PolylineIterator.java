/*public  class  PolylineIterator
{
    private  int     current =  -1;
    public  PolylineIterator  ()
    {
        if (Polyline.this.vertices.length  > 0)
            current = 0;
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
}*/
