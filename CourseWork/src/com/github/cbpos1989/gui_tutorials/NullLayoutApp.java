/**
 * 
 */
package com.github.cbpos1989.gui_tutorials;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * App to demonstrate the use of the null layout
 * 
 * @author Colm O'Sullivan
 *
 */
public class NullLayoutApp {

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenWidth = (int) screenSize.getWidth();
	int screenHeight = (int) screenSize.getHeight();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NullLayoutApp nla = new NullLayoutApp();
		nla.startProgram();

	}

	private void startProgram() {
		JFrame window = new JFrame("Null Layout App");
		NullLayoutPanel content = new NullLayoutPanel();
		window.setContentPane(content);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocation(screenWidth/2, screenHeight/2);
		window.pack();
		window.setResizable(false);
		window.setVisible(true);
		
	}

}
