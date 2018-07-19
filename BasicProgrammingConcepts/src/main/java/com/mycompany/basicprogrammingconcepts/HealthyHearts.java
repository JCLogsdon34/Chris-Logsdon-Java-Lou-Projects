
package com.mycompany.basicprogrammingconcepts;

import java.util.Scanner;

/**
 *
 * @author JCLog
 */
public class HealthyHearts {
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        String userHeart = "";
        float useAge = 0;
        float userMaxRange = 0;
        float userMinRange = 0;
        float maxRangeConstant = .85f;
        float minRangeConstant = .55f;
        float heartMaxConstant = 220;
        float heartMax = 0;
        
        while(useAge > 105 || useAge < 10){
        System.out.println("Hello, what is your age?");
        userHeart = userInput.nextLine();
        useAge  = Float.parseFloat(userHeart);
        }
        
         heartMax = heartMaxConstant - useAge;       
         System.out.println("Your maximum heart rate should be " +  heartMax + " beats per minute.");
        
         userMaxRange = heartMax * maxRangeConstant;
         userMinRange = heartMax * minRangeConstant;
         
         System.out.println(" Your target HR Zone is " + userMaxRange+ " - " + userMinRange + "beats per minute");
         
    }
}
