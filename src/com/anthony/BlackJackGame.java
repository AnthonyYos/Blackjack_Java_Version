package com.anthony;

import com.anthony.card.Deck;
import com.anthony.user.Dealer;
import com.anthony.user.Player;

import java.util.Scanner;

public class BlackJackGame {

    final int blackjack = 21;
    final int minDealerHandValue = 17;
    boolean playGame = true;

    public void playBlackjack(String playerName) {

        while (playGame) {
            // Create Deck, player, and dealer
            Player thePlayer = new Player(playerName);
            Dealer theDealer = new Dealer();
            Deck playDeck = new Deck();
            playDeck.shuffle();

            // Deal out cards and show current hands
            for (int i = 0; i < 2; i++) {
                thePlayer.addCard(playDeck.deal());
                theDealer.addCard(playDeck.deal());
            }
            thePlayer.showHandInfo();
            theDealer.showSomeInfo();

            // Player and dealer asked to hit if possible/wanted
            if (thePlayer.getHandValue() < blackjack) {
                hitOrStand(thePlayer, playDeck);
                thePlayer.showHandInfo();
            }
            // Full reveal dealer hand before possible hits
            theDealer.showHandInfo();
            while (theDealer.getHandValue() < minDealerHandValue)
                hit(theDealer, playDeck);

            // Print final hand values
            System.out.println("Final Hands:");
            thePlayer.showHandInfo();
            theDealer.showHandInfo();

            // Game conditions(win,loss,tie)
            // Tie (Equal hands or player and dealer bust)
            if (checkTieGame(thePlayer, theDealer))
                System.out.println("Tie");
                // Player wins (Dealer bust or player's hand > dealer's hand)
            else if (checkPlayerWin(thePlayer, theDealer))
                System.out.println(thePlayer.getName() + " wins!");
                // Player loses
            else
                System.out.println(theDealer.getName() + " wins");


            playGame = playAgain();
        }
    }

    private void hitOrStand(Player thePlayer, Deck theDeck) {
        Scanner input = new Scanner(System.in);
        while (thePlayer.getHandValue() < 21) {
            thePlayer.showHandInfo();
            try {
                System.out.println("Do you want to hit or stand? Enter 'h' or 's'\n");
                char choice = Character.toLowerCase(input.next().charAt(0));
                if (choice == 'h')
                    hit(thePlayer, theDeck);
                else if (choice == 's')
                    break;
                else
                    throw new Exception("Entered an invalid input");
            } catch (Exception e) {
                System.out.println(("Not a valid option\n"));
            }
        }
    }

    private void hit(Player thePlayer, Deck theDeck) {
        thePlayer.addCard(theDeck.deal());
    }

    private boolean checkTieGame(Player thePlayer, Dealer theDealer) {
        return (thePlayer.getHandValue() == theDealer.getHandValue() || checkBust(thePlayer) && checkBust(theDealer));
    }

    private boolean checkPlayerWin(Player thePlayer, Dealer theDealer) {
        return (checkBust(theDealer) || (thePlayer.getHandValue() > theDealer.getHandValue() && !checkBust(thePlayer)));
    }

    private boolean checkBust(Player currentUser) {
        return currentUser.getHandValue() > 21;
    }

    private boolean playAgain() {
        while (true) {
            try {
                System.out.println("Do you want to play again? Enter 'y' or 'n'");
                Scanner input = new Scanner(System.in);
                char choice = Character.toLowerCase(input.next().charAt(0));
                if (choice == 'y')
                    return true;
                else if (choice == 'n') {
                    return false;
                } else
                    throw new Exception("Invalid input entered");
            } catch (Exception e) {
                System.out.println("You entered an invalid choice");
            }
        }
    }

}
