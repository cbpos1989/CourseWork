/**
 * 
 */
package com.github.cbpos1989.cg_assignments;


import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;


import java.awt.Font;
import java.awt.Graphics;

import javax.swing.SwingConstants;

import java.awt.Color;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Colm O'Sullivan
 *
 */

public class HitsAndMissesGUI extends JPanel {
	private Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.BLACK};
	private Circle[] answer = new Circle[3];
	private Color[] guess = new Color[3];
	private int incrementX = 0;
	private int incrementY = 0;
	private int originX = 250;
	private int originY = 41;
	private int counter = 1;
	private int lblCounter = 1;
	private int lives = 6;
	
	
	
	private JLabel lb2ndGuess;
	private JLabel lb3rdGuess;
	private JLabel lb4thGuess;
	private JLabel lb5thGuess;
	private JLabel lb6thGuess;
	private JLabel lblGuessTheHidden;
	
	
	/**
	 * Create the panel.
	 */
			
	public HitsAndMissesGUI() {
		this.setLayout(null);
		
		initialiseGui();
		setupGame();
	}		
	
	void initialiseGui(){
		//Upper Labels
				JLabel lblClickAColour = new JLabel("Click a colour");
				lblClickAColour.setHorizontalAlignment(SwingConstants.CENTER);
				lblClickAColour.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblClickAColour.setBounds(54, 12, 108, 14);
				add(lblClickAColour);
				
				JLabel lblstGuess = new JLabel("1st Guess");
				lblstGuess.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblstGuess.setBounds(373, 39, 67, 22);
				add(lblstGuess);
				
				lb2ndGuess = new JLabel("");
				lb2ndGuess.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lb2ndGuess.setBounds(373, 64, 67, 22);
				add(lb2ndGuess);
				
				lb3rdGuess = new JLabel("");
				lb3rdGuess.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lb3rdGuess.setBounds(373, 89, 67, 22);
				add(lb3rdGuess);
			
				lb4thGuess = new JLabel("");
				lb4thGuess.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lb4thGuess.setBounds(373, 114, 67, 22);
				add(lb4thGuess);
				
				lb5thGuess = new JLabel("");
				lb5thGuess.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lb5thGuess.setBounds(373, 139, 67, 22);
				add(lb5thGuess);
				
				lb6thGuess = new JLabel("");
				lb6thGuess.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lb6thGuess.setBounds(373, 164, 67, 22);
				add(lb6thGuess);
			
				
				//Buttons
				JButton btnRed = new JButton("Red");
				btnRed.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						colorButtonAction(Color.RED);
					}
				});
				btnRed.setBounds(10, 37, 60, 30);
				add(btnRed);
				
				JButton btnBlue = new JButton("Blue");
				btnBlue.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						colorButtonAction(Color.BLUE);
					}
				});
				btnBlue.setBounds(70, 37, 60, 30);
				add(btnBlue);
				
				JButton btnGreen = new JButton("Green");
				btnGreen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						colorButtonAction(Color.GREEN);
					}
				});
				btnGreen.setFont(new Font("Tahoma", Font.PLAIN, 9));
				btnGreen.setBounds(130, 37, 60, 30);
				add(btnGreen);
				
				JButton btnYellow = new JButton("Yellow");
				btnYellow.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						colorButtonAction(Color.YELLOW);
					}
				});
				btnYellow.setHorizontalAlignment(SwingConstants.LEFT);
				btnYellow.setFont(new Font("Tahoma", Font.PLAIN, 8));
				btnYellow.setBounds(42, 70, 60, 30);
				add(btnYellow);
				
				JButton btnBlack = new JButton("Black");
				btnBlack.setFont(new Font("Tahoma", Font.PLAIN, 9));
				btnBlack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						colorButtonAction(Color.BLACK);
					}
				});
				btnBlack.setBounds(102, 70, 60, 30);
				add(btnBlack);
				
				//Lower Labels
				lblGuessTheHidden = new JLabel("Guess the hidden Code");
				lblGuessTheHidden.setHorizontalAlignment(SwingConstants.CENTER);
				lblGuessTheHidden.setBounds(42, 242, 136, 14);
				add(lblGuessTheHidden);
				
				JLabel lblHitsAndMisses = new JLabel("HITS AND MISSES");
				lblHitsAndMisses.setForeground(Color.BLUE);
				lblHitsAndMisses.setFont(new Font("Tahoma", Font.BOLD, 18));
				lblHitsAndMisses.setHorizontalAlignment(SwingConstants.CENTER);
				lblHitsAndMisses.setBounds(139, 267, 174, 25);
				add(lblHitsAndMisses);
	}
	
	void setupGame(){
		incrementX = 0; //reset increment
		
		for(int i = 0; i < answer.length; ++i){
			this.add(new Circle(250 + incrementX, 41));
			this.add(new Circle(250 + incrementX,238));
			
			answer[i] = new Circle(250 + incrementX, 238, colors[randomGenerator(colors.length)]);
			
			this.add(new Circle(250 + incrementX,238,Color.WHITE));
		
			incrementX += 25;
		}
		
		incrementX = 0; //reset increment
	}
	
	void addCircle(int x, int y){
		Circle temp = new Circle(x + incrementX, y + incrementY);
		temp.paint(getGraphics());
	}
	
	void fillCircle(int x, int y, Color circleColor){
		System.out.println(lives);
		Circle temp = new Circle(x + incrementX, y + incrementY, circleColor);
		temp.paint(getGraphics());
	}
	
	void colorButtonAction(Color clr){
		if(lives > 0){
			if (counter == 3) {
				//Fill in Circle and add color to guess array
				fillCircle(originX, originY, clr);
				guess[counter - 1] = clr;
				checkGuess();
				
				//Reset incrementX and concat incrementY for next line
				incrementX = 0;
				incrementY +=25;
				
				//Add empty circles for next line of guesses
				if(lives > 0){
					for(int i = 0; i < 3; ++i){
						addCircle(originX, originY);
						incrementX += 25;
					}
				}
				
				//Reset increment and counter for next line of guesses
				incrementX = 0;
				counter = 1;
				lblCounter++;
				addLabel(lblCounter);
			} else {
				//Fill in Circle and add color to guess array
				fillCircle(originX, originY, clr);
				guess[counter - 1] = clr;
				incrementX += 25;
				counter++;
			}
		}
	}
	
	void addLabel(int lblCounter){
		switch(lblCounter){
		case 2 : lb2ndGuess.setText("2nd Guess"); break;
		case 3 : lb3rdGuess.setText("3rd Guess"); break;
		case 4 : lb4thGuess.setText("4th Guess"); break;
		case 5 : lb5thGuess.setText("5th Guess"); break;
		case 6 : lb6thGuess.setText("6th Guess"); break;
		default: break;
		}
	}
	
	void checkGuess(){
		int cnt = 0;
		for(int i = 0; i < 3; ++i){
			if(guess[i] == answer[i].getColor()){
				//Reveal colour if the player got at least one of the guesses right
				answer[i].paint(getGraphics());
				++cnt;
			} else {
				continue;
			}
		}
			
		if(cnt == 3){
			GameOver(true);
		} else {
			--lives;
		}
			
		if(lives == 0){
			GameOver(false);
		}
		
	}
	
	void GameOver(boolean isMatch){
		System.out.println("gAME oVER");
		
		if(isMatch){
			lblGuessTheHidden.setText("You win");
		} else{
			lblGuessTheHidden.setText("You lose");
		}
		
		for(int i = 0; i < answer.length; ++i){
			answer[i].paint(getGraphics());
		}
	}
	
	int randomGenerator(int bound){
		Random rnd = new Random();
		return rnd.nextInt(bound);
	}
}
