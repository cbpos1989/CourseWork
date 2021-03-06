package com.github.cbpos1989.codingChallenge;
/**
 * Class to hold Lifeform state and behavior.
 * @author Colm O'Sullivan & James MacMahon
 */
public class LifeForm {
	
	int power;
	int uniqueID;
	public static int draws;
	
	public LifeForm(){
		this(-1, -1);
	}
	
	public LifeForm(int power, int uniqueID){
		this.power = power;
		this.uniqueID = uniqueID;
	}

	public int getPower() {
		return power;
	}

	public int getUniqueID() {
		return uniqueID;
	}
	public String toString(){
		return "Power: " + getPower() + " UniqueID: " + getUniqueID();
	}

}
