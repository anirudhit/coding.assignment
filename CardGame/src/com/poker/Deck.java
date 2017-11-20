package com.poker;

public class Deck {
    static String faces = Constants.FACES;
    static String suits = Constants.SUITS;
    final static String[] deck = new String[faces.length() * suits.length()];
    
    public String checkCard(String card) {
    	String inpString = "";
    	if(card.length() == 2) {
    		inpString = card;
		}else if(card.length() == 3){
			String fNum = card.substring(0, 2);
			String cNum = "10";
			if(fNum.trim().equals(cNum)) {
				inpString = "T"+card.charAt(2);
			}else {
				inpString = card;
			}
		}else {
			inpString = card;
		}
		return inpString;
    }
}
