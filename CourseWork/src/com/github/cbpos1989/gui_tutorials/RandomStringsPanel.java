/**
 * 
 */
package com.github.cbpos1989.gui_tutorials;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


import javax.swing.JPanel;

/**
 * JPanel class to display 25 copies of a message each with randomly choosen font and colour.
 * 
 * @author Colm O'Sullivan
 *
 */
public class RandomStringsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;
	private Font font1, font2, font3, font4, font5;
	
	public RandomStringsPanel(){
		this(null);
	}
	
	public RandomStringsPanel(String message){
		this.message = message;
		
		if(message == null){
			this.message = "Java!";
		}
		
		this.font1 = new Font("Serif", Font.BOLD, 14);
		this.font2 = new Font("Calibri", Font.BOLD + Font.ITALIC, 24);
		this.font3 = new Font("Berlin Sans FB", Font.PLAIN, 30);
		this.font4 = new Font("Cambria",Font.PLAIN, 36);
		this.font5 = new Font("Dialog",Font.ITALIC,48);
		
		setBackground(Color.BLACK);
	}
	
	/**
	 * Method that will draw 25 copies of message string using random colour,font and position.
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		int width = getWidth();
		int height = getHeight();
		
		for (int i = 0; i < 25; ++i) {
			int fontNum = (int)(5*Math.random()) + 1;
			
			switch (fontNum) {
			case 1: 
				g.setFont(font1);
				break;
			case 2: 
				g.setFont(font2);
				break;
			case 3: 
				g.setFont(font3);
				break;
			case 4: 
				g.setFont(font4);
				break;
			case 5: 
				g.setFont(font5);
				break;
			}
			
			float hue = (float)Math.random();
			g.setColor(Color.getHSBColor(hue, 1.0F, 1.0F));
			
			int x,y;
			x = -50 + (int)(Math.random()*(width+40));
			y = (int)(Math.random()*(height+20));
			
			g.drawString(message, x, y);
		}
	}
}
