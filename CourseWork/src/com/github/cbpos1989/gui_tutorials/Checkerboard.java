/**
 * 
 */
package com.github.cbpos1989.gui_tutorials;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;


/**
 * Class that will display a 160x160 checkerboard pattern.
 * 
 * @author Colm O'Sullivan
 *
 */
public class Checkerboard extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Checkerboard() {
		this.setBackground(Color.BLACK);
		setPreferredSize(new Dimension(164,164));
	}
	
	public void paintComponent(Graphics g){
		//Draw 2-pixel border
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, getSize().width -1, getSize().height -1);
		g.drawRect(1, 1, getSize().width -3, getSize().height -3);
		
		//Draw Checkerboard
		for (int row = 0; row < 8; ++row) {
			for (int col = 0; col < 8; ++col) {
				if (row  % 2 == col % 2) {
					g.setColor(Color.LIGHT_GRAY);
				} else {
					g.setColor(Color.GRAY);
				}
				
				g.fillRect(2 + col*20, 2 + row*20, 20, 20);
			}
		}
	}
}
