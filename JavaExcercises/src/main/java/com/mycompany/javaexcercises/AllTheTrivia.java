
package com.mycompany.javaexcercises;

import java.util.Scanner;

/**
 *
 * @author JCLog
 */
public class AllTheTrivia {
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        String stringA = "Ab Urbe Condida";
        String stringB;
        String stringC;
        String stringD;
        
        System.out.println("How were years measured in Rome?");
        stringA = userInput.nextLine();
        System.out.println("What year did The Beatles come to America?");
        stringB = userInput.nextLine();
        System.out.println("What was Daniel Boone's primary income source?");
        stringC = userInput.nextLine();
        System.out.println("How many acres of trees exist per person in Kentucky?");
        stringD = userInput.nextLine();
        
        System.out.println("Whoa!)"+stringB+ "is the year that" + stringD);
        System.out.println("Wow!)"+stringA+ "was a" + stringC);
        System.out.println("Whoa!)"+stringD+ "is the year that" + stringC);
        System.out.println("My goodness!)"+stringD+ "is the amount of" + stringB);
    }
}
