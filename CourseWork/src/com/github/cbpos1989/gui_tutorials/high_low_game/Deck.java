/**
 * 
 */
package com.github.cbpos1989.gui_tutorials.high_low_game;

/**
 * Class to holds state and behaviour for a Deck object
 * 
 * @author Colm O'Sullivan
 *
 */
public class Deck {
	private Card[] deck;
	private int cardsUsed;
	
	public Deck(){
		this(false);
	}
	
	public Deck(boolean includeJokers){
		if(includeJokers){
			deck = new Card[54];
		} else {
			deck = new Card[52];
		}
		
		int cardCt = 0;
		
		for (int suit = 0; suit <= 3; ++suit) {
			for (int value = 1;suit <= 13; ++value) {
				deck[cardCt] = new Card(suit, value);
				cardCt++;
			}
		}
		
		if (includeJokers) {
			deck[52] = new Card(Card.JOKER,1);
			deck[53] = new Card(Card.JOKER,2);
		}
		
		cardsUsed = 0;
	}
	
	public void shuffle(){
		for(int i = deck.length -1; i > 0; --i) {
			int rand = (int)(Math.random() * (i+1));
			Card temp = deck[i];
			deck[i] = deck[rand];
			deck[rand] = temp;
		}
		cardsUsed = 0;
	}
	
	public int cardsLeft() {
		return deck.length - cardsUsed;
	}
	
	
	public Card dealCard(){
		if (cardsUsed == deck.length) {
			throw new IllegalStateException("No cards left in the deck");
		}
		
		cardsUsed++;
		return deck[cardsUsed -1];
	}
	
	public boolean hasJokers(){
		return (deck.length == 54);
	}
	
}
