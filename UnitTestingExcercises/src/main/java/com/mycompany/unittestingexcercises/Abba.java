package com.mycompany.unittestingexcercises;

/**
 *
 * @author JCLog
 */
public class Abba {
     // Given two Strings, a and b, return the result of putting 
    // them together in the order abba, e.g. "Hi" and "Bye" 
    // returns "HiByeByeHi". 
    //
    // abba("Hi", "Bye") -> "HiByeByeHi"
    // abba("Yo", "Alice") -> "YoAliceAliceYo"
    // abba("What", "Up") -> "WhatUpUpWhat"
    public String abba(String a, String b) {
        String newString = "";
        newString = a + b + b + a;
       return newString;
    }

}
