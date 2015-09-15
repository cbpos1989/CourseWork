/**
 * 
 */
package com.github.cbpos1989.gui_tutorials;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JList;
import javax.swing.JPanel;

/**
 * Class to handle the GUI components of ListExampleApp
 * 
 * @author Colm O'Sullivan
 *
 */
public class ListExamplePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String[] listData = {"Item 1", "Item 2", "Item 3", "Item 4"};
	
	public ListExamplePanel(){
		setBackground(Color.LIGHT_GRAY);
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(1,1));
		topPanel.setSize(this.getWidth(), this.getHeight());
		this.add(topPanel);
		
		JList<String> listBox = new JList<String>(listData);
		listBox.setSize(this.getWidth() -10, this.getHeight()-10);
		listBox.setSelectedIndex(0);
		add(listBox);
	}

}
