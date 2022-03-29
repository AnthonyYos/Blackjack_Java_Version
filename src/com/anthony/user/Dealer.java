package com.anthony.user;

import com.anthony.card.Card;

import java.util.List;

public class Dealer extends  Player{

    public Dealer(){
        super("Dealer");
    }


    public void showSomeInfo(){
        System.out.println(getName() + "'s"  + " Hand");
        List<Card> hand = getHand();
        Card aCard = hand.get(0);
        System.out.println(aCard);
        System.out.println(aCard.getValue());
        System.out.println();
    }

}
