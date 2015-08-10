/**
 * 
 */
package com.github.cbpos1989.cg_assignments;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.TextField;
import java.awt.Label;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.text.BadLocationException;

/**
 * JPanel that handles all of the swing components for the menu interface.
 * 
 * @author Colm O'Sullivan
 *
 */

public class WordCountGUI extends JPanel {
	protected JTextField statusField;
	private JTextField numWordField;
	private JTextField numCharSpaceField;
	private JTextField numCharNoSpaceField;
	private JTextField numParagraphsField;

	private WordCountHandler wch = new WordCountHandler(this);

	/**
	 * Create the panel.
	 */
	public WordCountGUI() {
		this.setLayout(null);
		initialiseGui();
	}
	
	void initialiseGui(){
				//Enter Text Label and TextArea
				JLabel lblEnterText = new JLabel("Enter Text");
				lblEnterText.setFont(new Font("Times New Roman", Font.BOLD, 18));
				lblEnterText.setBounds(102, 11, 91, 22);
				add(lblEnterText);
				
				final JTextArea enterTextArea = new JTextArea();
				enterTextArea.setLineWrap(true);
				enterTextArea.setBounds(21, 39, 256, 181);
				add(enterTextArea);
				
				//Enter Word Label and TextField
				JLabel lblEnterWord = new JLabel("Enter Word");
				lblEnterWord.setFont(new Font("Times New Roman", Font.BOLD, 18));
				lblEnterWord.setBounds(287, 38, 91, 22);
				add(lblEnterWord);
				
				final JTextField enterWordField = new JTextField();
				enterWordField.setBounds(287, 71, 202, 20);
				add(enterWordField);
				enterWordField.setColumns(10);
				
				//Status Label and TextField
				JLabel lblStatus = new JLabel("Status");
				lblStatus.setFont(new Font("Times New Roman", Font.BOLD, 18));
				lblStatus.setBounds(287, 102, 91, 22);
				add(lblStatus);
				
				statusField = new JTextField();
				statusField.setEditable(false);
				statusField.setColumns(10);
				statusField.setBounds(287, 135, 202, 20);
				add(statusField);
				
				wch.resetText(enterWordField, enterTextArea);
				
				//Buttons
				JButton btnFindWord = new JButton("Find Word");
				btnFindWord.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try{
							wch.deHighlightWord(enterTextArea);
						} catch(BadLocationException ble){
							
						}
						
						if(wch.isTextEmpty(enterTextArea.getText().toCharArray()) && wch.isTextEmpty(enterWordField.getText().toCharArray())){
							wch.findWord(enterTextArea, enterWordField);
						} 
					}
				});
				btnFindWord.setBounds(287, 166, 101, 54);
				add(btnFindWord);
				
				JButton btnClear = new JButton("Clear");
				btnClear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						wch.resetText(enterWordField, enterTextArea);
					}
				});
				btnClear.setBounds(390, 166, 101, 54);
				add(btnClear);
				
				JButton btnWordCount = new JButton("Word Count");
				btnWordCount.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(wch.isTextEmpty(enterTextArea.getText().toCharArray())){
							
							int numWords = wch.countText(enterTextArea, ' ');
							int numCharsSpace = wch.countChars(enterTextArea, true);
							int numChars = wch.countChars(enterTextArea, false);
							int numPars = wch.countText(enterTextArea, '\n');
							
							wch.alterText(numWordField, numWords + "", Color.BLACK);
							wch.alterText(numCharSpaceField, numCharsSpace + "", Color.BLACK);
							wch.alterText(numCharNoSpaceField, numChars + "", Color.BLACK);
							wch.alterText(numParagraphsField, numPars + "", Color.BLACK);
						}
					}
				});
				btnWordCount.setBounds(339, 254, 110, 54);
				add(btnWordCount);
				
				//Counting labels and TextFields
				JLabel lblCountOfWords = new JLabel("Count of words and characters");
				lblCountOfWords.setFont(new Font("Times New Roman", Font.BOLD, 18));
				lblCountOfWords.setBounds(31, 231, 256, 22);
				add(lblCountOfWords);
				
				JLabel lblNumWords = new JLabel("Number of words");
				lblNumWords.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNumWords.setBounds(21, 254, 110, 14);
				add(lblNumWords);
				
				numWordField = new JTextField();
				numWordField.setEditable(false);
				numWordField.setBounds(246, 254, 45, 20);
				add(numWordField);
				numWordField.setColumns(10);
				
				
				JLabel lblNumCharactersSpace = new JLabel("Number of characters including spaces");
				lblNumCharactersSpace.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNumCharactersSpace.setBounds(21, 280, 215, 14);
				add(lblNumCharactersSpace);
				
				numCharSpaceField = new JTextField();
				numCharSpaceField.setEditable(false);
				numCharSpaceField.setColumns(10);
				numCharSpaceField.setBounds(246, 280, 45, 20);
				add(numCharSpaceField);
				
				JLabel lblNumCharactersNoSpace = new JLabel("Number of characters without spaces");
				lblNumCharactersNoSpace.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNumCharactersNoSpace.setBounds(21, 306, 215, 14);
				add(lblNumCharactersNoSpace);
				
				numCharNoSpaceField = new JTextField();
				numCharNoSpaceField.setEditable(false);
				numCharNoSpaceField.setColumns(10);
				numCharNoSpaceField.setBounds(246, 306, 45, 20);
				add(numCharNoSpaceField);
				
				JLabel lblNumberOfParagraphs = new JLabel("Number of paragraphs");
				lblNumberOfParagraphs.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNumberOfParagraphs.setBounds(21, 332, 133, 14);
				add(lblNumberOfParagraphs);
				
				numParagraphsField = new JTextField();
				numParagraphsField.setEditable(false);
				numParagraphsField.setColumns(10);
				numParagraphsField.setBounds(246, 332, 45, 20);
				add(numParagraphsField);
	}
	

}
