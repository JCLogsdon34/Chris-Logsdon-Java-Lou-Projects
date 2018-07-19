package com.mycompany.flooringmasterylou.dao;

import com.mycompany.flooringmasterylou.dto.Order;
import com.mycompany.flooringmasterylou.dto.Tax;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author JCLog
 */
public class DaoTaxImplTest {

    private DaoTax tax;

    public DaoTaxImplTest() {
        tax = new DaoTaxImpl();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetAllTaxes() throws FlooringPersistenceException {
        tax.loadTax();
        assertEquals(4, tax.getAllTax().size());
    }

    @Test
    public void testGetTax() throws FlooringPersistenceException {
        tax.loadTax();
        String state = "KY";
        assertEquals(state, tax.getTax(state).getState());
    }

    @Test
    public void testGetTaxRate() throws FlooringPersistenceException {
        tax.loadTax();
        String state = "KY";
        BigDecimal taxRate = new BigDecimal("6.25").setScale(2, RoundingMode.HALF_UP);
        assertEquals(taxRate, tax.getTax(state).getTaxRate());
    }
    
    @Test
    public void testStates() throws FlooringPersistenceException{
        tax.loadTax();
        String expectedResults = "TN";
        String state = "";
        List<Tax> taxes = tax.getAllTax();
        for(Tax t : taxes){
            if(t.getState().equalsIgnoreCase(expectedResults)){
                state = t.getState();
                assertEquals(expectedResults, state);
            }
        }
    }

}
