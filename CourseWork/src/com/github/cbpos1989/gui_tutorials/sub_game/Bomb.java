/**
 * 
 */
package com.github.cbpos1989.gui_tutorials.sub_game;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Class to set state and behaviour of a Bomb object.
 * 
 * @author Colm O'Sullivan
 *
 */
public class Bomb {
	private int centerX, centerY;
	private boolean isFalling;
	
	private SubKillerPanel skPanel;
	private SubKillerHandler skHandler;
	
	public Bomb(SubKillerPanel skPanel, SubKillerHandler skHandler) {
		this.skPanel = skPanel;
		this.skHandler = skHandler;
		isFalling = false;
	}
	
	void updateForNewFrame() {
		if (isFalling) {
			if(centerY > skPanel.getHeight()) {
				isFalling = false;
			} else if (Math.abs(centerX - skHandler.sub.getCenterX()) <= 36 &&
						Math.abs(centerY - skHandler.sub.getCenterY()) <= 21) {
				skHandler.sub.setExploding(true);
				skHandler.sub.setExplosionFrameNumber(1);
				isFalling = false;
			} else {
				centerY += 10;
			}
		}
	}
	


	void draw(Graphics g){
		if (!isFalling) {
			centerX = skHandler.boat.getCenterX();
			centerY = skHandler.boat.getCenterY() + 23;
		}
		g.setColor(Color.RED);
		g.fillOval(centerX - 8, centerY - 8, 16, 16);
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
	
	public boolean isFalling() {
		return isFalling;
	}

	public void setFalling(boolean isFalling) {
		this.isFalling = isFalling;
	}

}
