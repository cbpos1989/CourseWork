package com.github.cbpos1989.cg_assignments;

/**
 *  JPanel that contains all key GUI components for GuessWord game.
 * 
 * @author Colm O'Sullivan & Artjoms Porss
 *
 */

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import java.awt.Color;

import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessWord extends JPanel {
	
	JTextField textField_1;
	JTextField textField_2;
	private String[] answers = {"MEMORY", "COMPUTER", "PRINTER", "TROUSERS", "BUTTERCUP"};
	
	private char[] guessWord;
	private char[] asterisk;
	
	static int lives = 8;
	
	/**
	 * Create the panel.
	 */
	
	public GuessWord() {
		GuessWord.this.setLayout(null);
		
		//Guess Word
		JLabel lblGuessTheWord = new JLabel("GUESS THE WORD");
		lblGuessTheWord.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGuessTheWord.setForeground(Color.RED);
		lblGuessTheWord.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuessTheWord.setBounds(136, 11, 223, 36);
		add(lblGuessTheWord);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setBounds(119, 58, 240, 29);
		add(textField_1);
		textField_1.setColumns(24);
		
		//Guesses Remaining
		JLabel lblGuessesRemaning = new JLabel("GUESSES REMANING");
		lblGuessesRemaning.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuessesRemaning.setForeground(Color.RED);
		lblGuessesRemaning.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGuessesRemaning.setBounds(103, 98, 143, 36);
		add(lblGuessesRemaning);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_2.setEditable(false);
		textField_2.setColumns(3);
		textField_2.setBounds(257, 104, 102, 29);
		add(textField_2);
		
		JButton btnA = new JButton("A");
		btnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLetter('A');
			}
		});
		btnA.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnA.setBounds(10, 145, 50, 30);
		add(btnA);
		
		JButton btnB = new JButton("B");
		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLetter('B');
			}
		});
		btnB.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnB.setBounds(60, 145, 50, 30);
		add(btnB);
		
		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLetter('C');
			}
		});
		btnC.setBounds(new Rectangle(0, 0, 50, 30));
		btnC.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnC.setBounds(110, 145, 50, 30);
		add(btnC);
		
		JButton btnD = new JButton("D");
		btnD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLetter('D');
			}
		});
		btnD.setBounds(new Rectangle(0, 0, 50, 30));
		btnD.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnD.setBounds(160, 145, 50, 30);
		add(btnD);
		
		JButton btnE = new JButton("E");
		btnE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLetter('E');
			}
		});
		btnE.setBounds(new Rectangle(0, 0, 50, 30));
		btnE.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnE.setBounds(210, 145, 50, 30);
		add(btnE);
		
		JButton btnF = new JButton("F");
		btnF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLetter('F');
			}
		});
		btnF.setBounds(new Rectangle(0, 0, 50, 30));
		btnF.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnF.setBounds(260, 145, 50, 30);
		add(btnF);
		
		JButton btnG = new JButton("G");
		btnG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLetter('G');
			}
		});
		btnG.setBounds(new Rectangle(0, 0, 50, 30));
		btnG.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnG.setBounds(309, 145, 50, 30);
		add(btnG);
		
		JButton btnH = new JButton("H");
		btnH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLetter('H');
			}
		});
		btnH.setBounds(new Rectangle(0, 0, 50, 30));
		btnH.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnH.setBounds(10, 175, 50, 30);
		add(btnH);
		
		JButton btnI = new JButton("I");
		btnI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLetter('I');
			}
		});
		btnI.setBounds(new Rectangle(0, 0, 50, 30));
		btnI.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnI.setBounds(60, 175, 50, 30);
		add(btnI);
		
		JButton btnJ = new JButton("J");
		btnJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLetter('J');
			}
		});
		btnJ.setBounds(new Rectangle(0, 0, 50, 30));
		btnJ.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnJ.setBounds(110, 175, 50, 30);
		add(btnJ);
		
		JButton btnK = new JButton("K");
		btnK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLetter('K');
			}
		});
		btnK.setBounds(new Rectangle(0, 0, 50, 30));
		btnK.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnK.setBounds(160, 175, 50, 30);
		add(btnK);
		
		JButton btnL = new JButton("L");
		btnL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLetter('L');
			}
		});
		btnL.setBounds(new Rectangle(0, 0, 50, 30));
		btnL.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnL.setBounds(210, 175, 50, 30);
		add(btnL);
		
		JButton btnM = new JButton("M");
		btnM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLetter('M');
			}
		});
		btnM.setBounds(new Rectangle(0, 0, 50, 30));
		btnM.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnM.setBounds(260, 175, 50, 30);
		add(btnM);
		
		JButton btnN = new JButton("N");
		btnN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLetter('N');
			}
		});
		btnN.setBounds(new Rectangle(0, 0, 50, 30));
		btnN.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnN.setBounds(309, 175, 50, 30);
		add(btnN);
		
		JButton btnO = new JButton("O");
		btnO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLetter('O');
			}
		});
		btnO.setBounds(new Rectangle(0, 0, 50, 30));
		btnO.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnO.setBounds(10, 205, 50, 30);
		add(btnO);
		
		JButton btnP = new JButton("P");
		btnP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLetter('P');
			}
		});
		btnP.setBounds(new Rectangle(0, 0, 50, 30));
		btnP.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnP.setBounds(60, 205, 50, 30);
		add(btnP);
		
		JButton btnQ = new JButton("Q");
		btnQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLetter('Q');
			}
		});
		btnQ.setBounds(new Rectangle(0, 0, 50, 30));
		btnQ.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnQ.setBounds(110, 205, 50, 30);
		add(btnQ);
		
		JButton btnR = new JButton("R");
		btnR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLetter('R');
			}
		});
		btnR.setBounds(new Rectangle(0, 0, 50, 30));
		btnR.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnR.setBounds(160, 205, 50, 30);
		add(btnR);
		
		
		JButton btnS = new JButton("S");
		btnS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLetter('S');
			}
		});
		btnS.setBounds(new Rectangle(0, 0, 50, 30));
		btnS.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnS.setBounds(210, 205, 50, 30);
		add(btnS);
		
		JButton btnT = new JButton("T");
		btnT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLetter('T');
			}
		});
		btnT.setBounds(new Rectangle(0, 0, 50, 30));
		btnT.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnT.setBounds(260, 205, 50, 30);
		add(btnT);
		
		JButton btnU = new JButton("U");
		btnU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLetter('U');
			}
		});
		btnU.setBounds(new Rectangle(0, 0, 50, 30));
		btnU.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnU.setBounds(309, 205, 50, 30);
		add(btnU);
		
		JButton btnV = new JButton("V");
		btnV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLetter('V');
			}
		});
		btnV.setBounds(new Rectangle(0, 0, 50, 30));
		btnV.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnV.setBounds(10, 235, 50, 30);
		add(btnV);
		
		JButton btnW = new JButton("W");
		btnW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLetter('W');
			}
		});
		btnW.setBounds(new Rectangle(0, 0, 50, 30));
		btnW.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnW.setBounds(60, 235, 50, 30);
		add(btnW);
		
		JButton btnX = new JButton("X");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLetter('X');
			}
		});
		btnX.setBounds(new Rectangle(0, 0, 50, 30));
		btnX.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnX.setBounds(110, 235, 50, 30);
		add(btnX);
		
		JButton btnY = new JButton("Y");
		btnY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLetter('Y');
			}
		});
		btnY.setBounds(new Rectangle(0, 0, 50, 30));
		btnY.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnY.setBounds(160, 235, 50, 30);
		add(btnY);
		
		JButton btnZ = new JButton("Z");
		btnZ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLetter('Z');
			}
		});
		btnZ.setBounds(new Rectangle(0, 0, 50, 30));
		btnZ.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnZ.setBounds(210, 235, 50, 30);
		add(btnZ);
		
		JButton btnAnswer = new JButton("ANSWER");
		btnAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lives = 8;
				
				alterText(new String(guessWord),textField_1);
				alterText(lives + "", textField_2);
			}
		});
		btnAnswer.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAnswer.setBounds(260, 235, 99, 30);
		add(btnAnswer);
		
		JButton btnStart = new JButton("START");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setupGame();
			}
		});
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnStart.setBounds(10, 266, 349, 30);
		add(btnStart);
		

	
	}
	
	void setupGame(){
		String answerWord = null;
		int count = 0;
		
		if(count == 5){
			 count = 0;
		}
		
		answerWord = answers[count];
		guessWord = answerWord.toCharArray();
		
		//Initialise asterisk array
		asterisk = new char[guessWord.length];
		for(int i = 0; i < asterisk.length; ++i){
			asterisk[i] = '*';
		}
		
		String temp = new String(asterisk);
		
		//Passes in a String and TextField to be changed
		alterText(temp, textField_1);
		alterText(lives + "", textField_2);
		
		count++;
	}
	
	void alterText(String word, JTextField field){
		field.setText(word);
	}
	
	void checkLetter(char letter){
		//if letter is correct, switches an asterisk to actual letter
		boolean isRight = false;
		boolean hasAsterisk = true;
		
		for(int i = 0; i < guessWord.length; ++i){
			if(letter == guessWord[i]){
				asterisk[i] = guessWord[i];
				isRight = true;
			} 
			
			if(asterisk[i] == '*'){
				hasAsterisk = true;
				continue;
			} else {
				hasAsterisk = false;
			}
		}
		
		alterText(new String(asterisk), textField_1);
	
		if(!isRight){
			lives--;
			checkLives();
		}
		
		isRight = false;
		
		alterText(lives + "", textField_2);
		
		if(hasAsterisk ==  false){
			JFrame frame = new JFrame("JOptionPane example");
			JOptionPane.showMessageDialog(frame, "Win", "You Win", 
											JOptionPane.INFORMATION_MESSAGE);
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			
			
			//JDialog Message = new Message("You Win");
			//Message.setVisible(true);
		}
	}
	
	void checkLives(){
		if(lives == 0){
			JDialog Message = new Message("You Lose");
			Message.setVisible(true);
		}
	}
}
