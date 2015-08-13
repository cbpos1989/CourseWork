package com.github.cbpos1989.codingChallenge;

import java.util.Scanner;
import java.io.*;
import java.nio.file.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
/*
 * Class to demonstrate the use of mutli-dimensional arrays and file I/O.
 * 
 * @author Colm O'Sullivan & Jenn  Quinn
 */
public class TeamApp{
	String[][][] teams = new String[3][3][11];	
	ArrayList<String> listOfNames = new ArrayList<String>();
	final static Charset ENCODING = StandardCharsets.UTF_8;

	public static void main(String[] args){
		System.out.println("!!---MultiDimensionalArrayApp---!!");	
		TeamApp mda = new TeamApp();
		mda.runProgram();		
	
	}

	private void runProgram(){
		Scanner scan = new Scanner(System.in);
		try{
			readTextFile("PlayerNames.txt");
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		populateArray();
		printArray();	
		
		
		
		/*do{
			System.out.println("What would you like to do?");
			System.out.println("1) Display teams from a league");
			System.out.println("2) Work on a team from a league");
			System.out.println("3) Quit");
			while(!scan.hasNextInt()){
				scan.next();
				System.out.println("Invalid number, please try again");
			}
			
			int userChoice = scan.nextInt();
			
			switch(userChoice){
				case 1:
					displayTeam();
					break;
				case 2:
					removePlayer(teamChoice());
					break;
				case 3:
					isRunning = false;
					try{
						saveToFile("playerNames.txt");
					}catch(IOException e){
						System.out.println("Could not save");
					}
					break;
				default:
					System.out.println("invalid choice");
					break;
			}
		}while(isRunning);//*/
		
		scan.close();
	}

	private int leagueChoice(){
		Scanner scan = new Scanner(System.in);
		System.out.println("What league do you want work with:");
		System.out.println("Premier League, Championship League,"
			+ " League One");
		System.out.print("Please enter your choice: ");
		
		String league = scan.nextLine();
		league = league.toLowerCase();
		
		if(league.contains("premier")){
			return 0;
		}else if(league.contains("champ")){
			return 1;
		}else if(league.contains("league")){
			return 2;
		}else{
			return -1;
		}
	}
	
	private int teamChoice(){
		Scanner scan = new Scanner(System.in);
		System.out.println("What team do you want work with:");
		System.out.println("Reading, Bristol City, Leeds");
		System.out.print("Please enter your choice: ");
		String team = scan.nextLine();
		team = team.toLowerCase();
		switch(team){
			case "reading":
				return 0;
			case "bristol city":
				return 1;
			case "leeds":
				return 2;
			default:
				return -1;
		}
	}
	
	private void displayTeam(){
		printArray(teamChoice());
	}

	private void populateArray(){

			//Scanner names = new Scanner(new File("playerNames.txt"));

			for(int i = 0, c = 0; i < teams.length; ++i){
			
				for(int j = 0; j < teams[i].length; ++j){
					
					for(int k = 0; k< teams[i][j].length; ++k){
						if(c < listOfNames.size()){
							teams[i][j][k] = listOfNames.get(c++);
						}
						else{
							teams[i][j][k] = "n/a";
						}
						
					}
				
				}
				
			}

			//names.close();
	}

	private void populateList(String input){
		listOfNames.add(input);
	}

	private void printArray(){
		for(int i = 0; i < teams.length; ++i){
			System.out.println("3DArray " + i);
			for(int j = 0; j < teams[i].length; ++j){
				System.out.println("Arrays " + j);
				for(int k = 0; k < teams[i][j].length; ++k){
					System.out.print(("Element " + j) + ": " + teams[i][j][k] + " ");
				}
			}
			System.out.println("");
		}
	}
	
	private void printArray(int league){
		for(int j = 0; j < teams[league].length; ++j){
			System.out.print(("No " + (j+1)) + ": " + teams[league][j] + "\n");
		}
	}
	
	private void printArray(int league, int team){
		for(int j = 0; j < teams[league][team].length; ++j){
			System.out.print(("No " + (j+1)) + ": " + teams[league][team][j] + "\n");
		}
	}

	private void addPlayer(int league, int team){
		Scanner scan = new Scanner(System.in);
		System.out.println("What player do you want to add");
		String player = scan.nextLine();
		for(int i = 0; i <teams[team].length; ++i){
			if(teams[league][team][i].equals("")){
				System.out.println(teams[team][i] + " has been added");
				teams[league][team][i] = player;
			}else if(i == (teams[team].length - 1)){
				System.out.println("Team is full, please remove a player before adding one");
			}
		}
	}
	
	private void removePlayer(int league, int team){
		Scanner scan = new Scanner(System.in);
		System.out.println("What player do you want to remove");
		String player = scan.nextLine();
		for(int i = 0; i <teams[team].length; ++i){
			if(teams[league][team][i].toLowerCase().equals(player.toLowerCase())){
				System.out.println(teams[team][i] + " has been removed");
				teams[league][team][i] = "";
			}
		}
	}
	
  	void readTextFile(String fileName) throws IOException {
   		Path path = Paths.get(fileName);

    		try (BufferedReader reader = Files.newBufferedReader(path, ENCODING)){
				System.out.println("reached");
      			String line = null;
      			while ((line = reader.readLine()) != null) {
					System.out.println("Reached");
        			if(line.startsWith("-")){
					System.out.println("Skip line");
					} else {
						System.out.println(line);
						populateList(line);
				}

				//process each line in some way
        			
      			}      
    		}
  	}

	private void saveToFile(String fileName) throws IOException{
		

		Path path = Paths.get(fileName);
		
		try (BufferedWriter writer = Files.newBufferedWriter(path, ENCODING)){
			
			String separator = System.getProperty("line.separator");

			for(int i = 0; i < teams.length; ++i){
				writer.write("--" + separator);
				for(int j = 0; j <teams[i].length;++j){
					for(int k = 0; k < teams[i][j].length; ++k){
						System.out.println("i = " + i + " j = " + j + "k = " + k);
						writer.write(teams[i][j][k] + separator);
					}
				}
			}
			System.out.println("\n!!---Saved To File---!!");
			
			writer.close();
		}
		
}




}