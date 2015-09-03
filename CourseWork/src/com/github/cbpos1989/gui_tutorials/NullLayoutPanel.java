/**
 * 
 */
package com.github.cbpos1989.gui_tutorials;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author User1
 *
 */
public class NullLayoutPanel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Checkerboard board;
	
	JButton resignButton;
	JButton newGameButton;
	
	JLabel message;
	
	public NullLayoutPanel(){
		setLayout(null);
		setBackground(new Color(0,150,0));
		setBorder(BorderFactory.createEtchedBorder());
		setPreferredSize(new Dimension(350,240));
		
		board = new Checkerboard();
		add(board);
		
		newGameButton = new JButton("New Game");
		newGameButton.addActionListener(this);
		add(newGameButton);
		
		resignButton = new JButton("Resign");
		resignButton.addActionListener(this);
		add(resignButton);
		
		message = new JLabel("Click \"New Game\" to begin a game.");
		message.setForeground(new Color(100,255,100));
		message.setFont(new Font("Serif", Font.BOLD, 14));
		add(message);
		
		//Set position and size of each component
		board.setBounds(20,20,164,164);
		newGameButton.setBounds(210, 60, 120, 30);
		resignButton.setBounds(210, 120, 120, 30);
		message.setBounds(20, 200, 330, 30);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		message.setText(evt.getActionCommand() + " button was pressed.");
		
	}
}
