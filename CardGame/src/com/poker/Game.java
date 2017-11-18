package com.poker;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Game {
	final static String faces = "AKQJT98765432";
    final static String suits = "HDSC";
	void startGame() {
		Scanner scanner = new Scanner(System.in);
		String[] input = new String[5];
		String inpString = "";
		System.out.println("Enter the cards:");
		for (int i = 0; i < input.length; i++) {
			inpString = scanner.next();
			if(inpString.length() == 2) {
				input[i] = inpString;
			}else {
				input[i] = "T"+inpString.charAt(2);
			}
        }
		System.out.println(analyzeHand(input));
	}
	
	private static Score analyzeHand(final String[] hand) {
        if (hand.length != 5)
            return new Score("Wrong number of cards", -1, hand);
 
        if (new HashSet<>(Arrays.asList(hand)).size() != hand.length)
            return new Score("Duplicate cards in the set", -1, hand);
 
        int[] faceCount = new int[faces.length()];
        long straight = 0, flush = 0;
        for (String card : hand) {
 
            int face = faces.indexOf(card.charAt(0));
            if (face == -1)
                return new Score("Non existing face", -1, hand);
            straight |= (1 << face);
 
            faceCount[face]++;
 
            if (suits.indexOf(card.charAt(1)) == -1)
                return new Score("Non existing suit", -1, hand);
            flush |= (1 << card.charAt(1));
        }
        
        while (straight % 2 == 0)
            straight >>= 1;
            
        boolean hasStraight = straight == 0b11111 || straight == 0b1111000000001;
 
        boolean hasFlush = (flush & (flush - 1)) == 0;
 
        if (hasStraight && hasFlush)
            return new Score("Straight flush", 9, hand);
 
        int total = 0;
        for (int count : faceCount) {
            if (count == 4)
                return new Score("Four of a kind", 8, hand);
            if (count == 3)
                total += 3;
            else if (count == 2)
                total += 2;
        }
 
        if (total == 5)
            return new Score("Full house", 7, hand);
 
        if (hasFlush)
            return new Score("Flush", 6, hand);
 
        if (hasStraight)
            return new Score("Straight", 5, hand);
 
        if (total == 3)
            return new Score("Three of a kind", 4, hand);
 
        if (total == 4)
            return new Score("Two pair", 3, hand);
 
        if (total == 2)
            return new Score("One pair", 2, hand);
 
        return new Score("High card", 1, hand);
    }
	
	private static class Score {
        final int weight;
        final String name;
        final String[] hand;
 
        Score(String n, int w, String[] h) {
            weight = w;
            name = n;
            hand = h != null ? h.clone() : h;
        }
 
        @Override
        public String toString() {
        	String str="";
        	char ch = 'T';
        	for(int i=0; i<5; i++) {
        		str = hand[i];
        		if(str.charAt(0) == ch) {
        			hand[i] = "10"+str.charAt(1);
        		}
        	}
            return Arrays.toString(hand) + " " + name;
        }
    }
}
