package com.mycompany.flooringmasterylou.dao;

import com.mycompany.flooringmasterylou.dto.Tax;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author JCLog
 */
public class DaoTaxStubImpl implements DaoTax {

    private Tax onlyTax;
    private List<Tax> taxList = new ArrayList<>();

    public DaoTaxStubImpl() {
        onlyTax.setState("KY");
        onlyTax.setTaxRate(new BigDecimal("6.25").setScale(2, RoundingMode.HALF_UP));
        taxList.add(onlyTax);
    }

    @Override
    public Tax createTax(String state) {
        if (state.equalsIgnoreCase(onlyTax.getState())) {
            return onlyTax;
        } else {
            return null;
        }
    }

    @Override
    public Tax removeTax(String state, Tax tax) {
        if (state.equalsIgnoreCase(onlyTax.getState())) {
            return onlyTax;
        } else {
            return null;
        }
    }

    @Override
    public Tax getTax(String state) {
        if (state.equalsIgnoreCase(onlyTax.getState())) {
            return onlyTax;
        } else {
            return null;
        }
    }

    @Override
    public List<Tax> getAllTax() {
        return taxList;
    }

    @Override
    public void loadTax() throws FlooringPersistenceException {
        /// nothing
    }

    @Override
    public Set<String> getStates() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
