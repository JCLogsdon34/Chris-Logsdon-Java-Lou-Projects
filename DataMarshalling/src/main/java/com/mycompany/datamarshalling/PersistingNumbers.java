package com.mycompany.datamarshalling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author JCLog
 */
public class PersistingNumbers {

    public static void main(String[] args) throws IOException {

        ArrayList<Integer> programNumbers = new ArrayList<>();
        Scanner userInput = new Scanner(System.in);

        System.out.println("Welcome to NumberLand!");
        System.out.println("Press one to print out numbers!");
        System.out.println("Or press two in order to add numbers!");
        int choice = Integer.parseInt(userInput.nextLine());
        if (choice == 2) {
            System.out.println("Or press two in order to add numbers!");
            System.out.println("Write STOP to stop");
            while (true) {
                try {
                    int num = Integer.parseInt(userInput.nextLine());
                    programNumbers.add(num);
                } catch (NumberFormatException e) {
                    System.out.println("I see you got tired of numbers");
                    System.out.println("That is ok, so did I");
                    break;
                }
            }
        } else if (choice == 1) {
            ///first bring things out from cold storage
            Scanner reader = new Scanner(new BufferedReader(new FileReader("daNums.txt")));

            while (reader.hasNextLine()) {
                String lineToReadAndHopefullyNumber = reader.nextLine();
                int shouldBeANumber = Integer.parseInt(lineToReadAndHopefullyNumber);
                programNumbers.add(shouldBeANumber);
            }

            reader.close();

            System.out.println("Ok, here are your numbers");
            for (int num : programNumbers) {
                System.out.println(num);
            }
        } else {
            System.out.println("Dude, that was not an option");
        }
        FileWriter scribe = new FileWriter("daNums.txt");
        PrintWriter author = new PrintWriter(scribe);
        ///In here we have to get the numbers from the list 
        /// into the file. How do we do that!!!?
        for (int i = 0; i < programNumbers.size(); i++) {
            int numToWrite = programNumbers.get(i);
            author.println(numToWrite);
        }
        author.flush();
        author.close();
    }
}
