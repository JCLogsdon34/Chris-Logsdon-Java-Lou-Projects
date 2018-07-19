package com.sg.tipcalculator;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JCLog
 */
@WebServlet(name = "TipCalculator", urlPatterns = {"/TipCalculator"})
public class TipCalculatorServlet extends HttpServlet {


protected void processRequest(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {

    
    int factorSum = 0;
    List<BigDecimal> myList = new ArrayList<>();
    String tip = ".20";
    BigDecimal tipAmount = new BigDecimal(tip);
    BigDecimal tipProduct = new BigDecimal("0");
    BigDecimal total = new BigDecimal("0");
    
    String input = request.getParameter("billAmount");
    BigDecimal bill = new BigDecimal(input).setScale(2, RoundingMode.HALF_UP);
    tipProduct = bill.multiply(tipAmount).setScale(2, RoundingMode.HALF_UP);
    total = tipProduct.add(bill).setScale(2, RoundingMode.HALF_UP);
    
 


    request.setAttribute("billAmount", input);
    request.setAttribute("tip", tipAmount);
    request.setAttribute("tipProduct", tipProduct);
    request.setAttribute("total", total);
    
    RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
    rd.forward(request, response);
}


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}


