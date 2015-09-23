/**
 * 
 */
package com.github.cbpos1989.codingChallenge.code_parser;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * @author Alex Scanlan, Seamus O'Toole, Colm O'Sullivan, Marie Archbold
 *
 */
public class CodeParserApp implements Runnable{
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenWidth = (int) screenSize.getWidth();
	int screenHeight = (int) screenSize.getHeight();
	JFrame window ;
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CodeParserApp cpa = new CodeParserApp();
		cpa.startProgram();
		Thread t1 = new Thread(cpa, "One");
		t1.start();
	}
	
	private void startProgram(){
		window = new JFrame("Code Parser");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setSize(new Dimension(450,300));
		CodeParserGUI content = new CodeParserGUI();
		window.setContentPane(content);
		window.setVisible(true);
		window.setMinimumSize(new Dimension(0, 200));
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//while(true) //System.out.println("hello2");
		//window.repaint();
			//SwingUtilities.updateComponentTreeUI(window);
	}

}