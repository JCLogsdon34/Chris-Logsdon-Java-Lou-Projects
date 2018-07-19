/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.olympians;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author ahill
 */
public class SpringOlympics {
    
    public static void main(String[] args) {
        
        // Instead of instantiating things in code
        // we go to the context factory where we defined our beans
        // the blueprint of how we want to build objects.
        ApplicationContext factoryOfChampions;
        // We have to instantiate a new ApplicationContext object, and tell it he file name.
        factoryOfChampions = new ClassPathXmlApplicationContext("application-context.xml");
        
        // Once we do that, we can retrieve beans. This retrieval call uses the name of the bean, and tells the factory the class
        // So that it will come out appropriately. If we use the wrong name, or the wrong class - it will throw a runtime exception here.
        Olympian nigel = factoryOfChampions.getBean("nigelTheExtremeCurler", Olympian.class);
        
        // Once we have the bean, assuming everything ^^^ went correctly, we can just use it like a normal object.
        System.out.println("Hey, what's your name?");
        System.out.println(nigel.getName());
        
        System.out.println("And who are you competing for?");
        System.out.println(nigel.getCountry());
        
        String eventTag = nigel.competeInEvent();
        System.out.println(nigel.getName() + " just competed in " + eventTag);
        
        // We can also retrieve a bean just by name or class - but that is a bit less precise.
        // Here, we just give the name, but that means that the factory just sends back the bean as an 'Object'.
        // To make it an Olympian again, we have to CAST it back into it's proper shape.
        Olympian jimbo = (Olympian)factoryOfChampions.getBean("cowTipperJimbo");
        SpringOlympics.interviewOlympian(jimbo);
        
        
        
    }
    
    static public void interviewOlympian(Olympian o){
        System.out.println("Hey, what's your name?");
        System.out.println(o.getName());
        
        System.out.println("And who are you competing for?");
        System.out.println(o.getCountry());
        
        String eventTag = o.competeInEvent();
        System.out.println(o.getName() + " just competed in " + eventTag);
    }
    
}
