package com.mycompany.addressbooklou.ui;

import com.mycompany.addressbooklou.dto.Address;
import java.util.List;

/**
 *
 * @author JCLog
 */
public class AddressBookView {
     private UserIO io;

    public AddressBookView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List Addresses");
        io.print("2. Create New Address");
        io.print("3. View an Address by Last Namet");
        io.print("4. View Number of Addresses in Book");   /// use addressList.length() or Hashmap.size()
        io.print("5. Remove an Address");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }
    
    

    public Address getNewAddressInfo() {
        String lastName = io.readString("Please enter a Last Name");
        String firstName = io.readString("Please enter First Name");
        String streetAddress = io.readString("Please enter the Street Address");
        Address currentAddress = new Address(lastName);
        currentAddress.setFirstName(firstName);
        currentAddress.setLastName(lastName);
        currentAddress.setStreetAddress(streetAddress);
        return currentAddress;
    }

    public void displayAddressList(List<Address> addressList) {
        for (Address currentAddress : addressList) {
            io.print(currentAddress.getLastName() + ": "
                    + currentAddress.getFirstName() + " "
                    + currentAddress.getStreetAddress());
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayNumberOfEntries(int numberOfEntries){
        String entries = "";
         entries = Integer.toString(numberOfEntries);
        io.print(entries);
    }
    
    public void displayDisplayAllBanner() {
        io.print("=== Display All Entries ===");
    }
    
    public void displayEntriesNumberBanner() {
        io.print("=== Display Entries Number ===");
    }

    public void displayCreateAddressBanner() {
        io.print("=== Create Address ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString(
                "Address successfully created.  Please hit enter to continue");
    }

    public void displayDisplayAddressBanner() {
        io.print("=== Display Address ===");
    }

    public void displayRemoveAddressBanner() {
        io.print("=== Remove Address ===");
    }

    public void displayRemoveSuccessBanner() {
        io.readString("Address successfully removed. Please hit enter to continue.");
    }

    public String getLastNameChoice() {
        return io.readString("Please enter the Last Name by which to search.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayAddress(Address address) {
        if (address != null) {
            io.print(address.getLastName());
            io.print(address.getFirstName());
            io.print(address.getStreetAddress());
            io.print("");
        } else {
            io.print("No such entry.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayErrorMessage(String errorMsg) {
	    io.print("=== ERROR ===");
	    io.print(errorMsg);
	}
}
