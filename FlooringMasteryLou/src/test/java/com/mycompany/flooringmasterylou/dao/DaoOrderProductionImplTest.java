package com.mycompany.flooringmasterylou.dao;

import com.mycompany.flooringmasterylou.dto.Order;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JCLog
 */
public class DaoOrderProductionImplTest {

    private DaoOrder dao;

    public DaoOrderProductionImplTest() {
        dao = new DaoOrderProductionImpl();
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
    public void testGetAllOrders() throws FlooringPersistenceException, FlooringBadDateException {
        dao.loadAllOrders();
        String orderDate = "06012013";
        int orderNum = dao.getAllOrdersByDate(orderDate).size();
        assertEquals(1, dao.getAllOrdersByDate(orderDate).size());
    }

    //
    @Test
    public void testGetOrder() throws FlooringPersistenceException, FlooringBadDateException {
        dao.loadAllOrders();
        String orderNumber = "1";
        String orderDate = "06012013";
        Order o = new Order("1");
        o = dao.getOrder(orderDate, orderNumber);
        assertEquals(orderNumber, o.getOrderNumber());
    }

    @Test
    public void testCreateOrder() throws FlooringPersistenceException, FlooringBadDateException {
        dao.loadAllOrders();
        Order onlyOrder = new Order("");
        onlyOrder.setOrderDate("02192018");
        onlyOrder.setOrderName("Logsdon");
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
        assertEquals(onlyOrder.getTax().getState(), "KY");
        dao.removeOrder(onlyOrder.getOrderDate(), onlyOrder.getOrderNumber());
        dao.writeOrder();
    }

    @Test
    public void testCreateOrderTwo() throws FlooringPersistenceException, FlooringBadDateException {
        dao.loadAllOrders();
        Order onlyOrder = new Order("");
        onlyOrder.setOrderDate("02192018");
        onlyOrder.setOrderName("Cicero");
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

        Order order = new Order("");
        order.setOrderDate("02192018");
        order.setOrderName("Tiro");
        order.getTax().setState("KY");
        order.getTax().setTaxRate(new BigDecimal("6.25").setScale(2, RoundingMode.HALF_UP));
        order.getProduct().setProductType("Wood");
        order.setArea(new BigDecimal("100.00").setScale(2, RoundingMode.HALF_UP));
        order.getProduct().setCostPerSqFt(new BigDecimal("5.15").setScale(2, RoundingMode.HALF_UP));
        order.getProduct().setLaborCostPerSqFt(new BigDecimal("4.75").setScale(2, RoundingMode.HALF_UP));
        order.setMaterialCost(new BigDecimal("515.00").setScale(2, RoundingMode.HALF_UP));
        order.setLaborCost(new BigDecimal("475.00").setScale(2, RoundingMode.HALF_UP));
        order.setTaxAmount(new BigDecimal("61.88").setScale(2, RoundingMode.HALF_UP));
        order.setTotal(new BigDecimal("1051.00").setScale(2, RoundingMode.HALF_UP));

        order = dao.createOrder(order.getOrderDate(), order);
        
        assertNotNull(dao.getOrder(onlyOrder.getOrderDate(), onlyOrder.getOrderNumber()));
        assertNotNull(dao.getOrder(order.getOrderDate(), order.getOrderNumber()));
        dao.removeOrder(order.getOrderDate(), order.getOrderNumber());
        dao.removeOrder(onlyOrder.getOrderDate(), onlyOrder.getOrderNumber());
        dao.writeOrder();
    }
    
    
}
