/**
 * 
 */
package com.github.cbpos1989.codingChallenge.adventure_game;

import java.util.ArrayList;

/**
 * Class to hold state and behaviour for each quest node. 
 * 
 * @author Colm O'Sullivan
 *
 */
public class Quest {
	private String heading;
	private String body;
	private ArrayList<Question> questions;
	private String questionOutput = "";
	private int questID;
	
	
	

	public Quest(){
		this("Heading","Body",null, -1);
	}
	
	public Quest(String heading, String body, ArrayList<Question> questions, int questID){
		this.heading = heading;
		this.body = body;
		this.questions = questions;
		this.questID = questID;
		System.out.println(this.questID);
		for(Question q: questions){
			questionOutput += "\n" + q.getDialog();
		}
		
	}
	
	public ArrayList<Question> getQuestions() {
		return questions;
	}
	
	public int getQuestID() {
		return questID;
	}

	public String toString(){
		return this.heading + "\n" + this.body + "\n" + this.questionOutput;
	}
	

}
