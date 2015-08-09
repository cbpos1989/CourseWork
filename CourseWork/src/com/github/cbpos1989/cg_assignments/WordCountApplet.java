/**
 * 
 */
package com.github.cbpos1989.cg_assignments;

import java.awt.Color;
import javax.swing.JApplet;

/**
 * Applet that initialises program.
 * 
 * @author Colm O'Sullivan
 *
 */
public class WordCountApplet extends JApplet {
	public WordCountApplet(){
		setContentPane(new WordCountGUI());
	}
	
	
	public void init(){
		setSize(501, 361);
		setBackground(Color.LIGHT_GRAY);
	}
	
	public void start(){
		
	}
}
