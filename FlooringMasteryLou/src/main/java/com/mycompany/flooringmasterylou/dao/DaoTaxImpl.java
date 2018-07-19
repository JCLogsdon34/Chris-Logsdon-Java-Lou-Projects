package com.mycompany.flooringmasterylou.dao;

import com.mycompany.flooringmasterylou.dto.Tax;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author JCLog
 */
public class DaoTaxImpl implements DaoTax {

    private final Map<String, Tax> tax = new HashMap<>();

    @Override
    public Tax createTax(String state) {
        Tax currentTax = new Tax();
        tax.put(state, currentTax);
        return currentTax;
    }

    @Override
    public Tax removeTax(String state, Tax tax) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*
     */
    @Override
    public Tax getTax(String state) {
        return tax.get(state);
    }

    @Override
    public List<Tax> getAllTax() {
        Collection<Tax> taxes = tax.values();
        List<Tax> myList = new ArrayList<Tax>();
        myList.addAll(taxes);
        return myList;
    }

    @Override
    public Set<String> getStates() {
        Set<String> o = tax.keySet();
        return o;
    }

    public static final String TAX_FILE = "Data\\Taxes.txt";
    public static final String DELIMITER = ",";

    @Override
    public void loadTax() throws FlooringPersistenceException {
        Scanner scanner;
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(TAX_FILE)));
        } catch (FileNotFoundException e) {
            throw new FlooringPersistenceException(
                    "-_- Could not load Tax data into memory.", e);
        }
        String currentLine;
        String[] currentTokens;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Tax currentTax = new Tax();
            currentTax.setState(currentTokens[0]);
            currentTax.setTaxRate(new BigDecimal(currentTokens[1]).setScale(2, RoundingMode.HALF_UP));
            tax.put(currentTax.getState(), currentTax);
        }
        scanner.close();
    }
}
