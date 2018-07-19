/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.aop.racer.vehicles;

import com.tsguild.aop.racer.interfaces.Driveable;
import com.tsguild.aop.racer.vehicles.exceptions.VehicleException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 *
 * @author ahill
 */
public class HamsterBall implements Driveable{

    Random r = new Random();
    BigDecimal odometer = BigDecimal.ZERO;
    
    @Override // There's not a lot of logic to a Hamsterball...
    public BigDecimal drive() throws VehicleException {
        BigDecimal miles = new BigDecimal(r.nextDouble() * 10).setScale(1, RoundingMode.HALF_DOWN);
        odometer = odometer.add(miles);
        return miles;
    }
    
    public BigDecimal readOdometer() {
        return odometer;
    }

    @Override
    public String getIdentifier() {
        return "a Hamster Ball";
    }
    
}
