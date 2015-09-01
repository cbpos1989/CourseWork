package com.github.cbpos1989.examples.collections;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RegistrationApp{
	ArrayList<String> students = new ArrayList<String>();

	public static void main(String[] args){
		//System.out.println("Working");
		RegistrationApp ra = new RegistrationApp();
		ra.userMenu();
	}

	private void userMenu(){
		boolean invalidInput = true;
		Scanner scan = new Scanner(System.in);

		do{
			System.out.println("\n!!---RegistrationApp Menu---!!");
			System.out.println("1) Enter New Student\n2) Print List of Students\n3) Display Number of Students\n4) Remove Current Student\n5) Save to File\n6) Quit");
			System.out.print("Enter Your Choice: ");
			int userInput = scan.nextInt();

			switch(userInput){
			case 1: 	enterNewStudent();
					invalidInput = true; 	break;
			case 2: 	printArray(); 
					invalidInput = true;	break;
			case 3: 	System.out.println("\nNumber of students: " + students.size());	
					invalidInput = true; break;
			case 4:		removeStudent(); 	
					invalidInput = true;	break;
			case 5:		saveToFile();		
					invalidInput = true;	break;
			case 6:		System.out.println("Exiting Program"); 
					invalidInput = false;	break;
			default: 	System.out.println("Incorrect Choice");
					invalidInput = true;	break;
			}
		} while (invalidInput);

		scan.close();

	}

	private void enterNewStudent(){
		boolean isInputing = true;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n!!---Enter Student Details---!!");
		do{
			System.out.print("Enter Student Name(enter null to return to menu):");	
			String name = scan.nextLine();
			name = name.toLowerCase();
			String firstChar = name.substring(0,1);
			String formatedName = name.replaceFirst(firstChar,firstChar.toUpperCase());
			
			if (!name.equalsIgnoreCase("null")) {
				students.add(formatedName);
				isInputing = true;
			} else {
				isInputing = false;
			}

		} while(isInputing);
		
		
	
	}

	private void removeStudent(){
		
			
		System.out.println("\n!!---Remove Student Details---!!");
		boolean invalidInput = true;
		Scanner scan = new Scanner(System.in);

		do{
			System.out.print("Enter Student Name/Number to Remove: ");
			String userInput = scan.nextLine();

			try{
				int studentNumber = Integer.parseInt(userInput);
			
				if(studentNumber <= students.size()){
					System.out.println(students.get(studentNumber -1).toString() + " has been removed from the records");
					students.remove(studentNumber - 1);
					invalidInput = false;
				} else{
					System.out.println("Incorrect Value");
					invalidInput = true;
				}
			
			} catch(NumberFormatException nfe) {
				if(checkForStudent(userInput)){
					System.out.println(userInput + " has been removed from the records");
					students.remove(userInput);
					invalidInput = false;
				} else {
					System.out.println(userInput + " does not exsit");
					invalidInput = true;
				}
			
			}
		} while(invalidInput);

		
	}

	private boolean checkForStudent(String name){
		for(String s: students){
			if (s.equalsIgnoreCase(name)) {
				return true;
			}
		}

		return false;
	}

	//first sorts array alphabetically before printing
	private void printArray(){
		System.out.println("\n!!---Registered Students---!!");
		Scanner scan = new Scanner(System.in);
		System.out.print("Print Normal/Reverse Order (n/r): ");
		String userInput = scan.next();

		if(userInput.equalsIgnoreCase("n")){
			Collections.sort(students);
		} else if(userInput.equalsIgnoreCase("r")){
			Comparator<String> cmp = Collections.reverseOrder(); 
			Collections.sort(students,cmp);
		}
		
		for(String s: students){
			System.out.println(s);
		}	
	}

	private void saveToFile(){
		

		try{
			File file = new File("/users/user1/java/studentNames.txt");
			String separator = System.getProperty("line.separator");
			
			if(!file.exists()){
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Registered Students");
			for(int i = 0; i < students.size(); ++i){
				bw.write((i+1) + ") " + students.get(i) + separator);
			}
			System.out.println("\n!!---Student Details Saved---!!");
			
			bw.close();
		
		} catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
}