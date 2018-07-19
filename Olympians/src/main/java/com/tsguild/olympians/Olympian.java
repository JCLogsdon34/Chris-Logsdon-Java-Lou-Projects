/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.olympians;

import com.tsguild.olympians.event.Event;

/**
 *
 * @author ahill
 */
public class Olympian{
        
    private String name;
    private Event event;
    private String country;
    
    
    public Olympian(Event e){
        this.event = e;
        this.country = "Unknown";
        this.name = "Bob";
    }
    
    public void setEvent(Event e){
        this.event = e;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getCountry(){
        return this.country;
    }
    
    public void setCountry(String newCountry){
        this.country = newCountry;
    }
    
    public String competeInEvent(){
        System.out.println("NOW COMPETING FOR...:" + country);
        String eventTag = event.compete();
        return eventTag;
    }
        
    
}
