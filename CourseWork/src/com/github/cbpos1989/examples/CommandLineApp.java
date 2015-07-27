/**
 * 
 */
package com.github.cbpos1989.examples;

import java.util.Properties;
import java.util.Enumeration;
import java.util.Scanner;

/**
 * App to demonstrate the use of command line arguments and commands.
 * 
 * @author Colm O'Sullivan
 *
 */

public class CommandLineApp{
	public static void main(String[] args){
		CommandLineApp cla = new CommandLineApp();
		
		for(String str: args){
			System.out.println(str);
		}
		
		cla.runProperties();
		cla.runProgram();
		
	}
	
	private void runProperties(){
		Properties props = System.getProperties();
		Enumeration<?> keys = props.propertyNames();
	
		
		while(keys.hasMoreElements()){
			String key = keys.nextElement().toString();
			String value = props.getProperty(key);
			System.out.println(key + " = " + value);	
		}
	}

	private void runProgram(){
		System.out.println("!!---Hello World Program---!!");
		Scanner scan = new Scanner(System.in);
		System.out.println("Hello, who are you?");
		System.out.print("Enter Name: ");
		String userName = scan.nextLine();
		System.out.println("Hello " + userName);
		scan.close();
	}	


}

