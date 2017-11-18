package com.poker;
public class PokerTest {
	private static Deck cards;
    public static void main(String[] args){
    	cards = new Deck();
    	cards.createDeck();
    	cards.enterCards();
    }
}