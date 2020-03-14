import static java.lang.System.out;
//import java.lang.reflect.Array;
import java.util.*;
//import java.text.*;
import static java.lang.System.lineSeparator;

//when done add an option to choose how many words user wants to compare
// can be condensed by using only 1 loop for indexing the string values

public class WordSorter
{
    public static void main(String [] args)
    {
        out.println("Welcome to the word sorter" + System.lineSeparator() + "Please enter 5 words");
        Scanner in = new Scanner (System.in);

        String [] words = new String[5];

        //String words = in.nextLine();

        for (int index = 0; index < words.length; index++)
        {
            words[index] = in.nextLine();
        }
        // (up) adding user input into array

        //out.println(Arrays.toString(words));
        //out.println(words[0].length());

        for (int x = 0; x < 5; x++)
        {
            out.println(words[x].length());
        }
        // (up) print the array of words length

        double avg = 0;
        double meanVal = 0;
        for (int counter1 = 0; counter1 < 5; counter1++)
        {
            avg += words[counter1].length();
            meanVal = avg / words.length;
        }
        out.println(meanVal);
        //(up) mean value of string character
        // doesn't need to be different variable name

        double min = words[0].length();
        for (int x = 0; x < 5; x++) //originally 1
        {
            if (words[x].length() < min)
            {
                min = words[x].length();
            }

        }
        out.println(min);
        //(up) min value sorter
        //can be x again as it is different "branch"

        double max = words[4].length();
        for (int x = 4; x > 0; x--)
        {
            if (words[x].length() > max)
            {
                max = words[x].length();
            }
        }
        out.println(max);
        //(up) max value sorter (NOT WORKING)
        //starts from the top now

        double sum = 0;
        for (int x = 0; x < 5; x++)
        {
            sum += words[x].length();
        }
        //(up) adds the number of total char
        out.println(sum);

        out.println("The average character length is: " + meanVal);
        out.println("The minimum value character is: " + min);
        out.println("The maximum value character is: " + max);
        out.println("The total amount of character is: " + sum);

        /*String enter = lineSeparator();
        out.format("The average character length is: %s" + enter + "The minimum value character is: %d" + enter +
                "The maximum value character is: %d" + enter + "The total amount of character is: %d", meanVal, min, max, sum);*/
        /*out.format("The average character length is: %s", meanVal + enter + "The minimum value character is: %d", min + enter +
                "The maximum value character is: %d", max + enter + "The total amount of character is: %d", sum);*/
    }
}
