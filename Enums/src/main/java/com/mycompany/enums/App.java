/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enums;

import static com.mycompany.enums.Week.FRIDAY;
import static com.mycompany.enums.Week.MONDAY;
import static com.mycompany.enums.Week.SATURDAY;
import static com.mycompany.enums.Week.SUNDAY;
import static com.mycompany.enums.Week.THURSDAY;
import static com.mycompany.enums.Week.TUESDAY;
import static com.mycompany.enums.Week.WEDNESDAY;
import java.util.Scanner;

/**
 *
 * @author JCLog
 */
public class App {

    public static void main(String[] args) {
        int dayOfWeek = 0;
        Scanner sc = new Scanner(System.in);
        String day = "";
        Week theDay = null;
        
        System.out.println("How many days into the week are we?");
        day = sc.nextLine();
        dayOfWeek = Integer.parseInt(day);
        whatDay(dayOfWeek);
    }

    

    public Week whatDay(int day) {
        Week well = null;
        switch (day) {
            case 1:
                 well = SUNDAY;
            case 2:
                 well = MONDAY;
            case 3:
                well = TUESDAY;
            case 4:
                well = WEDNESDAY;
            case 5:
               well =  THURSDAY;
            case 6:
                well = FRIDAY;
            case 7:
                well = SATURDAY;
            default:
                System.out.println("Invalid Input");             
        }
        return well;
    }
}