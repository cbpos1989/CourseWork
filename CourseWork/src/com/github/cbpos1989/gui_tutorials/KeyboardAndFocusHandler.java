/**
 * 
 */
package com.github.cbpos1989.gui_tutorials;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Listener class for KeyboardAndFocusApp.
 * 
 * @author Colm O'Sullivan
 *
 */
public class KeyboardAndFocusHandler implements FocusListener, KeyListener, MouseListener {
	private KeyboardAndFocusPanel kfPanel;
	
	public KeyboardAndFocusHandler(KeyboardAndFocusPanel kfPanel){
		this.kfPanel = kfPanel;
	}
	
	/* (non-Javadoc)
	 * Lets the user control the movement of the square by using the arrow keys.
	 */
	@Override
	public void keyPressed(KeyEvent evt) {
		int key = evt.getKeyCode();
		
		switch(key) {
		case KeyEvent.VK_LEFT:
			kfPanel.setSquareLeft(kfPanel.getSquareLeft() - 8);
			if (kfPanel.getSquareLeft() < 3) {
				kfPanel.setSquareLeft(3);
			}
			
			kfPanel.repaint();
			break;
		case KeyEvent.VK_RIGHT:
			kfPanel.setSquareLeft(kfPanel.getSquareLeft() + 8);
			if (kfPanel.getSquareLeft() > kfPanel.getWidth() - 3 - KeyboardAndFocusPanel.SQUARE_SIZE) {
				kfPanel.setSquareLeft(kfPanel.getWidth() - 3 - KeyboardAndFocusPanel.SQUARE_SIZE);
			}
			
			kfPanel.repaint();
			break;
		case KeyEvent.VK_UP:
			kfPanel.setSquareTop(kfPanel.getSquareTop() - 8);
			if (kfPanel.getSquareTop() < 3) {
				kfPanel.setSquareTop(3);
			}
			
			kfPanel.repaint();
			break;
		case KeyEvent.VK_DOWN:
			kfPanel.setSquareTop(kfPanel.getSquareTop() + 8);
			if (kfPanel.getSquareTop() > kfPanel.getHeight() - 3 - KeyboardAndFocusPanel.SQUARE_SIZE) {
				kfPanel.setSquareTop(kfPanel.getHeight() - 3 - KeyboardAndFocusPanel.SQUARE_SIZE);
			}
			
			kfPanel.repaint();
			break;
		default:
			break;
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent evt) {}

	/* (non-Javadoc)
	 * Changes the colour of the square if the R, G, B or K keys are pressed.
	 */
	@Override
	public void keyTyped(KeyEvent evt) {
		char ch = evt.getKeyChar();
		
		if(ch > 96) {
			ch -= 31;
		}
		
		switch(ch){
		case 'R':
			kfPanel.setSquareColor(Color.RED);
			kfPanel.repaint();
			break;
		case 'G':
			kfPanel.setSquareColor(Color.GREEN);
			kfPanel.repaint();
			break;
		case 'B': 
			kfPanel.setSquareColor(Color.BLUE);
			kfPanel.repaint();
			break;
		case 'K':
			kfPanel.setSquareColor(Color.BLACK);
			kfPanel.repaint();
			break;
		}
	}

	/* (non-Javadoc)
	 *  Repaint with Cyan Border
	 */
	@Override
	public void focusGained(FocusEvent evt) {
		kfPanel.repaint();
	}

	/* (non-Javadoc)
	 * Repaint without Cyan Border
	 */
	@Override
	public void focusLost(FocusEvent evt) {
		kfPanel.repaint();
	}
	
	/* (non-Javadoc)
	 * Called when the user clicks on the panel with the mouse. 
	 * Will request that input focus is given to the panel.
	 */
	@Override
	public void mousePressed(MouseEvent evt) {
		kfPanel.requestFocus();
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent evt) {}

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

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent evt) {}

}
