package com.github.cbpos1989.codingChallenge.code_parser;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;          
import java.awt.*;
import java.awt.event.*;
import javax.swing.plaf.metal.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

import com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel;
/**
 * @author Alex Scanlan, Seamus O'Toole, Colm O'Sullivan, Marie Archbold
 *
 */
public class CodeParserGUI extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1853887432937732954L;
	protected static final String LOOKANDFEEL = "Motif";
	protected static final Object THEME = null;
	//private JPanel contentPane;
	private CodeParserHandler cph = new CodeParserHandler(this);
	private CodeParserApp cpa = new CodeParserApp();
	//private CodeParserGUI cpg = new CodeParserGUI();
	JTextPane textPane;
	final JButton btnLoadFile;
	private boolean firstLookAndFeel = true;


	/**
	 * Create the frame.
	 */
	public CodeParserGUI(){

		setLayout(new BorderLayout());

		//Text Panel
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new BorderLayout());
		this.add(textPanel, BorderLayout.CENTER);

		textPane = new JTextPane();
		JScrollPane scrollPane = new JScrollPane(textPane);
		textPanel.add(scrollPane, BorderLayout.CENTER);

		//textPane.setContentType( "text/html" );
		//textPane.setText("test <font color = \"red\">"+ " Alex " + "</font>");
		//textPane.setEditable(false);


		//Button Panel
		JPanel btnPanel = new JPanel();
		GridBagLayout gbl_btnPanel = new GridBagLayout();
		gbl_btnPanel.columnWidths = new int[]{84, 0};
		gbl_btnPanel.rowHeights = new int[]{33, 33, 33, 0};
		gbl_btnPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_btnPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		btnPanel.setLayout(gbl_btnPanel);
		
				String[] colours = {"Light", "Dark"};
		
				JComboBox<String> comboBox = new JComboBox<String>();
				comboBox.getSelectedIndex();
				JComboBox comboBox_1 = new JComboBox(colours);
				comboBox_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(comboBox_1.getSelectedIndex() == 1){
							//DARK
							btnPanel.setBackground(Color.BLACK);
							btnLoadFile.setBackground(Color.BLACK);
							btnLoadFile.setForeground(Color.WHITE);
							comboBox.setBackground(Color.BLACK);
							comboBox.setForeground(Color.WHITE);
							comboBox_1.setBackground(Color.BLACK);
							comboBox_1.setForeground(Color.WHITE);
							textPane.setForeground(Color.WHITE);
							textPane.setBackground(Color.BLACK);
						} else {
							//LIGHT
							btnPanel.setBackground(Color.WHITE);
							btnLoadFile.setBackground(Color.WHITE);
							btnLoadFile.setForeground(Color.BLACK);
							comboBox.setBackground(Color.WHITE);
							comboBox.setForeground(Color.BLACK);
							comboBox_1.setBackground(Color.WHITE);
							comboBox_1.setForeground(Color.BLACK);
							textPane.setForeground(Color.BLACK);
							textPane.setBackground(Color.WHITE);
						}
					}
				});
				
						btnLoadFile= new JButton("Load File");
						btnLoadFile.setFont(new Font("Dialog", Font.BOLD, 12));
						btnLoadFile.addActionListener(cph);
						GridBagConstraints gbc_btnLoadFile = new GridBagConstraints();
						gbc_btnLoadFile.fill = GridBagConstraints.BOTH;
						gbc_btnLoadFile.insets = new Insets(0, 0, 5, 0);
						gbc_btnLoadFile.gridx = 0;
						gbc_btnLoadFile.gridy = 0;
						btnPanel.add(btnLoadFile, gbc_btnLoadFile);
						btnLoadFile.setBackground(Color.WHITE);
						btnLoadFile.setForeground(Color.BLACK);
				GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
				gbc_comboBox_1.fill = GridBagConstraints.BOTH;
				gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
				gbc_comboBox_1.gridx = 0;
				gbc_comboBox_1.gridy = 1;
				btnPanel.add(comboBox_1, gbc_comboBox_1);
				comboBox_1.setBackground(Color.WHITE);
				comboBox_1.setForeground(Color.BLACK);
				GridBagConstraints gbc_comboBox = new GridBagConstraints();
				gbc_comboBox.fill = GridBagConstraints.BOTH;
				gbc_comboBox.gridx = 0;
				gbc_comboBox.gridy = 2;
				btnPanel.add(comboBox, gbc_comboBox);
				comboBox.setBackground(Color.WHITE);
				comboBox.setForeground(Color.BLACK);

		String[] languages = {"Java"};
		for (int i=0; i<languages.length; ++i){
			comboBox.addItem(languages[i]);
		}
		

		this.add(btnPanel, BorderLayout.EAST);

		//SET DEFAULT THEME
		btnPanel.setBackground(Color.WHITE);
		
	}

	
	
	
}
