package com.github.cbpos1989.examples.arrays;

import java.io.*;
import java.nio.file.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MultiDimensionalArrayApp{
	String[][] strs = new String[3][11];	
	ArrayList<String> listOfNames = new ArrayList<String>();
	final static Charset ENCODING = StandardCharsets.UTF_8;

	public static void main(String[] args){
		System.out.println("!!---MultiDimensionalArrayApp---!!");	
		MultiDimensionalArrayApp mda = new MultiDimensionalArrayApp();
		mda.runProgram();		
	
	}

	private void runProgram(){
		try{
			readTextFile("playerNames.txt");
		} catch(IOException ioe) {
			System.out.print("FIle not found");
		}
		populateArray();
		printArray();	
	}

	

	private void populateArray(){
		
		
			//Scanner names = new Scanner(new File("playerNames.txt"));

			for(int i = 0, c = 0; i < strs.length; ++i){
			
				for(int j = 0; j < strs[i].length; ++j){
				
						strs[i][j] = listOfNames.get(c++);
					
				
				}
			}

			//names.close();
		
	
	}

	private void populateList(String input){
		listOfNames.add(input);
	}

	private void printArray(){
		for(int i = 0; i < strs.length; ++i){
			System.out.println("Array " + i);
			for(int j = 0; j < strs[i].length; ++j){
				System.out.print(("Element " + j) + ": " + strs[i][j] + " ");
			}
			System.out.println("");
		}
	}

  	void readTextFile(String fileName) throws IOException {
   		Path path = Paths.get(fileName);
    		try (BufferedReader reader = Files.newBufferedReader(path, ENCODING)){
      			String line = null;
      			while ((line = reader.readLine()) != null) {
        			if(line.startsWith("-")){
					System.out.println("Skip line");
				} else {
					populateList(line);
				}

				//process each line in some way
        			
      			}      
    		}
  	}

	




}