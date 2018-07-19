
package com.mycompany.methodwork;

import java.util.Scanner;

public class InterestCalculator {
    public static void main(String[] args){
        float annualInterestRate, principal, numOfYears, newBalance;
        String prompt1 = "Please enter your annual interest rate";
        String prompt2 = "Please enter your principal";
        String prompt3 = "Please enter your number of years";
        String inputer1;
        String inputer2;
        String inputer3;
        Scanner userInput = new Scanner(System.in);
        System.out.println(prompt1);
        inputer1 = userInput.nextLine();
        annualInterestRate = Float.parseFloat(inputer1); 
        System.out.println(prompt2);
        inputer2 = userInput.nextLine();
        principal = Float.parseFloat(inputer2); 
        System.out.println(prompt3);
        inputer3 = userInput.nextLine();
        numOfYears = Float.parseFloat(inputer3); 

        getAnnualTotal(annualInterestRate, principal, numOfYears);
  

    }
        public static void getAnnualTotal(float annualInterestRate, float principal, float numOfYears){

        float quarterlyInterestRate = annualInterestRate/4f;

        for(int i = 0; i < numOfYears; i++){

            float q1 = principal * (1 + (quarterlyInterestRate / 100));
            float q2 = q1 * (1 + (quarterlyInterestRate / 100));
            float q3 = q2 * (1 + (quarterlyInterestRate / 100));
            float q4 = q3 * (1 + (quarterlyInterestRate / 100));
            
            principal = q4;

            System.out.println("||Number of years invested: " + numOfYears + " || Current Year" + i + "||Principal Invested: " + principal + " ||Annual Interest Rate: " + annualInterestRate + " " + " ||New Amount of Money at Year's End: " + q4 + "||");

        }
    }
}
