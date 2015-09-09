/**
 * 
 */
package com.github.cbpos1989.gui_tutorials.high_low_game;

import java.util.ArrayList;

/**
 * Clas to hold state and behaviour for Hand object
 * 
 * @author Colm O'Sullivan
 *
 */
public class Hand {
	private ArrayList<Card> hand;
	
	public Hand(){
		hand = new ArrayList<Card>();
	}
	
	//Empty hand of cards
	public void clear(){
		hand.clear();
	}
	
	public void addCard(Card c){
		if (c == null) {
			throw new NullPointerException("Can't add a null card to a hand");
		}
		
		hand.add(c);
	}
	
	public void removeCard(Card c){
		hand.remove(c);
	}
	
	public void removeCard(int position){
		if (position < 0 || position >=hand.size()) {
			throw new IllegalArgumentException("Position does not exsist in hand: " + position);
		}
		
		hand.remove(position);
	}
	
	public int getCardCount(){
		return hand.size();
	}
	
	public Card getCard(int position){
		if (position < 0 || position >=hand.size()) {
			throw new IllegalArgumentException("Position does not exsist in hand: " + position);
		}
		
		return hand.get(position);
	}
	
	public void sortBySuit(){
		ArrayList<Card> newHand = new ArrayList<Card>();
		
		while(hand.size() > 0){
			int pos = 0;
			Card c = hand.get(0);
			
			for (int i = 1; i < hand.size(); ++i) {
				Card c1 = hand.get(i);
				if (c1.getSuit() < c.getSuit() || (c1.getSuit() == c.getSuit() && c1.getValue() < c.getValue())) {
					pos = i;
					c = c1;
				}
				hand.remove(pos);
				newHand.add(c);
			}
			hand = newHand;
		}
	}
	
	public void sortByValue(){
		ArrayList<Card> newHand = new ArrayList<Card>();
		
		while(hand.size() > 0){
			int pos = 0;
			Card c = hand.get(0);
			
			for (int i = 1; i < hand.size(); ++i) {
				Card c1 = hand.get(i);
				if (c1.getValue() < c.getValue() || (c1.getValue() == c.getValue() && c1.getSuit() < c.getSuit())) {
					pos = i;
					c = c1;
				}
				hand.remove(pos);
				newHand.add(c);
			}
			hand = newHand;
		}
	}
}
