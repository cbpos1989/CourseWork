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
	private int questID = -1;
	private ArrayList<Question> questions = new ArrayList<Question>();
	private ArrayList<Quest> quests = new ArrayList<Quest>();
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
	
	/**
	 * Main Menu for the game.
	 */
	private void userMenu(){
		boolean invalidInput = true;
		Scanner scan = new Scanner(System.in);
		do{
			System.out.println("!---AdventureApp---!");
			System.out.println("1) Load new .txt file \n2) Start new Adventure \nEnter Choice: ");
			int userChoice = scan.nextInt();
		
			if (userChoice == 1) {
				//System.out.println("1");
				invalidInput = false;
				loadFile();
			} else if (userChoice == 2) {
				//System.out.println("2");
				invalidInput = false;
				
				runGame();
			} else {
				System.out.println("Invalid Choice");
				invalidInput = true;
			}
		} while(invalidInput);
		scan.close();
	}
	
	/**
	 * Menu for the user to enter file name of text file used to create the game.
	 */
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
			} catch (FileNotFoundException fnfe) {
				System.out.println("File not Found!");
				invalidInput = true;
			} catch (IOException ioe) {
				System.out.println(ioe);
				invalidInput = true;
			}
		} while(invalidInput);
		scan.close();
	}
	
	/**
	 * Method to read data from user given text file, 
	 * data is sorted by identifiers and used to create a new Quest object.
	 * @param fileName a file name that the user inputs.
	 * @throws IOException if the file is not found or an invalid identifier is found 
	 * and exception is thrown.
	 */
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
      				case "#ID": 
      					this.questID = formatQuestID(line); break;
      				case "*H*": 
      					this.heading += formatHeading(line); break;
      				case "*B*": 
      					this.body += "\n" + formatBody(line); break;
      				case "*Q*":
      					this.questions.add(new Question(formatQuestion(line,++index),index,2)); break;
      				case "***":
      					addNewQuest(this.heading,this.body,this.questions, this.questID);
      					index = 0; break;
      				default: 
      					throw new IOException("Invalid Identifier used in text file");
      				}
      			}      
    		}
    		System.out.println("Text file successfully loaded");
    		userMenu();
  	}
	
	private void addNewQuest(String heading, String body, ArrayList<Question> questions, int questID){
		quests.add(new Quest(heading,body,questions,questID));
		
		//Reset temporary variables so the next quest details can be stored
		this.heading = "";
		this.body = "";
		this.questions.removeAll(questions);
	}
	
	private int formatQuestID(String questID) throws IOException{
		questID = questID.substring(4, questID.length());

		try{
			int id = Integer.parseInt(questID);
			return id;
		} catch (NumberFormatException nfe){
			throw new IOException("Invalid Quest ID");
		}
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
		if (quests.size() == 0) {
			System.out.println("No adventure found!, txt file not loaded.");
			userMenu();
		} else {
			displayQuest(quests.get(0));
		}
	}
	
	private void displayQuest(Quest quest){
		System.out.println(quest + "\n");
		questMenu(quest);
	}
	
	private void questMenu(Quest quest){
		boolean invalidInput = true;
		int nextQuest = -1;
		Scanner scan = new Scanner(System.in);
		do{
			System.out.println("Enter Your Choice: ");
			int userChoice = scan.nextInt();
			
			for (Question q : quest.getQuestions()) {
				if (q.getIndex() == userChoice) {
					nextQuest = q.getQuestID();
				}
			}
			
			if(nextQuest > 0){
				findQuest(nextQuest);
				invalidInput = false;
			} else {
				System.out.println("No valid quest found");
			}
			
		} while(invalidInput);
		
		
		scan.close();
	}
	
	private void findQuest(int index){
		for (Quest q: quests) {
			if (q.getQuestID() == index) {
				displayQuest(q);
			}
		}
	}
}
