/**
 * 
 */
package com.github.cbpos1989.gui_tutorials.high_low_game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
 * Class to handle GUI components of HighLowApp
 * 
 * @author Colm O'Sullivan
 *
 */
public class HighLowGUI extends JPanel {
	private final Color BEIGE = new Color(220,200,180);
	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	
	public HighLowGUI(){
		setBackground(new Color(130,50,40));
		setLayout(new BorderLayout(3,3));
		
		//Creating Panels
		CardPanel board = new CardPanel();
		add(board, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(BEIGE);
		add(buttonPanel, BorderLayout.SOUTH);
		
		//Creating Buttons
		buttons.add(createButton("Higher"));
		buttons.add(createButton("Lower"));
		buttons.add(createButton("New Game"));
		
		for (JButton btn: buttons) {
			btn.addActionListener(board);
			buttonPanel.add(btn);
		}

		setBorder(BorderFactory.createLineBorder(new Color(130,50,40),3));
	}
	
	
	private JButton createButton(String name){
		JButton button = new JButton(name);
		button.setBackground(BEIGE);
		button.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		button.setPreferredSize(new Dimension(75,25));
		return button;
	}
	
	
	
	private class CardPanel extends JPanel implements ActionListener{
		Deck deck;
		Hand hand;
		String message;
		
		boolean gameInProgress;
		
		Font bigFont;
		Font smallFont;
		
		CardPanel(){
			setBackground(new Color(0,120,0));
			setForeground(Color.WHITE);
			smallFont = new Font("Consolas", Font.PLAIN, 12);
			bigFont = new Font("Serif", Font.BOLD, 14);
			setPreferredSize(new Dimension(370,150));
			doNewGame();
			
		}
		
		@Override
		public void actionPerformed(ActionEvent evt) {
			String command = evt.getActionCommand();
			if (command.equals("Higher")) {
				doHigher();
			} else if (command.equals("Lower")) {
				doLower();
			} else if (command.equals("New Game")) {
				doNewGame();
			}
			
		}
		
		private void doNewGame() {
			if (gameInProgress) {
				message = "You still have to finish this game!";
				repaint();
				return;
			}
			
			deck = new Deck();
			hand = new Hand();
			deck.shuffle();
			hand.addCard(deck.dealCard());
			message = "Is the next card higher or lower?";
			gameInProgress = true;
			repaint();
		}

		private void doHigher() {
			if (!gameInProgress) {
				message = "Click \"New Game\" to start a new game!";
				repaint();
				return;
			}
			
			hand.addCard(deck.dealCard());
			int cardCt = hand.getCardCount();
			Card thisCard = hand.getCard(cardCt -1);
			Card prevCard = hand.getCard(cardCt -2);
			
			if (thisCard.getValue() < prevCard.getValue()) {
				gameInProgress = false;
				message = "Too bad! You lose.";
			} else if (thisCard.getValue() == prevCard.getValue()) {
				gameInProgress = false;
				message = "Too bad! You lose on ties.";
			} else if (cardCt == 4) {
				gameInProgress = false;
				message = "You Win! You made three correct guesses.";
			} else {
				message = "You got it right! Try for " + cardCt + ".";
			}
			
			repaint();
		}
		
		private void doLower() {
			if (!gameInProgress) {
				message = "Click \"New Game\" to start a new game!";
				repaint();
				return;
			}
			
			hand.addCard(deck.dealCard());
			int cardCt = hand.getCardCount();
			Card thisCard = hand.getCard(cardCt -1);
			Card prevCard = hand.getCard(cardCt -2);
			
			if (thisCard.getValue() > prevCard.getValue()) {
				gameInProgress = false;
				message = "Too bad! You lose.";
			} else if (thisCard.getValue() == prevCard.getValue()) {
				gameInProgress = false;
				message = "Too bad! You lose on ties.";
			} else if (cardCt == 4) {
				gameInProgress = false;
				message = "You Win! You made three correct guesses.";
			} else {
				message = "You got it right! Try for " + cardCt + ".";
			}
			
			repaint();
			
		}
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.setFont(bigFont);
			g.drawString(message, 10, 135);
			g.setFont(smallFont);
			int cardCt = hand.getCardCount();
			
			for (int i = 0; i < cardCt; ++i) {
				drawCard(g, hand.getCard(i),10 + i * 90, 10);
				
				if (gameInProgress) {
					drawCard(g, null, 10 + cardCt * 90, 10);
				}
			}
		}

		private void drawCard(Graphics g, Card card, int x, int y) {
			if (card == null) {
				g.setColor(Color.BLUE);
				g.fillRect(x, y, 80, 100);
				g.setColor(Color.WHITE);
				g.drawRect(x+3, y+3, 73, 93);
				g.drawRect(x+4, y+4, 71, 91);
			} else {
				g.setColor(Color.WHITE);
				g.fillRect(x, y, 80, 100);
				g.setColor(Color.GRAY);
				g.drawRect(x, y, 79, 99);
				g.drawRect(x+1, y+1, 77, 97);
				
				if (card.getSuit() == Card.DIAMONDS || card.getSuit() == Card.HEARTS) {
					g.setColor(Color.RED);
				} else {
					g.setColor(Color.BLACK);
				}
				
				g.drawString(card.toString(), x + 5, y + 30);
			}
			
		}
	}
}

