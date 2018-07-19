package com.mycompany.unittestingexcercises;
/**
 *
 * @author JCLog
 */
public class MischieviousChildren {
        // We have two children, a and b, and the parameters aSmile and 
    // bSmile indicate if each is smiling. We are in trouble if they 
    // are both smiling or if neither of them is smiling. Return true 
    // if we are in trouble. 
    //
    // areWeInTrouble(true, true) -> true
    // areWeInTrouble(false, false) -> true
    // areWeInTrouble(true, false) -> false
    public boolean areWeInTrouble(boolean aSmile, boolean bSmile) {
        boolean troubling = true;
        
        if(aSmile = true){
            if(bSmile = true){
            return troubling;
            }
        } else  if (aSmile = false){
            if(bSmile = false){
                return troubling;
            }
        } else {
            troubling = false;
        }
        return troubling;
    }
}
