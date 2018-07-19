
package com.mycompany.javaexcercises;

import java.util.Scanner;

/**
 *
 * @author JCLog
 */
public class HealthyHearts {
     public static void main(String[] args) {
        String userAgeString;
        int userAge;
        int targetHeartRate;
        int minHeartRate;
        float maxHeartRate;
        Scanner inputReader = new Scanner(System.in);

        System.out.println("How Old Are You? ");
        userAgeString = inputReader.nextLine();
        userAge = Integer.parseInt(userAgeString);

        targetHeartRate = (220 - userAge);
        minHeartRate = targetHeartRate / 2;
        maxHeartRate = targetHeartRate * .85f;

        System.out.println("Your target maximum heart rate should be " + targetHeartRate + ".");
        
        System.out.println("Your target heart rate zone should be between " + minHeartRate + " " + "and"
                + " " + maxHeartRate + ".");
    }
}
