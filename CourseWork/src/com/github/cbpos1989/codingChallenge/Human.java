package com.github.cbpos1989.codingChallenge;

/**
 * Class to hold humans state and behavior.
 * @author Colm O'Sullivan & James MacMahon
 */
public class Human extends LifeForm{
	
	private String name;
	public static int humanWins;
	
	
	public Human(){
		this(-1, -1, "NA");
	}
	
	public Human(int power, int uniqueID, String Name){
		super(power, uniqueID);
		this.name = Name;
	}

	public String getName() {
		return name;
	}
	
	public String toString(){
		return super.toString() + " Name: " + name;
	}

}
