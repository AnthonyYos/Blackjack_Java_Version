package com.anthony;

public class Dealer extends  Player{

    Dealer(){
        super("Dealer");
    }

    public void showSomeHand(){
        System.out.println(hand.get(0));
    }

    public void showSomeInfo(){
        System.out.println(name + "'s"  + " Hand");
        showSomeHand();
        Card aCard = hand.get(0);
        System.out.println(aCard.getValue());
        System.out.println();
    }

    public void showHandInfo(){
        System.out.println(name + "'s" + " Hand");
        showHand();
        System.out.println(getHandValue());
        System.out.println();
    }

}
