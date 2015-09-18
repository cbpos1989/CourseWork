/**
 * 
 */
package com.github.cbpos1989.codingChallenge.adventure_game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * App that will allow the user to play an text based adventure style game. 
 * Implementing custom .txt files to create thier own adventures.
 * 
 * @author Colm O'Sullivan
 *
 */
public class AdventureApp {
	private final static Charset ENCODING = StandardCharsets.UTF_8;
	private final String FOLDER_PATH = "C:/Users/User1/git/CourseWork/CourseWork/src/com/github/cbpos1989/codingChallenge/adventure_game/";
	
	private String heading = "";
	private String body = "";
	private ArrayList<String> questions = new ArrayList<String>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AdventureApp aa = new AdventureApp();
		aa.startProgram();
	}

	private void startProgram(){
		userMenu();
	}
	
	private void userMenu(){
		boolean invalidInput = true;
		Scanner scan = new Scanner(System.in);
		do{
			System.out.println("!---AdventureApp---!");
			System.out.println("1) Load new .txt file \n2) Start new Adventure \nEnter Choice: ");
			int userChoice = scan.nextInt();
		
			if(userChoice == 1){
				System.out.println("1");
				invalidInput = false;
				loadFile();
			} else if(userChoice == 2){
				System.out.println("2");
				invalidInput = false;
				runGame();
			} else {
				System.out.println("Invalid Choice");
				invalidInput = true;
			}
		} while(invalidInput);
		scan.close();
	}
	
	private void loadFile(){
		boolean invalidInput = true;
		Scanner scan = new Scanner(System.in);
		do{
			System.out.println("!---Load File---!");
			System.out.println("Enter File Name: ");
			String fileName = scan.nextLine();
		
			try{
				invalidInput = false;
				readTextFile(fileName);
			} catch(FileNotFoundException fnfe){
				fnfe.printStackTrace();
			} catch (IOException ioe){
				ioe.printStackTrace();
			}
		} while(invalidInput);
		scan.close();
	}
	
	private void readTextFile(String fileName) throws IOException {
		fileName = FOLDER_PATH.concat(fileName);
		Path path = Paths.get(fileName);

    		try (BufferedReader reader = Files.newBufferedReader(path, ENCODING)){
      			String identifier = null;
    			String line = null;
    			int index = 0;
      			while ((line = reader.readLine()) != null) {
      				identifier = line.substring(0, 3);
      				switch(identifier){
      				case "*H*": 
      					this.heading += formatHeading(line); break;
      				case "*B*": 
      					this.body += "\n" + formatBody(line); break;
      				case "*Q*":
      					this.questions.add(formatQuestion(line,++index)); break;
      				default: 
      					System.out.println("Invalid Identifier used"); break;
      				}
      			}      
    		}
    		
    		userMenu();
  	}
	
	private String formatHeading(String heading){
		heading = heading.substring(4,heading.length());
		heading = heading.toUpperCase();
		return heading;
	}
	
	private String formatBody(String body){
		body = body.substring(4,body.length());
		return body;
	}
	
	private String formatQuestion(String question, int index){
		question = index  + ")" + question.substring(4, question.length());
		return question;
	}

	private void runGame(){
		Quest quest = new Quest(this.heading, this.body, this.questions);
		System.out.println(quest);
	}
}
