/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.aop.racer.interfaces;

import com.tsguild.aop.racer.vehicles.exceptions.VehicleException;
import java.math.BigDecimal;


/**
 *
 * @author ahill
 */
public interface Driveable {
    
    public BigDecimal drive() throws VehicleException;
    
    public BigDecimal readOdometer();
    
    public String getIdentifier();
    
}
