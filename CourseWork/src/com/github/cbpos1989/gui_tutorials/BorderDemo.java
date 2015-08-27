/**
 * 
 */
package com.github.cbpos1989.gui_tutorials;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * Class to demonstrate the use of borders.
 * 
 * @author Colm O'Sullivan
 *
 */
public class BorderDemo {
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int screenWidth = (int)screenSize.getWidth();
	private int screenHeight = (int)screenSize.getHeight();
	private JPanel content;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BorderDemo bd = new BorderDemo();
		bd.startProgram();
	}

	private void startProgram() {
		JFrame window = new JFrame("Border Demo");
		content = new JPanel();
		content.setBackground(Color.LIGHT_GRAY);
		content.setLayout(new GridLayout(0,1,7,7));
		content.setBorder(BorderFactory.createEmptyBorder(7,7,7,7));
		
		make(BorderFactory.createLineBorder(Color.RED,2),"BorderFactory.createLineBorder(Color.RED,2)");
		make(BorderFactory.createMatteBorder(2,2,5,5,Color.RED),"BorderFactory.createMatteBorder(2,2,5,5,Color.RED)");
		make(BorderFactory.createEtchedBorder(),"BorderFactory.createEtchedBorder()");
		make(BorderFactory.createRaisedBevelBorder(),"BorderFactory.createRaisedBevelBorder()");
		make(BorderFactory.createLoweredBevelBorder(),"BorderFactory.createLoweredBevelBorder()");
		make(BorderFactory.createTitledBorder("Title Goes Here"),"BorderFactory.createTitledBorder(\"Title Goes Here\")");
		
		
		window.setContentPane(content);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocation(screenWidth/2, screenHeight/2);
		window.setSize(300,600);
		window.setVisible(true);
	}
	
	private void make(Border border, String command){
		JLabel label = new JLabel(command,JLabel.CENTER);
		label.setBackground(Color.LIGHT_GRAY);
		label.setOpaque(true);
		label.setBorder(border);
		content.add(label);
	}

}
