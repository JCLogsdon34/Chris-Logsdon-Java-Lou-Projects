package com.mycompany.statecapitalsi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author JCLog
 */
public class StateCapitolsII {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        Map<String, Capital> statesAndCapitals = new HashMap<>();

     

        statesAndCapitals.put("Kentucky", new Capital("Frankfort", 25000, 15));
        statesAndCapitals.put("Tennessee", new Capital("Nashville", 684000, 526));
        statesAndCapitals.put("Virginia", new Capital("Richmond", 220300, 16));
        statesAndCapitals.put("NorthCarolina", new Capital("Durham", 30000, 350));
        statesAndCapitals.put("Indiana", new Capital("Indianapolis", 3684000, 700));
        statesAndCapitals.put("West Virginia", new Capital("Huntington", 205300, 35));
        statesAndCapitals.put("Mississippi", new Capital("Jackson", 173514, 113));

        System.out.println("=============State Capitols =================");
        for (Map.Entry<String, Capital> pair : statesAndCapitals.entrySet()) {
            System.out.println("Here are Capitols : "
                    + pair.getValue().getName() + " " + pair.getValue().getPop() + " " + pair.getValue().getArea());
        }
        System.out.println("=================================================");
        System.out.println("Please enter a population for state/capital matches"
                + " that are above that number");
        String userResponse = userInput.nextLine();
        int popChoice = Integer.parseInt(userResponse);
        System.out.println("=============State Capitols Bigger Than " + userResponse + "=================");
        for(String aState : statesAndCapitals.keySet()){
            Capital capital = statesAndCapitals.get(aState);
            if(capital.getPop() >= popChoice){
            System.out.println("This is " + aState + "'s capital: "
                + capital.getName() + " :" + capital.getPop() + " " + capital.getArea());
            }
        }
        System.out.println("=================================================");  
        
    }
}
