package test;

import java.util.Scanner;
import java.text.NumberFormat;
import java.lang.Math;
import java.math.*;
import java.math.RoundingMode;

public class test
{
    public static void main(String[] args)
    {
        // welcome the user to the program
        System.out.println("Welcome to the Download Time Estimator");
        System.out.println();  // print a blank line

        // create Scanner object and start a while loop
        Scanner sc = new Scanner(System.in);
        String choice = "y";
        while (choice.equalsIgnoreCase("y"))
        {
            // get user input
            System.out.print("Enter file size (MB):   ");
            double fileSize = sc.nextDouble();
            //get user input
            System.out.print("Enter download speed (MB/sec):  ");
            double downloadSpeed = sc.nextDouble();
// calculate the hour, minutes and seconds
            double totalSeconds;
            double totalMinutes;
            double totalHours;
            int hour;
            int minutes = 60;
            int seconds = 60;
            totalSeconds = fileSize / downloadSpeed;
            totalSeconds = totalSeconds / 3600;
            totalSeconds = seconds / 60;
            totalMinutes = ((int)(seconds))/60;
            totalHours =  ((int)(seconds))/3600;


            NumberFormat number = NumberFormat.getNumberInstance();
            number.setMaximumFractionDigits(0);


            String message =
                    "This download will take approximately " + number.format(totalHours) +
                            " hours\n"   + number.format(totalMinutes) + " minutes\n"
                            + number.format(totalSeconds) + " seconds\n"  ;
            System.out.println(message);



            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.next();
            System.out.println();
        }
    }
}