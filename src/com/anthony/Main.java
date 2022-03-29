package com.anthony;

import com.anthony.game.BlackJackGame;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter a name: ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        BlackJackGame blackjack = new BlackJackGame();
        blackjack.playBlackjack(name);
    }
}
