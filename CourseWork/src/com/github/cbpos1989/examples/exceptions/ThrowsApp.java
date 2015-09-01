package com.github.cbpos1989.examples.exceptions;

public class ThrowsApp{
	public static void main(String[] args){
		ThrowsApp ta = new ThrowsApp();
		
		try{
			ta.startProgram();
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	private void startProgram(){
		//System.out.println("ThrowsApp is working");

		try{
			checkedExceptionMethod();
		} catch (Exception e){
			e.printStackTrace();
		}

		
		uncheckedExceptionMethod();

	}

	

	private void checkedExceptionMethod() throws Exception{
		throw new IJustDontKnowAnyMoreException("Jon Snow");
	}

	private void uncheckedExceptionMethod() {
		throw new WhatIsThePointToAnythingException("Marvin");
	}
}


class IJustDontKnowAnyMoreException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;

	public  IJustDontKnowAnyMoreException(){
		this("annonymous");
	}

	public  IJustDontKnowAnyMoreException(String name){
		this.name = name;
	}

	public void printStackTrace(){
		System.out.println("You know nothing " + this.name + "\n");
	}
}

class WhatIsThePointToAnythingException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;

	public WhatIsThePointToAnythingException(){
		this("annonymous");
	}

	public WhatIsThePointToAnythingException(String name){
		this.name = name;
	}

	public void printStackTrace(){
		System.out.println("Then just go ahead an kill yourself " + this.name + "\n");
	}
}
