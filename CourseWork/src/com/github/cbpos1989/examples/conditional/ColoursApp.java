/**
 * 
 */
package com.github.cbpos1989.examples.conditional;

import java.util.Scanner;
import static java.awt.Color.*;

/**
 * App to demonstrate the import of static class
 * 
 * @author Colm O'Sullivan
 *
 */
public class ColoursApp{
	public static void main(String[] args){
		ColoursApp ca = new ColoursApp();
		ca.setupProgram();
		ca.userInput();
		
		

		
	}

	private void setupProgram(){
		String[] colours = {"Blue","Red","Green","Black","Cyan","Dark Grey","Grey","Light Grey","Magenta","Orange","Pink","White","Yellow"};
		
		System.out.println("!!---Colour Picker Menu---!!");
		for(int i = 0; i < colours.length;++i){
			System.out.println((i + 1) + ")" + colours[i]);
		}
	}

	private void userInput(){
		boolean invalidInput = true;
		Scanner scan = new Scanner(System.in);
		
		do{
			System.out.print("Pick a Colour: ");
			String userInput = scan.nextLine();


			switch(userInput.toUpperCase()){
				case "BLUE":System.out.print(BLUE); 
					invalidInput = false; break;
				case "RED":System.out.print(RED); 
					invalidInput = false; break;
				case "GREEN":System.out.print(GREEN); 
					invalidInput = false; break;
				case "BLACK":System.out.print(BLACK);
					invalidInput = false;  break;	
				case "CYAN":System.out.print(CYAN); 
					invalidInput = false; break;
				case "DARK GREY":System.out.print(DARK_GRAY);
					invalidInput = false;  break;
				case "GREY":System.out.print(GRAY); 
					invalidInput = false; break;
				case "LIGHT GREY":System.out.print(LIGHT_GRAY); 
					invalidInput = false; break;
				case "MAGENTA":System.out.print(MAGENTA); 
					invalidInput = false; break;
				case "ORANGE":System.out.print(ORANGE); 
					invalidInput = false; break;
				case "PINK":System.out.print(PINK); 
					invalidInput = false; break;
				case "WHITE":System.out.print(WHITE); 
					invalidInput = false; break;
				case "YELLOW":System.out.print(YELLOW); 
					invalidInput = false; break;
				default: System.out.println("Invalid Choice");
					invalidInput = true; break;
			}
		} while(invalidInput);
		
		scan.close();
	}



}