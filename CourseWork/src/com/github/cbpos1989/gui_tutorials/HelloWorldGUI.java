
/**
 * 
 */
package com.github.cbpos1989.gui_tutorials;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * Class to demonstrate the use of JOptionPane and understand how it is implemented.
 * 
 * @author Colm O'Sullivan
 *
 */
public class HelloWorldGUI {

	private static class HelloWorldDisplay extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 3905876079721087536L;
	
		@SuppressWarnings("unused")
		public void paintComponet(Graphics g){
			super.paintComponent(g);
			g.drawString("Hello World", 20, 30);
		}
	}
	
	private static class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		//Use JOption to display Message
		//JOptionPane.showMessageDialog(null, "Hello World");

		//Display the message without the use of JOption
		HelloWorldDisplay displayPanel = new HelloWorldDisplay();
		JButton okButton = new JButton("OK");
		ButtonHandler listner = new ButtonHandler();
		okButton.addActionListener(listner);
		
		JPanel content = new JPanel();
		content.setLayout(new BorderLayout());
		content.add(displayPanel, BorderLayout.CENTER);
		content.add(okButton, BorderLayout.SOUTH);
		
		JFrame window = new JFrame("GUI Test");
		window.setContentPane(content);
		window.setSize(250, 100);
		window.setLocation(100, 100);
		window.setVisible(true);
		
		
	}

}
