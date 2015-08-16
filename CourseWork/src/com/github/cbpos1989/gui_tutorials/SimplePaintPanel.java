/**
 * 
 */
package com.github.cbpos1989.gui_tutorials;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Implement the GUI components and painting methods for SimplePaintApp.
 * 
 * @author Colm O'Sullivan
 *
 */
public class SimplePaintPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static int BLACK = 0,
			RED = 1,
			GREEN = 2,
			BLUE = 3,
			CYAN = 4,
			MAGENTA = 5,
			YELLOW = 6;
	
	private int currentColor = BLACK;
	protected Graphics graphicsForDrawing;
	private SimplePaintHandler listener;
	
	public SimplePaintPanel(){
		this.listener = new SimplePaintHandler(this);
		setBackground(Color.WHITE);
		addMouseListener(listener);
		addMouseMotionListener(listener);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		int width = getWidth();
		int height = getHeight();
		
		int colorSpacing = (height -56)/7;
		
		//Drawing 3-pixel border around panel
		g.setColor(Color.GRAY);
		g.drawRect(0, 0, width - 1, height - 1);
		g.drawRect(1, 1, width - 3, height - 3);
		g.drawRect(2, 2, width - 5, height - 5);
		
		//Drawing the right hand panel for the colour palettes
		g.fillRect(width - 56 , 0, 56, height);
		
		//Drawing the clear button
		g.setColor(Color.WHITE);
		g.fillRect(width - 53, height - 53, 50, 50);
		g.setColor(Color.BLACK);
		g.drawRect(width - 53, height - 53, 49, 49);
		g.drawString("CLEAR", width -48, height -23);
		
		//Drawing the seven colour palettes
		g.setColor(Color.BLACK);
		g.fillRect(width - 53, 3 + 0*colorSpacing, 50, colorSpacing -3);
		g.setColor(Color.RED);
		g.fillRect(width - 53, 3 + 1*colorSpacing, 50, colorSpacing -3);
		g.setColor(Color.GREEN);
		g.fillRect(width - 53, 3 + 2*colorSpacing, 50, colorSpacing -3);
		g.setColor(Color.BLUE);
		g.fillRect(width - 53, 3 + 3*colorSpacing, 50, colorSpacing -3);
		g.setColor(Color.CYAN);
		g.fillRect(width - 53, 3 + 4*colorSpacing, 50, colorSpacing -3);
		g.setColor(Color.MAGENTA);
		g.fillRect(width - 53, 3 + 5*colorSpacing, 50, colorSpacing -3);
		g.setColor(Color.YELLOW);
		g.fillRect(width - 53, 3 + 6*colorSpacing, 50, colorSpacing -3);
		
		//Draw white border around currently selected color.
		g.setColor(Color.WHITE);
		g.drawRect(width - 55, 1 + currentColor*colorSpacing, 53, colorSpacing);
		g.drawRect(width - 54, 2 + currentColor*colorSpacing, 51, colorSpacing - 2);
		
	}
	
	//Change the color depending on what color palate the user clicks on.
	void changeColor(int y){
		int width = getWidth();
		int height = getHeight();
		int colorSpacing = (height - 56)/7;
		int newColor = y / colorSpacing;
		
		if(newColor < 0 || newColor > 6){
			return;
		}
		
		Graphics g = getGraphics();
		g.setColor(Color.GRAY);
		g.drawRect(width -55, 1 + currentColor*colorSpacing, 53, colorSpacing);
		g.drawRect(width -54, 2 + currentColor*colorSpacing, 51, colorSpacing -2);
		currentColor = newColor;
		g.setColor(Color.WHITE);
		g.drawRect(width -55, 1 + currentColor*colorSpacing, 53, colorSpacing);
		g.drawRect(width -54, 2 + currentColor*colorSpacing, 51, colorSpacing -2);
		g.dispose();
		
	}
	
	void setUpDrawingGraphics(){
		graphicsForDrawing = getGraphics();
		
		switch(currentColor){
		case BLACK:
			graphicsForDrawing.setColor(Color.BLACK);
			break;
		case RED:
			graphicsForDrawing.setColor(Color.RED);
			break;
		case GREEN:
			graphicsForDrawing.setColor(Color.GREEN);
			break;
		case BLUE:
			graphicsForDrawing.setColor(Color.BLUE);
			break;
		case CYAN:
			graphicsForDrawing.setColor(Color.CYAN);
			break;
		case MAGENTA:
			graphicsForDrawing.setColor(Color.MAGENTA);
			break;
		case YELLOW:
			graphicsForDrawing.setColor(Color.YELLOW);
			break;
		}
	}
}
