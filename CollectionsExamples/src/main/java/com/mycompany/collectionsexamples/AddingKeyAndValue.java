/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.collectionsexamples;

/**
 *
 * @author JCLog
 */
public class AddingKeyAndValue {
    public static void main(String[] args) {
    // create a map that maps a country to its population
    HashMap<String, Integer> populations = new HashMap<>();
       
    // add the first country
    populations.put("USA", 313000000);
       
    // add the next country
    populations.put("Canada", 34000000);
       
    // add another country
    populations.put("United Kingdom", 63000000);
       
    // add another country
    populations.put("Japan", 127000000);
       
    // ask the map for its size
    System.out.println("Map size is: " + populations.size());
 }
}
