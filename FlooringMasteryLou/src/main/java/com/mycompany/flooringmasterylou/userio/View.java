package com.mycompany.flooringmasterylou.userio;

import com.mycompany.flooringmasterylou.dto.Order;
import com.mycompany.flooringmasterylou.dto.Product;
import com.mycompany.flooringmasterylou.dto.Tax;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author JCLog
 */
public class View {

    private UserIO io;

    public View(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("* * * * * * *Main Menu* * * * * * *");
        io.print("|| 1. List Orders by Date ||");
        io.print("|| 2. Place an Order ||");
        io.print("|| 3. Remove an order ||");
        io.print("|| 4. Edit an Order ||");
        io.print("|| 5. Save Orders ||");
        io.print("|| 6. Exit :( ||");

        return io.readInt("Please select from the above choices.", 1, 6);
    }

    public String getOrderName() {
        String orderName = "";
        orderName = io.readString("Please enter a name for the order.");
        return orderName;
    }

    public String getOrderDate() {
        String orderDate = "";
        LocalDate dates;
        String date = "";
        boolean checkDate = true;
        do {
            orderDate = io.readString("Please enter an Order Date of pattern MM/dd/yyyy");
            if (orderDate.length() > 10) {
                checkDate = true;
            } else if (orderDate.length() < 10) {
                checkDate = true;
            } else {
                if (!orderDate.contains("/")) {
                    checkDate = true;
                } else if (orderDate.contains("/")) {
                    checkDate = false;
                    break;
                }
            }
        } while (checkDate);
       //make local date changes here to accomodate the distant future 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate ld = LocalDate.parse(orderDate, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String formatted = ld.format(formatter);
        if (formatted.contains("/")) {
            date = formatted.replace("/", "");
        }
        return date;
    }

    public String getTheOrdersNumber() {
        int orderNumber = 0;
        String orderNumString = "";
        orderNumber = io.readInt("Please enter your order number");
        orderNumString = String.valueOf(orderNumber);
        return orderNumString;
    }

    public Order getNewOrderInfo(String orderDate, Collection<Tax> taxInfo, Collection<Product> productInfo) {
        String orderName = "";
        String state = "";
        String productType = "";
        boolean booleanAroundWithArea = true;
        BigDecimal area;
        BigDecimal areaChecker = new BigDecimal("99").setScale(2, RoundingMode.HALF_UP);

        orderName = io.readString("Please enter a name for this order");
        Order currentOrder = new Order("");

        io.print("These are the product types we offer: ");
        for (Product stuff : productInfo) {
            io.print("___________" + stuff.getProductType() + "___________");
        }
        productType = io.readString("Please enter the Product Type you would like");
        io.print("These are the states we work in right now: ");
        for (Tax t : taxInfo) {
            io.print("___________" + t.getState() + "___________");
        }
        state = io.readString("Please enter the state in which we are working: ");
        do {
            area = io.readBigDecimal("Please enter the area (at least 100 sqft) in which you want flooring");
            if (area.compareTo(areaChecker) < 1) {
                booleanAroundWithArea = true;
            } else if (area.compareTo(areaChecker) >= 1) {
                booleanAroundWithArea = false;
            }
        } while (booleanAroundWithArea);
        currentOrder.setOrderDate(orderDate);
        currentOrder.setOrderName(orderName);
        currentOrder.getTax().setState(state);
        currentOrder.getProduct().setProductType(productType);
        currentOrder.setArea(area);
        return currentOrder;
    }

    public Order getOrderEdits(Order currentOrder, Collection<Tax> taxInfo, Collection<Product> productInfo) {
        boolean keepGoing = true;
        int userSelection = 0;
        String orderName = "";
        String orderDate = "";
        String state = "";
        String productType = "";
        BigDecimal areaChecker = new BigDecimal("100").setScale(2, RoundingMode.HALF_UP);

        io.print("|||||||||| Edit ||||||||||");
        boolean boolingAround = true;

        io.print(currentOrder.getOrderName());
        orderName = io.readString("Please enter your desired changes for the Order Name");
        if (!orderName.isEmpty()) {
            currentOrder.setOrderName(orderName);
            io.print("Your change to the Order Name has been noted");

        } else if (orderName.isEmpty() || orderName.length() < 1) {

        }

        io.print("|||||||||||||||||||||||||||||||||||||||||||||||||||||");
        io.print(currentOrder.getOrderDate());
        orderDate = io.readString("Please enter your desired changes for the Order Date in this patter: MM/dd/yyyy");
        if (!orderDate.isEmpty()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            LocalDate ld = LocalDate.parse(orderDate, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
            String formatted = ld.format(formatter);
            currentOrder.setOrderDate(formatted);
            io.print("Your change to the Order Date has been noted");

        } else if (orderDate.isEmpty() || orderDate.length() < 10) {

        }

        io.print("|||||||||||||||||||||||||||||||||||||||||||||||||||||");
        io.print("These are the states we work in right now: ");
        for (Tax t : taxInfo) {
            io.print(t.getState());
        }
        io.print("Here was your choice for a state: " + currentOrder.getTax().getState());
        state = io.readString("Please enter your choice of state or hit enter: ");
        if (!state.isEmpty()) {
            for (Tax t : taxInfo) {
                if (state.equalsIgnoreCase(t.getState()));

                currentOrder.getTax().setState(state);
                io.print("Your change to the State has been noted");

            }
        } else if (state.isEmpty() || state.length() < 1) {

        }

        io.print("|||||||||||||||||||||||||||||||||||||||||||||||||||||");
        io.print("These are the product types we offer: ");
        for (Product stuff : productInfo) {
            io.print(stuff.getProductType());
        }
        io.print("Here was your product choice: " + currentOrder.getProduct().getProductType());
        productType = io.readString("Please enter your desired changes for the Product Type");
        if (!productType.isEmpty()) {
            for (Product stuff : productInfo) {
                if (productType.equalsIgnoreCase(stuff.getProductType())) {
                    currentOrder.getProduct().setProductType(productType);
                    io.print("Your change to the Product Type has been saved");

                }
            }
        } else if (productType.isEmpty()) {

        }

        io.print("|||||||||||||||||||||||||||||||||||||||||||||||||||||");
        io.print("Here was your choice of Area: " + currentOrder.getArea().toString());
        io.print("Please enter your desired changes for Area");
        String s = "";

        s = io.readString("Please enter the area (at least 100 sqft) in which you want flooring");
        BigDecimal area = new BigDecimal("0").setScale(2, RoundingMode.HALF_UP);
        if (!s.isEmpty()) {
            area = new BigDecimal(s).setScale(2, RoundingMode.HALF_UP);
            if (area.compareTo(areaChecker) >= 1) {
                currentOrder.setArea(area);
                io.print("Your change to the Flooring Area have been saved");

            }
        } else if (s.isEmpty()) {

        }
        if (area.compareTo(areaChecker) < 1) {

        }

        return currentOrder;
    }

    public void displaySearchedOrders(List<Order> orderList, String orderNumber) {

        for (Order order : orderList) {
            if (order.getOrderNumber().contains(orderNumber)) {
                io.print("Order Number :" + order.getOrderNumber() + ": ");
                io.print("Order Name :" + order.getOrderName() + " ");
                io.print("State :" + order.getTax().getState() + " ");
                io.print("Tax Rate: " + order.getTax().getTaxRate().setScale(2, RoundingMode.HALF_UP).toString() + " ");
                io.print("Product Type: " + order.getProduct().getProductType() + " ");
                io.print("Area: " + order.getArea().setScale(2, RoundingMode.HALF_UP).toString() + " ");
                io.print("CostPerSqFt: " + order.getProduct().getCostPerSqFt().setScale(2, RoundingMode.HALF_UP).toString() + " ");
                io.print("LaborCostPerSqFt: " + order.getProduct().getLaborCostPerSqFt().setScale(2, RoundingMode.HALF_UP).toString() + " ");
                io.print("Material Cost Total: " + order.getMaterialCost().setScale(2, RoundingMode.HALF_UP).toString() + " ");
                io.print("Labor Cost Total: " + order.getLaborCost().setScale(2, RoundingMode.HALF_UP).toString() + " ");
                io.print("Total Tax Amount: " + order.getTaxAmount().setScale(2, RoundingMode.HALF_UP).toString() + " ");
                io.print("Total: " + order.getTotal().setScale(2, RoundingMode.HALF_UP).toString() + " ");
                io.print("");
            } else if (order.getOrderNumber().isEmpty()) {
                io.print("No such order placed");
            }
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayOrder(Order order) {
        if (order != null) {
            io.print("Order Number" + order.getOrderNumber() + ": ");
            io.print("Order Name" + order.getOrderName() + " ");
            io.print("State :" + order.getTax().getState() + " ");
            io.print("Tax Rate: " + order.getTax().getTaxRate().setScale(2, RoundingMode.HALF_UP).toString() + " ");
            io.print("Product Type: " + order.getProduct().getProductType() + " ");
            io.print("Area: " + order.getArea().setScale(2, RoundingMode.HALF_UP).toString() + " ");
            io.print("CostPerSqFt: " + order.getProduct().getCostPerSqFt().setScale(2, RoundingMode.HALF_UP).toString() + " ");
            io.print("LaborCostPerSqFt: " + order.getProduct().getLaborCostPerSqFt().setScale(2, RoundingMode.HALF_UP).toString() + " ");
            io.print("Material Cost Total: " + order.getMaterialCost().setScale(2, RoundingMode.HALF_UP).toString() + " ");
            io.print("Labor Cost Total: " + order.getLaborCost().setScale(2, RoundingMode.HALF_UP).toString() + " ");
            io.print("Total Tax Amount: " + order.getTaxAmount().setScale(2, RoundingMode.HALF_UP).toString() + " ");
            io.print("Total: " + order.getTotal().setScale(2, RoundingMode.HALF_UP).toString() + " ");
            io.print("");
            //ask them to confirm
        } else {
            io.print("Unable to create order.");
        }
        io.readString("Please hit enter to continue.");
    }

    public boolean askIfCertain() {
        String message = "";
        boolean leaving = false;
        boolean doing = true;
        do {
            io.print("===== Are You Sure? =====");
            message = io.readString("Are you sure you want to do this? Y/N ");
            if (message.equalsIgnoreCase("Y")) {
                leaving = true;
                doing = false;
            } else if (message.equalsIgnoreCase("N")) {
                leaving = false;
                doing = false;
            } else {
                doing = true;
            }
        } while (doing);
        return leaving;
    }

    public boolean tellBeforeExit() {
        String message = "";
        boolean leaving = false;
        boolean doing = true;
        do {
            io.print("===== A Quick Word Before You Exit =====");
            io.print("If you exit without saving, all data created will be lost");
            message = io.readString("Are you sure you want to exit without saving? Y/N ");
            if (message.equalsIgnoreCase("Y")) {
                leaving = false;
                doing = false;
            } else if (message.equalsIgnoreCase("N")) {
                leaving = true;
                doing = false;
            } else {
                doing = true;
            }
        } while (doing);
        return leaving;
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All Orders By Date ===");
    }

    public void displayCreateOrderBanner() {
        io.print("=== Create Order ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString(
                "Order created.  Please hit enter to continue");
    }

    public void displayDisplayOrderBanner() {
        io.print("=== Display Order ===");
    }

    public void displayRemoveOrderBanner() {
        io.print("=== Remove Order ===");
    }

    public void displayNoSuchOrder() {
        io.print("=== ERROR ===");
        io.print("No such order");
    }

    public void displayEditOrderBanner() {
        io.print("=== Edit Order ===");
    }

    public void displayRemoveSuccessBanner() {
        io.readString("Order successfully removed. Please hit enter to continue.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
