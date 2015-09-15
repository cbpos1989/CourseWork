/**
 * 
 */
package com.github.cbpos1989.gui_tutorials;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * App to demonstrate the use of the JList component
 * 
 * @author Colm O'Sullivan
 *
 */
public class ListExampleApp {
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenHeight = (int) screenSize.getHeight();
	int screenWidth = (int) screenSize.getWidth();
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListExampleApp lea = new ListExampleApp();
		lea.startProgram();

	}
	
	private void startProgram(){
		JFrame window = new JFrame("List Example");
		ListExamplePanel content = new ListExamplePanel();
		window.setContentPane(content);
		window.setSize(300,100);
		window.setLocation(screenWidth/2, screenHeight/2);
		window.setVisible(true);
	}

}
