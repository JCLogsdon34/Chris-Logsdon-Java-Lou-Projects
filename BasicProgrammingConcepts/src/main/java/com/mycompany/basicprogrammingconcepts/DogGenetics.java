package com.mycompany.basicprogrammingconcepts;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author JCLog
 */
public class DogGenetics {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        Random randomizer = new Random();
        String dogName;
        int firstBreed = 0;
        int secondBreed = 0;
        int thirdBreed = 0;
        int fourthBreed = 0;
        int fifthBreed = 0;


        System.out.println("What is your dog's name?");
        dogName = userInput.nextLine();

        System.out.println(" Well then, I have this highly reliable report on "
                + dogName + "'s prestigious background right here.");

        System.out.println(dogName + " is: ");
        //put add outside of random() +1;
        firstBreed = randomizer.nextInt(35) + 1;

        secondBreed = randomizer.nextInt(25) +1;

        thirdBreed = randomizer.nextInt(15) + 1;

        fourthBreed = randomizer.nextInt(25) + 1;
        
        fifthBreed = 100 - firstBreed - secondBreed - thirdBreed - fourthBreed;

        System.out.println(firstBreed + "% Pembroke Corgi");
        System.out.println(secondBreed + "% Cardigan Corgi");
        System.out.println(thirdBreed + "% Dachshund");
        System.out.println(fourthBreed + "% German Shepherd");
        System.out.println(fifthBreed + "% English Sheep Dog");
        System.out.println("Wow, that's QUITE the dog!");
    }
}
