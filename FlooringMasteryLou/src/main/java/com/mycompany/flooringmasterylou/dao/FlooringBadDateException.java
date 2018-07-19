/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmasterylou.dao;

/**
 *
 * @author JCLog
 */
public class FlooringBadDateException extends Exception {

    public FlooringBadDateException(String message) {
        super(message);
    }

    public FlooringBadDateException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
