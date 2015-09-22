package com.github.cbpos1989.examples.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIApp extends JFrame {

	private JPanel contentPane;
	private JTextField textField_01;
	private JTextField textField_02;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int screenWidth = (int) screenSize.getWidth();
	private int screenHeight = (int) screenSize.getHeight();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIApp frame = new GUIApp();
					frame.setTitle("GUI App");
					frame.pack();
					frame.setLocation((frame.screenWidth/2) - (frame.getWidth()/2), (frame.screenHeight/2) - (frame.getHeight()/2));
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUIApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setPreferredSize(new Dimension(512,175));
		//contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel titleLbl = new JLabel("Text Manipulator");
		titleLbl.setFont(new Font("Verdana", Font.BOLD, 24));
		titleLbl.setPreferredSize(new Dimension(contentPane.getWidth()/2,25));
		contentPane.add(titleLbl,BorderLayout.NORTH);
		
		//Text Fields Panel
		JPanel textFieldPanel = new JPanel();
		textFieldPanel.setBorder(new EmptyBorder(5,5,5,5));
		textFieldPanel.setLayout(new GridLayout(4,1));
		textFieldPanel.setPreferredSize(new Dimension(256,100));
		contentPane.add(textFieldPanel, BorderLayout.CENTER);
		
		JLabel textFieldLbl_01 = new JLabel("Text Field 1");
		textFieldLbl_01.setFont(new Font("Verdana", Font.PLAIN, 12));
		textFieldLbl_01.setPreferredSize(new Dimension(contentPane.getWidth()/2,22));
		textFieldPanel.add(textFieldLbl_01);
		
		textField_01 = new JTextField();
		textField_01.setBorder(new LineBorder(Color.RED));
		textField_01.setPreferredSize(new Dimension(textFieldPanel.getWidth(), textFieldPanel.getHeight()/2));
		textField_01.setHorizontalAlignment(JTextField.CENTER);
		textField_01.setColumns(10);
		textFieldPanel.add(textField_01);
		
		JLabel textFieldLbl_02 = new JLabel("Text Field 2");
		textFieldLbl_02.setFont(new Font("Verdana", Font.PLAIN, 12));
		textFieldLbl_02.setPreferredSize(new Dimension(contentPane.getWidth()/2,22));
		textFieldPanel.add(textFieldLbl_02);
		
		textField_02 = new JTextField();
		textField_02.setBorder(new LineBorder(Color.BLUE));
		textField_02.setPreferredSize(new Dimension(textFieldPanel.getWidth(),textFieldPanel.getHeight()/2));
		textField_02.setHorizontalAlignment(JTextField.CENTER);
		textField_02.setColumns(10);
		textFieldPanel.add(textField_02);
		
		
		//Buttons Panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBorder(new EmptyBorder(5,5,5,5));
		buttonPanel.setLayout(new GridLayout(3,1));
		buttonPanel.setPreferredSize(new Dimension(150,75));
		contentPane.add(buttonPanel, BorderLayout.EAST);
		
		JButton clearBtn = new JButton("Clear");
		clearBtn.setPreferredSize(new Dimension(50, 25));
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_01.setText("");
			}
		});
		clearBtn.setBorder(new BevelBorder(BevelBorder.RAISED));
		buttonPanel.add(clearBtn);
		
		JButton reverseBtn = new JButton("Reverse");
		reverseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_01.setText(reverseText(textField_01.getText()));
			}
		});
		reverseBtn.setPreferredSize(new Dimension(50, 25));
		reverseBtn.setBorder(new BevelBorder(BevelBorder.RAISED));
		buttonPanel.add(reverseBtn);
		
		JButton transferBtn = new JButton("Transfer");
		transferBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//transferText();
			}
		});
		transferBtn.setPreferredSize(new Dimension(50, 25));
		transferBtn.setBorder(new BevelBorder(BevelBorder.RAISED));
		buttonPanel.add(transferBtn);
	}
	
	private String reverseText(String text){
		StringBuilder sb = new StringBuilder(text);
		return sb.reverse().toString();
	}
	
	private void transferText(JTextField source, JTextField dest){
		dest.setText(source.getText());
	}
}
