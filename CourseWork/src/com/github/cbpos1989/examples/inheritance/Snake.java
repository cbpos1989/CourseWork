/**
 * 
 */
package com.github.cbpos1989.examples.inheritance;

/**
 * Class to hold state and behaviour for Snake object
 * 
 * @author Colm O'Sullivan
 *
 */
public class Snake extends Animal{
	private static final String SPECIES = "Snake";
	
	public Snake(String name) {
		super(name,Snake.SPECIES);
	}

	@Override
	public String move(){
		return super.move() + " by sliding on its belly";
	}
	
	public void sleep(int hour){
		if(hour >= 7 || hour <= 22){
			System.out.println(super.getName() + " is Sleeping");
			super.setSleeping(true);
		} else {
			System.out.println(Snake.SPECIES + " only sleep after 7am");
		}
	}
	
	@Override
	public String makeNoise(){
		return super.makeNoise() + " do you like apples?";
	}
	
	public void spawn(){
		System.out.println(super.getName() + " is Spawing...");
	}
}
