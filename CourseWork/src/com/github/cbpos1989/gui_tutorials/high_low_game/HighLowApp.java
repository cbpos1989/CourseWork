/**
 * 
 */
package com.github.cbpos1989.gui_tutorials.high_low_game;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * Class that recreates a simple game of high low with basic gui
 * 
 * @author Colm O'Sullivan
 *
 */
public class HighLowApp {
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenWidth = (int) screenSize.getWidth(); 
	int screenHieght = (int) screenSize.getHeight();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HighLowApp hla = new HighLowApp();
		hla.startProgram();

	}

	private void startProgram() {
		JFrame window = new JFrame("HighLow Game");
		HighLowGUI content = new HighLowGUI();
		window.setContentPane(content);
		window.pack();
		window.setLocation(screenWidth/2, screenHieght/2);
		window.setVisible(true);
		
	}

}
