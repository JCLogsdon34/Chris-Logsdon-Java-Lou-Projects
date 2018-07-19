package com.mycompany.takingcalcsgetresults;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author JCLog
 */
public class MakingCalculations {
    
    private String[] probs;

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        Calculator work = new Calculator();
        LocalDate time = LocalDate.now();
        
        
        String CALCS_FILE = "calcs.txt";
        String RESULTS_FILE = "results.txt";
        String DELIMITER = "::";

        Scanner scanner = new Scanner(
                new BufferedReader(
                        new FileReader(CALCS_FILE)));

        String currentLine;
        String[] currentTokens;
        String mathOp = "";
        String opOne = "";
        String opTwo = "";
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            mathOp = currentTokens[0];
            opOne = currentTokens[1];
            opTwo = currentTokens[2];
            
        }
        scanner.close();

        BigDecimal solution = new BigDecimal("0");
        solution = work.useStuff(mathOp, opOne, opTwo);

        PrintWriter out = new PrintWriter(new FileWriter(RESULTS_FILE));
        List<String> solutionList = new ArrayList<>();
        
        String printBlock = "";
        printBlock = time.toString() + DELIMITER + solution.toString();
        solutionList.add(printBlock);

        for (Iterator<String> it = solutionList.iterator(); it.hasNext();) {
            String printerBlock = it.next();
            out.println(printerBlock);
            out.flush();
        }
        out.close();
    }
}
