/**
 * 
 */
package com.github.cbpos1989.gui_tutorials;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Class to demonstrate using the Timer class
 * 
 * @author Colm O'Suillivan
 *
 */
public class RandomArtPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private class RepaintAction implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			repaint();
		}
	}
	
	/**
	 * Using the timer to create a four second delay before it call RepaintAction
	 */
	public RandomArtPanel(){
		RepaintAction action = new RepaintAction();
		Timer timer = new Timer(4000, action);
		timer.start();
	}
	
	/**
	 * Will fill the panel with a random shade of gray and one of three randomly choosen shapes.
	 */
	public void paintComponent(Graphics g){
		Color randomGray = Color.getHSBColor(1.0F, 0.0F, (float)Math.random());
		g.setColor(randomGray);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		int artType = (int)(3*Math.random());
		
		switch(artType){
		case 0:
			for(int i = 0; i < 500; i++){
				int posX = (int)(getWidth() * Math.random());
				int posY = (int)(getHeight() * Math.random());
				int shapeX = (int)(getWidth() * Math.random());
				int shapeY = (int)(getHeight() * Math.random());
				Color randomHue = Color.getHSBColor((float)Math.random(), 1.0F, 1.0F);
				
				g.setColor(randomHue);
				g.drawLine(posX, posY, shapeX, shapeY);
			}
			break;
		case 1:
			for(int i = 0; i < 200; i++){
				int centerX = (int)(getWidth() * Math.random() - 50);
				int centerY = (int)(getHeight() * Math.random() - 50);
				Color randomHue = Color.getHSBColor((float)Math.random(), 1.0F, 1.0F);
				
				g.setColor(randomHue);
				g.drawOval(centerX, centerY, 100, 100);
			}
			break;
		case 2:
			for(int i = 0; i < 25; i++){
				int size = 30 + (int)(170 * Math.random());
				int centerX = (int)(getWidth() * Math.random() - (size/2));
				int centerY = (int)(getHeight() * Math.random() - (size/2));
				Color randomHue = Color.getHSBColor((float)Math.random(), 1.0F, 1.0F);
				
				g.setColor(randomHue);
				g.fill3DRect(centerX, centerY, size, size, true);
			}
			break;
		}
	}
}
