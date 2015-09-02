/**
 * 
 */
package com.github.cbpos1989.examples.collections;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.List;
import java.util.Random;

/**
 * App to demonstrate the use of ArrayLists
 * 
 * @author Colm O'Sullivan
 *
 */

public class ClassroomApp{
	ArrayList<String> classroom = new ArrayList<String>();

	public static void main(String[] args){
		ClassroomApp ca = new ClassroomApp();
		ca.runProgram();
		
		

	}

	private void runProgram(){
		populateArrayList();

		System.out.println("!!---Morning Registration---!!");
		printArrayList();

		//classroom.remove("Seamus");
		//classroom.remove("Jenn");
		//classroom.remove("Alex");
		classroom = removeRandomPerson(classroom);
		
		System.out.println("!!---Midday Registration---!!");
		printArrayList();
		
		classroom.clear();
		System.out.println("!!---Afternoon Registration---!!");
		printArrayList();
	}

	private void populateArrayList(){

	try{
		Scanner names = new Scanner(new File("classroomNames.txt"));

		while(names.hasNext()){
			classroom.add(names.next());
		}

		names.close();
	} catch(FileNotFoundException fnfe){
		System.out.println("File not Found");
	}
		
	}

	private int randomGenerator(int index){
		Random rand = new Random();
		return rand.nextInt(index);	
	}

	private ArrayList<String> removeRandomPerson(List<String> list){
		list.remove(randomGenerator(list.size()));
		ArrayList<String> arrayList = new ArrayList<String>(list);
		return arrayList;
	}


	private void printArrayList(){

		if(!classroom.isEmpty()){
			for(String s: classroom){
				System.out.println(s);
			}
		}	
	}
}