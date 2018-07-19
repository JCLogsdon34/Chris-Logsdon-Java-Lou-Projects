/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clasworkcollections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author JCLog
 */
public class UsingLists {
    public static void main(String[] args){
        
        List<String> someNames;
        someNames = new ArrayList<>();
        
        System.out.println("This is what I have in my list: " + someNames.size());
        someNames.add("Bob");
        someNames.add("Sue");
        someNames.add("Red");
        someNames.add("Jed");
        someNames.add("Jim");
        someNames.add("Ben");
        System.out.println(someNames);  // Don;t do this
        
        Iterator<String> myOneUseListIterator = someNames.iterator();
        while(myOneUseListIterator.hasNext()){
            System.out.println("A name : " + myOneUseListIterator.next()); 
        }
        
        System.out.println("With an enhanced for-loop"); 
        for(String aName : someNames){
            System.out.println("A name : " + aName); 
        }
        
        //we can use this because it is an ordered list
        //This one is also easier to keep trackof where youa re int he lsit
        System.out.println("With a regular for-loop"); 
        for(int i = 0; i < someNames.size(); i++){
            System.out.println("A name : " + someNames.get(i)); 
        }
        
        someNames.add("Ben");
        
        System.out.println("Where is Ben in the list : " + someNames.contains("Ben"));
        System.out.println("Where is Ben in the list : " + someNames.remove("Ben"));
        

        System.out.println("Where is Ben in the list : " + someNames.indexOf("Ben"));
        for(int i = 0; i < someNames.size(); i++){
            System.out.println(i + " : " + someNames.get(i)); 
        }
        
        someNames.remove(3);
        someNames.add(3, "Ha, ha, ha");
        
        for(int i = 0; i < someNames.size(); i++){
            System.out.println(i + " : " + someNames.get(i)); 
        }
        
        Collection<String> listAsCollection = someNames;
        someNames.indexOf("Ben");
   //     listAsCollection.indexOf("Ben");  // Does not exist
    }
}
