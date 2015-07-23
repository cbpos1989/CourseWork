/**
 * 
 */
package com.teamcolmjames.robothumangame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;


/**
 * Class to hold main logic for human vs robot battling game.
 * @author Colm O'Sullivan & James MacMahon
 */
public class GameApp {
	private LifeForm[] robots = new LifeForm[500];
	private LifeForm[] humans = new LifeForm[500];
	private ArrayList<String> firstNames = new ArrayList<String>();
	private ArrayList<String> robitNames = new ArrayList<String>();
	private int robotTotalPower;
	private int humanTotalPower;
	private final int MAX_LIFEFORM_POWER = 101;
	private final String HUMAN_NAMES_PATH = "/resources/FirstNames.txt";
	private final String ROBOT_NAMES_PATH = "/resources/RobotNames.txt";
	//private final String HUMAN_NAMES_PATH = "/Users/User1/Desktop/FirstNames.txt";
	//private final String ROBOT_NAMES_PATH = "/Users/User1/Desktop/RobotNames.txt";

	public static void main(String[] args) {
		GameApp ga = new GameApp();
		ga.initialiseGame();
	}

	private void initialiseGame(){
		populateList(firstNames, HUMAN_NAMES_PATH);
		populateList(robitNames, ROBOT_NAMES_PATH);
		
		populateArray(humans, true);
		populateArray(robots, false);
		printArray(humans);
		printArray(robots);
	
		
		gameMenu();
	}
	
	private void populateList(ArrayList<String> list, String path){
		try {
			
			Scanner fNames = new Scanner(new File(path));
			
			while(fNames.hasNext()){
				list.add(fNames.next());
			}
			
			Collections.shuffle(list);
			
			//System.out.println("Array Size: " + list.size());
			//System.out.println("Array Element 0: " + list.get(0));
			
			fNames.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private String generateName(ArrayList<String> list,int index){
		
		//System.out.println(firstNames.get(index));
		
		return list.get(index);
	}

	private void gameMenu(){
		Scanner scan = new Scanner(System.in);
		boolean invalidInput = true;
		do {
			System.out.println("1) Play Classic \n2) Play Last Man Standing");
			System.out.print("Enter a choice: ");
			int userInput = scan.nextInt();
			if (userInput == 1) {
				invalidInput = false;
				runClassicBattle();
			} else if (userInput == 2) {
				invalidInput = false;
				runLMSBattle();
			} else {
				invalidInput = true;
				System.out.println("Enter valid input!\n");
			} 
		} while (invalidInput);
	}

	private int randomGenerator(int index){
		Random rand = new Random();
		return rand.nextInt(index);
	}

	private void populateArray(LifeForm[] lifeforms, boolean creatingHumans){
		int uniqueID = 100;
		for(int i = 0; i < lifeforms.length; ++i){

			if(creatingHumans){
				lifeforms[i] = new Human(randomGenerator(MAX_LIFEFORM_POWER),uniqueID++,generateName(firstNames,i));
				humanTotalPower += lifeforms[i].getPower();
			} else{
				String model = randomGenerator(11)%2 == 0 ? "Type A" : "Type B";
				lifeforms[i] = new Robot(randomGenerator(MAX_LIFEFORM_POWER),uniqueID++,generateName(robitNames,i) + " " + model);
				robotTotalPower += lifeforms[i].getPower();
			}
		}
	}
	private void runClassicBattle(){
		for(int i = 0; i < robots.length; ++i){
			if(robots[i].getPower() > humans[i].getPower()){
				Robot.robotWins++;
			}else if(humans[i].getPower() > robots[i].getPower()){
				Human.humanWins++;
			}else{
				LifeForm.draws++;
			}
		}
		
		printResults(true);
		
	}
	private void runLMSBattle(){
		
		
		while (!checkForWinner()) {
			for (int i = 0, j = 0; i < robots.length && j < humans.length;) {
				if (robots[i].getPower() > humans[j].getPower()) {
					Robot.robotWins++;
					j++;
					robots[i].setPower(robots[i].getPower() / 2);
				} else if (humans[j].getPower() > robots[i].getPower()) {
					Human.humanWins++;
					i++;
					humans[j].setPower(humans[j].getPower() / 2);
				} else {
					LifeForm.draws++;
					i++;
					j++;
				}
			}
		} 

		printResults(false);

	}

		
	private boolean checkForWinner(){
		if((Robot.robotWins + LifeForm.draws) >= 499){
			return true;
		} else if ((Human.humanWins + LifeForm.draws) >= 499){
			return true;
		} else {
			return false;
		}
	}

	private void printResults(boolean isClassicBattle){
		System.out.println("\nRobots total power: " + robotTotalPower + "\nHumans total power: " + humanTotalPower);

		if(Robot.robotWins > Human.humanWins){
			System.out.println("\nThe robots won!");
		}else if(Human.humanWins > Robot.robotWins){
			System.out.println("\nThe humans won!");
		}else{
			System.out.println("\nIt was a draw.");
		}

		if (isClassicBattle) {
			System.out.println("\nHuman wins: " + Human.humanWins + "\nHuman losses: " + Robot.robotWins);
			System.out.println("\nRobot wins: " + Robot.robotWins + "\nRobot losses: " + Human.humanWins);
			System.out.println("\nNumber of draws: " + LifeForm.draws);
		}else{
			System.out.println("There are " + (humans.length - (Robot.robotWins + LifeForm.draws)) + " humans left alive.");
			System.out.println("There are " + (robots.length - (Human.humanWins + LifeForm.draws)) + " robots left functioning.");

		}
	}
	
	//For testing purposes
	private void printArray(LifeForm[] lifeforms){
		for(LifeForm lf: lifeforms){
			System.out.println(lf);
		}
	}
}
