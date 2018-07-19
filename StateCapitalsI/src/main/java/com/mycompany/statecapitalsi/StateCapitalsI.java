
package com.mycompany.statecapitalsi;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author JCLog
 */
public class StateCapitalsI {
    public static void main(String[] args){
        Map<String, String> statesAndCapitols = new HashMap<>();
        statesAndCapitols.put("Kentucky", "Frankfort");
        statesAndCapitols.put("Tennessee", "Nashville");
        statesAndCapitols.put("Virginia", "Richmond");
        statesAndCapitols.put("Indiana", "Indianapolis");
        statesAndCapitols.put("Georgia", "Atlanta");
        statesAndCapitols.put("Missouri", "Jefferson City");
        statesAndCapitols.put("Louisiana", "Baton Rougue");
        statesAndCapitols.put("North Carolina", "Durham");
        statesAndCapitols.put("South Carolina", "Charlstown");
        statesAndCapitols.put("West Virginia", "Huntington");
        statesAndCapitols.put("Arkansas", "Little Rock");
        statesAndCapitols.put("Mississippi", "Biloxi");
        statesAndCapitols.put("Texas", "Austin");
        statesAndCapitols.put("Alabama", "Montgomery");
        
        
        System.out.println("=============States =================");     
        Set<String> states = statesAndCapitols.keySet();
        System.out.println("Here are the states: ");
        for(String aState: states){
            System.out.println(aState);
        }
        System.out.println("=================================================");     
        
        System.out.println("=============State Capitals =================");
        for(Map.Entry<String, String> pair: statesAndCapitols.entrySet()){
            System.out.println("Here are Capitols : "
                + pair.getValue());
        }
        System.out.println("=================================================");     
        
        System.out.println("=============States and Capitals =================");
        for(String aState : statesAndCapitols .keySet()){
            String capitol = statesAndCapitols .get(aState);
            System.out.println("This is " + aState + "'s capital: "
                + capitol);
        }
        System.out.println("=================================================");     
    }
}
