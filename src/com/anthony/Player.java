package com.anthony;

import java.util.ArrayList;
import java.util.Objects;

public class Player {
    private String name;
    private ArrayList<Card> hand = new ArrayList<>();
    private int handValue = 0;
    private int aces = 0;

    Player(){}

    Player(String name){
        this.name = name;
    }

    public void addCard(Card card){
        hand.add(card);
        handValue += card.getValue();
        if(Objects.equals(card.getRank(), "Ace"))
            aces += 1;
    }

    public void adjustForAce(){
        if (handValue > 21 && aces > 0) {
            handValue -= 10;
            aces -= 1;
        }
    }

    public void showHand(){
        for(Object card: hand)
            System.out.print(card + "\t");
        System.out.println();
    }

    public int getHandValue() {
        return handValue;
    }

    public void showHandInfo(){
        System.out.println(name + "'s" + " Hand");
        showHand();
        System.out.println(getHandValue());
        System.out.println();
    }

    public boolean bust(){
        return getHandValue() > 21;
    }

    public String getName(){
        return name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }
}
