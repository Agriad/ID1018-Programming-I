//import com.sun.tools.jdeprscan.scan.Scan;

import java.util.Scanner; //need to import this to scan input (done automatically by IJ)
import java.util.concurrent.TimeUnit;

public class Shop {
    public static void main(String [] args)
    {
        System.out.println("Welcome to the Kwik-E-Mart");
        System.out.println("How many hotdogs are you purchasing?"); //intro
        Scanner in = new Scanner(System.in);
        int hotdogs = in.nextInt();
        System.out.println("I'm sorry but the price is on your side. Could you tell me what the price is?");
        double price = in.nextDouble();
        //test delay start
        if(price == 0){
            System.out.println("Hey that is not free");
            /*int count = 0;
            count += 1;
            while(count <= 10){
                System.out.println();
            }*/
            //Thread.sleep(1000);
            //TimeUnit.SECONDS.sleep(3);
            System.out.println("Seriously, what is the price?");
            price = in.nextDouble();
        }
        double totalPrice = hotdogs * price;
        System.out.println("The total price is " + totalPrice + " dollars.");
        System.out.println("Thank you, come again!");
        //test delay ends

        /*while (price == 0){
            //test build
            System.out.println("Hey that is not free");
            System.out.println("Seriously, what is the price?");
            price = in.nextDouble();
        }
        double totalPrice = hotdogs * price;
        System.out.println("The total is " + totalPrice);
        System.out.println("Thank you, come again");*/

        /*if (price == 0){
            //test build
            System.out.println("Hey that is not free");
            }
        else {
            double totalPrice = hotdogs * price;
            System.out.println("The total is " + totalPrice);
            System.out.println("Thank you, come again");*/
        }
    }
//}
