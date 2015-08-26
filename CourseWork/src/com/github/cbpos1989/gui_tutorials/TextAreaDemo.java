/**
 * 
 */
package com.github.cbpos1989.gui_tutorials;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Class to demonstrate the use of JTextArea with JScrollPane
 * 
 * @author Colm O'Sullivan
 *
 */
public class TextAreaDemo {
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int screenHeight = (int)screenSize.getHeight();
	private int screenWidth = (int)screenSize.getWidth();
	
	String text =	"So, naturalists observe, a flea\n"
	         + "Has smaller fleas that on him prey;\n"
	         + "And these have smaller still to bite 'em;\n"
	         + "And so proceed ad infinitum.\n\n"
	         + "                              --Jonathan Swift";
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TextAreaDemo tad = new TextAreaDemo();
		tad.startProgram();
		

	}
	
	private void startProgram(){
		JFrame window = new JFrame("Text Area Demo");
		
		JTextArea textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		
		textArea.setText(text);
		textArea.setFont(new Font("Serif", Font.PLAIN,24));
		textArea.setMargin(new Insets(7,7,7,7));
	
		JPanel content = new JPanel();
		content.setLayout(new BorderLayout());
		content.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		content.add(scrollPane, BorderLayout.CENTER);
		
		window.setContentPane(content);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocation(screenWidth/2,screenHeight/2);
		window.setSize(300,300);
		window.setVisible(true);
		window.setVisible(true);
		
	}


}
