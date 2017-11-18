package com.poker;
import java.util.Scanner;

public class Deck {
	String[] deck = new String[52];
	String[] inpCard = new String[5];
	public void createDeck() {
		String[] suit = {"S","D","C","H"};
		String[] rank = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
		for(int i = 0; i < deck.length; i++ ) {
			deck[i] = rank[i%13] + suit[i/13];
		}
	}
	
	public Boolean checkCard(String inCard) {
		Boolean flag = true;
		Integer count = 0;
		for(int i = 0; i < deck.length; i++ ) {
			if(inCard.toUpperCase().equals(deck[i])) {
				count = count + 1;
			}
		}
		if(count > 0) {
			flag = true;
		}else {
			flag = false;
		}
		return flag;
	}
	
	public void enterCards() {
		Boolean chCard = false;
		Scanner scanner = new Scanner(System.in);
		String addCard = "";
		System.out.println("Enter your cards:");
		for (int i = 0; i < inpCard.length; i++) {
			addCard = scanner.next();
			chCard= checkCard(addCard);
			if(chCard) {
				inpCard[i] = addCard.toUpperCase();
			}else{
				System.out.println("Enter card from Deck");
				i = i -1;
			}
        }
		for (int j=0; j < inpCard.length; j++) {
			System.out.print(inpCard[j] + " ");
		}
	}
}
