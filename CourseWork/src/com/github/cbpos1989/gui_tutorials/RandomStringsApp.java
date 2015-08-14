/**
 * 
 */
package com.github.cbpos1989.gui_tutorials;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * RandomStringsApplet will display 25 strings of the same message with random fonts, colours and positions.
 * 
 * @author Colm O'Sullivan
 *
 */
public class RandomStringsApp{

	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int screenHeight = (int)screenSize.getHeight();
	private int screenWidth = (int)screenSize.getWidth();
	
	public static void main(String[] args){
		RandomStringsApp rsa = new RandomStringsApp();
		rsa.startProgram();
		
	}

	private void startProgram() {
		JFrame window = new JFrame("Radom Strings");
		RandomStringsPanel content = new RandomStringsPanel("Hello World");
		content.addMouseListener(new RepaintOnClick());
		window.setContentPane(content);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocation((screenWidth/2) - 250, (screenHeight/2) - 180);
		window.setSize(500,360);
		window.setVisible(true);
	}

}
