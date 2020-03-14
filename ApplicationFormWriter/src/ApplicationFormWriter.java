import java.util.*;
import  java.io.*;

public class ApplicationFormWriter
{
    public static void main(String [] args)
    throws Exception // not sure what this does
    {
        System.out.println("Welcome to the application form program");
        System.out.println("Please type in your name: " + "(First name, Last name) ");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        System.out.println("Please type in your date of birth: " + "(Year, Month, Date) ");
        String dateOfBirth = in.nextLine();
        System.out.println("Please type in your nationality: ");
        String country = in.nextLine();

        System.out.println("You entered: " + name + "  " + dateOfBirth + " " + country );
        System.out.println("Are these inputs correct? " + "Y/N");
        String ans = in.nextLine();
        ans.toLowerCase();
        if (ans.equals("yes") || (ans.equals("y")))
        {
            PrintWriter file = new PrintWriter("Form.txt"); // issue if no throws exception
            file.println("Name: " + name + System.lineSeparator() + "Date of birth: " + dateOfBirth + System.lineSeparator() + "Nationality: " + country);
            file.flush(); //not sure what this does
            System.out.println("Check the \"Form.txt\" file");
        }
        else
        {
            System.out.println("Please reset the program");
        }
    }
}
