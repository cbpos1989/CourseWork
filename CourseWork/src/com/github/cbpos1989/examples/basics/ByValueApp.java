/**
 * 
 */
package com.github.cbpos1989.examples.basics;

/**
 * App to demonstrate that primitves pass by value
 * 
 * @author Colm O'Sullivan
 *
 */
public class ByValueApp {


	public static void main(String[] args) {
		int num = 0;
		ByValueApp ba = new ByValueApp();
		System.out.print("num value is: " + num);
		ba.changeValue(num);
		System.out.print("num value is: " + num);
	}

	private void changeValue(int number){
		System.out.print("number value is: " + number);
		++number;
		System.out.print("number value is: " + number);
	}
}
