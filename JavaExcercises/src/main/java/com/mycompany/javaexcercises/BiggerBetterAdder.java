
package com.mycompany.javaexcercises;

import java.util.Scanner;

/**
 *
 * @author JCLog
 */
public class BiggerBetterAdder {
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
    String stringA;
    String stringB;
    String stringC;
    int a;
    int b;
    int c;
    int sum;
    
    System.out.println("Please Give me a Number: ");
    stringA = userInput.nextLine();
    a = Integer.parseInt(stringA);
    
    System.out.println("Please Give me a Number: ");
    stringB = userInput.nextLine();
    b = Integer.parseInt(stringB);
    
    System.out.println("Please Give me a Number: ");
    stringC = userInput.nextLine();
    c = Integer.parseInt(stringC);
    
    sum = a + b + c;
    // a,b, and c stay the same, so the sum remains the same because they are constant 
    System.out.println(a + " " + b + " " + c + " " + sum + "");
    }
}
