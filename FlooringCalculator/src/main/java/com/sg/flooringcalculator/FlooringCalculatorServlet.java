package com.sg.flooringcalculator;

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
@WebServlet(name = "FlooringCalculator", urlPatterns = {"/FlooringCalculator"})
public class FlooringCalculatorServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String stringLength = request.getParameter("length");
        String stringWidth = request.getParameter("width");
        String stringCost = request.getParameter("cost");
        BigDecimal costPerSqFt = new BigDecimal(stringCost).setScale(2, RoundingMode.HALF_UP);
        BigDecimal laborPerHour = new BigDecimal("86.00").setScale(2, RoundingMode.HALF_UP);
        BigDecimal taxRate = new BigDecimal("3.25").setScale(2, RoundingMode.HALF_UP);
        BigDecimal length = new BigDecimal(stringLength).setScale(2, RoundingMode.HALF_UP);
        BigDecimal width = new BigDecimal(stringWidth).setScale(2, RoundingMode.HALF_UP);
        BigDecimal quarterly = new BigDecimal("15").setScale(2, RoundingMode.HALF_UP);
        BigDecimal qRate = laborPerHour.divide(quarterly).setScale(0, RoundingMode.HALF_UP);

        
        BigDecimal area = length.multiply(width).setScale(2, RoundingMode.HALF_UP);
        BigDecimal material = costPerSqFt.multiply(area).setScale(2, RoundingMode.HALF_UP);
        BigDecimal labor = area.multiply(qRate).setScale(2, RoundingMode.HALF_UP);
        BigDecimal mL = labor.add(material).setScale(2, RoundingMode.HALF_UP);
        BigDecimal realTax = taxRate.multiply(mL).setScale(2, RoundingMode.HALF_UP);
        BigDecimal total = mL.add(realTax).setScale(2, RoundingMode.HALF_UP);

        request.setAttribute("length", stringLength);
        request.setAttribute("width", stringWidth);
        request.setAttribute("cost", stringCost);
        request.setAttribute("rate", qRate);
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
