package com.anthony.user;

import com.anthony.card.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player {
    private final String name;
    private List<Card> hand;
    private int handValue;
    private int aces;


    public Player(String name){
        this.name = name;
        hand = new ArrayList<>();
        handValue = 0;
        aces = 0;
    }

    public void addCard(Card card){
        hand.add(card);
        handValue += card.getValue();
        String sameRank = "Ace";
        if(sameRank.equals(card.getRank()))
            aces += 1;
        // If there are more than 1 ace check to see if hand value should be adjusted
        if(aces > 0)
            adjustForAce();
    }

    private void adjustForAce(){
        if (handValue > 21 && aces > 0) {
            handValue -= 10;
            aces -= 1;
        }
    }

    private void showHand(){
        for(Card card: hand)
            System.out.print(card + "\t");
        System.out.println();
    }

    public int getHandValue() {
        return handValue;
    }

    public void showHandInfo(){
        System.out.println(name + "'s Hand");
        showHand();
        System.out.println(getHandValue());
        System.out.println();
    }


    public String getName(){
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void resetPlayer(){
        //.Clear() empties the list, but keeps the size (potentially wasted memory allocation)
        // new ArrayList() creates a new object, get rid of final if choosing new ArryaList();
        hand = new ArrayList<>();
        handValue = 0;
        aces = 0;
    }

}
