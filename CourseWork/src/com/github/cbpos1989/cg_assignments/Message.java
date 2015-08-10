package com.github.cbpos1989.cg_assignments;

/**
 *  JDialog that will display either a winning messages or losing message.
 * 
 * @author Colm O'Sullivan & Artjoms Porss
 *
 */

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Message extends JDialog {

	private final JPanel contentPanel = new JPanel();

	

	/**
	 * Create the dialog.
	 */
	public Message(String str) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		
			JLabel lblNewLabel = new JLabel(str);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(128, 46, 161, 45);
			getContentPane().add(lblNewLabel);
		
		
			JButton btnOk = new JButton("Ok");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GuessWord.lives = 8;
					Message.this.dispose();
					
				}
			});
			btnOk.setBounds(163, 127, 96, 38);
			getContentPane().add(btnOk);
		}
	}


