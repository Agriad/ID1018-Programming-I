import  java.util .*;     //  Scanner
import  static  java.lang.System.out;
class  OperationsWithNaturalNumbersGivenAsStrings
{
    public  static  void  main (String [] args)
    {
        out.println ("OPERATIONS  ON  NATURAL  NUMBERS " +
                "IN  CHARACTER  STRINGS");
//  enter  two  natural  numbers
        Scanner     in = new  Scanner (System.in);
        out.println ("two  natural  numbers:");
        String     tal1 = in.next  ();
        String     tal2 = in.next  ();
        out.println  ();
// add  the  numbers  and  show  the  result
        String     sum = add (tal1 , tal2); //refers to method below called add
        show (tal1 , tal2 , sum , '+'); // also refers to method below called show
//  subtract  the  numbers  and  show  the  result
// ***  WRITE  YOUR  CODE  HERE  ***
        String total = subtract(tal1, tal2);
        show (tal1, tal2, total, '-');
    }
    // The  add  method  accepts  two  natural  numbers  represented
// as  character  strings  and  returns  their  sum as a
//  character  string.
    public  static  String  add (String  num1 , String  num2)
    {
// ***  WRITE  YOUR  CODE  HERE  ***

        // pads numbers if one is smaller than the other with zeroes also it reverses the numbers
        StringBuilder sbNum1 = new StringBuilder(num1).reverse();
        StringBuilder sbNum2 = new StringBuilder(num2).reverse();
        for(int x = 0; x < num1.length() || x < num2.length(); x++)
        {
            if(num1.length() == num2.length())
            {
                break;
            }
            else if(num1.length() < num2.length())
            {
                sbNum1.append(0);
            }
            else
            {
                sbNum2.append(0);
            }
        }
        //sbNum1 = sbNum1.reverse();
        //sbNum2 = sbNum2.reverse();

        // puts the stringubilder into string into char array
        char[] array1 = sbNum1.toString().toCharArray();
        char[] array2 = sbNum2.toString().toCharArray();

        // calculates digit by digit
        int carry = 0;
        int sum = 0;
        int out = 0;
        //String[] result = new String[array1.length + array2.length]; //array length issue how to make perfect length? nvm redundant just use stringbuilder
        String result = "";
        StringBuilder sbResult = new StringBuilder(result);
        for(int x = 0; x < num1.length() ; x++)
        {//adds the digits
            sum = carry + Character.getNumericValue(array1[x]) + Character.getNumericValue(array2[x]);
            //sum = carry + array1[x] + array2[x]; //does not work probably because char addition instead of int addition
            //System.out.println(Character.getNumericValue(array1[x]) + " " + Character.getNumericValue(array2[x]));
            if(x == num1.length() - 1) //checks if it is the last number (overhang / deck) situation
            {
                //sbResult.append(sum); can't use stringbuilder as the datatype needs to be int
                sbResult.append(sum % 10); // adds last digit first to avoid half reverse number
                if(sum / 10 != 0) // checks if front digit exist or 0 and adds if not zero

                {
                    sbResult.append(sum / 10);
                }
                //System.out.println(sum);
            }
            else if(sum >= 10) // check if sum bigger and puts carry accordingly
            {
                out = sum % 10;
                sbResult.append(out);
                carry = sum / 10;
                //System.out.println(out);
            }
            else // if not more than 10 just add it // redundant as the one above it does it as well
            {
                carry = 0;
                sbResult.append(sum);
                //System.out.println(sum);
            }
        }
        return sbResult.reverse().toString(); //makes it a string while reversing it
    }
    // The  subtract  method  accepts  two  natural  numbers
//  represented  as  character  strings  and  returns  their
//  difference  as a character  string.
// The  first  number  is not  smaller  than  the  second
    public  static  String  subtract (String  num1 , String  num2)
    {
// ***  WRITE  YOUR  CODE  HERE  ***
        // pads numbers if one is smaller than the other with zeroes also it reverses the numbers
        StringBuilder sbNum1 = new StringBuilder(num1).reverse();
        StringBuilder sbNum2 = new StringBuilder(num2).reverse();
        for(int x = 0; x < num1.length() || x < num2.length(); x++)
        {
            if(num1.length() == num2.length())
            {
                break;
            }
            else if(num1.length() < num2.length())
            {
                sbNum1.append(0);
            }
            else
            {
                sbNum2.append(0);
            }
        }
        //sbNum1 = sbNum1.reverse();
        //sbNum2 = sbNum2.reverse();

        // puts the stringubilder into string into char array
        char[] array1 = sbNum1.toString().toCharArray();
        char[] array2 = sbNum2.toString().toCharArray();

        // calculates digit by digit
        int sum = 0;
        int borrow = 0;
        StringBuilder sbResult = new StringBuilder("");
        for(int x = 0; x < num1.length(); x++) //num1 - num2 // better to use get numeric value as it ensures int operation instead of char operation
        {
            if(borrow == 1) // checks to see if digit is borrowed from previous subtraction
            {
                if(array1[x] - 1 < array2[x]) // check to see if the operation needs to borrow again
                {
                    borrow = 1;
                    sum = 10 + array1[x] - array2[x] - 1;
                    sbResult.insert(0, sum);
                }
                else// if it doesn't then subtract away
                {
                    borrow = 0;
                    sum = array1[x] - array2[x] - 1;
                    sbResult.insert(0, sum);
                }
            }
            else if(array1[x] < array2[x]) //made for the first subtraction or if previous subtractions required no borrowing. Checks to see if it needs to borrow from the next digit
            {
                borrow = 1;
                sum = 10 + array1[x] - array2[x];
                sbResult.insert(0, sum);
            }
            else//if it doesn't need to borrow and has not borrowed then subtract away
            {
                borrow = 0;
                sum = array1[x] - array2[x];
                sbResult.insert(0, sum);
            }
        }

        return sbResult.toString();
    }



    // The  show  method  presents  two  natural  numbers , an
//  operator  and  the  result  string.
    public  static  void  show (String  num1 , String  num2 ,
                                String  result , char  operator)
    {
// set an  appropriate  length  on  numbers  and  result
        int     len1 = num1.length  ();
        int     len2 = num2.length  ();
        int     len   = result.length  ();
        int     maxLen = Math.max (Math.max (len1 , len2), len);
        num1 = setLen (num1 , maxLen  - len1);
        num2 = setLen (num2 , maxLen  - len2);
        result = setLen (result , maxLen  - len);
// show  the  expression
        out.println ("  " + num1);
        out.println ("" + operator + " " + num2);
        for (int i = 0; i < maxLen + 2; i++)
            out.print ("-");
        out.println  ();
        out.println ("  " + result + "\n");
    }
    // The  setLen  method  prepends  the  supplied  number  of
//  spaces  ato  the  beginning  of a string
    public  static  String  setLen (String s, int  nofSpaces)
    {
        StringBuilder     sb = new  StringBuilder (s);
        for (int i = 0; i < nofSpaces; i++)
            sb.insert (0, " ");
        return  sb.toString  ();
    }
}
