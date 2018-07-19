/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methodwork;

import java.util.Random;

/**
 *
 * @author JCLog
 */
public class InClassWork {

    public static void main(String[] args) {
        String name = returnAnimal();
        System.out.println(name);
    }
    
    public static String sayHello(String name){
        return "Hello" + name;
    }
    
    public static void greetTrio(String personOne, String personTwo, String personThree){
        System.out.println(personOne);
        System.out.println(personTwo);
        System.out.println(personThree);
    }

    public static String returnAnimal() {
        Random randomizer = new Random();
        String animalReturner = null;

        switch (randomizer.nextInt(10)) {
            case 1:
                animalReturner = "Corgi";
                break;
            case 2:
                animalReturner = "Dachsund";
                break;
            case 3:
                animalReturner = "Aussie";
                break;
            case 4:
                animalReturner = "English Sheep Dog";
                break;
            case 5:
                animalReturner = "Lhasa Opso";
                break;
            case 6:
                animalReturner = "Racoon";
                break;
            case 7:
                animalReturner = "Irish Setter";
                break;
            case 8:
                animalReturner = "Irish Wolfhound";
                break;
            case 9:
                animalReturner = "Sicilian Shepherd";
                break;
            case 10:
                animalReturner = "Tibetan Terrier";
                break;
        }
        return animalReturner;
    }
}
