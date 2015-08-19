/**
 * 
 */
package com.github.cbpos1989.gui_tutorials;



import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * JPanel class for KeyboardAndFocusApp.
 * 
 * @author Colm O'Sullivan
 *
 */
public class KeyboardAndFocusPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected static final int SQUARE_SIZE = 40;
	private Color squareColor;
	private int squareTop, squareLeft;
	
	private KeyboardAndFocusHandler listener;
	
	public KeyboardAndFocusPanel(){
		listener = new KeyboardAndFocusHandler(this);
		
		squareTop = 100;
		squareLeft = 100;
		squareColor = Color.RED;
		
		setBackground(Color.WHITE);
		
		addKeyListener(listener);
		addFocusListener(listener);
		addMouseListener(listener);
	}
	/**
	 * Will draw a border of different colours depending on whether or not the panel is in focus
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		if (hasFocus()) {
			g.setColor(Color.CYAN);
		} else {
			g.setColor(Color.LIGHT_GRAY);
		}
		
		//Draw Border
		int width = getWidth();
		int height = getHeight();
		g.drawRect(0, 0, width - 1, height - 1);
		g.drawRect(1, 1, width - 3 , height - 3);
		g.drawRect(2,2,width - 5, height - 5);
		
		//Draw Square
		g.setColor(squareColor);
		g.fillRect(squareLeft, squareTop, SQUARE_SIZE, SQUARE_SIZE);
		
		//Print Message about the focus state
		g.setColor(Color.MAGENTA);
		
		if(hasFocus()) {
			g.drawString("Arrow Keys Move Square", 7, 20);
			g.drawString("R, G, B, K Change Colour", 7, 40);
		} else {
			g.drawString("Click to Activate", 7, 20);
		}
		
		
		
	}
	
	public void setSquareColor(Color squareColor) {
		this.squareColor = squareColor;
	}
	
	public int getSquareTop() {
		return squareTop;
	}
	public void setSquareTop(int squareTop) {
		this.squareTop = squareTop;
	}
	public int getSquareLeft() {
		return squareLeft;
	}
	public void setSquareLeft(int squareLeft) {
		this.squareLeft = squareLeft;
	}
}
