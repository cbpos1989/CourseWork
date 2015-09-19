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
	private ArrayList<String> questions;
	private String questionOutput;
	
	
	public Quest(){
		this("Heading","Body",null);
	}
	
	public Quest(String heading, String body, ArrayList<String> questions){
		this.heading = heading;
		this.body = body;
		this.questions = questions;
		
		for(String s: questions){
			questionOutput += "\n" + questions;
		}
		
	}
	
	
	
	public String toString(){
		return this.heading + "\n" + this.body + "\n" + this.questionOutput;
	}
}
