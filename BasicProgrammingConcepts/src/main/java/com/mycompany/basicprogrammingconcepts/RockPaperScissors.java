package com.mycompany.basicprogrammingconcepts;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author JCLog
 */
public class RockPaperScissors {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        Random randomizer = new Random();
        int rounds = 0;
        String userRounds = "";
        String playAgain = "";
        int drawCounter = 0;
        int winCounter = 0;
        int loseCounter = 0;
        boolean partyOn = true;

        do {
            String userChoice = "";
            int userPick = 0;
            int computerChoice = 0;

            System.out.println("Hello, how many rounds of Rock, Paper, Scissors would you like to play?"
                    + "Please chose between 1 - 10.");
            userRounds = userInput.nextLine();
            rounds = Integer.parseInt(userRounds);
            if (rounds < 1 || rounds > 10) {
                System.out.println("Invalid Input for Number of Rounds");
                rounds = 0;
                playAgain = "n";
                partyOn = false;
                break;
            }
            
            for (int i = rounds; i > 0; i--) {
                System.out.println("Ok then, please choose (1) Rock, "
                        + "(2) Paper, or (3) Scissors. ");
                userChoice = userInput.nextLine();
                userPick = Integer.parseInt(userChoice);

                computerChoice = randomizer.nextInt(3) + 1;

                switch (userPick) {
                    case 1:
                        switch (computerChoice) {
                            case 1:
                                System.out.println("It is a draw");
                                drawCounter++;
                                break;
                            case 2:
                                System.out.println("Computer wins!! Paper beats rock!");
                                loseCounter++;
                                break;
                            default:
                                System.out.println("You win!! Rock beats Scissors!! Nice!");
                                winCounter++;
                                break;
                        }
                        break;

                    case 2:
                        switch (computerChoice) {
                            case 1:
                                System.out.println("You win!! Paper beats rock!! Nice!");
                                winCounter++;
                                break;
                            case 2:
                                System.out.println("It is a draw");
                                drawCounter++;
                                break;
                            default:
                                System.out.println("Computer wins!! Scissors beats paper!");
                                loseCounter++;
                                break;
                        }
                        break;

                    case 3:
                        switch (computerChoice) {
                            case 1:
                                System.out.println("Computer wins!! Rock beats Scissors!");
                                loseCounter++;
                                break;
                            case 2:
                                System.out.println("You win!! Scissors beats paper!! Nice!");
                                winCounter++;
                                break;
                            default:
                                System.out.println("It is a draw");
                                drawCounter++;
                                break;
                        }
                        break;

                    default:
                        System.out.println("No no!! See, you have to choose (1) Rock, (2) Paper, or"
                                + "(3) Scissors");
                        break;
                }
            }

            System.out.println("||Wins: " + winCounter
                    + "||Loses: " + loseCounter + " || Draws: " + drawCounter
                    + " You went a total of " + rounds + " rounds.");

                // fix this, it assumes you want to keep playing
                System.out.println("Would you like to play again? Yes (y) or "
                        + "No (n)");
                playAgain = userInput.next();
                if (playAgain.equalsIgnoreCase("y")) {
                    partyOn = true;
                    winCounter = 0;
                    drawCounter = 0;
                    loseCounter = 0;
                } else if (playAgain.equalsIgnoreCase("n")) {
                    System.out.println("Thanks for playing!");
                    partyOn = false;
                }
        } while (partyOn == true);
    }
}