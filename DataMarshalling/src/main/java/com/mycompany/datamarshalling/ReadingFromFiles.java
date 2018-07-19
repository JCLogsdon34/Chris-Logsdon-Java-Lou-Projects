/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.datamarshalling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author JCLog
 */
public class ReadingFromFiles {
    
    public static void main(String[] args) throws FileNotFoundException{
        String fileLocation = "myBook.txt";
        FileReader librarian = new FileReader(fileLocation);
        BufferedReader translator = new BufferedReader(librarian);
        Scanner prompter = new Scanner(translator);
        
        System.out.println("First Line: " + prompter.nextLine());
        System.out.println("Second Line: " + prompter.nextLine());
        System.out.println("Third Line: " + prompter.nextLine());
        prompter.close();
        
        
        Scanner newPrompter = new Scanner(new BufferedReader(new FileReader("emptyFile")));
        System.out.println("First Line: " + newPrompter.nextLine());
        System.out.println("Second Line: " + newPrompter.nextLine());
        System.out.println("Third Line: " + newPrompter.nextLine());

        newPrompter.close();
        
        Scanner myBookPrompterAgain = new Scanner(new BufferedReader(new FileReader("myBook.txt")));
        int lineCounter = 0;
        
        while(myBookPrompterAgain.hasNextLine()){
            System.out.println(lineCounter + " : " + myBookPrompterAgain.nextLine());
            lineCounter++;
        }
        myBookPrompterAgain.close();
    }
}
