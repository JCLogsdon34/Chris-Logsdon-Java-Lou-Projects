
package com.mycompany.randomexercises;

import java.util.Random;

/**
 *
 * @author JCLog
 */
public class ALittleChaos {
     public static void main(String[] args) {

        Random randomizer = new Random();

        System.out.println("Random can make integers: " + randomizer.nextInt());
        System.out.println("Or a double: " + randomizer.nextDouble());
        System.out.println("Or even a boolean: " + randomizer.nextBoolean());

        int num = randomizer.nextInt(150);

        System.out.println("You can store a randomized result: " + num);
        System.out.println("And use it over and over again: " + num + ", " + num);
        ///these were the same numbers
        System.out.println("Or just keep generating new values");
        System.out.println("Here's a bunch of numbers from 0 - 100: ");

        System.out.print(randomizer.nextInt(50) + 50 + ", ");
        System.out.print(randomizer.nextInt(50) + 50 + ", ");
        System.out.print(randomizer.nextInt(50) + 50 + ", ");
        System.out.print(randomizer.nextInt(50) + 50 + ", ");
        System.out.print(randomizer.nextInt(50) + 50 + ", ");
        //The above gave me 69, 60, 65, 67, 89, 87, 
        //the 50 + 50 gives a top and bottom limit to the randomizer
        System.out.println(randomizer.nextInt(50) + 50);
    }
}
