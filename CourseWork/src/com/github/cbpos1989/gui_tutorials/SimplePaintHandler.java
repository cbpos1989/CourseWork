/**
 * 
 */
package com.github.cbpos1989.gui_tutorials;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Handle the mouse events for the SimplePaintApp
 * 
 * @author Colm O'Sullivan
 *
 */
public class SimplePaintHandler implements MouseListener, MouseMotionListener {
	private SimplePaintPanel spp;
	private int prevX, prevY;
	private boolean isDragging;
	
	
	SimplePaintHandler(SimplePaintPanel spp){
		this.spp = spp;
	}
	
	/* (non-Javadoc)
	 * Will draw a line as long as the user has the mouse button down and dragging.
	 */
	@Override
	public void mouseDragged(MouseEvent evt) {
		if(isDragging == false) {
			return;
		}
		
		int x = evt.getX();
		int y = evt.getY();

		//Make sure user stays within drawing area.
		if (x < 3) {
			x =3;
		}
		if (x > spp.getWidth() - 57) {
			x = spp.getWidth() - 57;
		}

		if (y < 3) {
			y =3;
		}
		if (y > spp.getHeight() - 4) {
			y = spp.getHeight() - 4;
		}
		
		spp.graphicsForDrawing.drawLine(prevX, prevY, x, y);
		
		prevX = x;
		prevY = y;
			
	}

	/* (non-Javadoc)
	 * Allows user to draw curve as long as the mouse is pressed and also allows for interact with right hand panel.
	 */
	@Override
	public void mousePressed(MouseEvent evt) {
		int x = evt.getX();
		int y = evt.getY();
		
		int width = spp.getWidth();
		int height = spp.getHeight();
		
		if(isDragging == true){
			return;
		}
		
		if (x > width -53) {
			if (y > height - 53) {
				spp.repaint();
			} else {
				spp.changeColor(y);
			}
		} else if (x > 3 && x < width -56 && y > 3 && y < height -3) {
			prevX = x;
			prevY = y;
			isDragging = true;
			spp.setUpDrawingGraphics();
		}

	}

	/* (non-Javadoc)
	 * If the user is drawing a curve, the curve is now done.
	 */
	@Override
	public void mouseReleased(MouseEvent evt) {
		if (isDragging == false) {
			return;
		}
		
		isDragging = false;
		spp.graphicsForDrawing.dispose();
		spp.graphicsForDrawing = null;

	}
	
	@Override
	public void mouseMoved(MouseEvent evt) {}

	@Override
	public void mouseClicked(MouseEvent evt) {}

	@Override
	public void mouseEntered(MouseEvent evt) {}

	@Override
	public void mouseExited(MouseEvent evt) {}

}
