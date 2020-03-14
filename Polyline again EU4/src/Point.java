public class Point
{
    String pointName;
    int pointX;
    int pointY;
    public Point(String name, int x, int y)
    {
        pointName = name;
        pointX = x;
        pointY = y;
    }

    public Point(Point px)
    {
        this.pointName = px.getName();
        this.pointX = px.getX();
        this.pointY = px.getY();
    }

    @Override // overrides the default to string so that it outputs something more useful
    public String toString()
    {
        return pointName + " " + pointX + " " + pointY;
    }

    // returns the name of the point
    public String getName()
    {
        return pointName;
    }

    // returns the x value of the point
    public Integer getX()
    {
        return pointX;
    }

    // returns the y value of the point
    public Integer getY()
    {
        return pointY;
    }

    // returns the distance between 2 points
    public Double distance(Point px)
    {
        double dX = pointX - px.getX();
        double dY = pointY - px.getY();

        double squaredSum = Math.pow(dX, 2) + Math.pow(dY, 2);

        return Math.sqrt(squaredSum);
    }

    public void setX(int x) {
        this.pointX = x;
    }

    public void setY(int y)
    {
        this.pointY = y;
    }


}
