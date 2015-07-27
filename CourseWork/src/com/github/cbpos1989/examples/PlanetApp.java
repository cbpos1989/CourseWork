package com.github.cbpos1989.examples;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Properties;
import java.util.Enumeration;

/**
 * App to demonstrate the using enums and Properties.
 * 
 * @author Colm O'Sullivan
 *
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