/**
 * 
 */
package com.github.cbpos1989.gui_tutorials;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Class to demonstrate the use of MouseEvents. Different shapes are drawn onto the JPanel 
 * depending on what mouse button is pressed.
 * 
 * @author Colm O'Sullivan
 *
 */
public class SimpleStamper extends JPanel implements MouseListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int screenHeight = (int)screenSize.getHeight();
	private int screenWidth = (int)screenSize.getWidth();
	
	public SimpleStamper(){
		setBackground(Color.BLACK);
		addMouseListener(this);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame window = new JFrame("Simple Stamper");
		SimpleStamper content = new SimpleStamper();
		window.setContentPane(content);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocation((content.screenWidth/2) - 375, (content.screenHeight/2) - 234);
		window.setSize(750,470);
		window.setVisible(true);
		
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
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent evt) {
		if (evt.isShiftDown()) {
			repaint();
			return;
		}
		
		int x = evt.getX();
		int y = evt.getY();
		
		Graphics g = getGraphics();
		
		if (evt.isMetaDown()) {
			g.setColor(Color.BLUE);
			g.fillOval(x - 30, y - 15, 60, 30);
			g.setColor(Color.BLACK);
			g.drawOval(x - 30, y - 15, 60, 30);
		} else {
			g.setColor(Color.RED);
			g.fillRect(x - 30, y - 15, 60, 30);
			g.setColor(Color.BLACK);
			g.drawRect(x - 30, y - 15, 60, 30);
		}

		g.dispose();
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent evt) {}

	

}
