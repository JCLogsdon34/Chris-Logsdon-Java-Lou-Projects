
package com.mycompany.arrayswork;

/**
 *
 * @author JCLog
 */
public class FruitsBasket {
     public static void main(String[] args) {
         int orangeCounter = 0;
         int appleCounter = 0;
         
         String[] Oranges = new String [33];
         String[] Apples = new String [28];
        String[] fruit = {"Orange", "Apple", "Orange", "Apple", "Orange", 
            "Apple", "Orange", "Apple", "Orange", "Orange", "Orange", "Apple",
            "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", 
            "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", 
            "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", 
            "Orange", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple", 
            "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", 
            "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", 
            "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Orange"};

        // Fruit sorting code goes here!
        for(int i = 0; i < fruit.length; i++){
            if("Orange".equals(fruit[i])){
                orangeCounter++;
            } else {
                appleCounter++;
            }
        }   
        System.out.println("Apples: " + appleCounter + " Oranges: " + orangeCounter + "Total Fruit: " + appleCounter+orangeCounter);
        for(int i = 0; i < fruit.length; i++){
            if("Orange".equals(fruit[i])){
                Oranges[i] = "Orange";
            } else {
                appleCounter++;
                Apples[i] = "Apple";
            }
        
        for(int j = 0; j < Oranges.length; j++){
        System.out.println("Oranges: " + Oranges[j]);
        }
        for(int k = 0; k < Apples.length; k++){
        System.out.println("Apples: " + Apples[k]);
        }
        }
    }
}
