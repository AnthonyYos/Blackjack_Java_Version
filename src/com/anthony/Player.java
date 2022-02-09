package com.anthony;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Player {
    private final String name;
    private final List<Card> hand;
    private int handValue;
    private int aces;

    Player(){
        name = "NoName";
        hand = new ArrayList<>();
        handValue = 0;
        aces = 0;}

    Player(String name){
        this.name = name;
        hand = new ArrayList<>();
        handValue = 0;
        aces = 0;
    }

    public void addCard(Card card){
        hand.add(card);
        handValue += card.getValue();
        if(Objects.equals(card.getRank(), "Ace"))
            aces += 1;
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

    protected List<Card> getHand() {
        return hand;
    }

    public void hitOrStand(Deck theDeck){
        Scanner input = new Scanner(System.in);
        while (getHandValue() < 21){
            showHandInfo();
            try{
                System.out.println("Do you want to hit or stand? Enter 'h' or 's'\n");
                char choice = Character.toLowerCase(input.next().charAt(0));
                if(choice == 'h')
                    hit(theDeck);
                else if (choice == 's')
                    break;
                else
                    throw new Exception("Entered an invalid input");
            }
            catch (Exception e) {
                System.out.println(("Not a valid option\n"));
            }
        }
    }

    public void hit(Deck theDeck){
        addCard(theDeck.deal());
    }
}
