package com.github.cbpos1989.examples.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ExceptionHierarchy{
	
	public static void main(String[] args){
		ExceptionHierarchy eh = new ExceptionHierarchy();
		eh.startProgram();
	}

	private void startProgram(){
		//System.out.println("ExceptionHierarchy is working");
	
		File file = new File("file.txt");
		Scanner scan = null;
		try{
			scan = new Scanner(file);
			while(scan.hasNext()){
				System.out.println(scan.next());
				throw new IOException();
			}
		} catch(FileNotFoundException fnfe) {
			System.out.println("File not found " + file);
		} catch (IOException ioe) {
			System.out.println("IOException");
		} catch (Exception e) {
			System.out.println("Exception");
		} finally {
			if(scan != null){
				scan.close();
			}

			System.out.println("Ending Program...");
		}
	}

}