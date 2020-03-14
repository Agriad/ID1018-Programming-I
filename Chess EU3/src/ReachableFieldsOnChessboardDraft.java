public class ReachableFieldsOnChessboardDraft {
}

/*import java.util.Random;
        import static java.lang.System.out;

public class ReachableFieldsOnChessboard {
    public static void main(String[] args) throws NotValidFieldException
    {
        Chessboard     chessBoard = new  Chessboard  (); //nested class comes along with it
        out.println (chessBoard + "\n");
        Chessboard.Chesspiece []   pieces = new  Chessboard.Chesspiece [6];
        pieces [0] = chessBoard.new  Pawn ('w', 'P'); // what why not working, messed up quote sign
        pieces [1] = chessBoard.new  Rook ('b', 'R');
        pieces [2] = chessBoard.new  Queen ('w', 'Q');
        pieces [3] = chessBoard.new  Bishop ('w', 'B');
        pieces [4] = chessBoard.new  King ('b', 'K');
        pieces [5] = chessBoard.new  Knight ('w', 'N');

        //Random rand = new Random();
        byte x = (byte) (1);

        boolean a = pieces[0].isOnBoard();

        if(a)
        {
            out.println("is on board");
        }

        pieces[0].moveTo('a', (byte) (1));
        pieces[0].markReachableFields();


        a = pieces[0].isOnBoard();

        if(a)
        {
            out.println("is on board");
        }

        out.println(chessBoard);
        pieces[0].unmarkReachableFields();
        //pieces[0].moveTo( 'h', (byte) (8)); // bad field exception?
        //pieces[0].moveTo('b', (byte) 2);
        pieces[0].moveTo('b', (byte) 1);
        pieces[0].markReachableFields();
        out.println(chessBoard);
        pieces[0].unmarkReachableFields();
        //pieces[0].moveTo('h', (byte) 8);

        //pieces[0].unmarkReachableFields();
        //pieces[0].markReachableFields();
        //pieces[0].unmarkReachableFields();

        pieces[0].moveTo('h', (byte) 8);
        pieces[0].markReachableFields();
        pieces[0].unmarkReachableFields();
        out.println(chessBoard);

        //pieces[0].moveTo('h', (byte) 0);

        pieces[0].moveOut();
        pieces[0].unmarkReachableFields();

        out.println(chessBoard);

        pieces[1].moveTo('d', (byte) (4));
        if(pieces[1].isOnBoard()) {
            out.println("is on board");
        }

        out.println(chessBoard);

        pieces[1].markReachableFields();
        out.println(chessBoard);

        pieces[1].unmarkReachableFields();
        out.println(chessBoard);

        pieces[1].moveTo('h', (byte) (4));
        out.println(chessBoard);

        pieces[1].markReachableFields();
        out.println(chessBoard);

        pieces[1].unmarkReachableFields();
        pieces[1].moveOut();
        out.println(chessBoard);

        pieces[4].moveTo('e', (byte) (6));
        out.println(chessBoard);

        pieces[4].markReachableFields();
        out.println(chessBoard);

        pieces[4].unmarkReachableFields();
        pieces[4].moveTo('a', (byte) (1));
        pieces[4].markReachableFields();
        out.println(chessBoard);

        pieces[4].unmarkReachableFields();
        pieces[4].moveOut();
        out.println(chessBoard);

        pieces[3].moveTo('c', (byte) (3));
        out.println(chessBoard);
        pieces[3].markReachableFields();
        out.println(chessBoard);
        pieces[3].unmarkReachableFields();
        out.println(chessBoard);

        pieces[3].moveTo('a', (byte) (8));
        out.println(chessBoard);
        pieces[3].markReachableFields();
        out.println(chessBoard);
        pieces[3].unmarkReachableFields();

        pieces[3].moveTo('b', (byte) (4));
        out.println(chessBoard);
        pieces[3].markReachableFields();
        out.println(chessBoard);
        pieces[3].unmarkReachableFields();

        out.println(chessBoard);
        pieces[3].moveOut();
        out.println(chessBoard);

        pieces[2].moveTo('d', (byte) (5));
        out.println(chessBoard);
        pieces[2].markReachableFields();
        out.println(chessBoard);
        pieces[2].unmarkReachableFields();
        out.println(chessBoard);

        pieces[2].moveTo('h', (byte) (1));
        out.println(chessBoard);
        pieces[2].markReachableFields();
        out.println(chessBoard);
        pieces[2].unmarkReachableFields();

        pieces[2].moveTo('e', (byte) (8));
        out.println(chessBoard);
        pieces[2].markReachableFields();
        out.println(chessBoard);
        pieces[2].unmarkReachableFields();

        out.println(chessBoard);
        pieces[2].moveOut();
        out.println(chessBoard);

        pieces[5].moveTo('h', (byte) (8)); //d 4 works
        out.println(chessBoard);
        pieces[5].markReachableFields();
        out.println(chessBoard);
        pieces[5].unmarkReachableFields();

        out.println(chessBoard);
        pieces[5].moveOut();
        out.println(chessBoard);

        //chessBoard.new Pawn('w', 'P');
        /*Chessboard.Pawn pawn = new Chessboard.Pawn('w', 'P');

        Chessboard.Field field = chessBoard.new Field().mark();
        chessBoard.new Field().put(Chessboard.Pawn);

        Field x =
        //new Chessboard.*/
/*    }

}
*/
