package com.teamcolmjames.robothumangame;

/**
 * Class to hold robots state and behavior.
 * @author Colm O'Sullivan & James MacMahon
 */
public class Robot extends LifeForm{
	
	private String modelName;
	public static int robotWins;
	
	public Robot(){
		this(-1, -1, "NA");
	}
	
	public Robot(int power, int uniqueID, String modelName){
		super(power, uniqueID);
		this.modelName = modelName;
	}

	public String getModelName() {
		return modelName;
	}
	
	public String toString(){
		return super.toString() + " Model Name: " + modelName;
	}

}
