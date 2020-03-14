class TheShortestPath
{
    // The  method  intermediateStations  returns a vector  of the
//  intermediate  stations  that  are on the  shortest  path.
// The  ordinal  number  of the  first  station  is  located  in
//  index 1 of the  vector , and  the  second  station  on index  2.
    public  static  int []  intermediateStations (double  [] a,
                                                  double  [][] b,
                                                  double  [] c)
    {
// ***  WRITE  YOUR  CODE  HERE  ***
        double min = a[0] + b[0][0] + c[0];
        int minX = 0;
        int minY = 0;
        for(int x = 0; x < a.length; x++)
        {
            for(int y = 0; y < c.length; y++)
            {
                if(min > a[x] + b[x][y] + c[y])
                {
                    min = a[x] + b[x][y] + c[y];
                    minX = x;
                    minY = y;
                }
            }
        }
        //int[] answer = new int[] {minX, minY};
        //return answer;
        return new int[] {minX + 1, minY + 1};
    }
    // The  method  length  returns  the  length  of the  shortest  path.
    public  static  double  length (double  [] a,
                                    double  [][] b,
                                    double  [] c)
    {
// ***  WRITE  YOUR  CODE  HERE  ***
        double min = a[0] + b[0][0] + c[0];
        for(int x = 0; x < a.length; x++)
        {
            for(int y = 0; y < c.length; y++)
            {
                if(min > a[x] + b[x][y] + c[y])
                {
                    min = a[x] + b[x][y] + c[y];
                }
            }
        }
        return min;
    }
}
