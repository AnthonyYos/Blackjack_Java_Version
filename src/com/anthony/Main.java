package com.anthony;

import com.anthony.card.Deck;
import com.anthony.game.BlackJackGame;
import com.anthony.user.Dealer;
import com.anthony.user.Player;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter a name: ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        Player thePlayer = new Player(name);
        Dealer theDealer = new Dealer();
        Deck theDeck = new Deck();
        BlackJackGame blackjack = new BlackJackGame(thePlayer, theDealer, theDeck);
        blackjack.playBlackjack();
    }
}