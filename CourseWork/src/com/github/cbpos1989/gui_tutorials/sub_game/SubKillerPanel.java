/**
 * 
 */
package com.github.cbpos1989.gui_tutorials.sub_game;

import java.awt.Color;


import javax.swing.JPanel;

/**
 * @author Colm O'Sullivan
 *
 */
public class SubKillerPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int width, height;
	
	public SubKillerPanel(){
		
		setBackground(Color.GREEN);
		
		
	}

	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
