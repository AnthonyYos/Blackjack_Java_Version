package com.anthony.game;

import com.anthony.card.Deck;
import com.anthony.user.Dealer;
import com.anthony.user.Player;

public class BlackJackGame {

    private final int blackjack;
    private final int minDealerHandValue;
    private boolean playGame;

    public BlackJackGame() {
        blackjack = 21;
        minDealerHandValue = 17;
        playGame = true;
    }

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

            // Player asked to hit if possible/wanted
            if (thePlayer.getHandValue() < blackjack) {
                GameAction.hitOrStand(thePlayer, playDeck);
                thePlayer.showHandInfo();
            }
            // Full reveal dealer hand before possible hits
            theDealer.showHandInfo();
            while (theDealer.getHandValue() < minDealerHandValue)
                GameAction.hit(theDealer, playDeck);

            // Print final hand values
            System.out.println("Final Hands:");
            thePlayer.showHandInfo();
            theDealer.showHandInfo();

            //Display winner and check if users wants to play again
            GameEvaluator.evaluateGame(thePlayer, theDealer);
            playGame = GameAction.playAgain();
        }
    }

}
