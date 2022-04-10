package com.anthony.game;

import com.anthony.card.Deck;
import com.anthony.user.Dealer;
import com.anthony.user.Player;

public class BlackJackGame {

    private final int blackjack;
    private final int minDealerHandValue;
    private boolean playGame;
    private final Player thePlayer;
    private final Dealer theDealer;
    private final Deck theDeck;

    public BlackJackGame(Player thePlayer, Dealer theDealer, Deck theDeck) {
        blackjack = 21;
        minDealerHandValue = 17;
        playGame = true;
        this.thePlayer = thePlayer;
        this.theDealer = theDealer;
        this.theDeck = theDeck;
    }

    public void playBlackjack() {

        while (playGame) {
            // Create Deck, player, and dealer
            setupGame();

            // Deal out cards and show current hands
            for (int i = 0; i < 2; i++) {
                thePlayer.addCard(theDeck.deal());
                theDealer.addCard(theDeck.deal());
            }
            thePlayer.showHandInfo();
            theDealer.showSomeInfo();

            // Player asked to hit if possible/wanted
            if (thePlayer.getHandValue() < blackjack) {
                GameAction.hitOrStand(thePlayer, theDeck);
                thePlayer.showHandInfo();
            }
            // Full reveal dealer hand before possible hits
            theDealer.showHandInfo();
            while (theDealer.getHandValue() < minDealerHandValue)
                GameAction.hit(theDealer, theDeck);

            // Print final hand values
            System.out.println("Final Hands:");
            thePlayer.showHandInfo();
            theDealer.showHandInfo();

            //Display winner and check if users wants to play again
            GameEvaluator.evaluateGame(thePlayer, theDealer);
            playGame = GameAction.playAgain();
        }
    }

    private void setupGame(){
        theDeck.resetDeck(thePlayer,theDealer);
        thePlayer.resetPlayer();
        theDealer.resetPlayer();
        theDeck.shuffle();
    }

}
