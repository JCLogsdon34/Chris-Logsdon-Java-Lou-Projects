package com.mycompany.classworkgoblins;

/**
 *
 * @author JCLog
 */
public class TheArena {
    public static void main(String[] args){
        
        Weapon aSword = new Sword("Eduardo", "He is a run-of-the-mill Sword");
        Weapon aSuperSword = new Sword("Super Sword", "He is a Super mean Sword", 10);
        
        Goblin bob = new Goblin("Bob", 10, aSuperSword);
        Goblin kingGoblin = new Goblin("King Goblin", 10, aSword);
        
        int turn = 0;
        while(bob.getHitPoints() > 0
                && kingGoblin.getHitPoints() > 0){
        if(turn% 2 == 0){
            System.out.println("It is +" + bob.getName() + "'s turn! ");
            bob.hit(kingGoblin);
        }else{
            System.out.println("It is +" + kingGoblin.getName() + "'s turn! ");
            kingGoblin.hit(bob);
        }
        
         if(bob.getHitPoints() <= 0){
             System.out.println("Bob is dead");
         } else {
             System.out.println("Bob has triumphed");
         }  
         turn++;
         
         
        }
        
        
        
        }
        
    }
    

