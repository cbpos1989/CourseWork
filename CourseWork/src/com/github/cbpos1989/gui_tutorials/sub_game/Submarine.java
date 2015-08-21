/**
 * 
 */
package com.github.cbpos1989.gui_tutorials.sub_game;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Class to set state and behaviour of a Submarine object.
 * 
 * @author Colm O'Sullivan
 *
 */
public class Submarine {
	private int centerX, centerY;
	private boolean isMovingLeft;
	private boolean isExploding;
	private int explosionFrameNumber;
	private SubKillerPanel skPanel;
	
	public Submarine(SubKillerPanel skPanel){
		this.skPanel = skPanel;
		centerX = (int)(skPanel.getWidth()*Math.random());
		centerY = skPanel.getHeight() - 40;
		isExploding = false;
		isMovingLeft = (Math.random() < 0.5);
	}
	
	void updateForNewFrame(){
		if (isExploding) {
			explosionFrameNumber++;
			if (explosionFrameNumber == 15) {
				centerX = (int)(skPanel.getWidth()*Math.random());
				centerY = skPanel.getHeight() - 40;
				isExploding = false;
				isMovingLeft = (Math.random() < 0.5);
			}
		} else {
			if (Math.random() < 0.04) {
				isMovingLeft = !isMovingLeft;
			}
			
			if (isMovingLeft) {
				centerX -= 5;
				if (centerX <= 0) {
					centerX = 0;
					isMovingLeft = false;
				}
			} else {
				centerX += 5;
				if (centerX > skPanel.getWidth()) {
					centerX = skPanel.getWidth();
					isMovingLeft = true;
				}
			}
		}
	}
	
	void draw(Graphics g){
		g.setColor(Color.BLACK);
		g.fillOval(centerX - 30, centerY - 15, 60, 30);
		
		if (isExploding) {
			g.setColor(Color.YELLOW);
			g.fillOval(	centerX - 4*explosionFrameNumber, 
						centerY - 2*explosionFrameNumber, 
						8*explosionFrameNumber, 
						4*explosionFrameNumber);
			g.setColor(Color.RED);
			g.fillOval(	centerX - 2*explosionFrameNumber, 
						centerY - explosionFrameNumber/2, 
						4*explosionFrameNumber, 
						explosionFrameNumber);
		}
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
	
	public boolean isExploding() {
		return isExploding;
	}
	public void setExploding(boolean isExploding) {
		this.isExploding = isExploding;
	}
	public int getExplosionFrameNumber() {
		return explosionFrameNumber;
	}
	public void setExplosionFrameNumber(int explosionFrameNumber) {
		this.explosionFrameNumber = explosionFrameNumber;
	}
}
