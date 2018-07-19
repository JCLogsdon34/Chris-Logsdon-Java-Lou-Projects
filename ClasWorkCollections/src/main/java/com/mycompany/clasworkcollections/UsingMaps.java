
package com.mycompany.clasworkcollections;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author JCLog
 */
public class UsingMaps {
    
    public static void main(String[] args){
        
        Map<String, String> favoriteColors = new HashMap<>();
        favoriteColors.put("Chris", "Green");
        favoriteColors.put("Matt", "Blue");
        favoriteColors.put("Stephen", "Pink");
        favoriteColors.put("Dylan", "Blue");
        favoriteColors.put("Brett", "Red");
        favoriteColors.put("Brian", "Blue");
        favoriteColors.put("Austyn", "Silver");
        
        Set<String> names = favoriteColors.keySet();
        System.out.println("Here are the people who listed a color: ");
        for(String aName: names){
            System.out.println(aName);
        }
        System.out.println("This is Austyn's favorite color: "
                + favoriteColors.get("Austyn"));
        System.out.println("This is Chase's favorite color: "
                + favoriteColors.get("Chase"));
        
        for(String aName : favoriteColors.keySet()){
            String favoriteColor = favoriteColors.get(aName);
            System.out.println("This is " + aName + "'s favorite color: "
                + favoriteColor);
        }
        
      //  favoriteColors.put("Dylan", "Black"); This will replance our Dylan's choice, blue
        System.out.println("There are this many entries in my map: "
                + favoriteColors.size());
        System.out.println("Now I will clear it: ");
        favoriteColors.clear();
        System.out.println("There are this many entries in my map: "
                + favoriteColors.size());
        
        System.out.println("Another way to iterate: ");
        
        for(Entry<String, String> pair: favoriteColors.entrySet()){
            System.out.println("Map name/key: "
                + pair.getKey());
            System.out.println("Map color/value: "
                + pair.getValue());
        }
    }
}
