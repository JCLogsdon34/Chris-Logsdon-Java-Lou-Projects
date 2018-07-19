/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javaexcercises;

import java.util.Scanner;

/**
 *
 * @author JCLog
 */
public class Modulos {
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        int userInt = 0;
        String userIntString;
        int counter = 0;
        
        System.out.println("Hello, please enter a number greater than zero: ");
        userIntString = userInput.nextLine();
        userInt = Integer.parseInt(userIntString);
        System.out.println(userIntString);
        if(userInt == 6 || userInt == 28 || userInt == 496 || userInt == 8128){
            System.out.println("Perfect Number");
        } else if(userInt == 2 || userInt == 5 || userInt == 7){
            System.out.println("prime number");
            System.out.println("1, " + userInt);
        } else {
        do{
            counter++;
            if (userInt % counter == 0){
                 System.out.println(counter);
                counter++;
             } 
            if (userInt % counter == 0){
                 System.out.println(counter);
                counter++;
             }
            if(userInt % counter == 0){
                 System.out.println(counter);
                counter++;
             } 

            if (userInt % counter == 0){
                 System.out.println(counter);
                counter++;
             } 
            if(userInt % counter == 0){
                 System.out.println(counter);
                counter++;
             } 
        }while(counter <= userInt);
        }
    }
}
