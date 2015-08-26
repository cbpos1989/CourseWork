/**
 * 
 */
package com.github.cbpos1989.gui_tutorials.sub_game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * JPanel class for SubKiller Demo
 * 
 * @author Colm O'Sullivan
 *
 */
public class SubKillerPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int width, height;
	private SubKillerHandler skHandler;
	Timer timer;
	
	public SubKillerPanel(){
		skHandler = new SubKillerHandler(this);
		
		repaint();
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (skHandler.boat != null){
					skHandler.boat.updateForNewFrame();
					skHandler.bomb.updateForNewFrame();
					skHandler.sub.updateForNewFrame();
				}
				repaint();
				
			}
		};
		
		
		timer = new Timer(30, action);
		
		
		setBackground(Color.GREEN);
		addMouseListener(skHandler);
		addFocusListener(skHandler);
		addKeyListener(skHandler);
		
	}
	
	public void paint(Graphics g){
		System.out.println("Action Performed");
		super.paintComponent(g);
		
		if (skHandler.boat == null) {
			width = getWidth();
			height = getHeight();
			skHandler.boat = new Boat(this);
			skHandler.sub = new Submarine(this);
			skHandler.bomb = new Bomb(this, skHandler);
		}
		
		if (hasFocus()) {
			g.setColor(Color.CYAN);
		} else {
			g.setColor(Color.RED);
			g.drawString("CLICK TO ACTIVATE", 20, 30);
			g.setColor(Color.GRAY);
		}
		
		g.drawRect(0, 0, width - 1, height - 1);
		g.drawRect(1, 1, width - 3, height - 3);
		g.drawRect(2, 2, width - 5, height - 5);
		
		skHandler.boat.draw(g);
		skHandler.sub.draw(g);
		skHandler.bomb.draw(g);
	}

	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
