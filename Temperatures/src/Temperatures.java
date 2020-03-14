import java.util .*; // Scanner , Locale
class Temperatures
{
    public static void main ( String [] args )
    {
        System.out.println ("TEMPERATURES \n");
// input tools
        Scanner in = new Scanner ( System.in );
        in. useLocale ( Locale.US );
// enter the number of weeks and measurements
        System.out.print ("number of weeks : ");
        int nofWeeks = in. nextInt ();
        System.out.print ("number of measurements per week : ");
        int nofMeasurementsPerWeek = in. nextInt ();
// storage space for temperature data
        double [][] t = new double [ nofWeeks + 1][ nofMeasurementsPerWeek + 1];
// read the temperatures
        for (int week = 1; week <= nofWeeks ; week ++)
        {
            System.out.println ("temperatures - week " + week + ":");
            for (int reading = 1; reading <= nofMeasurementsPerWeek ; reading ++)
                t[ week ][ reading ] = in. nextDouble (); // check. loop in loop. adds in weeks first then changes weeks
        }
        System.out.println ();
// show the temperatures
        System.out.println ("the temperatures: ");
        for (int week = 1; week <= nofWeeks ; week ++)
        {
            for (int reading = 1; reading <= nofMeasurementsPerWeek ; reading ++)
                System.out.print (t[ week ][ reading ] + " "); // check same as before but print
            System.out.println ();
        }
        System.out.println ();
// the least , greatest and average temperature - weekly
        double [] minT = new double [ nofWeeks + 1];// this is an array of min val for each weeks
        double [] maxT = new double [ nofWeeks + 1];
        double [] sumT = new double [ nofWeeks + 1];
        double [] avgT = new double [ nofWeeks + 1];
// compute and store the least , greatest and average
// temperature for each week .
// *** WRITE YOUR CODE HERE ***

        //Double minPlace = minT[1]
        for (int posOne = 0; posOne < nofWeeks; posOne++)// need to place min values in the week to array
        {
            double min = t [posOne + 1] [1];
            for (int posTwo = 0; posTwo < nofMeasurementsPerWeek; posTwo++)// need to find min value. sort the thing
            {
                if (t[posOne + 1] [posTwo + 1] < min) // NOTE seems like it's [postTwo] need to change it for everything before: t[nofWeeks + 1] [nofMeasurementsPerWeek + 1] < min
                {
                    min = t [posOne + 1] [posTwo + 1];
                }
            }
            minT [posOne] = min;  //need to add min value to corresponding week. NOTE unlike prewritten this starts from 0
        }// min val

        for (int posOne = 0; posOne < nofWeeks; posOne++)
        {
            double max = t [posOne + 1] [1];
            for (int posTwo = 0; posTwo < nofMeasurementsPerWeek; posTwo++)
            {
                if (t [posOne + 1] [posTwo + 1] > max)
                {
                    max = t [posOne + 1] [posTwo + 1];
                }
            }
            maxT [posOne] = max;
        }// max val

        for (int posOne = 0; posOne < nofWeeks; posOne++)
        {
            double sum = 0;
            double amount = 0;
            for (int posTwo = 0; posTwo < nofMeasurementsPerWeek; posTwo++)
            {
                ++amount;
                sum += t [posOne + 1] [posTwo + 1];
            }
            sumT [posOne] = sum;
            avgT [posOne] = sum / amount;
        }// average

// show the least , greatest and average temperature for
// each week
// *** WRITE YOUR CODE HERE ***

        for (int pos = 0; pos < nofWeeks; pos++)
        {
            System.out.println("Week: " + (pos + 1));
            System.out.println("The lowest temperature is: " + minT[pos]);
            System.out.println("The highest temperature is: " + maxT[pos]);
            System.out.println("The average temperatures is: " + avgT[pos]+ System.lineSeparator());

        }

// the least , greatest and average temperature - whole period
        double minTemp = minT [1];
        double maxTemp = maxT [1];
        double sumTemp = sumT [1];
        double avgTemp = 0;
// compute and store the least , greatest and average
// temperature for the whole period
// *** WRITE YOUR CODE HERE ***

        for (int pos = 0; pos < nofWeeks; pos++)
        {
            if (minTemp > minT [pos])
            {
                minTemp = minT [pos];
            }
        }// min all

        for (int pos = 0; pos < nofWeeks; pos++)
        {
            if (maxTemp < maxT [pos])
            {
                maxTemp = maxT [pos];
            }
        }// max all

        sumTemp = 0;
        for (int pos = 0; pos < nofWeeks; pos++)
        {
            sumTemp += sumT [pos];
            //++amount;
        }
        avgTemp = sumTemp / (nofWeeks * nofMeasurementsPerWeek); //amount;

// show the least , greatest and average temperature for
// the whole period
// *** WRITE YOUR CODE HERE ***

        System.out.println("The lowest temperature in the whole period is: " + minTemp);
        System.out.println("The highest temperature in the whole period is: " + maxTemp);
        System.out.println("The average temperature in the whole period is: " + avgTemp);
// note variable no of week +1 redundant as program added uses standard from 0
    }
}














/*import java.util .*; // Scanner , Locale
class Temperatures
{
    public static void main ( String [] args )
    {
        System.out.println ("TEMPERATURES \n");
// input tools
        Scanner in = new Scanner ( System.in );
        in. useLocale ( Locale.US );
// enter the number of weeks and measurements
        System.out.print ("number of weeks : ");
        int nofWeeks = in. nextInt ();
        System.out.print ("number of measurements per week : ");
        int nofMeasurementsPerWeek = in. nextInt ();
// storage space for temperature data
        double [][] t = new double [ nofWeeks + 1][ nofMeasurementsPerWeek + 1];
// read the temperatures
        for (int week = 1; week <= nofWeeks ; week ++)
        {
            System.out.println ("temperatures - week " + week + ":");
            for (int reading = 1; reading <= nofMeasurementsPerWeek ; reading ++)
                t[ week ][ reading ] = in. nextDouble (); // check. loop in loop. adds in weeks first then changes weeks
        }
        System.out.println ();
// show the temperatures
        System.out.println ("the temperatures: ");
        for (int week = 1; week <= nofWeeks ; week ++)
        {
            for (int reading = 1; reading <= nofMeasurementsPerWeek ; reading ++)
                System.out.print (t[ week ][ reading ] + " "); // check same as before but print
            System.out.println ();
        }
        System.out.println ();
// the least , greatest and average temperature - weekly
        double [] minT = new double [ nofWeeks + 1];// this is an array of min val for each weeks
        double [] maxT = new double [ nofWeeks + 1];
        double [] sumT = new double [ nofWeeks + 1];
        double [] avgT = new double [ nofWeeks + 1];
// compute and store the least , greatest and average
// temperature for each week .
// *** WRITE YOUR CODE HERE ***

        //Double minPlace = minT[1]
        for (int posOne = 0; posOne < nofWeeks; posOne++)// need to place min values in the week to array
        {
            double min = t [posOne + 1] [1];
            for (int posTwo = 0; posTwo < nofMeasurementsPerWeek; posTwo++)// need to find min value. sort the thing
            {
                if (t[posOne + 1] [posTwo + 1] < min) // NOTE seems like it's [postTwo] need to change it for everything before: t[nofWeeks + 1] [nofMeasurementsPerWeek + 1] < min
                {
                    min = t [posOne + 1] [posTwo + 1];
                }
            }
            minT [posOne] = min;  //need to add min value to corresponding week. NOTE unlike prewritten this starts from 0
        }// min val

        /*for (int posOne = 0; posOne <= nofWeeks; posOne++)// need to place min values in the week to array
        {
            double min = t [1] [1];
            for (int posTwo = 0; posTwo <= nofMeasurementsPerWeek; posTwo++)// need to find min value. sort the thing
            {
                if (t[posOne + 1] [posTwo + 1] < min) // NOTE seems like it's [postTwo] need to change it for everything before: t[nofWeeks + 1] [nofMeasurementsPerWeek + 1] < min
                {
                    min = t [nofWeeks + 1] [nofMeasurementsPerWeek + 1];
                }
            }
            minT [posOne] = min;  //need to add min value to corresponding week. NOTE unlike prewritten this starts from 0
        }// min val*

        for (int posOne = 0; posOne < nofWeeks; posOne++)
        {
            double max = t [posOne + 1] [1];
            for (int posTwo = 0; posTwo < nofMeasurementsPerWeek; posTwo++)
            {
                if (t [posOne + 1] [posTwo + 1] > max)
                {
                    max = t [posOne + 1] [posTwo + 1];
                }
            }
            maxT [posOne] = max;
        }// max val

        //test prototype prototype
        /*for (int posOne = 0; posOne <= nofWeeks; posOne++)
        {
            double max = t [1] [1];
            double min = t [1] [1];
            for (int posTwo = 0; posTwo <= nofMeasurementsPerWeek; posTwo++)
            {
                if (t [nofWeeks + 1] [nofMeasurementsPerWeek + 1] > max)
                {
                    max = t [nofWeeks + 1] [nofMeasurementsPerWeek + 1];
                    if (t[nofWeeks + 1] [nofMeasurementsPerWeek + 1] < min)
                    {
                        min = t [nofWeeks + 1] [nofMeasurementsPerWeek + 1];
                    }
                }
            }
            maxT [posOne] = max;
            minT [posOne] = min;
        }// max min values*/

        /*for (int posOne = 0; posOne <= nofWeeks; posOne++)
        {
            double sum = 0; // what. nvm not accessed because it's modified first not called
            for (int posTwo = 0; posTwo <= nofMeasurementsPerWeek; posTwo++)
            {
                sum += t [nofWeeks + 1] [nofMeasurementsPerWeek + 1];
            }
            sumT [posOne] = sum;
        }// sum (redundant?)*


        for (int posOne = 0; posOne < nofWeeks; posOne++)
        {
            double sum = 0;
            double amount = 0;
            for (int posTwo = 0; posTwo < nofMeasurementsPerWeek; posTwo++)
            {
                ++amount;
                sum += t [posOne + 1] [posTwo + 1];
            }
            sumT [posOne] = sum;
            avgT [posOne] = sum / amount;
        }// average

        /*for (int posOne = 0; posOne < nofWeeks; posOne++)
        {
            double sum = 0;
            double amount = 0;
            for (int posTwo = 0; posTwo < nofMeasurementsPerWeek; posTwo++)
            {
                ++amount;
                sum += t [posOne + 1] [posTwo + 1];
            }
            sumT [posOne] = sum;
            avgT [posOne] = sum / amount;
        }// average*/

        //test prototype prototype
        /*for (int posOne = 0; posOne <= nofWeeks; posOne++)
        {
            double sum = 0;
            double amount = 0;
            for (int posTwo = 0; posTwo <= nofMeasurementsPerWeek; posTwo++)
            {
                ++amount;
                sum += t [nofWeeks + 1] [nofMeasurementsPerWeek + 1];
            }
            sumT [posOne] = sum / amount;
            avgT [posOne] = sum / amount;
        }// sum average value*

// show the least , greatest and average temperature for
// each week
// *** WRITE YOUR CODE HERE ***

        for (int pos = 0; pos < nofWeeks; pos++)
        {
            System.out.println("Week: " + (pos + 1));
            System.out.println("The lowest temperature is: " + minT[pos]);
            System.out.println("The highest temperature is: " + maxT[pos]);
            //System.out.println("Temperature sum " + sumT [pos]);// REMOVE
            System.out.println("The average temperatures is: " + avgT[pos]+ System.lineSeparator());

        }

// the least , greatest and average temperature - whole period
        double minTemp = minT [1];
        double maxTemp = maxT [1];
        double sumTemp = sumT [1];
        double avgTemp = 0;
// compute and store the least , greatest and average
// temperature for the whole period
// *** WRITE YOUR CODE HERE ***

        for (int pos = 0; pos < nofWeeks; pos++)
        {
            if (minTemp > minT [pos])
            {
                minTemp = minT [pos];
            }
        }// min all

        for (int pos = 0; pos < nofWeeks; pos++)
        {
            if (maxTemp < maxT [pos])
            {
                maxTemp = maxT [pos];
            }
        }// max all

        //prototype prototype
        /*for (int pos = 0; pos <= nofWeeks; pos++)
        {
            if (minTemp > minT [pos])
            {
                minTemp = minT [pos];
                if (maxTemp < maxT [pos])
                {
                    maxTemp = maxT [pos];
                }
            }
        }// min max all*/

        /*for (int pos = 1; pos <= nofWeeks; pos++)
        {
            sumTemp += sumT [pos];
        }//sum (redundant?)*/

        /*double amount = 1;
        for (int pos = 1; pos < nofWeeks; pos++)
        {
            sumTemp += sumT [pos];
            amount++;
        }
        avgTemp = sumTemp / amount;*

        //double amount = 1;
        sumTemp = 0;
        for (int pos = 0; pos < nofWeeks; pos++)
        {
            sumTemp += sumT [pos];
            //++amount;
        }
        avgTemp = sumTemp / ((nofWeeks) * (nofMeasurementsPerWeek)); //amount;
// 2 weeks 0 1 2
        // 0 = 0 1=6 2=15
        //sumTemp =

// show the least , greatest and average temperature for
// the whole period
// *** WRITE YOUR CODE HERE ***

        System.out.println("The lowest temperature in the whole period is: " + minTemp);
        System.out.println("The highest temperature in the whole period is: " + maxTemp);
        System.out.println("The average temperature in the whole period is: " + avgTemp);
// note variable no of week +1 redundant as program added uses standard from 0
        //System.out.println("All sum " + sumTemp); //REMOVE
    }
}*/