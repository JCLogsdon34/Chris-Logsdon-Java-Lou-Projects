/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.aop.racer.engines.exceptions;

/**
 *
 * @author ahill
 */
public class MisfiredCylinderException extends EngineException{

    public MisfiredCylinderException(String message) {
        super(message);
    }

    public MisfiredCylinderException(String message, Throwable cause) {
        super(message, cause);
    }
    
}