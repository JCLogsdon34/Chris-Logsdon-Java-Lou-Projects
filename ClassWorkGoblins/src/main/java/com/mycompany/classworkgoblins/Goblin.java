package com.mycompany.classworkgoblins;
/**
 *
 * @author JCLog
 */
public class Goblin {
    private String name;
    private int hitPoints;
    private Weapon myWeapon;
    
    public Goblin(String name, int hitPoints, Weapon aWeapon){
        this.name = name;  //gives value for the name
        this.hitPoints = hitPoints;
        this.myWeapon = aWeapon;
    }
    
    public Weapon getMyWeapon(){
        return this.myWeapon;
    }
    
    public void setMyWeapon(Weapon aWeapon){
        this.myWeapon = aWeapon;
    }
    
    //only  getter, we will not let them change the name
    public String getName(){
        return this.name;
    }
    
    public int getHitPoints(){
        return this.hitPoints;
    }
    
    public void setHitPoints(int hitPoints){
        this.hitPoints = hitPoints;
    }
    
    public void hit(Goblin opponent){
        myWeapon.hit(opponent);
    }
    
}
