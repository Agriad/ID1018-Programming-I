public class Test1
{
    public static class Numbers
    {
        private int[] numbers =  null;

        public Numbers (int [] numbers)
        {
            int[] numbersCopy = numbers;
            int[] numbersTemp = new int[numbers.length];
            for(int x = 0; x < numbers.length; x++)
            {
                numbersTemp[x] = numbersCopy[x];
            }

            this.numbers = numbersTemp;
        }

        public Numbers[] numberArray (Numbers n)
        {
            Numbers[] numberArray = null;

            return numberArray;
        }

    }

    /*public static class Field {
        private char row;
        private byte column;
        //private  Chesspiece     piece = null;
        private boolean marked = false;
    }

    /*String testName;
    Integer dd = 7;
    public Test1(String name)
    {
        this.testName = name;
    }

    public Integer getDd() {

    }

    public String getTestName() {
        return testName;
    }

    public void print()
    {
        System.out.println("Test1 name is " + testName);
    }*/
}
