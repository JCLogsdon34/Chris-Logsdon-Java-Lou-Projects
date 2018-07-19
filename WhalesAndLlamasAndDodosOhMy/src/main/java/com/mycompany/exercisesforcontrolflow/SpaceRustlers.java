
package com.mycompany.exercisesforcontrolflow;

/**
 *
 * @author JCLog
 */
public class SpaceRustlers {
     public static void main(String[] args) {

        int spaceships = 10;
        int aliens = 25;
        int cows = 100;

        if(aliens > spaceships){
            System.out.println("Vrroom, vroom! Let's get going!");
        } else{
            System.out.println("There aren't enough green guys to drive these ships!");
        }

        if(cows == spaceships){
            System.out.println("Wow, way to plan ahead! JUST enough room for all these walking hamburgers!");
        } 
        if (cows > spaceships){   
            //the if-else takes the flow to here and prints this line.
            //without the else with theif, then it skips to the else condition
            System.out.println("Dangit! I don't how we're going to fit all these cows in here!");
        } else {
            System.out.println("Too many ships! Not enough cows.");
        }
    }
}
