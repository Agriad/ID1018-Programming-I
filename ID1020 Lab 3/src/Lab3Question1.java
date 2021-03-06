import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

/*README
Programs takes in a text file and turns all non alphabetic or blank spaces as blank
 */

public class Lab3Question1
{
    public void textFilter(String text) throws IOException  //throws exception so that it can complain if it
    // cannot find or create the file
    {
        BufferedReader br = new BufferedReader(new FileReader(text));
        String line = "";
        FileWriter fr = new FileWriter("TextModified.txt");  //make a new file with this name. Can use
    //buffered writer as well in addition
        while ((line = br.readLine()) != null)  //when there are words
        {
            //System.out.println("1");
            int x = 0;
            int limit = line.length();

            while (x < limit)  //while in the String check and change if needed
            {
                Character c = line.charAt(x);
                x++;

                if (!((Character.isAlphabetic(c)) || (c == ' ')))  //if not alphabetic or is blank
                {
                    fr.append(' ');
                }
                else
                {
                    fr.append(c);
                }
            }

            fr.append("\n");
        }

        fr.flush();
        fr.close();
    }

    public static void main(String[] args) throws IOException
    {
        Lab3Question1 filter = new Lab3Question1();
        String text = "Text.txt";

        filter.textFilter(text);
    }
}
