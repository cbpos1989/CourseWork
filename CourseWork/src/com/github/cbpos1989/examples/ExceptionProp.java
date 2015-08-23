package com.github.cbpos1989.examples;

public class ExceptionProp{
	private boolean validNumber = true;

	public static void main(String[] args){
		ExceptionProp epa = new ExceptionProp();
		System.out.println("");
		try{
			if(args[0].equalsIgnoreCase("true")){
				epa.validNumber = true;
				epa.startProgram();	
			} else if(args[0].equalsIgnoreCase("false")){
				epa.validNumber = false;
				epa.startProgram();	
			} else {
				System.out.print("Inncorrect arguement");
			}
		} catch (ArrayIndexOutOfBoundsException aobe){
			System.out.print("No arguements");
		} finally {
			System.out.print(" program ending...\n");
		}
	}

	private void startProgram(){
		System.out.println("!!----ExceptionProp App----!!");
		try{
			runProgram();
		} catch (NumberFormatException nfe) {
			System.out.print("NumberFormatException was thrown");
		}
	}

	private void runProgram(){
		try{
			if (validNumber) {
				causeException(Integer.parseInt("4"));
			} else {
				causeException(Integer.parseInt("four"));
			}
		} catch(ArithmeticException ae) {
				System.out.print("ArithmeticException was thrown");
		}
	}

	private void causeException(int num){
		num /= 0;
	}
	
}