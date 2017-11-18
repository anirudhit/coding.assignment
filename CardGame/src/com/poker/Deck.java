package com.poker;

public class Deck {
    static String faces = Constants.FACES;
    static String suits = Constants.SUITS;
    final static String[] deck = new String[faces.length() * suits.length()];
    
    void buildDeck() {
        int i = 0;
        for (char s : suits.toCharArray()) {
            for (char f : faces.toCharArray()) {
            	deck[i] = "" + f + s;
                i++;
            }
        }
        for(int j=0; i<deck.length; j++) {
    		System.out.println(deck[j]);
    	}
    }
}
