/**
 * 
 */
package com.github.cbpos1989.examples;
/**
 * Class to hold state and behaviour for Dog object
 * 
 * @author Colm O'Sullivan
 *
 */
public class Dog extends Animal{
	private static final String SPECIES = "Dog";
	
	public Dog(String name){
		super(name, Dog.SPECIES);
	}
	
	@Override
	public String move(){
		return super.move() + " by bounding on all fours";
	}
	
	public void sleep(int hour){
		if(hour >= 19 || hour <= 4){
			System.out.println(super.getName() + " is Sleeping");
			super.setSleeping(true);
		} else {
			System.out.println(Dog.SPECIES + " only sleep after 7pm");
		}
	}
	
	@Override
	public String makeNoise(){
		return super.makeNoise() + " and I like to bark";
	}
}
