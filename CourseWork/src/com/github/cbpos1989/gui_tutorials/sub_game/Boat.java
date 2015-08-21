/**
 * 
 */
package com.github.cbpos1989.gui_tutorials.sub_game;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Class to set state and behaviour of a Boat object.
 * 
 * @author Colm O'Sullivan
 *
 */
public class Boat {
	private SubKillerPanel skPanel;
	private int centerX, centerY;
	
	
	public Boat(SubKillerPanel skPanel){
		this.skPanel = skPanel;
		centerX = this.skPanel.getWidth()/2;
		centerY = 80;
	}
	
	void updateForNewFrame() {
		if (centerX < 0) {
			centerX = 0;
		} else if (centerX > skPanel.getWidth()) {
			centerX = skPanel.getWidth();
		}
	}
	
	void draw(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRoundRect(centerX - 40, centerY - 20, 80, 40, 20, 20);
	}
	
	public int getCenterX() {
		return centerX;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}

	
}
