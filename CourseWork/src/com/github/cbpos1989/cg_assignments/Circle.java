/**
 * 
 */
package com.github.cbpos1989.cg_assignments;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * @author Colm O'Sullivan
 *
 */
public class Circle extends JPanel{
	private int x;
	private int y;
	private final int CIRCLE_WIDTH = 15;
	private final int CIRCLE_HIEGHT = 15;
	private Color circleColor;
	private boolean isEmptyCircle = true;
	
	public Circle(){
		
	}
	
	public Circle(int x, int y){
		this.x = x;
		this.y = y;
		this.setSize(450, 300);
		isEmptyCircle = true;
	}
	
	public Circle(int x, int y, Color circleColor){
		this.x = x;
		this.y = y;
		this.setSize(450, 300);
		this.circleColor = circleColor;
		isEmptyCircle = false;
	}
	
	public Color getColor(){
		return this.circleColor;
	}
	
	public void paint(Graphics g){
		if(isEmptyCircle){
			g.drawOval(x, y, CIRCLE_WIDTH, CIRCLE_HIEGHT);
		} else {
			g.setColor(circleColor);	
			g.fillOval(x, y, CIRCLE_WIDTH, CIRCLE_HIEGHT);
		}
	}
	
}
