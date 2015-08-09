/**
 * 
 */
package com.github.cbpos1989.cg_assignments;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

/**
 * Class to handle core logic of the applet is passed in reference to the GUI it is handling logic for.
 * 
 * @author Colm O'Sullivan
 *
 */
public class WordCountHandler {
	private WordCountGUI myGui;
	public WordCountHandler(){
		
	}
	
	
	public WordCountHandler(WordCountGUI myGui){
		this.myGui = myGui;
	}
	
	//Check if area or fields are populated
	boolean isTextEmpty(char[] checkText){
		if(checkText.length > 0){
			return true;
		} else {
			return false;
		}
	}
	
	//Checks a JTextArea for a string that has been passed in through a JTextField
	void findWord(JTextArea txtArea, JTextField txtField){
		String searchWord = txtField.getText();
		String searchArea = txtArea.getText();
		
		int index = searchArea.indexOf(searchWord);
		
		//Check if word is found
		if(index == -1){
			alterText(myGui.statusField,"Word not found", Color.RED);
		} else {
			int indexEnd = index + txtField.getText().length();
			try{
				highlightWord(txtArea,index, indexEnd, Color.BLUE);
			} catch(BadLocationException ble){
				
			}
			alterText(myGui.statusField,"Word found at: " + index, Color.BLUE);
		}
	}

	
	void resetText(JTextField txtField, JTextArea txtArea){
		txtField.setText(null);
		txtArea.setText(null);
	}
	
	void alterText(JTextField txtField, String text, Color clr){
		txtField.setText(text);
		txtField.setForeground(clr);
	}
	
	void highlightWord (JTextArea txtArea, int indexStart,int indexEnd, Color clr) throws BadLocationException{
		
		Highlighter highlighter = txtArea.getHighlighter();
		highlighter.addHighlight(indexStart, indexEnd,DefaultHighlighter.DefaultPainter);
	}
	
	void deHighlightWord (JTextArea txtArea) throws BadLocationException{
		Highlighter highlighter = txtArea.getHighlighter();
		highlighter.removeAllHighlights();
	}
	
	//counts either words or paragraphs depending on what character is passed in space or newline
	int countText(JTextArea txtArea, char c){
		String aplhaText = txtArea.getText().toString().replaceAll("[^A-Za-z \n]", "");
		boolean isBreak = false;
		char[] wordArray = aplhaText.toCharArray();
		int count = 0;
		
		//Check for spaces increment wordCount when one is found
		for (int i = 0, j = 1; i < wordArray.length; ++i){
			if(wordArray[i] == c){
				count++;
				isBreak = true;
				do {
					if (wordArray[i + j] != c){
						isBreak = false;
					} else {
						++i;
						//System.out.println("Found another space");
					}
				} while (isBreak);
			}
		}
		
		//Last word that has no space afterwards
		count+=1;
		return count;
	}
	
	//Counts characters in a given JTextArea can handle with or without spaces
	int countChars (JTextArea txtArea, boolean hasSpaces) {
		if(hasSpaces){
			char[] allChars = txtArea.getText().toCharArray();
			return allChars.length;
		} else {
			String temp = txtArea.getText().toString().replaceAll(" ","");
			char[] noSpaceChars = temp.toCharArray();
			return noSpaceChars.length;
		}
	}
}

