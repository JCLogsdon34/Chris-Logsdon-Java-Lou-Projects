package com.sg.luckyseven;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
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
@WebServlet(name = "LuckySeven", urlPatterns = {"/LuckySeven"})
public class LuckySevenServlet extends HttpServlet {


protected void processRequest(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {

    
 
        String bet = "";
        BigDecimal maxCasino = new BigDecimal("0").setScale(2, RoundingMode.HALF_UP);
        BigDecimal minCasino = new BigDecimal("0").setScale(2, RoundingMode.HALF_UP);
        boolean keepGoing = true;

           System.out.println("Hello, please place your bet: ");
           bet = request.getParameter("bet");
           BigDecimal userBet = new BigDecimal(bet).setScale(2, RoundingMode.HALF_UP);
           BigDecimal userMaxWinnings = new BigDecimal("0").setScale(2, RoundingMode.HALF_UP);
           BigDecimal winnings = new BigDecimal(bet).setScale(2, RoundingMode.HALF_UP);
        int turnCounter = 0;
        int turnCounterAtWins = 0;
        
        do{
            
            turnCounter++;
            Random randomizer = new Random(6);
            int diceOne = 0;
            int diceTwo = 0;
            int dice = 0;
            userMaxWinnings = new BigDecimal(bet).setScale(2, RoundingMode.HALF_UP);
            diceOne = randomizer.nextInt();
            diceTwo = randomizer.nextInt();
            dice = + diceOne + diceTwo;
            BigDecimal win = new BigDecimal("4").setScale(2, RoundingMode.HALF_UP);
            BigDecimal lose = new BigDecimal("1").setScale(2, RoundingMode.HALF_UP);
            
            if(dice == 7){
                userBet.add(win).setScale(2, RoundingMode.HALF_UP);
            }
            if((userBet.compareTo(userMaxWinnings) > 0)){
                    userMaxWinnings = userMaxWinnings.add(userBet).setScale(2, RoundingMode.HALF_UP);
                    turnCounterAtWins = turnCounter;
                    break;
                } else {
                userBet = userBet.subtract(lose).setScale(2, RoundingMode.HALF_UP);
            }
            winnings = userMaxWinnings.add(userBet).setScale(2, RoundingMode.HALF_UP);
        }while(userBet.compareTo(BigDecimal.ZERO) > 0);

 


    request.setAttribute("bet", bet);
    request.setAttribute("winnings", winnings.toString());
    request.setAttribute("roundsAtWins", turnCounterAtWins);
    request.setAttribute("turns", turnCounter);
    
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