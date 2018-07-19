package com.mycompany.flooringmasterylou.controller;

import com.mycompany.flooringmasterylou.dao.FlooringBadDateException;
import com.mycompany.flooringmasterylou.dao.FlooringPersistenceException;
import com.mycompany.flooringmasterylou.dto.Order;
import com.mycompany.flooringmasterylou.dto.Product;
import com.mycompany.flooringmasterylou.dto.Tax;
import com.mycompany.flooringmasterylou.service.FlooringDataValidationException;
import com.mycompany.flooringmasterylou.service.FlooringProductException;
import com.mycompany.flooringmasterylou.service.FlooringTaxException;
import com.mycompany.flooringmasterylou.service.ServiceLayer;
import com.mycompany.flooringmasterylou.userio.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author JCLog
 */
public class Controller {

    private View view;
    private ServiceLayer service;

    public Controller(ServiceLayer service, View view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {
                service.loadProduct();
                service.loadTax();
                 loadOrder();
                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        listOrdersByDay();
                        break;
                    case 2:
                        createOrder();
                        break;
                    case 3:
                        removeOrder();
                        break;
                    case 4:
                        editOrder();
                        break;
                    case 5:
                        writeOrder();
                        break;
                    case 6:
                        keepGoing = view.tellBeforeExit();
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (FlooringPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        } catch (FlooringBadDateException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void loadOrder() throws FlooringPersistenceException {
        service.loadAllOrders();
    }

    private void writeOrder() throws FlooringPersistenceException, FlooringBadDateException {
        service.writeOrder();
    }

    private void createOrder() {
        String orderDate = "";
        String fileName = "";
        boolean certainty = true;
        Order currentOrder = new Order("");
        Order computedOrder = new Order("");
        Order completedOrder = new Order("");
        Collection<Tax> taxInfo;
        Collection<Product> productInfo;

        taxInfo = service.getAllTax();
        productInfo = service.getAllProduct();
        view.displayCreateOrderBanner();
        orderDate = view.getOrderDate();
        currentOrder = view.getNewOrderInfo(orderDate, taxInfo, productInfo);
        try {
            computedOrder = service.computeProductCosts(currentOrder);
            view.displayOrder(computedOrder);
            certainty = view.askIfCertain();
            if (certainty) {
                completedOrder = service.createOrder(orderDate, computedOrder);
                view.displayCreateSuccessBanner();
            } else if (certainty) {
                return;
            }
        } catch (FlooringDataValidationException e) {
            view.displayErrorMessage(e.getMessage());
        } catch (FlooringTaxException e) {
            view.displayErrorMessage(e.getMessage());
        } catch (FlooringProductException e) {
            view.displayErrorMessage(e.getMessage());
        } catch (FlooringBadDateException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void removeOrder() {
        String orderNumber = "";
        Order removedOrder = new Order("");
        boolean certainty = true;
        String fileName = "";
        String orderDate = "";
        orderDate = view.getOrderDate();
        view.displayRemoveOrderBanner();
        orderNumber = view.getTheOrdersNumber();
        try {
            removedOrder = service.getOrder(orderDate, orderNumber);
            view.displayOrder(removedOrder);
            certainty = view.askIfCertain();
            if (certainty) {
                removedOrder = service.removeOrder(orderDate, orderNumber);
                view.displayOrder(removedOrder);
            } else if (certainty = false) {
                unknownCommand();
            }
        } catch (FlooringDataValidationException e) {
            view.displayErrorMessage(e.getMessage());
        } catch (FlooringPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        } catch (FlooringBadDateException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void editOrder() {
        boolean certainty = true;
        String orderDate = "";
        String orderNumber = "";
        String fileName = "";
        Order editedOrder = new Order("");
        Order currentOrder = new Order("");

        Collection<Tax> taxInfo;
        Collection<Product> productInfo;

        taxInfo = service.getAllTax();
        productInfo = service.getAllProduct();
        try {
            view.displayEditOrderBanner();
            orderDate = view.getOrderDate();
            orderNumber = view.getTheOrdersNumber();
            currentOrder = service.getOrder(orderDate, orderNumber);
            editedOrder = view.getOrderEdits(currentOrder, taxInfo, productInfo);
            certainty = view.askIfCertain();
            if (certainty) {
                service.editOrder(orderDate, orderNumber, editedOrder);
                view.displayOrder(editedOrder);
            } else if (certainty = false) {
                return;
            }
        } catch (FlooringDataValidationException e) {
            view.displayErrorMessage(e.getMessage());
        } catch (FlooringPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        } catch (FlooringBadDateException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void listOrdersByDay() {
        view.displayDisplayAllBanner();
        String orderDate = "";
        String orderNumber = "";
        String fileName = "";
        List<Order> orderList = new ArrayList<Order>();
        orderDate = view.getOrderDate();
        try {
            orderList = service.getAllOrdersByDate(orderDate);
        } catch (FlooringBadDateException e) {
            view.displayErrorMessage(e.getMessage());
        }
        view.displaySearchedOrders(orderList, orderNumber);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
