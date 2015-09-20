/**
 * 
 */
package com.github.cbpos1989.codingChallenge.adventure_game;

/**
 * Class to hold state and behaviour of a Question object.
 * 
 * @author Colm O'Sullivan
 *
 */
public class Question {
	private String dialog = "";
	private int index;
	private int questID;
	
	
	public Question(){
		this("",-1,-1);
	}
	
	public Question(String dialog, int index, int questID){
		this.dialog = dialog;
		this.index = index;
		this.questID = questID;
	}

	public String getDialog() {
		return dialog;
	}
	
	public int getIndex(){
		return index;
	}

	public int getQuestID() {
		return questID;
	}
}
