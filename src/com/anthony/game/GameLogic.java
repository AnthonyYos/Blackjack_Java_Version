package com.anthony.game;

import com.anthony.user.Dealer;
import com.anthony.user.Player;

public class GameLogic {

    public boolean checkTieGame(Player thePlayer, Dealer theDealer) {
        return (thePlayer.getHandValue() == theDealer.getHandValue() || checkBust(thePlayer) && checkBust(theDealer));
    }

    public boolean checkPlayerWin(Player thePlayer, Dealer theDealer) {
        return (checkBust(theDealer) || (thePlayer.getHandValue() > theDealer.getHandValue() && !checkBust(thePlayer)));
    }

    public boolean checkBust(Player currentUser) {
        return currentUser.getHandValue() > 21;
    }
}
