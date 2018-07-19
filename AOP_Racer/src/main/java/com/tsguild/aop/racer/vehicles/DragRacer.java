/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.aop.racer.vehicles;

import com.tsguild.aop.racer.interfaces.Engine;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author ahill
 */
public class DragRacer extends Vehicle{
    
    public DragRacer(Engine anEngine) {
        super(anEngine);
        
        this.GAS_THRUPUT = this.GAS_THRUPUT.multiply(new BigDecimal("5")).setScale(0, RoundingMode.HALF_DOWN);
        this.MAX_TANK_SIZE = new BigDecimal("20.00");
        this.MI_PER_KW  = this.GAS_THRUPUT.multiply(new BigDecimal(".9")).setScale(0, RoundingMode.HALF_DOWN);
        this.PERCENT_CHANCE_OF_FLAT = 5;
    }
    
    @Override
    public String getIdentifier() {
        return "a fancy drag racer w/ a " + this.engine.getClass().getSimpleName() + " engine";
    }
    
}
