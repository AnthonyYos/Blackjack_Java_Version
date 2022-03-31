package com.anthony.game;

import com.anthony.card.Deck;
import com.anthony.user.Player;

import java.util.Scanner;

public class GameAction {

    private GameAction() {
    }

    static void hitOrStand(Player thePlayer, Deck theDeck) {
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

    static void hit(Player thePlayer, Deck theDeck) {
        thePlayer.addCard(theDeck.deal());
    }

    static boolean playAgain() {
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
