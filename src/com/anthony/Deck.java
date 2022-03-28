package com.anthony;

import java.util.ArrayList;
import java.util.Collections;

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

    public void createDeck(){
        //Generate cards
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
}
