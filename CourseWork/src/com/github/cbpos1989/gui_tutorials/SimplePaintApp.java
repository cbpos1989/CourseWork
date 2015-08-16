/**
 * 
 */
package com.github.cbpos1989.gui_tutorials;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;


/**
 * A class to demonstrate the implementation of mouse dragging in order to create a simple paint app.
 * 
 * @author Colm O'Sullivan
 *
 */
public class SimplePaintApp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int screenHeight = (int)screenSize.getHeight();
	private int screenWidth = (int)screenSize.getWidth();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimplePaintApp spa = new SimplePaintApp();
		spa.startProgram();
		

	}
	
	private void startProgram(){
		JFrame window = new JFrame("Simple Paint");
		SimplePaintPanel content = new SimplePaintPanel();
		window.setContentPane(content);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocation((screenWidth/2) - 300, (screenHeight/2) - 240);
		window.setSize(600,480);
		window.setVisible(true);
	}
}
