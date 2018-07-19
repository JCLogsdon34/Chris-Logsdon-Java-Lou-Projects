package com.mycompany.datamarshalling;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author JCLog
 */
public class WritingFiles {
    public static void main(String[] args) throws IOException{
        String fileName = "TheBestBookEvar.txt";
        FileWriter scribe = new FileWriter(fileName);
        PrintWriter author = new PrintWriter(scribe);
        
        author.println("This is Mr.Hat, he is a puppet");
        author.println("And this is Mr.Twig, he is stick better used as firewood");
        author.println("Mr. Garrison loves them both");
        author.println("Which will he choose?");
        
        //Like commiting to the file or push
        author.flush();
        author.close();
        
        FileWriter respectfulScribe = new FileWriter(fileName, true);
        author = new PrintWriter(respectfulScribe);
        author.println("DUN DUN DUN");
        author.flush();
        author.close();
    }
}
