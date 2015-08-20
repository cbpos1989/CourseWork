/**
 * 
 */
package com.github.cbpos1989.gui_tutorials.sub_game;

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
	
	public Bomb(SubKillerPanel skPanel) {
		this.skPanel = skPanel;
		isFalling = false;
	}
	
	void updateForNewFrame() {
		if (isFalling) {
			//if(c)
		}
	}
}
