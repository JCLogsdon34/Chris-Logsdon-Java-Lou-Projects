package com.mycompany.flooringmasterylou.dao;

import com.mycompany.flooringmasterylou.dto.Tax;
import java.util.List;
import java.util.Set;

/**
 *
 * @author JCLog
 */
public interface DaoTax {

    public Set<String> getStates();

    Tax createTax(String state);

    Tax removeTax(String state, Tax tax);

    Tax getTax(String state);

    List<Tax> getAllTax();

    void loadTax() throws
            FlooringPersistenceException;
}
