package com.github.cbpos1989.codingChallenge;

import java.util.Scanner;

public class ValidationApp{
	private final String NAME_MESSAGE = "Name e.g 'Dean Harrison'";
	private final String PPS_MESSAGE = "PPS e.g '3973038P'";
	private final String DOB_MESSAGE = "D.O.B. e.g 'dd/mm/yyyy'";
	private final int MAX_YEAR = 2015;
	private final int MIN_YEAR = 1900;

	private Scanner scan = null;

	public static void main(String[] args){
		ValidationApp va = new ValidationApp();
		va.startProgram();
	}

	private void startProgram(){
		//System.out.println("ValidationApp is Working");
		userMenu();
	}

	private void userMenu(){
		
		
		String nameInput = userInput(NAME_MESSAGE);
		String ppsInput = userInput(PPS_MESSAGE);
		String dobInput = userInput(DOB_MESSAGE);
		
		dobInput = dobInput.replaceAll("[^0-9/]","/");
		if(scan != null){
			scan.close();
		}

		System.out.printf("\nYour Name: %s Your PPS: %s Your DOB: %s", nameInput, ppsInput, dobInput);
	}

	private String userInput(String message){
		boolean invalidInput = true;
		String userInput = null;
		scan = new Scanner(System.in);
		do{
			System.out.println("\n!!----Persoal Details Menu----!!\n");
			System.out.printf("Enter Your %s : ", message);
			userInput = scan.nextLine();
			try{
				if(message.equals(NAME_MESSAGE)){
					validateName(userInput);
				} else if (message.equals(PPS_MESSAGE)){
					validatePPS(userInput);
				} else {
					validateDate(userInput);
				}
				
				invalidInput = false;
			} catch( InvalidNameException | InvalidPPSException | InvalidDateException ie) {
				ie.printStackTrace();
				invalidInput = true;
			}
		} while (invalidInput);
		
	
		return userInput;
	}

	private void validateName(String name) throws InvalidNameException{
		if(!name.contains("\u0020")){
			throw new InvalidNameException(("Incorrect name entered has no space to seperate first and last name\n"));
		}
	}

	private void validatePPS(String pps) throws InvalidPPSException{
		boolean validInput = false;

		if(pps.length() > 8 || pps.length() < 8){
			throw new InvalidPPSException("Incorrect PPS, must be 8 characters in length e.g 8574930A\n");
		}
		
		String ppsNumeric = pps.substring(0,7);
		char[] ppsAlpha = pps.substring(7).toCharArray();

		try{
			Integer.parseInt(ppsNumeric);
		} catch(NumberFormatException nfe) {
			throw new InvalidPPSException("Incorrect PPS, first 7 characters must be numeric digits\n");
		}
		
		for (int i = 65; i < 91; ++i) {
			if(ppsAlpha[0] == i){
				validInput = true;
				break;
			}
		}

		if(validInput != true){
			throw new InvalidPPSException("Incorrect PPS, the 8 character must be A-Z\n");
		}
	}

	private void validateDate(String date) throws InvalidDateException{
		String dayStr = date.substring(0,2);
		String monthStr = date.substring(3,5);
		String yearStr = date.substring(6,10);
		int day = -1;
		int month = -1;
		int year = -1;
		
		try{
			day = Integer.parseInt(dayStr);
			month = Integer.parseInt(monthStr);
			year = Integer.parseInt(yearStr);
		} catch(NumberFormatException nfe) {
			throw new InvalidDateException("Incorrect date format must be numeric digits\n");
		}

		if (year < MIN_YEAR || year > MAX_YEAR) {
			throw new InvalidDateException("Incorrect year must be between 1900-2015\n");
		}

		if (month < 1 || month > 12) {
			throw new InvalidDateException("Incorrect month must be between 01-12\n");
		}
		
		if(month == 9|| month == 4|| month == 6|| month == 11){
			if (day < 1 || day > 30) {
				throw new InvalidDateException("Incorrect month must be between 01-30\n");
			}
		} else if(month == 2){
			
			if ((day < 1 || day > 28) && !isLeapYear(year)) {
				throw new InvalidDateException("Incorrect date must be between 01-28\n");
			} else if ((day < 1 || day > 29) && isLeapYear(year)) {
				throw new InvalidDateException("Incorrect date must be between 01-29\n");
			}
		} else {
			if (day < 1 || day > 31) {
				throw new InvalidDateException("Incorrect month must be between 01-31\n");
			}
		}

		//System.out.printf("%s-%s-%s",dayStr,monthStr,yearStr);
	}

	private boolean isLeapYear(int year){
		if (year % 4 == 0 && year % 100 != 0) {
			return true;
		} else if (year % 400 == 0) {
			return true;
		} else {
			return false;
		}
	}
}

class InvalidNameException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidNameException(){
		super();
	}

	public InvalidNameException(String message){
		super(message);
	}
}

class InvalidPPSException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;	

	public InvalidPPSException(){
		super();
	}

	public InvalidPPSException(String message){
		super(message);
	}
}

class InvalidDateException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;	

	public InvalidDateException(){
		super();
	}

	public InvalidDateException(String message){
		super(message);
	}
}