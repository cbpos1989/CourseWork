/**
 * 
 */
package com.github.cbpos1989.gui_tutorials;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * Class to demonstrate using the Timer class.
 * 
 * @author Colm O'Sullivan
 *
 */
public class RandomArtApp{
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int screenHeight = (int)screenSize.getHeight();
	private int screenWidth = (int)screenSize.getWidth();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RandomArtApp raa = new RandomArtApp();
		raa.startProgram();

	}
	
	private void startProgram(){
		JFrame window = new JFrame("Random Art");
		RandomArtPanel content = new RandomArtPanel();
		window.setContentPane(content);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocation(0, 0);
		window.setSize(screenWidth,screenHeight-40);
		window.setVisible(true);
	}

}
