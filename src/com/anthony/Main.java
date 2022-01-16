package com.anthony;

import java.util.Scanner;

public class Main {

    public static void hitOrStand(Deck theDeck, Player thePlayer){
        Scanner input = new Scanner(System.in);
        while (thePlayer.getHandValue() < 21){
            thePlayer.showHandInfo();

            try{
                System.out.println("Do you want to hit or stand? Enter 'h' or 's'\n");
                char choice = Character.toLowerCase(input.next().charAt(0));
                if(choice == 'h')
                    hit(theDeck,thePlayer);
                else if (choice == 's')
                    break;
                else
                    throw new Exception("Entered an invalid input");
            }
            catch (Exception e) {
                System.out.println(("Not a valid option\n"));
            }

        }

        thePlayer.showHandInfo();
    }

    public static void hit(Deck theDeck, Player thePlayer){
        thePlayer.addCard(theDeck.deal());
        thePlayer.adjustForAce();
    }

    public static void main(String[] args) {
    /*use to test for ace cases
        Player testPlayer = new Player();
        Suit suit = Suit.Club;
        Rank rank = Rank.Ace;
        Card aCard = new Card(suit,rank);
        testPlayer.addCard(aCard);
        System.out.println(aCard);*/

    // Create Deck, player, and dealer
        Deck aDeck = new Deck();
        aDeck.createDeck();
        aDeck.shuffle();
        Player p1 = new Player("Ant");
        Dealer dealer = new Dealer();

    // Deal out cards and show current hands
        for(int i = 0; i < 2; i++){
            p1.addCard(aDeck.deal());
            dealer.addCard(aDeck.deal());
        }
        p1.showHandInfo();
        dealer.showSomeInfo();

    // Player and dealer asked to hit if possible/wanted
        if(p1.getHandValue() < 21)
            hitOrStand(aDeck,p1);
        // Full reveal dealer hand before possible hits
        dealer.showHandInfo();
        while(dealer.getHandValue() < 17)
            hit(aDeck, dealer);

    // Print final hand values
        System.out.println("Final Hands:");
        p1.showHandInfo();
        dealer.showHandInfo();

    // Game conditions(win,loss,tie)
        System.out.println();
    }
}
