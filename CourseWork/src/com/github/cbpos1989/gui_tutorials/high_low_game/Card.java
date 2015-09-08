/**
 * 
 */
package com.github.cbpos1989.gui_tutorials.high_low_game;

/**
 * A Class to hold state and behaviour of a Card type object.
 * 
 * @author Colm O'Sullivan
 *
 */
public class Card {
	
	//Codes for suits, plus Joker
	public final static int SPADES = 0;
	public final static int HEARTS = 1;
	public final static int DIAMONDS = 2;
	public final static int CLUBS = 3;
	public final static int JOKER = 4;
	
	//Codes for non-numeric cards.
	public final static int ACE = 1;
	public final static int JACK = 11;
	public final static int QUEEN = 12;
	public final static int KING = 13;
	
	private final int suit;
	private final int value;
	
	public Card(){
		suit = JOKER;
		value = 1;
	}
	
	//Checks is both passing in suit and value arguments are valid values before assign them.
	public Card(int suit, int value){
		if (suit < 0 || suit > 4) {
			throw new IllegalArgumentException("Illegal playing card value");
		}
		if (suit != JOKER && (value < 1 || value > 13)) {
			throw new IllegalArgumentException("Illegal playing card value");
		}
		
		this.value = value;
		this.suit = suit;
	}
	
	public int getSuit(){
		return suit;
	}
	
	public int getValue(){
		return value;
	}
	
	//Returns unicode symbols for each suit
	public String getSuitAsString() {
		switch ( suit ) {
	    case SPADES:   
	    	return "\u0006";
	    case HEARTS:   
	    	return "\u0003";
	    case DIAMONDS: 
	    	return "\u0004";
	    case CLUBS:    
	    	return "\u0005";
	    default:       
	    	return "Joker";
	    	}
	}
	
	public String toString(){
		if (suit == JOKER) {
			if (value == 1) {
				return "Joker";
			} else {
				return "Joker #" + value;
			}
		} else {
			return getSuitAsString() + " " + value;
		}
	}
}


