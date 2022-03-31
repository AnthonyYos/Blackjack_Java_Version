package com.anthony.game;

import com.anthony.user.Dealer;
import com.anthony.user.Player;

public class GameEvaluator {

    private GameEvaluator() {
    }

    static public void evaluateGame(Player thePlayer, Dealer theDealer) {
        if (checkTieGame(thePlayer, theDealer))
            System.out.println("Tie");
        else if (checkPlayerWin(thePlayer, theDealer))
            System.out.println(thePlayer.getName() + " wins!");
        else
            System.out.println(theDealer.getName() + " wins");
    }

    private static boolean checkTieGame(Player thePlayer, Dealer theDealer) {
        return (thePlayer.getHandValue() == theDealer.getHandValue() || checkBust(thePlayer) && checkBust(theDealer));
    }

    private static boolean checkPlayerWin(Player thePlayer, Dealer theDealer) {
        return (checkBust(theDealer) || (thePlayer.getHandValue() > theDealer.getHandValue() && !checkBust(thePlayer)));
    }

    private static boolean checkBust(Player currentUser) {
        return currentUser.getHandValue() > 21;
    }
}