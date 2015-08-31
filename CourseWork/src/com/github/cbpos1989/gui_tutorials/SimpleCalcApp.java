/**
 * 
 */
package com.github.cbpos1989.gui_tutorials;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * Class that will mimic a simple calculator in order to demonstrate nested subpanels.
 * 
 * @author Colm O'Sullivan
 *
 */
public class SimpleCalcApp {
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int screenWidth = (int) screenSize.getWidth();
	private int screenHeight = (int) screenSize.getHeight();
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimpleCalcApp sc = new SimpleCalcApp();
		sc.startProgram();

	}

	private void startProgram() {
		JFrame window = new JFrame("Calculator");
		SimpleCalcPanel content = new SimpleCalcPanel();
		window.setContentPane(content);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocation(screenWidth/2, screenHeight/2);
		window.setSize(250,250);
		window.setVisible(true);
		
	}

}
