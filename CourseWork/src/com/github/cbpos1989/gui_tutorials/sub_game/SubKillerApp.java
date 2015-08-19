/**
 * 
 */
package com.github.cbpos1989.gui_tutorials.sub_game;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;



/**
 * @author User1
 *
 */
public class SubKillerApp {
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int screenHeight = (int)screenSize.getHeight();
	private int screenWidth = (int)screenSize.getWidth();
	private int appHeight = (int)screenHeight/2;
	private int appWidth = (int)screenWidth/2;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SubKillerApp ska = new SubKillerApp();
		ska.startProgram();

	}
	
	private void startProgram(){
		JFrame window = new JFrame("SubKiller Game");
		SubKillerPanel content = new SubKillerPanel();
		window.setContentPane(content);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocation((screenWidth/2) - (appWidth/2), (screenHeight/2) - (appHeight/2));
		window.setSize(appWidth,appHeight);
		window.setResizable(false);
		window.setVisible(true);
	}

}