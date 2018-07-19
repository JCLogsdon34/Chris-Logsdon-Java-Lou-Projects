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
public class GuessMe {
    public static void main(String[] args){
        int theNum = 7;
        int theUserGuess;          
        String theUserString;
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("Hey, guess what my number is!");
        theUserString = userInput.nextLine();
        theUserGuess = Integer.parseInt(theUserString);
        
        if(theUserGuess == theNum){
            System.out.println("Wow! You got it!");
        } else if (theUserGuess > theNum){
            System.out.println("Ha! Too high!");
        } else {
            System.out.println("Ha! Too low!");
        }
    }
}
