
package com.mycompany.classworkgoblins;

import java.util.Random;

/**
 *
 * @author JCLog
 */
public class Sword extends Item implements Weapon{
    
    private static Random diceRoller = new Random();
    private int damageDice;
    
    public Sword(String name, String description){
        super(name, description);
        this.damageDice = 5;
    }
    
     public Sword(String name, String description, int damageDice){
        super(name, description);
        this.damageDice = damageDice;
    }
    
    @Override
     public int rollDamage(){
         return diceRoller.nextInt(damageDice) + 1;
     }
     
    @Override
    public void hit(Goblin g){
     int damageToDo = this.rollDamage();
     int goblinLifePoints = g.getHitPoints();
     int remainingLife = goblinLifePoints - damageToDo;
     g.setHitPoints(remainingLife);
    }
}
