/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.addressbooklou.dao;

import com.mycompany.addressbooklou.dto.Address;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author JCLog
 */
public class AddressBookDaoImpl implements AddressBookDao {
    
    private Map<String, Address> addresses = new HashMap<>();

    @Override
    public Address addAddress(String lastName, Address address)
            throws AddressBookLouPersistenceException {
        Address newAddress = addresses.put(lastName, address);
        writeBook();
        return newAddress;
    }

    @Override
    public List<Address> getAllAddresses()
            throws AddressBookLouPersistenceException {
        loadBook();
        return new ArrayList<Address>(addresses.values());
    }

    @Override
    public int getNumberOfEntries()
            throws AddressBookLouPersistenceException {
        loadBook();
        return new ArrayList<Address>(addresses.values()).size();
    }
    
    @Override
    public Address getAddress(String lastName)
            throws AddressBookLouPersistenceException {
        loadBook();
        return addresses.get(lastName);
    }

    @Override
    public Address removeAddress(String lastName)
            throws AddressBookLouPersistenceException {
        Address removedAddress = addresses.remove(lastName);
        writeBook();
        return removedAddress;
    }
    
    public static final String BOOK_FILE = "book.txt";
    public static final String DELIMITER = "::";

      private void loadBook() throws AddressBookLouPersistenceException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(BOOK_FILE)));
        } catch (FileNotFoundException e) {
            throw new AddressBookLouPersistenceException(
                    "-_- Could not load roster data into memory.", e);
        }
        String currentLine;
        String[] currentTokens;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Address currentAddress = new Address(currentTokens[0]);
            // Set the remaining vlaues on currentStudent manually
            currentAddress.setFirstName(currentTokens[1]);
            currentAddress.setLastName(currentTokens[2]);
            currentAddress.setStreetAddress(currentTokens[3]);
            addresses.put(currentAddress.getLastName(), currentAddress);
        }
        scanner.close();
    }


    private void writeBook() throws AddressBookLouPersistenceException{

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(BOOK_FILE));
        } catch (IOException e) {
            throw new AddressBookLouPersistenceException(
                    "Could not save student data.", e);
        }


        List<Address> addressList = this.getAllAddresses();
        for (Address currentAddress : addressList) {
            // write the Student object to the file
            out.println(currentAddress.getLastName() + DELIMITER
                    + currentAddress.getFirstName() + DELIMITER
                    + currentAddress.getLastName() + DELIMITER
                    + currentAddress.getStreetAddress());
            out.flush();
        }
        out.close();
    }
}