import static java.lang.System.out;

public class ChesboardDraft {
}

/*
public class Chessboard {
    public static class Field
    {
        private  char     row;
        private  byte     column;
        private  Chesspiece     piece = null;
        private  boolean     marked = false;

        public  Field (char row , byte  column) {
            this.row = row;
            this.column = column;
        }

        //constructors
        public  void  put (Chesspiece  piece) {

            //TODO do this late (defensive coding)
            //check first

            /*char[] name = {'K', 'Q', 'R', 'B', 'N', 'P'}

            for(int x = 0; x < name.length; x++)
            {
                if(piece.equals(name[x]))
                {

                }
            }*/
/*
            this.piece = piece;
            this.row = (char) (piece.row + 97);
            this.column = (byte) (piece.column + 97);
        }

        public  Chesspiece  take () {// used for what?. Opposite of put
            this.piece = null;
            return piece;
        }

        public  void  mark () {
            this.marked = true;
        }

        public  void  unmark  ()   {
            this.marked = false;
        }

        public  String  toString  ()
        {
            String     s = (marked )? "xx" : "--";
            return (piece  == null)? s : piece.toString  ();
        }
    }

    public  static  final  int     NUMBER_OF_ROWS = 8;
    public  static  final  int     NUMBER_OF_COLUMNS = 8;

    public  static  final  int     FIRST_ROW = 'a';
    public  static  final  int     FIRST_COLUMN = 1;

    private  Field [][]     fields;

    public  Chessboard  ()
    {
        fields = new  Field[NUMBER_OF_ROWS ][ NUMBER_OF_COLUMNS ];
        char     row = 0;
        byte     column = 0;
        for (int r = 0; r < NUMBER_OF_ROWS; r++)
        {
            row = (char) (FIRST_ROW + r);
            column = FIRST_COLUMN;
            for (int c = 0; c < NUMBER_OF_COLUMNS; c++)
            {
                fields[r][c] = new  Field (row , column );
                column ++;
            }
        }
    }

    public  String  toString  ()   {//row then column //not done need to check if piece and where it can go is there // thi is wrong
        StringBuilder sb = new StringBuilder();

        //TODO check if this is the way
        for(int x = 0; x < NUMBER_OF_COLUMNS; x++)
        {
            sb.append("  " + (int) (1 + x));
        }
        sb.append("\n");
        for(int x = 0; x < NUMBER_OF_ROWS; x++) {
            sb.append((char) ('a' + x) + " ");
            for (int y = 0; y < NUMBER_OF_COLUMNS; y++) {

                sb.append(fields[x][y] + " ");
            }
            sb.append("\n");
        }

        return sb.toString();

        /*sb.append("  ");
        for(int x = 0; x < NUMBER_OF_COLUMNS; x++)
        {
            sb.append(sb.append((int) (1 + x) + "  ")); //why are there 2 sb append?
        }
        //sb.append("\n");

        /*for(int x = 0; x < NUMBER_OF_ROWS; x++) {
            sb.append((char) ('a' + x) + " ");
            for(int y = 0; y < NUMBER_OF_COLUMNS; y++) {
                sb.append(fields[x][y]);
            }
        }*/

        //return sb.toString();

        //StringBuilder sb = new StringBuilder();

        /*sb.append("  ");
        for(int x = 0; x < NUMBER_OF_COLUMNS; x++) {
            sb.append((int) (1 + x) + "  ");
        }
        sb.append("\n");

        for(int x = 0; x < NUMBER_OF_ROWS; x++) {
            sb.append((char) ('a' + x) + " ");
            for(int y = 0; y < NUMBER_OF_COLUMNS; y++) {
                    {
                        sb.append("-- ");
                    }
            }
            sb.append("\n");
        }
        String board = sb.toString();*/
        //return board;
   /* }
/*
    public  boolean  isValidField (char row , byte  column)   {

        boolean answer = true;

        //hmm row is fine i think but what about column
        row -= 97;
        //column -= 1;

        if(row > NUMBER_OF_ROWS - 1 || row < 0) {//before it had +1
            answer = false;
        }
        else if(column > NUMBER_OF_COLUMNS || column < 1)
        {
            answer = false;
        }

        return answer;
    }

    public  abstract  class  Chesspiece
    {
        private  char     color;
        // w - white , b - black

        private  char     name;
        // K - King , Q - Queen , R - Rook , B - Bishop , N - Knight ,
        // P      Pawn

        protected  char     row = 0;
        protected  byte     column =  -1;

        protected  Chesspiece (char  color , char  name)   {
            //TODO add defensive code

            this.color = color;
            this.name = name;
        }

        public  String  toString  ()
        {
            return "" + color + name;
        }

        public  boolean  isOnBoard  ()
        {
            return  Chessboard.this.isValidField (row , column );
        }

        public  void  moveTo (char row , byte  column)
                throws  NotValidFieldException
        {
            if (! Chessboard.this.isValidField (row , column ))
                throw  new  NotValidFieldException
                        ("bad  field: " + row + column);

            this.row = row;
            this.column = column;

            //TODO figure out why row - FIRST_ROW
            int     r = row - FIRST_ROW;
            int     c = column  - FIRST_COLUMN;

            //experiment
            for(int x = 0; x < NUMBER_OF_ROWS; x++) {
                for (int y = 0; y < NUMBER_OF_COLUMNS; y++) {
                    Chessboard.this.fields[x][y].take();
                }
            }

            //int     r = row;
            //int     c = column;
            Chessboard.this.fields[r][c].put (this);

        }

        //TODO implement remove
        //the actual remove the chesspiece

        public  void  moveOut  ()   {
            //int r = row - FIRST_ROW;
            //int c = row - FIRST_COLUMN;
            /*
            int r = 0;
            int c = 0;

            Chessboard.this.fields[r][c].take();
            */
/*
            for(int x = 0; x < NUMBER_OF_ROWS; x++) {
                for (int y = 0; y < NUMBER_OF_COLUMNS; y++) {
                    Chessboard.this.fields[x][y].take();
                }
            }

            //Chessboard.this.fields.
        }

        public  abstract  void  markReachableFields  (

        );

        public  abstract  void  unmarkReachableFields  (

        );
    }

    public  class  Pawn  extends  Chesspiece
    {
        public  Pawn (char  color , char  name)
        {
            super (color , name);
        }

        public  void  markReachableFields  ()
        {
            //byte     col = (byte) (column + 1);
            byte     col = (byte) (column);

            if((int) (column) == 8)
            {

            }
            else if (Chessboard.this.isValidField (row , col))
            { //TODO need to change back and figure out
                int     r = row - FIRST_ROW;
                int     c = col - FIRST_COLUMN + 1;

                //int r = row;
                //int c = col;

                //System.out.println(r);
                //System.out.println(c);
                Chessboard.this.fields[r][c].mark  ();
            }
        }

        public  void  unmarkReachableFields  ()
        {
            byte     col = (byte) (column);
            if (Chessboard.this.isValidField (row, (byte) (col + 1)))
            {
                int     r = row - FIRST_ROW;
                int     c = col - FIRST_COLUMN + 1;
                Chessboard.this.fields[r][c]. unmark  ();
            }
        }


    }

    /*public  class  Pawn  extends  Chesspiece
    {
        public  Pawn (char  color , char  name)
        {
            super (color , name);
        }

        public  void  markReachableFields  ()
        {
            //byte     col = (byte) (column + 1);
            byte     col = (byte) (column);

            if(Character.toString(row).equals("h"))
            {

            }
            else if (Chessboard.this.isValidField (row , col))
            { //TODO need to change back and figure out
                int     r = row - FIRST_ROW + 1;
                int     c = col - FIRST_COLUMN;

                //int r = row;
                //int c = col;

                //System.out.println(r);
                //System.out.println(c);
                Chessboard.this.fields[r][c].mark  ();
            }
        }

        public  void  unmarkReachableFields  ()
        {
            byte     col = (byte) (column);
            if (Chessboard.this.isValidField (row , col))
            {
                int     r = row - FIRST_ROW;
                int     c = col - FIRST_COLUMN;
                Chessboard.this.fields[r][c]. unmark  ();
            }
        }


    }*/
/*
    //TODO change a lot of things below this

    public  class  Rook  extends  Chesspiece   {
        public  Rook (char  color , char  name)
        {
            super (color , name);
        }

        public  void  markReachableFields  ()
        {
            byte     col = (byte) (column);
            char rowVar = (char) (row);
            if (Chessboard.this.isValidField (rowVar , col))
            {
                int     r = rowVar - FIRST_ROW;
                int     c = col - FIRST_COLUMN;
                for(int x = 0; x < NUMBER_OF_ROWS; x++)
                {
                    Chessboard.this.fields[x][c].mark  (); //marks all rows
                }
                for(int x = 0; x < NUMBER_OF_COLUMNS; x++)
                {
                    Chessboard.this.fields[r][x].mark  (); //marks all columns
                }

                //Chessboard.this.fields[r][c].mark  ();
            }
        }

        public  void  unmarkReachableFields  ()
        {
            byte     col = (byte) (column);
            char rowVar = (char) (row);
            if (Chessboard.this.isValidField (rowVar , col)) {
                int r = rowVar - FIRST_ROW;
                int c = col - FIRST_COLUMN;
                for (int x = 0; x < NUMBER_OF_ROWS; x++) {
                    Chessboard.this.fields[x][c].unmark();
                }
                for (int x = 0; x < NUMBER_OF_COLUMNS; x++) {
                    Chessboard.this.fields[r][x].unmark();
                }
            }
        }
    }

    public  class  Knight  extends  Chesspiece   {
        public  Knight (char  color , char  name)
        {
            super (color , name);
        }

        public  void  markReachableFields  ()
        {
            int r = row - FIRST_ROW;
            int c = column - FIRST_COLUMN;

            // 4 arrays for the 8 positions but with same latitude or altitude in one array so 4 array
            int[] pos1 = new int[4];
            int[] pos2 = new int[4];
            int[] pos3 = new int[4];
            int[] pos4 = new int[4];

            //preparing the marked position
            int r1 = r + 2;
            int c1 = c; //before -1
            int r2 = r + 1;
            int c2 = c - 1; //before -2
            int r3 = r - 1;
            int c3 = c - 1; //before -2
            int r4 = r - 2;
            int c4 = c; //before -1
            //ok now

            //putting it into the array
            for(int x = 0; x < 4; x++)
            {
                if(x < 2) //first 2 elements are the rows
                {
                    pos1[x] = r1;
                    pos2[x] = r2;
                    pos3[x] = r3;
                    pos4[x] = r4;
                }
                else //last 2 elements are the columns
                {
                    pos1[x] = c1;
                    c1 += 2;
                    pos2[x] = c2;
                    c2 += 4;
                    pos3[x] = c3;
                    c3 += 4;
                    pos4[x] = c4;
                    c4 += 2;
                }
                //example x and x+2 are the rows an column
            }

            for(int x = 0; x < 2; x++)
            {
                if(Chessboard.this.isValidField((char) (pos1[x] + FIRST_ROW),(byte) (pos1[x+2])) && pos1[x] < 8) //all were without first row and also without less than 8 thing
                {//why doesn't exception catch 9 //now fixed //&& pos1[x] < 8 now redundant
                    /*out.println((char) (pos1[x] + FIRST_ROW));
                    out.println(pos1[x] + FIRST_ROW);
                    out.println(pos1[x]);
                    out.println(pos1[x+2] - 1);
                    Chessboard.this.fields[pos1[x]][pos1[x+2] - 1].mark();
                    out.println("ok1");*/
              /*  }
            /*
                if(Chessboard.this.isValidField((char) (pos2[x] + FIRST_ROW),(byte) (pos2[x+2])) && pos2[x] < 8)
                {
                    Chessboard.this.fields[pos2[x]][pos2[x+2] - 1].mark();
                    //out.println("ok2");
                }
                if(Chessboard.this.isValidField((char) (pos3[x] + FIRST_ROW),(byte) (pos3[x+2])) && pos3[x] < 8)
                {
                    Chessboard.this.fields[pos3[x]][pos3[x+2] - 1].mark();
                    //out.println("ok3");
                }
                if(Chessboard.this.isValidField((char) (pos4[x] + FIRST_ROW),(byte) (pos4[x+2])) && pos4[x] < 8)
                {
                    Chessboard.this.fields[pos4[x]][pos4[x+2] - 1].mark();
                    //out.println("ok4");
                }
            }

            /*for(int x = 0; x < 2; x++)
            {
                out.printf("%d, %d ", (pos1[x]), (pos1[x+2]));
                out.println(Chessboard.this.isValidField((char) (pos1[x]),(byte) (pos1[x+2])));
                out.printf("%d, %d ", (pos2[x]), (pos2[x+2]));
                out.println(Chessboard.this.isValidField((char) (pos2[x]),(byte) (pos2[x+2])));
                out.printf("%d, %d ", (pos3[x]), (pos3[x+2]));
                out.println(Chessboard.this.isValidField((char) (pos3[x]),(byte) (pos3[x+2])));
                out.printf("%d, %d ", (pos4[x]), (pos4[x+2]));
                out.println(Chessboard.this.isValidField((char) (pos4[x]),(byte) (pos4[x+2])));
            }
            out.println();

            for(int x = 0; x < 2; x++)
            {
                out.printf("%d, %d ", (pos1[x] + FIRST_ROW), (pos1[x+2]));
                out.println(Chessboard.this.isValidField((char) (pos1[x] + FIRST_ROW),(byte) (pos1[x+2])));
                out.printf("%d, %d ", (pos2[x] + FIRST_ROW), (pos2[x+2]));
                out.println(Chessboard.this.isValidField((char) (pos2[x] + FIRST_ROW),(byte) (pos2[x+2])));
                out.printf("%d, %d ", (pos3[x] + FIRST_ROW), (pos3[x+2]));
                out.println(Chessboard.this.isValidField((char) (pos3[x] + FIRST_ROW),(byte) (pos3[x+2])));
                out.printf("%d, %d ", (pos4[x] + FIRST_ROW), (pos4[x+2]));
                out.println(Chessboard.this.isValidField((char) (pos4[x] + FIRST_ROW),(byte) (pos4[x+2])));
            }
            out.println();

            for(int x = 0; x < 4; x++)
            {
                out.println(pos1[x]);
                out.println(pos2[x]);
                out.println(pos3[x]);
                out.println(pos4[x]);
            }*/
        /*}
/*
        public  void  unmarkReachableFields  ()
        {
            byte     col = (byte) (column);
            char rowVar = (char) (row);
            if (Chessboard.this.isValidField (rowVar , col))
            {
                int     r = row - FIRST_ROW;
                int     c = col - FIRST_COLUMN;
                for (int x = 0; x < NUMBER_OF_ROWS; x++) {
                    for (int y = 0; y < NUMBER_OF_COLUMNS; y++)
                        Chessboard.this.fields[x][y].unmark();
                }
            }//deletes everything
        }
    }

    public  class  Bishop  extends  Chesspiece   {
        public  Bishop (char  color , char  name)
        {
            super (color , name);
        }

        public  void  markReachableFields  ()
        {
            //char rowVar = (char) (row);
            //byte     col = (byte) (column);
            int r = row - FIRST_ROW;
            int c = column - FIRST_COLUMN;

            int[] rList1 = new int[NUMBER_OF_ROWS];//row increasing
            int[] rList2 = new int[NUMBER_OF_ROWS];//row decreasing
            int[] cList1 = new int[NUMBER_OF_COLUMNS];//column increasing
            int[] cList2 = new int[NUMBER_OF_COLUMNS];//column decreasing

            int r1 = r;
            int r2 = r;
            int c1 = c;
            int c2 = c;
            for(int x = 0; x < NUMBER_OF_ROWS; x++)
            {
                rList1[x] = r1++;
                rList2[x] = r2--;
                cList1[x] = c1++;
                cList2[x] = c2--;

                //System.out.printf("! %d, %d, %d, %d ", r1, r2, c1, c2);
            }
            //System.out.println("\n");

            for(int x = 0; x < NUMBER_OF_ROWS; x++)
            {
                //System.out.printf("! %d, %d, %d, %d ", rList1[x], rList2[x], cList1[x], cList2[x]);

                /*if(rList1[x] < 8 && rList2[x] > -1 && cList1[x] < 9 && cList2[x] > 0)//need to split into 2 or 4
                {
                    Chessboard.this.fields[rList1[x]][cList1[x]].mark(); //r+ c+
                    Chessboard.this.fields[rList2[x]][cList2[x]].mark(); //r- c-
                    Chessboard.this.fields[rList1[x]][cList2[x]].mark(); //r+ c-
                    Chessboard.this.fields[rList2[x]][cList1[x]].mark(); //r- c+
                }*/
        /*
                if(rList1[x] < 8 && cList1[x] < 8)//r+ c+ // not 8 for second? // why not use isValidField???
                {
                    Chessboard.this.fields[rList1[x]][cList1[x]].mark();
                }
                if(rList2[x] > -1 && cList2[x] > -1)//r- c- //not 0 for second?
                {
                    Chessboard.this.fields[rList2[x]][cList2[x]].mark();
                }
                if(rList1[x] < 8 && cList2[x] > -1)//r+ c-
                {
                    Chessboard.this.fields[rList1[x]][cList2[x]].mark();
                }
                if(rList2[x] > -1 && cList1[x] < 8)//r- c+
                {
                    Chessboard.this.fields[rList2[x]][cList1[x]].mark();
                }
            }

            /*char rowVar = (char) (row);
            byte     col = (byte) (column);
            //int x = rowVar - FIRST_ROW - col;
            //int x = rowVar - FIRST_ROW;
            int x = rowVar - FIRST_ROW - FIRST_COLUMN;
            //int y = col - FIRST_COLUMN - 1;//why -1
            int y = col - FIRST_COLUMN -1;
            System.out.println(x);
            System.out.println(y);
            while(x < NUMBER_OF_ROWS && y < NUMBER_OF_COLUMNS)
            {
                Chessboard.this.fields[x][y].mark();
                x++;
                y++;
            }

            //x = rowVar - FIRST_ROW - col;
            //x = rowVar - FIRST_ROW;
            x = rowVar - FIRST_ROW - FIRST_COLUMN;
            //y = col - FIRST_COLUMN + rowVar - FIRST_ROW;
            y = col - FIRST_COLUMN + rowVar - FIRST_ROW;
            System.out.println(x);
            System.out.println(y);
            while(x < NUMBER_OF_ROWS && y >= 0)
            {
                Chessboard.this.fields[x][y].mark();
                x++;
                y--;
            }*/
       /* }

        public  void  unmarkReachableFields  ()
        {
            /*byte     col = (byte) (column);
            char rowVar = (char) (row);
            if (Chessboard.this.isValidField (rowVar , col))
            {
                int     r = row - FIRST_ROW;
                int     c = col - FIRST_COLUMN;
                for (int x = 0; x < NUMBER_OF_ROWS; x++) {
                    for (int y = 0; y < NUMBER_OF_COLUMNS; y++)
                        Chessboard.this.fields[x][y].unmark();
                }


            }*/
/*
            int r = row - FIRST_ROW;
            int c = column - FIRST_COLUMN;

            int[] rList1 = new int[NUMBER_OF_ROWS];//row increasing
            int[] rList2 = new int[NUMBER_OF_ROWS];//row decreasing
            int[] cList1 = new int[NUMBER_OF_COLUMNS];//column increasing
            int[] cList2 = new int[NUMBER_OF_COLUMNS];//column decreasing

            int r1 = r;
            int r2 = r;
            int c1 = c;
            int c2 = c;
            for(int x = 0; x < NUMBER_OF_ROWS; x++)
            {
                rList1[x] = r1++;
                rList2[x] = r2--;
                cList1[x] = c1++;
                cList2[x] = c2--;
            }

            for(int x = 0; x < NUMBER_OF_ROWS; x++)
            {
                if(rList1[x] < 8 && cList1[x] < 8)//r+ c+ // not 8 for second?
                {
                    Chessboard.this.fields[rList1[x]][cList1[x]].unmark();
                }
                if(rList2[x] > -1 && cList2[x] > -1)//r- c- //not 0 for second?
                {
                    Chessboard.this.fields[rList2[x]][cList2[x]].unmark();
                }
                if(rList1[x] < 8 && cList2[x] > -1)//r+ c-
                {
                    Chessboard.this.fields[rList1[x]][cList2[x]].unmark();
                }
                if(rList2[x] > -1 && cList1[x] < 8)//r- c+
                {
                    Chessboard.this.fields[rList2[x]][cList1[x]].unmark();
                }
            }

            /*char rowVar = (char) (row);
            byte     col = (byte) (column);
            //int x = rowVar - FIRST_ROW - col;
            //int x = rowVar - FIRST_ROW;
            int x = rowVar - FIRST_ROW - FIRST_COLUMN;
            //int y = col - FIRST_COLUMN - 1;//why -1
            int y = col - FIRST_COLUMN -1;
            System.out.println(x);
            System.out.println(y);
            while(x < NUMBER_OF_ROWS && y < NUMBER_OF_COLUMNS)
            {
                Chessboard.this.fields[x][y].unmark();
                x++;
                y++;
            }

            //x = rowVar - FIRST_ROW - col;
            //x = rowVar - FIRST_ROW;
            x = rowVar - FIRST_ROW - FIRST_COLUMN;
            //y = col - FIRST_COLUMN + rowVar - FIRST_ROW;
            y = col - FIRST_COLUMN + rowVar - FIRST_ROW;
            System.out.println(x);
            System.out.println(y);
            while(x < NUMBER_OF_ROWS && y >= 0)
            {
                Chessboard.this.fields[x][y].unmark();
                x++;
                y--;
            }*/

  /*      }
    }

    public  class  Queen  extends  Chesspiece   {
        public  Queen (char  color , char  name)
        {
            super (color , name);
        }

        public  void  markReachableFields  ()
        {
            int r = row - FIRST_ROW;
            int c = column - FIRST_COLUMN;

            byte     col = (byte) (column);
            char rowVar = (char) (row);

            //Rook part
            if (Chessboard.this.isValidField (rowVar , col)) {
                int ro = rowVar - FIRST_ROW;
                int co = col - FIRST_COLUMN;
                for (int x = 0; x < NUMBER_OF_ROWS; x++) {
                    Chessboard.this.fields[x][co].mark(); //marks all rows
                }
                for (int x = 0; x < NUMBER_OF_COLUMNS; x++) {
                    Chessboard.this.fields[ro][x].mark(); //marks all columns
                }
            }

            //Bishop part
            int[] rList1 = new int[NUMBER_OF_ROWS];//row increasing
            int[] rList2 = new int[NUMBER_OF_ROWS];//row decreasing
            int[] cList1 = new int[NUMBER_OF_COLUMNS];//column increasing
            int[] cList2 = new int[NUMBER_OF_COLUMNS];//column decreasing

            int r1 = r;
            int r2 = r;
            int c1 = c;
            int c2 = c;
            for(int x = 0; x < NUMBER_OF_ROWS; x++)
            {
                rList1[x] = r1++;
                rList2[x] = r2--;
                cList1[x] = c1++;
                cList2[x] = c2--;
            }

            for(int x = 0; x < NUMBER_OF_ROWS; x++)
            {
                if(rList1[x] < 8 && cList1[x] < 8)//r+ c+ // not 8 for second?
                {
                    Chessboard.this.fields[rList1[x]][cList1[x]].mark();
                }
                if(rList2[x] > -1 && cList2[x] > -1)//r- c- //not 0 for second?
                {
                    Chessboard.this.fields[rList2[x]][cList2[x]].mark();
                }
                if(rList1[x] < 8 && cList2[x] > -1)//r+ c-
                {
                    Chessboard.this.fields[rList1[x]][cList2[x]].mark();
                }
                if(rList2[x] > -1 && cList1[x] < 8)//r- c+
                {
                    Chessboard.this.fields[rList2[x]][cList1[x]].mark();
                }
            }
        }

        public  void  unmarkReachableFields  ()
        {
            byte     col = (byte) (column);
            char rowVar = (char) (row);
            if (Chessboard.this.isValidField (rowVar , col))
            {
                int     r = row - FIRST_ROW;
                int     c = col - FIRST_COLUMN;
                for (int x = 0; x < NUMBER_OF_ROWS; x++) {
                    for (int y = 0; y < NUMBER_OF_COLUMNS; y++)
                        Chessboard.this.fields[x][y].unmark();
                }
            }//deletes everything
        }
    }

    public  class  King  extends  Chesspiece   {
        public  King (char  color , char  name)
        {
            super (color , name);
        }

        public  void  markReachableFields  ()
        {
            byte     col = (byte) (column);
            char rowVar = (char) (row);
            if (Chessboard.this.isValidField (rowVar , col))
            {
                int     r = rowVar - FIRST_ROW - 1;
                int     c = col - FIRST_COLUMN - 1;

                //int counter = 0;
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) { // 2 loops to mark 9 spots from top left to bottom right with king in the center
                        //counter++;
                        //System.out.println(counter);
                        //System.out.println("x = " + x + "y = " + y);
                        //System.out.println("r = " + r + "c = " + c);
                        if(r >= NUMBER_OF_ROWS || c >= NUMBER_OF_COLUMNS || r < 0 || c < 0) //checks if mark position is inside field
                        {
                        }
                        else { // if it is mark it
                            Chessboard.this.fields[r][c].mark();
                        }
                        c++;
                    }
                    c = col - FIRST_COLUMN - 1; // need to reset else goes out of bounds
                    r++;
                }
            }
        }

        public  void  unmarkReachableFields  ()
        {//delete everything

            byte     col = (byte) (column);
            char rowVar = (char) (row);
            if (Chessboard.this.isValidField (rowVar , col))
            {
                int     r = row - FIRST_ROW;
                int     c = col - FIRST_COLUMN;
                for (int x = 0; x < NUMBER_OF_ROWS; x++) {
                    for (int y = 0; y < NUMBER_OF_COLUMNS; y++)
                        Chessboard.this.fields[x][y].unmark();
                }


            }
        }
    }

}
*/