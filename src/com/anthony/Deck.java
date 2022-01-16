package com.anthony;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;

    public Deck(){
        this.cards = new ArrayList<Card>();
    }

    public void createDeck(){
        //Generate cards
        for(Suit cardSuit: Suit.values()){
            for(Rank cardRank : Rank.values()) {
                this.cards.add(new Card(cardSuit, cardRank));
            }
        }
    }

    public void shuffle(){
            Collections.shuffle(this.cards);
    }

    public Card deal(){
        return this.cards.remove(0);
    }

    public void printDeck(){
        for(Card card: cards)
            System.out.println(card);
    }
}
