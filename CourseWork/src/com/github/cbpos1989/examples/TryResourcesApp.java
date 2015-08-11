package com.github.cbpos1989.examples;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TryResourcesApp{
	public static void main(String[] args){
		TryResourcesApp tra = new TryResourcesApp();
		tra.readNames();
	}
	
	private void readNames(){
		File file = new File("names.txt");

		try(Scanner scan = new Scanner(file)){
			while(scan.hasNext()){
				System.out.println(scan.next());
			}
		} catch(FileNotFoundException fnfe) {
		}
	}
}