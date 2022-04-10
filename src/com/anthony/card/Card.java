package com.anthony.card;

import java.util.HashMap;
import java.util.Map;

public class Card {
     Map<String, Integer> mapValues = new HashMap<>(){{
        put("Two",2);
        put("Three",3);
        put("Four",4);
        put("Five",5);
        put("Six",6);
        put("Seven",7);
        put("Eight",8);
        put("Nine",9);
        put("Ten",10);
        put("Jack",10);
        put("Queen",10);
        put("King",10);
        put("Ace",11);
    }};
    final private Suit suit;
    final private Rank rank;
    final private int value;

    public Card(Suit suit, Rank rank){
        this.rank = rank;
        this.suit = suit;
        this.value = mapValues.get(this.rank.toString());
    }

    public String toString(){
        return this.suit.toString() + "-" + this.rank.toString();
    }

    public int getValue(){
        return this.value;
    }

    public String getRank(){
        return this.rank.toString();
    }
}
