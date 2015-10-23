/**
 * 
 */
package com.github.cbpos1989.examples.collections;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author Colm O'Sullivan
 *
 */
public class StudentRegApp {
	TreeSet<Student> students = new TreeSet<Student>();	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StudentRegApp sra = new StudentRegApp();
		sra.userMenu();

	}
	
	private void userMenu(){
		Scanner scan = new Scanner(System.in);
		boolean invalidInput = true;
		do{
			System.out.println("1) Register new Student \n2) Display List of Students \n3) Quit");
			
			System.out.print("Enter Choice: ");
			int userInput = scan.nextInt();
			
			switch(userInput){
			case 1:  registerNewStudent();
					 break;
			case 2:  displayAllStudents();
					 break;
			case 3:  invalidInput = false;
					 break;
			default: System.out.println("Enter a valid option");
					 invalidInput = true;
					 break;
			}
		} while(invalidInput);
		
		scan.close();
	}
	
	private void registerNewStudent(){
		Scanner scan = new Scanner(System.in);
		System.out.println("\n!---Register New Student---!");
		
		System.out.print("Enter Name: ");
		String name = scan.next();
		
		System.out.print("Enter Student Number: ");
		int studentNumber = scan.nextInt();
		
		System.out.println(" ");
		
		students.add(new Student(name, studentNumber));
		
	}
	
	private void displayAllStudents(){
		System.out.println("\n!---List of Students---!");
		
		for (Student s: students) {
			System.out.println(s + "\n");
		}
	}

}
