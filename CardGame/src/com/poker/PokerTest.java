package com.poker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PokerTest {
	private static Game gm;
    public static void main(String[] args) throws IOException{
    	char ch;
    	do {
        	//Creating the Game class instance
        	gm = new Game();
        	gm.startGame();
        	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        	System.out.println("Do you want to continue (Y/N) : ");
        	ch = (char) br.read();
    	}
    	while(ch == 'y' || ch == 'Y');
    }
}