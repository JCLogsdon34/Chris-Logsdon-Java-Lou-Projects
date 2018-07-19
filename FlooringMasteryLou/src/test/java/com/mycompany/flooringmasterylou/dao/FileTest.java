package com.mycompany.flooringmasterylou.dao;

import com.mycompany.flooringmasterylou.dto.Order;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

/**
 *
 * @author JCLog
 */
public class FileTest {

    private DaoOrder dao;

    public FileTest() {
        dao = new DaoOrderProductionImpl();
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws FlooringPersistenceException {
    }

    @After
    public void tearDown() throws FlooringPersistenceException, FlooringBadDateException {

    }

    @Test
    public void load() throws Exception {
        dao.loadAllOrders();
        List<Order> newList = new ArrayList<Order>();
        newList = dao.getAllOrdersByDate("02012018");
        assertEquals(2, newList.size());
    }

    @Test
    public void loadOne() throws Exception {
        dao.loadAllOrders();
        //   List<Order> newList = dao.getAllOrdersByDate("06012013");
        assertEquals(1, dao.getAllOrdersByDate("06012013").size());
    }

    @Test
    public void writeThree() throws Exception {
        dao.loadAllOrders();
        List<Order> onlyList = new ArrayList<Order>();
        Order onlyOrder = new Order("");
        onlyOrder.setOrderDate("02142018");
        onlyOrder.setOrderName("Cassius");
        onlyOrder.getTax().setState("KY");
        onlyOrder.getTax().setTaxRate(new BigDecimal("6.25").setScale(2, RoundingMode.HALF_UP));
        onlyOrder.getProduct().setProductType("Wood");
        onlyOrder.setArea(new BigDecimal("100.00").setScale(2, RoundingMode.HALF_UP));
        onlyOrder.getProduct().setCostPerSqFt(new BigDecimal("5.15").setScale(2, RoundingMode.HALF_UP));
        onlyOrder.getProduct().setLaborCostPerSqFt(new BigDecimal("4.75").setScale(2, RoundingMode.HALF_UP));
        onlyOrder.setMaterialCost(new BigDecimal("515.00").setScale(2, RoundingMode.HALF_UP));
        onlyOrder.setLaborCost(new BigDecimal("475.00").setScale(2, RoundingMode.HALF_UP));
        onlyOrder.setTaxAmount(new BigDecimal("61.88").setScale(2, RoundingMode.HALF_UP));
        onlyOrder.setTotal(new BigDecimal("1051.00").setScale(2, RoundingMode.HALF_UP));
        
        onlyOrder = dao.createOrder(onlyOrder.getOrderDate(), onlyOrder);

        Order myOrder = new Order("");
        myOrder.setOrderDate("02142018");
        myOrder.setOrderName("Mascius");
        myOrder.getTax().setState("KY");
        myOrder.getTax().setTaxRate(new BigDecimal("6.25").setScale(2, RoundingMode.HALF_UP));
        myOrder.getProduct().setProductType("Wood");
        myOrder.setArea(new BigDecimal("100.00").setScale(2, RoundingMode.HALF_UP));
        myOrder.getProduct().setCostPerSqFt(new BigDecimal("5.15").setScale(2, RoundingMode.HALF_UP));
        myOrder.getProduct().setLaborCostPerSqFt(new BigDecimal("4.75").setScale(2, RoundingMode.HALF_UP));
        myOrder.setMaterialCost(new BigDecimal("515.00").setScale(2, RoundingMode.HALF_UP));
        myOrder.setLaborCost(new BigDecimal("475.00").setScale(2, RoundingMode.HALF_UP));
        myOrder.setTaxAmount(new BigDecimal("61.88").setScale(2, RoundingMode.HALF_UP));
        myOrder.setTotal(new BigDecimal("1051.00").setScale(2, RoundingMode.HALF_UP));

        myOrder = dao.createOrder(myOrder.getOrderDate(), myOrder);

        Order theOrder = new Order("");
        theOrder.setOrderDate("02142018");
        theOrder.setOrderName("Roscius");
        theOrder.getTax().setState("KY");
        theOrder.getTax().setTaxRate(new BigDecimal("6.25").setScale(2, RoundingMode.HALF_UP));
        theOrder.getProduct().setProductType("Wood");
        theOrder.setArea(new BigDecimal("100.00").setScale(2, RoundingMode.HALF_UP));
        theOrder.getProduct().setCostPerSqFt(new BigDecimal("5.15").setScale(2, RoundingMode.HALF_UP));
        theOrder.getProduct().setLaborCostPerSqFt(new BigDecimal("4.75").setScale(2, RoundingMode.HALF_UP));
        theOrder.setMaterialCost(new BigDecimal("515.00").setScale(2, RoundingMode.HALF_UP));
        theOrder.setLaborCost(new BigDecimal("475.00").setScale(2, RoundingMode.HALF_UP));
        theOrder.setTaxAmount(new BigDecimal("61.88").setScale(2, RoundingMode.HALF_UP));
        theOrder.setTotal(new BigDecimal("1051.00").setScale(2, RoundingMode.HALF_UP));

        theOrder = dao.createOrder(theOrder.getOrderDate(), theOrder);
        
        dao.writeOrder();
        onlyList = dao.getAllOrdersByDate("02142018");
        assertEquals(3, onlyList.size());
        dao.removeOrder(theOrder.getOrderDate(), theOrder.getOrderNumber());
        dao.removeOrder(myOrder.getOrderDate(), myOrder.getOrderNumber());
        dao.removeOrder(onlyOrder.getOrderDate(), onlyOrder.getOrderNumber());
        dao.writeOrder();
    }

    @Test
    public void testRemoveOrder() throws FlooringBadDateException, FlooringPersistenceException {
        dao.loadAllOrders();
        Order theOrder = new Order("");
        theOrder.setOrderDate("02012018");
        theOrder.setOrderName("Lucius Antonius");
        theOrder.getTax().setState("KY");
        theOrder.getTax().setTaxRate(new BigDecimal("6.25").setScale(2, RoundingMode.HALF_UP));
        theOrder.getProduct().setProductType("Wood");
        theOrder.setArea(new BigDecimal("100.00").setScale(2, RoundingMode.HALF_UP));
        theOrder.getProduct().setCostPerSqFt(new BigDecimal("5.15").setScale(2, RoundingMode.HALF_UP));
        theOrder.getProduct().setLaborCostPerSqFt(new BigDecimal("4.75").setScale(2, RoundingMode.HALF_UP));
        theOrder.setMaterialCost(new BigDecimal("515.00").setScale(2, RoundingMode.HALF_UP));
        theOrder.setLaborCost(new BigDecimal("475.00").setScale(2, RoundingMode.HALF_UP));
        theOrder.setTaxAmount(new BigDecimal("61.88").setScale(2, RoundingMode.HALF_UP));
        theOrder.setTotal(new BigDecimal("1051.00").setScale(2, RoundingMode.HALF_UP));

        dao.createOrder(theOrder.getOrderDate(), theOrder);
        dao.writeOrder();

        dao.removeOrder(theOrder.getOrderDate(), theOrder.getOrderNumber());
        dao.writeOrder();
        Order currentOrder = dao.getOrder("02012018", theOrder.getOrderNumber());
        assertNull(currentOrder.getOrderName());

    }

    @Test
    public void testBadDate() throws FlooringPersistenceException, FlooringBadDateException {
        dao.loadAllOrders();
        try {
            dao.getOrder("02172018", "2");
            fail("Expected FlooringBadDateException was not thrown.");
        } catch (FlooringBadDateException e) {
            Assert.assertTrue("Correct exception occurred", true);
        } catch (NumberFormatException e) {
            Assert.assertFalse("Wrong exception occurred", false);
        }
    }
    //small level tests, like writeTest
    // create three orders for three dates, 
    //then check how many orders are in each file
    //
}
