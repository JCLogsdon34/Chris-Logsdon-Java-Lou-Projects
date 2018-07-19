package com.mycompany.datamarshalling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author JCLog
 */
public class BookWriterApp {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String userResponse = "";
        String userLine = "";
        boolean keepOnKeepingOn = true;
         String fileLocation = "myLines.txt";
        FileReader librarian = new FileReader(fileLocation);
        BufferedReader translator = new BufferedReader(librarian);
        Scanner prompter = new Scanner(translator);
        FileWriter respectfulScribe = new FileWriter(fileLocation, true);
        PrintWriter author = new PrintWriter(respectfulScribe);

        do {
            System.out.println("Hello, do you have a line to write for me?");
            if (userResponse.equals("y")) {
                 keepOnKeepingOn = true;
            } else if (userResponse.equals("n") || userResponse.isEmpty()) {
                keepOnKeepingOn = false;
                break;
            }
            
            System.out.println("Please enter your line below, and hit enter");
            userResponse = prompter.nextLine();
            
            
         author.flush();
         author.close();
            
        } while (keepOnKeepingOn = true);
    }
}
