package com.anthony.card;

import com.anthony.user.Dealer;
import com.anthony.user.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    final private ArrayList<Card> cards;

    public Deck(){
        cards = new ArrayList<>();
        for(Suit cardSuit: Suit.values()){
            for(Rank cardRank : Rank.values()) {
                cards.add(new Card(cardSuit, cardRank));
            }
        }
    }

    public void shuffle(){
            Collections.shuffle(cards);
    }

    public Card deal(){
        return cards.remove(0);
    }

    public void printDeck(){
        for(Card card: cards)
            System.out.println(card);
    }

    public void resetDeck(Player thePlayer, Dealer theDealer){
        List<Card> playerHand = thePlayer.getHand();
        List<Card> dealerHand = theDealer.getHand();
        cards.addAll(playerHand);
        cards.addAll(dealerHand);
    }
}
