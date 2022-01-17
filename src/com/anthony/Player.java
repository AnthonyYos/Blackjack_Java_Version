package com.anthony;

import java.util.ArrayList;
import java.util.Objects;

public class Player {
    protected String name;
    protected ArrayList<Card> hand = new ArrayList<Card>();
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
            this.aces += 1;
    }

    public void adjustForAce(){
        if (this.handValue > 21 && this.aces > 0) {
            this.handValue -= 10;
            this.aces -= 1;
        }
    }

    public void showHand(){
        for(Object card: hand)
            System.out.print(card + "\t");
        System.out.println();
    }

    public int getHandValue() {
        return this.handValue;
    }

    public void showHandInfo(){
        System.out.println(name + "'s" + " Hand");
        showHand();
        System.out.println(getHandValue());
        System.out.println();
    }

    public boolean bust(){
        return this.getHandValue() > 21;
    }

    public String getName(){
        return name;
    }
}
