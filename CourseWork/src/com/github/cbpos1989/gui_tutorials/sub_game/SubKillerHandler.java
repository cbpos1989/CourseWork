/**
 * 
 */
package com.github.cbpos1989.gui_tutorials.sub_game;


import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



/**
 * Listener Class for SubKiller Demo
 * 
 * @author Colm O'Sullivan
 *
 */
public class SubKillerHandler implements MouseListener, KeyListener, FocusListener{

	private SubKillerPanel skPanel;
	Boat boat;
	Bomb bomb;
	Submarine sub;
	
	public SubKillerHandler(SubKillerPanel skPanel){
		this.skPanel = skPanel;
	}
	
	/* (non-Javadoc)
	 * Start timer when focus gained
	 */
	@Override
	public void focusGained(FocusEvent evt) {
		skPanel.timer.start();
		skPanel.repaint();
	}

	/* (non-Javadoc)
	 * stops the timer when focus lost
	 */
	@Override
	public void focusLost(FocusEvent evt) {
		skPanel.timer.stop();
		skPanel.repaint();
	}

	/* (non-Javadoc)
	 *Allows the user to use left and right arrows to move and down to drop bomb.
	 */
	@Override
	public void keyPressed(KeyEvent evt) {
		int code = evt.getKeyCode();
		
		switch(code) {
		case KeyEvent.VK_LEFT:
			boat.setCenterX(boat.getCenterX() - 15);
			break;
		case KeyEvent.VK_RIGHT:
			boat.setCenterX(boat.getCenterX() + 15);
			break;
		case KeyEvent.VK_DOWN:
			if (!bomb.isFalling()) {
				bomb.setFalling(true);
			}
		}

	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent evt) {}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent evt) {}
	
	/* (non-Javadoc)
	 * Check if user clicks on the panel
	 */
	@Override
	public void mousePressed(MouseEvent evt) {
		skPanel.requestFocus();
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent evt) {}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent evt) {}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent evt) {}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent evt) {}

}
