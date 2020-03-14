public class MyException extends Exception{
    private int number;

    public MyException(int x)
    {
        this.number = x;
    }
}
