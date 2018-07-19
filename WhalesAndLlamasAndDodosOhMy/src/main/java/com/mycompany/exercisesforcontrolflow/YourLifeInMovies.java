/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exercisesforcontrolflow;

import java.util.Scanner;

/**
 *
 * @author JCLog
 */
public class YourLifeInMovies {
     public static void main(String[] args){
        int theYear = 7;
        int up = 2005;
        int harryPotter = 1995;
        int spaceJam = 1985;
        int jurassicPark = 1975;
        int mASH = 1965;
        int theUserYear;          
        String theUserString;
        Scanner userInput = new Scanner(System.in);
        String theName;
        
        System.out.println("Hey, what is your name?");
        theName = userInput.nextLine();
        System.out.println("Ok, "+theName+ "guess what my number is!");
        theUserString = userInput.nextLine();
        theUserYear = Integer.parseInt(theUserString);
        
        if(theUserYear < mASH){
            System.out.println("MASH has been around for almost half a century!");
        } else if(theUserYear > mASH){
        if (theUserYear > jurassicPark){
            System.out.println("the original Jurassic Park release is closer to the lunar landing!");
        } else if (theUserYear > spaceJam){
            System.out.println("Space Jam came out not last decade, but the one before THAT!");
        } else if (theUserYear > harryPotter){
            System.out.println("the first Harry Potter came out over 15 years ago!");
        } else {
            System.out.println("Pixar's 'Up' came out half a decade ago");
        }
        }
    }
}
