
package com.mycompany.javabasics;

import java.util.Scanner;

/**
 *
 * @author JCLog
 */
public class Adder2 {
    
    public static void main(String[]args){
        int numOne = 0;
        int numTwo = 0;
        int sum = 0;
        Scanner userInput = new Scanner(System.in);
        
        String numOneString;
        String numTwoString;
        
        System.out.println("Please enter first number: ");
        numOneString = userInput.nextLine();
        
        System.out.println("Please enter the second number: ");
        numTwoString = userInput.nextLine();
        
        
        numOne = Integer.parseInt(numOneString);
        numTwo = Integer.parseInt(numTwoString);
        
        sum =  numOne + numTwo;
        
        System.out.println("The sum was: " + sum);
    }
}
