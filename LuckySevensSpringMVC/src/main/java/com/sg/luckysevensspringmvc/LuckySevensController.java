package com.sg.luckysevensspringmvc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author JCLog
 */
@Controller
public class LuckySevensController {

    @RequestMapping(value = "/LuckySevens",
            method = RequestMethod.POST)
    public String luckyNumber(HttpServletRequest request,
            Map<String, Object> model) {
        String bet = "";

        System.out.println("Hello, please place your bet: ");
        bet = request.getParameter("bet");
        BigDecimal userBet = new BigDecimal(bet).setScale(2, RoundingMode.HALF_UP);
        BigDecimal userMaxWinnings = new BigDecimal("0").setScale(2, RoundingMode.HALF_UP);
        BigDecimal winning = new BigDecimal(bet).setScale(2, RoundingMode.HALF_UP);
        int turnCounter = 0;
        int turnCounterAtWins = 0;
        String winnings = "";
        String winner = "";
        String turn = "";
        do {

            turnCounter++;
            Random randomizer = new Random(6);
            int diceOne = 0;
            int diceTwo = 0;
            int dice = 0;
            userMaxWinnings = new BigDecimal(bet).setScale(2, RoundingMode.HALF_UP);
            diceOne = randomizer.nextInt();
            diceTwo = randomizer.nextInt();
            dice = +diceOne + diceTwo;
            BigDecimal win = new BigDecimal("4").setScale(2, RoundingMode.HALF_UP);
            BigDecimal lose = new BigDecimal("1").setScale(2, RoundingMode.HALF_UP);

            if (dice == 7) {
                userBet.add(win).setScale(2, RoundingMode.HALF_UP);
            }
            if ((userBet.compareTo(userMaxWinnings) > 0)) {
                userMaxWinnings = userMaxWinnings.add(userBet).setScale(2, RoundingMode.HALF_UP);
                turnCounterAtWins = turnCounter;
                winner = String.valueOf(turnCounterAtWins);
                break;
            } else {
                userBet = userBet.subtract(lose).setScale(2, RoundingMode.HALF_UP);
            }
            winning = userMaxWinnings.add(userBet).setScale(2, RoundingMode.HALF_UP);
            winnings = String.valueOf(winning);
            turn = String.valueOf(turnCounter);
            
        } while (userBet.compareTo(BigDecimal.ZERO) > 0);


        
        model.put("bet", bet);
        model.put("winnings", winnings);
        model.put("roundsAtWins", winner);
        model.put("turns", turn);
        return "result";
    }
}
