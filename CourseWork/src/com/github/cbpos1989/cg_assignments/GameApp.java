package com.github.cbpos1989.cg_assignments;

/**
 *  Applet to run GuessWord game. Will initialise applet and create a new JPanel for the GuessWord game.
 * 
 * @author Colm O'Sullivan & Artjoms Porss
 *
 */


import java.awt.Dimension;
import javax.swing.JApplet;


public class GameApp extends JApplet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Create the applet.
	 */
	public GameApp() {
		setContentPane(new GuessWord());
	}
	
	public void init(){
		this.setSize(new Dimension(370,310));
		
	}
	
	public void start(){
		
		
		
	}

	public void stop(){
		
	}
	
	public void destroy(){
		
	}
	
	
	
	
}
