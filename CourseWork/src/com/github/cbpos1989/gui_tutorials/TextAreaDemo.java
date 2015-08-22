/**
 * 
 */
package com.github.cbpos1989.gui_tutorials;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Demonstrate the use of JTextArea with JScrollPane
 *
 * @author Colm O'Sullivan
 *
 */

public class TextAreaDemo{

	public static void main(String[] args){
		//System.out.println("TextAreaDemo Working");
		JFrame window = new JFrame("TextAreaDemo");
		TextAreaPanel content = new TextAreaPanel();
		window.setContentPane(content);
		window.setSize(600,400);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}	

}

class TextAreaPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TextAreaPanel(){
		String text =  "So, naturalists observe, a flea\n"
        			 + "Has smaller fleas that on him prey;\n"
        			 + "And these have smaller still to bite 'em;\n"
        			 + "And so proceed ad infinitum.\n\n"
        			 + "                              --Jonathan Swift";	
	
		JTextArea textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);


		textArea.setText(text);
		textArea.setFont( new Font("Serif",Font.PLAIN, 24));
		textArea.setMargin( new Insets(7,7,7,7));

		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

		this.add(scrollPane, BorderLayout.CENTER);
	}
}
