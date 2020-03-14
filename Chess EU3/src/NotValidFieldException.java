public class NotValidFieldException extends Exception {
    /*private char row;
    private byte column;

    public NotValidFieldException(char row, byte column){
        this.row = row;
        this.column = column;
    }*/

    public NotValidFieldException(String message)
    {
        super(message);
    }

}
