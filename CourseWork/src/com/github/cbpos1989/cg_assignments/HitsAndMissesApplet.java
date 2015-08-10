/**
 * 
 */
package com.github.cbpos1989.cg_assignments;


import java.awt.Color;
import javax.swing.JApplet;

/**
 * @author Colm O'Sullivan
 *
 */
public class HitsAndMissesApplet extends JApplet {
	public HitsAndMissesApplet(){
		setContentPane(new HitsAndMissesGUI());
	}
	
	
	public void init(){
		setSize(450, 300);
		setBackground(Color.LIGHT_GRAY);
	}
	
	public void start(){
		
	}
	

}
