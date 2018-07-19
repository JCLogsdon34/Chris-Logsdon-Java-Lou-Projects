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
public class BirthStones {
      public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        int userInt = 0;
        String userIntString;
        int counter = 0;
        
        System.out.println("Hello, please the number that corresponds with your birth month: ");
        userIntString = userInput.nextLine();
        userInt = Integer.parseInt(userIntString);
        System.out.println(userIntString);

            if (userInt == 1){
                 System.out.println("1 - January - Garnet");
                counter++;
             } 
            if (userInt == 2){
                 System.out.println("2 - February - Amethyst");
                counter++;
             }
            if(userInt == 3){
                 System.out.println("3 - March - Aquamarine");
                counter++;
             } 

            if (userInt == 4){
                 System.out.println("4 - April - Diamond");
                counter++;
             } 
            if(userInt == 5){
                 System.out.println("5 - May - Emerald");
                counter++;
             } 
            if (userInt == 6){
                 System.out.println("6 - June - Pearl");
                counter++;
             }
            if(userInt == 7){
                 System.out.println("7 - July - Ruby");
                counter++;
             } 

            if (userInt == 8){
                 System.out.println("8 - August - Peridot");
                counter++;
             } 
            if(userInt == 9 ){
                 System.out.println("9 - September - Sapphire");
                counter++;
             } 
            if(userInt == 10){
                 System.out.println("10 - October - Opal");
                counter++;
             } 

            if (userInt == 11){
                 System.out.println("11 - November - Topaz");
                counter++;
             } 
            if(userInt == 12 ){
                 System.out.println("12 - December - Turquoise");
                counter++;
             } 
        }
    }