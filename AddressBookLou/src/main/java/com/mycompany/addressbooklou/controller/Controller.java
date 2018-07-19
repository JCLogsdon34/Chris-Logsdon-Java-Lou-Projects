/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.addressbooklou.controller;

import com.mycompany.addressbooklou.dao.AddressBookDao;
import com.mycompany.addressbooklou.dao.AddressBookLouPersistenceException;
import com.mycompany.addressbooklou.dto.Address;
import com.mycompany.addressbooklou.ui.AddressBookView;
import com.mycompany.addressbooklou.ui.UserIO;
import com.mycompany.addressbooklou.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author JCLog
 */
public class Controller {

    AddressBookView view;
    AddressBookDao dao;
    private UserIO io = new UserIOConsoleImpl();

    public Controller(AddressBookDao dao, AddressBookView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        listAddresses();
                        break;
                    case 2:
                        createAddress();
                        break;
                    case 3:
                        viewAddress();
                        break;
                    case 4:
                        getEntries();
                        break;
                    case 5:
                        removeAddress();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (AddressBookLouPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void getEntries() throws AddressBookLouPersistenceException {
        int numberOfEntries = 0;
        view.displayEntriesNumberBanner();
        numberOfEntries = dao.getNumberOfEntries();
        view.displayNumberOfEntries(numberOfEntries);
    }

    private void createAddress() throws AddressBookLouPersistenceException {
        view.displayCreateAddressBanner();
        Address newAddress = view.getNewAddressInfo();
        dao.addAddress(newAddress.getLastName(), newAddress);
        view.displayCreateSuccessBanner();
    }

    private void listAddresses() throws AddressBookLouPersistenceException {
        view.displayDisplayAllBanner();
        List<Address> addressList = dao.getAllAddresses();
        view.displayAddressList(addressList);
    }

    private void viewAddress() throws AddressBookLouPersistenceException {
        view.displayDisplayAddressBanner();
        String lastName = view.getLastNameChoice();
        Address address = dao.getAddress(lastName);
        view.displayAddress(address);
    }

    private void removeAddress() throws AddressBookLouPersistenceException {
        view.displayRemoveAddressBanner();
        String lastName = view.getLastNameChoice();
        dao.removeAddress(lastName);
        view.displayRemoveSuccessBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

}
