package com.github.cbpos1989.examples.exceptions;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * Class to demonstrate Try/Catch/Finally block
 * 
 * @author Colm O'Sullivan
 * 
 */
public class FinallyApp{
	public static void main(String[] args){
		FinallyApp fa = new FinallyApp();
		fa.startProgram();
	}

	private void startProgram(){
		File file = new File("names.txt");
		FileReader fileReader = null;
		BufferedReader reader = null;

		try{
			fileReader  = new FileReader(file);
			reader = new BufferedReader(fileReader);
		} catch (FileNotFoundException fnfe) {
			System.out.println("File not found " + file);
		}  finally {
			closeReaders(reader);
		}
	}

	private void closeReaders(BufferedReader reader){
		if (reader != null) {
			try{
				reader.close();
			} catch (IOException ioe){
				ioe.printStackTrace();
			}
		}
	}

}