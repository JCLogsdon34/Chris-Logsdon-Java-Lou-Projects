/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.addressbooklou.dao;

import com.mycompany.addressbooklou.dto.Address;
import java.util.List;

/**
 *
 * @author JCLog
 */
public interface AddressBookDao {

    Address addAddress(String lastName, Address address)
            throws AddressBookLouPersistenceException;

    List<Address> getAllAddresses()
            throws AddressBookLouPersistenceException;
    
    public int getNumberOfEntries()
            throws AddressBookLouPersistenceException;

    Address getAddress(String lastName)
            throws AddressBookLouPersistenceException;

    Address removeAddress(String lastName)
            throws AddressBookLouPersistenceException;
}
