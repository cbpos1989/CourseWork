/**
 * 
 */
package com.github.cbpos1989.gui_tutorials;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Class to demonstrate creating JPanel class that is called by JApplet class
 * 
 * @author Colm O'Sullivan
 *
 */
public class HelloWorldPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String currentMessage = "Hello World!";
	private MessageDisplay displayPanel;
	
	private class MessageDisplay extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawString(currentMessage, 20, 30);
		}
	}
	
	private class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(currentMessage.equals("Hello World!")){
				currentMessage = "Gooodbye World!";
			} else {
				currentMessage = "Hello World!";
			}
			
			displayPanel.repaint();
		}
	}
	
	public HelloWorldPanel(){
		displayPanel = new MessageDisplay();
		
		JButton changeMessageButton = new JButton("Change Message");
		ButtonHandler listener = new ButtonHandler();
		changeMessageButton.addActionListener(listener);
		
		setLayout(new BorderLayout());
		add(displayPanel, BorderLayout.CENTER);
		add(changeMessageButton, BorderLayout.SOUTH);
		
	}
}
