/**
 * 
 */
package com.github.cbpos1989.gui_tutorials;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * App to demonstrate keyEvents by moving a square around a panel depending on the user hit the arrow keys.
 * 
 * @author Colm O'Sullivan
 * 
 *
 */
public class KeyboardAndFocusApp {
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int screenHeight = (int)screenSize.getHeight();
	private int screenWidth = (int)screenSize.getWidth();
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		KeyboardAndFocusApp kfApp = new KeyboardAndFocusApp();
		kfApp.startProgram();
		
	}
	
	private void startProgram(){
		JFrame window = new JFrame("Keyboard And Focus Demo");
		KeyboardAndFocusPanel content = new KeyboardAndFocusPanel();
		window.setContentPane(content);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocation((screenWidth/2) - 250, (screenHeight/2) - 180);
		window.setSize(500,360);
		window.setVisible(true);

	}

}
