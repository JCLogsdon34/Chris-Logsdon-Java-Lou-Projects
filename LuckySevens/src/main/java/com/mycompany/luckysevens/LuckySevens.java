package com.mycompany.luckysevens;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author JCLog
 */
public class LuckySevens {
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        String bet;
        float userBet = 0;
        float userMaxWinnings = userBet;
        float maxCasino = 11;
        float minCasino = 1;
        boolean keepGoing = true;
        do {
           System.out.println("Hello, please place your bet: ");
           bet = userInput.nextLine();
           userBet = Float.parseFloat(bet);
            if (userBet > maxCasino || userBet < minCasino) {
                keepGoing = true;
            } else {
                keepGoing = false;
            }
        } while (keepGoing); 
    
        int turnCounter = 0;
        int turnCounterAtWins = 0;
        
        do{
            
            turnCounter++;
            Random randomizer = new Random(6);
            int diceOne = 0;
            int diceTwo = 0;
            int dice = 0;
            userMaxWinnings = userBet;
            diceOne = randomizer.nextInt();
            diceTwo = randomizer.nextInt();
            dice = + diceOne + diceTwo;
            int win = 4;
            int lose = -1;
            
            if(dice == 7){
                userBet = userBet + win;
                
                if(userBet > userMaxWinnings){
                    userMaxWinnings = userBet;
                    turnCounterAtWins = turnCounter;
                }
            } else {
                userBet = userBet - lose;
            }
            
        }while(userBet > 0);
        
        System.out.println("Turns: " + turnCounter + " Max amount of winnings" + userMaxWinnings + " Number of Turns when winnings were at their highest: " + turnCounterAtWins);
    }
}
