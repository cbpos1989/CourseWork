/**
 * 
 */
package com.github.cbpos1989.gui_tutorials.high_low_game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
 * Class to handle GUI components of HighLowApp
 * 
 * @author Colm O'Sullivan
 *
 */
public class HighLowGUI extends JPanel {
	private final Color BEIGE = new Color(220,200,180);
	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	
	public HighLowGUI(){
		setBackground(new Color(130,50,40));
		setLayout(new BorderLayout(3,3));
		
		//Creating Panels
		CardPanel board = new CardPanel();
		add(board, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(BEIGE);
		add(buttonPanel, BorderLayout.SOUTH);
		
		//Creating Buttons
		buttons.add(createButton("Higher"));
		buttons.add(createButton("Lower"));
		buttons.add(createButton("New Game"));
		
		for (JButton btn: buttons) {
			btn.addActionListener(board);
			buttonPanel.add(btn);
		}

		setBorder(BorderFactory.createLineBorder(new Color(130,50,40),3));
	}
	
	
	private JButton createButton(String name){
		JButton button = new JButton(name);
		button.setBackground(BEIGE);
		button.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		button.setPreferredSize(new Dimension(75,25));
		return button;
	}
	
	
	
	private class CardPanel extends JPanel implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}

