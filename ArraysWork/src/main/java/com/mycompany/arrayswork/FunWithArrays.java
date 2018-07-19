/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arrayswork;

/**
 *
 * @author JCLog
 */
public class FunWithArrays {

    public static void main(String[] args) {

        String[] llamaNames;
        llamaNames = new String[10];
        llamaNames[0] = "Felicity";
        llamaNames[1] = "Angelina";
        llamaNames[2] = "Snow White";
        llamaNames[3] = "Spectra";
        llamaNames[4] = "Dixie";
        llamaNames[5] = "Oreo";
        llamaNames[6] = "Boo";
        llamaNames[7] = "Floyd";
        llamaNames[8] = "Pepper";
        llamaNames[9] = "Kalidescope";
        //llamaNames[10] = "Serrano";   //ArrayIndexOutOfBoundsException: 10
        System.out.println(llamaNames[5]);

        for (int i = 0; i < llamaNames.length; i++) {   //for enhanced, just do datatype singular array name, then the arrayName you are iterating through
            System.out.println(llamaNames[i]);
        }
        
        int index = 0;
        while(index < llamaNames.length){
            System.out.println(llamaNames[index]);
            index++;
        }
        
        int sum = 0;
        int [] someNums = {
          56, -100, 3947, 22, 6474, 88   
        };
        System.out.println(someNums.length);
        System.out.println("The sum of the elements int his array is: " +someNums.length);
        
        for(int i = 0; i < someNums.length; i ++){
            sum = someNums[i] + sum;
        }
        System.out.println(sum);
    }
}
