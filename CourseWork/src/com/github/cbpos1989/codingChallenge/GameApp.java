/**
 *
 */
package com.github.cbpos1989.codingChallenge;

/**
 *  App to demonstrate difference between static and non-static, inheritance and object orientated programming.
 * 
 * @author Colm O'Sullivan & Artjoms Porss
 *
 */


import java.util.Random;

public class GameApp{
	private static final int MAX_NUMBER_LIFEFORMS = 1000;
   	private static final int MAX_NUMBER_ROBOTS = 500;
	private Lifeforms[] lifeforms = new Lifeforms[MAX_NUMBER_LIFEFORMS];
	private static int totalRobotPower = 0;
	private static int totalHumanPower = 0;
    
	public static void main(String[] args){
		// checks if modulo division of random num is odd or even and assigns robot model
		new GameApp().runProgram();
	}

	public int getRobotPower(){
		return totalRobotPower;
	}
	public void setRobotPower(int newPower){
		GameApp.totalRobotPower = newPower;
	}

	public int getHumanPower(){
		return totalHumanPower;
	}
	public void setHumanPower(int newPower){
		GameApp.totalHumanPower = newPower;
	}

	private void runProgram(){
		intializeArray();
		battleMethod();
	}

	
	private int randomGenerator(){
		Random random = new Random();
		int number = random.nextInt(((100 + 1) - 1) +1);
		return number;
	}
    
    	private void intializeArray(){
    		for (int i = 0; i < MAX_NUMBER_ROBOTS; ++i) {
        		String model = new GameApp().randomGenerator()%2 == 0 ? "Type A" : "Type B";
          		int num = new GameApp().randomGenerator() + i;
        		lifeforms[i] = new Robit(new GameApp().randomGenerator(), i + " " + num, model);
        	}
        
        	for (int i = MAX_NUMBER_ROBOTS; i < lifeforms.length; ++i) {
            		int num = new GameApp().randomGenerator() + i;
        		lifeforms[i] = new Humann(new GameApp().randomGenerator(), i + " " + num, "Agent Smith number " + i);
        	}

		for(Lifeforms lf : lifeforms){
			System.out.println(lf);
		}
	}

	private void battleMethod(){
		int result = 0;
		if(totalHumanPower > totalRobotPower){
			result = totalHumanPower - totalRobotPower;
			System.out.println("Human win by " + result);
		} else {
			result =  totalRobotPower - totalHumanPower;
			System.out.println("Robots win by " + result);
		}
	}
}

class Lifeforms{
	private int power = -1;
	private String uniqueID = "Unknown";

	public Lifeforms(){

	}

	public Lifeforms(int power, String uniqueID){
		this.power = power;
		this.uniqueID = uniqueID;
	}
  
  public String toString(){
  	return "Power: " + this.power + "\t  UniqueID: " + this.uniqueID;
  }
  	
}

class Robit extends Lifeforms{
	private String model = null;
	
	public Robit(){
	}

	public Robit(int power, String uniqueID, String model){
		super(power, uniqueID);
		this.model = model;
		GameApp ga = new GameApp();
      		ga.setRobotPower(ga.getRobotPower() + power);
	}
  
  	public String toString(){
  		return super.toString() + "\t	 Model: " + this.model;
  	}
}


class Humann extends Lifeforms{
	String name = "John Connor";

	public Humann(){
	}

	public Humann(int power, String uniqueID, String name){
		super(power, uniqueID);
		this.name = name;
		GameApp ga = new GameApp();
      		ga.setHumanPower(ga.getHumanPower() + power);
	}
  
  	public String toString(){
  		return super.toString() + "\t  Name: " + this.name;
  	}
}