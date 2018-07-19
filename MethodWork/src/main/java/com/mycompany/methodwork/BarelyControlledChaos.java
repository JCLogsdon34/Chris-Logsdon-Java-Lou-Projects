package com.mycompany.methodwork;

import java.util.Random;

/**
 *
 * @author JCLog
 */
public class BarelyControlledChaos {

    public static void main(String[] args) {
        String color = returnColor(); // call color method here 
        String animal = returnAnimal(); // call animal method again here 
        String colorAgain = returnColor(); // call color method again here 
        int weight = returnNumber(5, 200); // call number method, 
        // with a range between 5 - 200 
        int distance = returnNumber(10, 20); // call number method, 
        // with a range between 10 - 20 
        int number = returnNumber(10000, 20000); // call number method, 
        // with a range between 10000 - 20000 
        int time = returnNumber(2, 6); // call number method, 
        // with a range between 2 - 6            

        System.out.println("Once, when I was very small...");

        System.out.println("I was chased by a " + color + ", "
                + weight + "lb " + " miniature " + animal
                + " for over " + distance + " miles!!");

        System.out.println("I had to hide in a field of over "
                + number + " " + colorAgain + " poppies for nearly "
                + time + " hours until it left me alone!");

        System.out.println("\nIt was QUITE the experience, "
                + "let me tell you!");
    }

    // ??? Method 1 ??? 
    public static String returnColor() {
        Random randomizer = new Random();
        int y;
        String colorReturner = null;
        y = randomizer.nextInt(0) + 5;
        switch (y) {
            case 1:
                colorReturner = "red";
                break;
            case 2:
                colorReturner = "orange";
                break;
            case 3:
                colorReturner = "green";
                break;
            case 4:
                colorReturner = "blue";
                break;
            case 5:
                colorReturner = "purple";
                break;
        }
        return colorReturner;
    }

    // ??? Method 2 ??? 
    public static String returnAnimal() {
        Random randomizer = new Random();
        int y;
        String animalReturner = null;
        y = randomizer.nextInt(0) + 5;
        switch (y) {
            case 1:
                animalReturner = "red";
                break;
            case 2:
                animalReturner = "orange";
                break;
            case 3:
                animalReturner = "green";
                break;
            case 4:
                animalReturner = "blue";
                break;
            case 5:
                animalReturner = "purple";
                break;
        }
        return animalReturner;
    }

    // ??? Method 3 ??? 
    public static int returnNumber(int a, int b) {
        Random randomizer = new Random();
        int y;
        y = randomizer.nextInt(a) + b;
        return y;
    }
}
