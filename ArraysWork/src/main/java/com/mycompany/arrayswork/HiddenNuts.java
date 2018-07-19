
package com.mycompany.arrayswork;

import java.util.Random;

/**
 *
 * @author JCLog
 */
public class HiddenNuts {
     public static void main(String[] args) {

        String[] hidingSpots = new String[100];
        Random squirrel = new Random();
        hidingSpots[squirrel.nextInt(hidingSpots.length)] = "Nut";
        System.out.println("The nut has been hidden ...");
        for(int i =0; i < hidingSpots.length; i++){
            if("Nut".equals(hidingSpots[i])){
                System.out.println("The Nut is at index # " + i);
            }
        }
		// Nut finding code should go here! 
    }
}
