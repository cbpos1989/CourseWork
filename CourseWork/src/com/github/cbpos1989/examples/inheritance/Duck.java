/**
 * 
 */
package com.github.cbpos1989.examples.inheritance;

/**
 * Class to hold state and behaviour for Duck object
 * 
 * @author Colm O'Sullivan
 *
 */
public class Duck extends Animal{
	private static final String SPECIES = "Duck";
	
	public Duck(String name){
		super(name, Duck.SPECIES);
	}
	
	@Override
	public String move(){
		return super.move() + " by paddling two feet";
	}
	
	public void sleep(int hour){
		if(hour >= 22 || hour <= 5){
			System.out.println(super.getName() + " is Sleeping");
			super.setSleeping(true);
		} else {
			System.out.println(Duck.SPECIES + " only sleep after 10pm");
		}
	}
	
	@Override
	public String makeNoise(){
		return super.makeNoise() + " and I say quack!";
	}

	public void spawn(){
		System.out.println(super.getName() + " is Spawing...");
	}
}
