import static java.lang.System.out;
import java.util.Scanner;
import java.util.*;
import java.lang.*;

public class Test
{
    public static void main(String[] args) {



        /*
        int[] arr1 = {4, 2, 3, 1};

        out.println(Arrays.toString(arr1));

        int x1 = arr1[0];
        int y1 = arr1[1];
        if (arr1[1] < arr1[0]) {
            arr1[0] = y1;
            arr1[1] = x1;
        }

        /*out.println(Arrays.toString(arr1));

        for(int a = 0; a < 8; a++) {
            out.println();
            for(int b = 0; b < 8; b++) {
                out.print("--");
            }
        }*/

        /*StringBuilder sb = new StringBuilder();

        sb.append("  ");
        for (int x = 0; x < 8; x++) {
            sb.append((int) (1 + x) + "  ");
        }
        sb.append("\n");

        for (int x = 0; x < 8; x++) {
            sb.append((char) ('a' + x) + " ");
            for (int y = 0; y < 8; y++) {
                sb.append("-- ");
            }
            sb.append("\n");
        }
        String board = sb.toString();
        out.println(board);

        char charTest = 'a';
        byte byteTest = 1;

        out.println(charTest);
        out.println(byteTest);

        int[][] doubleArr = {{1, 2, 3}, {4, 5, 6}};

        for (int x = 0; x < 2; x++) {
            for (int y = 0; y < 3; y++) {
                out.println(doubleArr[x][y]);
            }
        }

        Scanner in = new Scanner(System.in);

        out.println("number input");
        //int number = in.nextInt();

        out.println((byte) (2));

        byte column = -1;
        byte     col = (byte) (column + 1);

        out.println(col);*/
        /*Random rand = new Random();
        String     n = "" + (char) (65 + rand.nextInt  (26));
        out.println(n);

        int x = 0;
        while(x < 10)
        {
            out.println(n);
            x++;
        }/*

        /*Test1 test = new Test1("Steve");
        test.print();
        out.println(test);*/

        /*char x = 1;
        char y = 2;
        out.print(x);
        out.print(y);
        out.print(x + y);*/


        /*out.println(121 % 10);

        out.println("number 1");
        Scanner in = new Scanner(System.in);
        String n1 = in.next();

        out.println("number 2");
        String n2 = in.next();

        char[] no1 = n1.toCharArray();
        char[] no2 = n2.toCharArray();


        int[] ar1 = new int[n1.length()];
        for (int x = 0; x < n1.length(); x++) {
            out.println(Character.getNumericValue(no1[x]));
        }

        for (int x = 0; x < n1.length() || x < n2.length(); x++) {
            out.println(x);
        }

        StringBuilder sbn1 = new StringBuilder(n1);
        for (int x = 0; x < n1.length() || x < n2.length(); x++) {
            out.println(sbn1.append(0));
        }

        show("123", "2", "125", '+' );

    }

    public static void show(String num1, String num2,
                            String result, char operator) {
// set an  appropriate  length  on  numbers  and  result
        int len1 = num1.length();
        int len2 = num2.length();
        int len = result.length();
        int maxLen = Math.max(Math.max(len1, len2), len);
        num1 = setLen(num1, maxLen - len1);
        num2 = setLen(num2, maxLen - len2);
        result = setLen(result, maxLen - len);
// show  the  expression
        out.println("  " + num1);
        out.println(operator + " " + num2); // (original) out.println("" + operator + " " + num2);
        for (int i = 0; i < maxLen + 2; i++)
            out.print("-");
        out.println();
        out.println("  " + result + "\n");
    }

    public static String setLen(String s, int nofSpaces) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < nofSpaces; i++)
            sb.insert(0, " ");
        return sb.toString();*/
    }
}


