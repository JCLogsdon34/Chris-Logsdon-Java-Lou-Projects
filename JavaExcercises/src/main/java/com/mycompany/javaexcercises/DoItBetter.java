
package com.mycompany.javaexcercises;

import java.util.Scanner;

/**
 *
 * @author JCLog
 */
public class DoItBetter {
    public static void main(String[] args){
        String run;
        int myDist;
        int myDistReal;
        String lang;
        int numLang;
        int numLangReal;
       String hotDog;
       int hotDogNum;
       int hotDogNumReal;
        Scanner userInput = new Scanner(System.in);
    
     System.out.println("Hello there!");
     System.out.println("How far can you run?");
     run = userInput.nextLine();
     myDist = Integer.parseInt(run);
     myDistReal = myDist * 2;
    
    System.out.println("Well "+run+"Ks eh? I can go"+myDistReal );

     System.out.println("How many hot dogs can you eat?");
     hotDog  = userInput.nextLine();
     hotDogNum = Integer.parseInt(hotDog);
     hotDogNumReal = hotDogNum * 2;

    System.out.println("Well, well,well "+hotDog+" eh? I can eat"+hotDogNumReal);
    
    
    System.out.println("Alright, alright, how many languages do you speak?");
     lang  = userInput.nextLine();
     numLang = Integer.parseInt(lang);
     numLangReal = numLang * 2;
     
     System.out.println("Haha "+lang+"!!? I can speak"+numLangReal);
    }
}
