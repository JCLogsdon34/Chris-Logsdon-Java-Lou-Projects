package com.mycompany.flooringmasterylou.dao;

import com.mycompany.flooringmasterylou.dto.Order;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JCLog
 */
public class DaoOrderProductionStubImpl implements DaoOrder {

    private Order onlyOrder;
    private List<Order> list = new ArrayList<>();

    public DaoOrderProductionStubImpl() {
        onlyOrder = new Order("2");
        onlyOrder.setOrderDate("02182018");
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
        list.add(onlyOrder);
    }

    @Override
    public Order createOrder(String orderDate, Order order) {
        if (orderDate.equals(order.getOrderDate())) {
            return order;
        } else {
            return null;
        }
    }

    @Override
    public Order removeOrder(String orderDate, String orderNumber) {
        if (orderDate.equals(onlyOrder.getOrderDate())) {
            if (orderNumber.equals(onlyOrder.getOrderNumber()));
            return onlyOrder;
        } else {
            return null;
        }
    }

    @Override
    public List<Order> getAllOrdersByDate(String orderDate) {
        return list;
    }

    @Override
    public void editOrder(String orderDate, String orderNumber, Order order) {
        list.remove(0);
        list.add(order);
    }

    @Override
    public Order getOrder(String orderDate, String orderNumber) {
        if (orderDate.equals(onlyOrder.getOrderDate())) {
            if (orderNumber.equals(onlyOrder.getOrderNumber()));
            return onlyOrder;
        } else {
            return null;
        }
    }

    @Override
    public void loadAllOrders() throws FlooringPersistenceException {
        /// do nothing
    }

    @Override
    public void writeOrder() throws FlooringPersistenceException {
        /// do nothing
    }

}
