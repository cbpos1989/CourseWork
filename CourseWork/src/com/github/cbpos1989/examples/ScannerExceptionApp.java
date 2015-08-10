package com.github.cbpos1989.examples;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * Class to demonstrate Try/Catch block
 * 
 * @author Colm O'Sullivan
 * 
 */
public class ScannerExceptionApp{
	public static void main(String[] args){

		//System.out.println("ScannerExceptionApp working");
		
		try{
			File file = new File("FirstNames.txt");
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(file);
			
			while(scan.hasNext()) {
				System.out.println(scan.next());
			}
			
		} catch (FileNotFoundException fnfe) {
			System.out.println("Could not find file");
			fnfe.printStackTrace();
		}

	}


}

