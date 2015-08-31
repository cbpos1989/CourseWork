/**
 * 
 */
package com.github.cbpos1989.gui_tutorials;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Class for the GUI components of the SimpleCalcApp
 * 
 * @author Colm O'Sullivan
 *
 */
public class SimpleCalcPanel extends JPanel implements ActionListener{

	private JTextField xInput, yInput;
	private JLabel answer;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SimpleCalcPanel(){
		setBackground(Color.GRAY);
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		//Input JTextFields
		xInput = new JTextField("0",10);
		xInput.setBackground(Color.WHITE);
		yInput = new JTextField("0",10);
		yInput.setBackground(Color.WHITE);
		
		JPanel xPanel = new JPanel();
		xPanel.add(new JLabel(" x = "));
		xPanel.add(xInput);
		
		JPanel yPanel = new JPanel();
		yPanel.add(new JLabel(" y = "));
		yPanel.add(yInput);
		
		//Operations JButtons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1,4));
		
		JButton plus = new JButton("+");
		plus.addActionListener(this);
		buttonPanel.add(plus);
		
		JButton minus = new JButton("-");
		minus.addActionListener(this);
		buttonPanel.add(minus);
		
		JButton multi = new JButton("*");
		multi.addActionListener(this);
		buttonPanel.add(multi);
		
		JButton divide = new JButton("/");
		divide.addActionListener(this);
		buttonPanel.add(divide);
		
		//Answer Panel
		answer = new JLabel("x + y = 0", JLabel.CENTER);
		answer.setForeground(Color.RED);
		answer.setBackground(Color.WHITE);
		answer.setOpaque(true);
		
		setLayout(new GridLayout(4,1,3,3));
		add(xPanel);
		add(yPanel);
		add(buttonPanel);
		add(answer);
		
		xInput.requestFocus();
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		double x, y;
		
		try {
			String xStr = xInput.getText();
			x = Double.parseDouble(xStr);
		} catch (NumberFormatException nfe) {
			answer.setText("Illegal data for x");
			xInput.requestFocus();
			return;
		}
		
		try {
			String yStr = yInput.getText();
			y = Double.parseDouble(yStr);
		} catch (NumberFormatException nfe) {
			answer.setText("Illigel data for y");
			yInput.requestFocus();
			return;
		}
		
		String op = evt.getActionCommand();
		switch(op){
		case "+": 
			answer.setText("x + y = " + (x+y));
			break;
		case "-":
			answer.setText("x - y = " + (x-y));
			break;
		case "*":
			answer.setText("x * y = " + (x*y));
			break;
		case "/":
			answer.setText("x / y = "+ (x/y));
			break;
		}
		
		
	}
}
