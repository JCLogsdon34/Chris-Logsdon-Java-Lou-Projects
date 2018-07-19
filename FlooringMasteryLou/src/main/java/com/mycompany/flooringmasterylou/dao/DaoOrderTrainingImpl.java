package com.mycompany.flooringmasterylou.dao;

import static com.mycompany.flooringmasterylou.dao.DaoOrderProductionImpl.DELIMITER;
import com.mycompany.flooringmasterylou.dto.Order;
import java.io.BufferedReader;
import java.io.File;
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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author JCLog
 */
public class DaoOrderTrainingImpl implements DaoOrder {

      private Map<String, List<Order>> orders = new HashMap<>();
    private int nums;  // = MIN_VALUE;
    private String folderPath = "OrderFile";
    public static final String DELIMITER = ",";
    ////create a max orderNumber;

    @Override
    public Order createOrder(String orderDate, Order order) throws FlooringBadDateException {
        List<Order> daysOrders = new ArrayList<Order>();
        Set<String> days = orders.keySet();
        order = getOrderNumber(order);
        //     for (String d : days) {
        if (days.contains(orderDate)) {
            daysOrders = getAllOrdersByDate(orderDate);
            daysOrders.add(order);
        } else if (!days.contains(orderDate)) {
            daysOrders.add(order);
        }
        orders.put(orderDate, daysOrders);
        return order;
    }
    
    private Order getOrderNumber(Order order) {
        int newOrderNumber = 0;
        
        List<Order> ord = new ArrayList<>();
        ord = getAllOrders();
        for (Order o : ord) {
            Iterator iter = ord.iterator();
            o.equals(iter.hasNext());
            nums++;
        }
        newOrderNumber = nums + 1;
        nums = nums + 1;
        String orderNumber = String.valueOf(newOrderNumber);
        order.setOrderNumber(orderNumber);
        return order;
    }
    
    private void checkMyDate(String orderDate) throws FlooringBadDateException {
        Set<String> days = orders.keySet();
        Iterator iter = days.iterator();
        while (iter.hasNext()) {
            if (days.contains(orderDate)) {
                break;
            } else if (!days.contains(orderDate)) {
                throw new FlooringBadDateException(
                        "No orders for that date");
            }
        }
    }
    
    @Override
    public Order getOrder(String orderDate, String orderNumber) throws FlooringPersistenceException, FlooringBadDateException {
        //       loadAllOrders();
        String oD = "";
        checkMyDate(orderDate);
        List<Order> ordersOnThatDate = getAllOrdersByDate(orderDate);
        Order currentOrder = new Order(orderNumber);
        int i = 0;
        
        for (Order s : ordersOnThatDate) {
            oD = s.getOrderNumber();
            if (oD.equals(orderNumber)) {
                i = ordersOnThatDate.indexOf(s);
                currentOrder = ordersOnThatDate.get(i);
                return currentOrder;
            }
        }
        return currentOrder;
    }
    
    private List<Order> getAllOrders() {
        List<Order> orderTime = new ArrayList<Order>();
        Order currentOrder = new Order("");
        Set<String> days = orders.keySet();
        Collection<List<Order>> ordserTotal = orders.values();
        Iterator it = days.iterator();
        Iterator iter = ordserTotal.iterator();
        for (List<Order> l : ordserTotal) {
            for (Order o : l) {
                orderTime.add(o);
            }
        }
        return orderTime;
    }
    
    @Override
    public Order removeOrder(String orderDate, String orderNumber) {
        
        String newName = "";
        int i = 0;
        Order currentOrder = new Order("");
        List<Order> dayOrders = orders.get(orderDate);
        for (Order o : dayOrders) {
            newName = o.getOrderNumber();
            if (newName.contains(orderNumber)) {
                i = dayOrders.indexOf(o);
                currentOrder = dayOrders.remove(i);
                if (dayOrders.size() < 1) {
                    return currentOrder;
                } else {
                    orders.put(orderDate, dayOrders);
                    return currentOrder; //return o, or make currentOrder = o
                }
            }
        }
        return null;
        
    }
    
    @Override
    public List<Order> getAllOrdersByDate(String orderDate) throws FlooringBadDateException {
        List<Order> newList = new ArrayList<Order>();
        Set<String> o = orders.keySet();
        if (o.contains(orderDate)) {
            
            newList.addAll(orders.get(orderDate));
        } else if (!o.contains(orderDate)) {
            throw new FlooringBadDateException(
                    "No orders for that date");
        }
        return newList;
    }
    
    @Override
    public void editOrder(String orderDate, String orderNumber, Order order) {
        String ordNum = "";
        int myNumber = 0;
        List<Order> dayOrders = orders.get(orderDate);
        for (Order o : dayOrders) {
            ordNum = o.getOrderNumber();
            if (ordNum.contentEquals(order.getOrderNumber())) {
                myNumber = dayOrders.indexOf(o);
                break;
            }
        }
        dayOrders.remove(myNumber);
        dayOrders.add(myNumber, order);
        orders.put(orderDate, dayOrders);
    }

    //make private and 
    private String getMyFile(String orderDate) {
        String fileNames = "OrderFile\\Orders_" + orderDate + ".txt";
        String theFile = "";
        File folder = new File(folderPath);
        File[] OrderFiles = folder.listFiles();
//
        String myFile = "OrderFile\\Orders_" + orderDate + ".txt";
        for (int i = 0; i < OrderFiles.length; i++) {
            if (OrderFiles[i].toString().equals(fileNames)) {
                return theFile = OrderFiles[i].toString();
            }
        }
        return myFile;
    }

    //use a loadAllOrders and one like below, and two write orders
    @Override
    public void loadAllOrders() throws FlooringPersistenceException {
        List<Order> myList = new ArrayList<Order>();
        List<Order> newList = new ArrayList<Order>();
        
        String[] currentTokens;
        String orderDate = "";
        String fileName = "";
        String o = "";
        String theFile = "";
        Scanner inputReader;
        //  fileName = "Orders_" + s + ".txt";
        File folder = new File(folderPath);
        File[] orderFiles = folder.listFiles();
        for (File s : orderFiles) {
            theFile = s.toString();
            
            o = theFile.replace("OrderFile\\Orders_", "");
            orderDate = o.replace(".txt", "");
            theFile = getMyFile(orderDate);
            
            try {
                inputReader = new Scanner(new BufferedReader(new FileReader(theFile)));
            } catch (FileNotFoundException e) {
                throw new FlooringPersistenceException("Could not load files", e);
            }
            String currentLine = "";
            List<Order> ordList = new ArrayList<Order>();
            
            while (inputReader.hasNextLine()) {
                currentLine = inputReader.nextLine();
                currentTokens = currentLine.split(DELIMITER);
                Order currentOrder = new Order("");
                currentOrder.setOrderDate(orderDate);
                currentOrder.setOrderNumber(currentTokens[0]);
                currentOrder.setOrderName(currentTokens[1]);
                currentOrder.getTax().setState(currentTokens[2]);
                currentOrder.getTax().setTaxRate(new BigDecimal(currentTokens[3]).setScale(2, RoundingMode.HALF_UP));
                currentOrder.getProduct().setProductType(currentTokens[4]);
                currentOrder.setArea(new BigDecimal(currentTokens[5]).setScale(2, RoundingMode.HALF_UP));
                currentOrder.getProduct().setCostPerSqFt(new BigDecimal(currentTokens[6]).setScale(2, RoundingMode.HALF_UP));
                currentOrder.getProduct().setLaborCostPerSqFt(new BigDecimal(currentTokens[7]).setScale(2, RoundingMode.HALF_UP));
                currentOrder.setMaterialCost(new BigDecimal(currentTokens[8]).setScale(2, RoundingMode.HALF_UP));
                currentOrder.setLaborCost(new BigDecimal(currentTokens[9]).setScale(2, RoundingMode.HALF_UP));
                currentOrder.setTaxAmount(new BigDecimal(currentTokens[10]).setScale(2, RoundingMode.HALF_UP));
                currentOrder.setTotal(new BigDecimal(currentTokens[11]).setScale(2, RoundingMode.HALF_UP));
                ordList.add(currentOrder);
            }
            orders.put(orderDate, ordList);
            
            inputReader.close();
        }
    }

    @Override
    public void writeOrder() throws FlooringPersistenceException, FlooringBadDateException  {
        //does nothing
    }

}
