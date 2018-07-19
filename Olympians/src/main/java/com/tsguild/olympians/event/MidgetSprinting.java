package com.tsguild.olympians.event;

/**
 *
 * @author ahill
 */
public class MidgetSprinting implements Event{

    @Override
    public String compete() {
        System.out.println("aieeEEEEEEEEE!");
        return "MidgetSprinting";
    }
    
}
