/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.basicprogrammingconcepts;

/**
 *
 * @author JCLog
 */
public class SummativeSums {

    public static void main(String[] args) {
        int[] firstSet = {1, 90, -33, -55, 67, -16, 28, -55, 15};
        int[] secondSet = {999, -60, -77, 14, 160, 301};
        int[] thirdSet = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130,
            140, 150, 160, 170, 180, 190, 200, -99};
        
        System.out.println("#1 Array Sum: " + arrayAdder(firstSet));
        System.out.println("#2 Array Sum: " + arrayAdder(secondSet));
        System.out.println("#3 Array Sum: " + arrayAdder(thirdSet));  
    }

    public static int arrayAdder(int[] numsArray) {
        int arraySum = 0;
        for (int i = 0; i < numsArray.length; i++) {
            arraySum = arraySum + numsArray[i];
        }
        return arraySum;
    }
}
