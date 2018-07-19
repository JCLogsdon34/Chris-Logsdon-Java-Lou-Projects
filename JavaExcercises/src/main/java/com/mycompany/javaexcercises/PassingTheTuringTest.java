
package com.mycompany.javaexcercises;

import java.util.Scanner;

/**
 *
 * @author JCLog
 */
public class PassingTheTuringTest {
    public static void main(String[] args){
        String name;
        String color;
        String fruit;
        String num;
        Scanner userInput = new Scanner(System.in);
    
     System.out.println("Hello there!");
     System.out.println("What is your name");
     name = userInput.nextLine();
    
    System.out.println("Hi "+name+", what is your favorite color?");
    color = userInput.nextLine();
    System.out.println(color + "Huh, Blue? Mine's Electric Lime.");
    
    System.out.println("I really like limes. They're my favorite fruit, too.\n" +
    "What's YOUR favorite fruit," + name);
    fruit = userInput.nextLine();
    
    System.out.println("Really? "+ fruit + "? That's wild!\n" +
"Speaking of favorites, what's your favorite number?");
    num = userInput.nextLine();
    
    System.out.println(num + " is a cool number. Mine's -7.\n" +
"Did you know 42 * -7 is -294? That's a cool number too!");
    System.out.println("Well, thanks for talking to me, Zaphod!");
    }
}
