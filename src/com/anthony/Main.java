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
    }

    public static void main(String[] args) {
        final int blackjack = 21;
        final int minHandValue = 17;
        boolean  playBlackjack = true;
    /*use to test for ace cases
        Player testPlayer = new Player();
        Suit suit = Suit.Club;
        Rank rank = Rank.Ace;
        Card aCard = new Card(suit,rank);
        testPlayer.addCard(aCard);
        System.out.println(aCard);*/

        while(playBlackjack) {
            // Create Deck, player, and dealer
            Deck aDeck = new Deck();
            aDeck.createDeck();
            aDeck.shuffle();
            Player p1 = new Player("Ant");
            Dealer dealer = new Dealer();

            // Deal out cards and show current hands
            for (int i = 0; i < 2; i++) {
                p1.addCard(aDeck.deal());
                dealer.addCard(aDeck.deal());
            }
            p1.showHandInfo();
            dealer.showSomeInfo();

            // Player and dealer asked to hit if possible/wanted
            if (p1.getHandValue() < blackjack)
                hitOrStand(aDeck, p1);
            // Full reveal dealer hand before possible hits
            dealer.showHandInfo();
            while (dealer.getHandValue() < minHandValue)
                hit(aDeck, dealer);

            // Print final hand values
            System.out.println("Final Hands:");
            p1.showHandInfo();
            dealer.showHandInfo();

            // Game conditions(win,loss,tie)
            // Tie (Equal hands or player and dealer bust)
            if (p1.getHandValue() == dealer.getHandValue() || p1.bust() && dealer.bust())
                System.out.println("Tie");
                // Player wins (Dealer bust or player's hand > dealer's hand)
            else if (dealer.bust() || (p1.getHandValue() > dealer.getHandValue() && !p1.bust()))
                System.out.println(p1.getName() + " wins!");
                // Player loses
            else
                System.out.println(dealer.getName() + " wins");


            while(true){
                try{
                    System.out.println("Do you want to play again? Enter 'y' or 'n'");
                    Scanner input = new Scanner(System.in);
                    char choice = Character.toLowerCase(input.next().charAt(0));
                    if(choice == 'y')
                        break;
                    else if(choice == 'n'){
                        playBlackjack = false;
                        break;
                    }
                    else
                        throw new Exception("Invalid input entered");
                } catch (Exception e) {
                    System.out.println("You entered an invalid choice");
                }
            }
        }
    }
}
