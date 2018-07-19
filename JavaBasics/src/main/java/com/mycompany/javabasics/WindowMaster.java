
package com.mycompany.javabasics;

import java.util.Scanner;

public class WindowMaster {
    public static void main(String[] args){
        System.out.println("Welcome to our window master program!!!!!!!!!!!  *********");
        float heightInFeet, widthInFeet;
        float windowArea, windowPerimeter, windowGlassCost, windowTrimCost, totalCost;
        
        float glassCostPerSqFt = 3.50f;
        float trimCostPerSqFt = 2.25f;

        heightInFeet = readValue("What is the window height (in ft)? ");

        widthInFeet = readValue("What is the window width (in ft)? ");
        
        windowArea = heightInFeet * widthInFeet;
        
        windowPerimeter = 2 * (heightInFeet + widthInFeet);
        
        windowGlassCost = glassCostPerSqFt * windowArea;
        
        windowTrimCost = windowPerimeter * trimCostPerSqFt;
        
        totalCost = windowGlassCost + windowTrimCost;
        
        System.out.println("");
        System.out.println("Your window is: " + heightInFeet + "ft x" + widthInFeet + "ft");
        System.out.println("Your window cost");
        System.out.println("Glass cost: $" + windowGlassCost);
        System.out.println("Trim cost: $" + windowTrimCost);
        System.out.println("Total cost: $" + totalCost);
    }
    
    public static float readValue(String prompt){
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        String input = sc.nextLine();
        float floatVal = Float.parseFloat(input);
        return floatVal;
    }
}
