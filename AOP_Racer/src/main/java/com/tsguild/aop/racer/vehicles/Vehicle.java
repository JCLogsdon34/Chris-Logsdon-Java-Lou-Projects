/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.aop.racer.vehicles;

import com.tsguild.aop.racer.engines.exceptions.EngineException;
import com.tsguild.aop.racer.interfaces.Driveable;
import com.tsguild.aop.racer.interfaces.Engine;
import com.tsguild.aop.racer.vehicles.exceptions.FlatTireException;
import com.tsguild.aop.racer.vehicles.exceptions.OutOfGasException;
import com.tsguild.aop.racer.vehicles.exceptions.StalledOutException;
import com.tsguild.aop.racer.vehicles.exceptions.VehicleException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 *
 * @author ahill
 */
public class Vehicle implements Driveable{
    
    protected Engine engine;
    protected BigDecimal odometer = BigDecimal.ZERO;
    protected BigDecimal gasTank = BigDecimal.ZERO; // in gallons;
    
    protected Random r = new Random();
    protected BigDecimal GAS_THRUPUT = new BigDecimal(1);
    protected BigDecimal MI_PER_KW = new BigDecimal(5);
    protected BigDecimal MAX_TANK_SIZE = new BigDecimal(50);
    
    protected int PERCENT_CHANCE_OF_FLAT = 10;
    
    public Vehicle(Engine anEngine){
        this.engine = anEngine;
    }

    @Override
    public BigDecimal drive() throws VehicleException{
        BigDecimal milesTraveled = BigDecimal.ZERO;
        try {
            BigDecimal gas = this.getGasFromTank();
            BigDecimal kwOfPower = this.engine.generateKWPower(gas);
            milesTraveled = this.convertPowerToMiles(gas);
            odometer = odometer.add(milesTraveled);
            this.possibleFlatTire();
        } catch (EngineException ex) {
            throw new VehicleException("Something's wrong with the Engine!", ex);
        }
        return milesTraveled;
    }
    
    private BigDecimal getGasFromTank() throws OutOfGasException{
        BigDecimal gas;
        if(gasTank.compareTo(BigDecimal.ZERO) < 1){
            // We're outta gas
            throw new OutOfGasException("No power, cap'n! We can't go any farther ...!");
        }else if(gasTank.compareTo(GAS_THRUPUT) < 1){
            // Not a lot of gas, but a bit
            gas = gasTank;
            gasTank = BigDecimal.ZERO;
        }else{
            // apparently plenty of gas!
            gas = GAS_THRUPUT;
            gasTank = gasTank.subtract(GAS_THRUPUT);
        }
        
        return gas;
    }
    
    private BigDecimal convertPowerToMiles(BigDecimal kw) throws StalledOutException{
        if(kw.compareTo(BigDecimal.ZERO) < 1){
            throw new StalledOutException("No power, cap'n! We can't go any farther ...!");
        }else{
            return kw.multiply(MI_PER_KW).setScale(1, RoundingMode.HALF_DOWN);
        }
    }
    
    private void possibleFlatTire() throws FlatTireException{
        int diceRoll = r.nextInt(100);
        if(diceRoll < PERCENT_CHANCE_OF_FLAT){
            throw new FlatTireException("OH NO! We've THROWN A SHOE!");
        }
    }
    
    // Helper functions
    public String getEngineInfo() {
        return engine.getClass().getSimpleName();
    }

    public BigDecimal readOdometer() {
        return odometer;
    }
    
    public BigDecimal readGasGauge() {
        return gasTank;
    }
    
    public void setGasTank(String moreGas) {
        gasTank = new BigDecimal(moreGas);
        if(gasTank.compareTo(MAX_TANK_SIZE) > 0){
            gasTank = MAX_TANK_SIZE;
        }
    }
    
    @Override
    public String getIdentifier() {
        return "a plain ol' car w/ a " + this.engine.getClass().getSimpleName() + " engine";
    }
    
}