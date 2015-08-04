/**
 * 
 */
package com.github.cbpos1989.examples;

/**
 * Class to hold state and behaviour for Person object
 * 
 * @author Colm O'Sullivan
 *
 */
public class Person extends Animal{
	private static final String SPECIES = "Human";
	
	public Person(String name){
		super(name, Person.SPECIES);
	}
	
	@Override
	public String move(){
		return super.move() + " by walking on two feet";
	}
	
	@Override
	public void sleep(int hour){
		if(hour >= 24 || hour <= 7){
			System.out.println(super.getName() + " is Sleeping");
			super.setSleeping(true);
		} else {
			System.out.println(Person.SPECIES + " only sleep after 12pm");
		}
	}
	
	
	@Override
	public String makeNoise(){
		return super.makeNoise() + " and I say Hello";
	}
}
