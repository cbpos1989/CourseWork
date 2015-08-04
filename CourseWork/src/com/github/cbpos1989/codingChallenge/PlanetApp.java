package com.github.cbpos1989.codingChallenge;

import com.github.cbpos1989.codingChallenge.Planets;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Properties;
import java.util.Enumeration;
/*
 * Class to to run program that will allow user to type in a planet name and have information about that planet display to console.
 * 
 * @author Colm O'Sullivan & Mubasher Mohammed
 */
public class PlanetApp{
	ArrayList<Planets> planets = new ArrayList<Planets>();
	public static void main(String[] args){

	PlanetApp pa = new PlanetApp();
	pa.runProgram();
	


	}
	public void runProgram(){

	Properties props = System.getProperties();
	
	Enumeration<?> keys = props.propertyNames();

		while(keys.hasMoreElements()){
			String key = keys.nextElement().toString();
			String value = props.getProperty(key);

			if(key.equals("user.name")){
				System.out.println("Hello " + value);
			}
	
		}



	Scanner scan = new Scanner(System.in);
	
	System.out.println("---List of Planets (Radius)---");
		for(Planets p: Planets.values()){
			planets.add(p);
			System.out.println(p);
		

		}
	System.out.println("please pick a planet! ");
	String userInput = scan.nextLine();
	
		for(Planets p: planets){
			if(userInput.equalsIgnoreCase(p.toString())){
				System.out.println(p + " (" + p.getRadius() + ")");
			}
	
		}
		
		scan.close();
	}
	
	


}