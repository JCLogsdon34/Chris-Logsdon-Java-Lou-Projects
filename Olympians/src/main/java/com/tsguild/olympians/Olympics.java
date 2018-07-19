/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.olympians;

import com.tsguild.olympians.event.*;

/**
 *
 * @author ahill
 */
public class Olympics {
    
    
    public static void main(String[] args) {
        
        // Llama jousting IS-A event, because it _implements_ the Event interface
        Event anEvent = new LlamaJousting();
        
        // To construct an olympian, we have to give it an event.
        // This is because the Olympian class has declared an EVENT as a parameter
        // of the Constructor.
        Olympian anAthlete = new Olympian(anEvent);
        
        // Once we do that, we can ask the olympian to compete - which should return the
        // event tag of the event that it just competed in.
        String result = anAthlete.competeInEvent();
        System.out.println(anAthlete.getName() + " just competed in "+result);
        
        // And this works just fine - except if I have new Events, and new Olympians etc.
        // I'd have to come in and change the code _manually_ and recompile before running.
        // This means I am not _truly_ loosely coupled.
        Olympian athleteTwo = new Olympian(new CowTipping());
        athleteTwo.setName("Wilbur");
        athleteTwo.setCountry("Montana");
        
        String resultTwo = athleteTwo.competeInEvent();
        System.out.println(athleteTwo.getName() + " just competed in "+resultTwo);
        
    }
    
    
}
