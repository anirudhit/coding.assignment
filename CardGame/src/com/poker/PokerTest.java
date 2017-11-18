package com.poker;
public class PokerTest {
	private static Deck cards;
	private static Game gm;
    public static void main(String[] args){
    	cards = new Deck();
    	cards.buildDeck();
    	gm = new Game();
    	gm.startGame();
    }
}