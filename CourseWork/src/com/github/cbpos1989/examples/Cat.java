/**
 * 
 */
package com.github.cbpos1989.examples;

/**
 * Class to hold state and behaviour for Cat object
 * 
 * @author Colm O'Sullivan
 *
 */
public class Cat extends Animal{
	private static final String SPECIES = "Cat";
	
	public Cat(String name) {
		super(name,Cat.SPECIES);
	}

	@Override
	public String move(){
		return super.move() + " by slinking on all fours";
	}
	
	public void sleep(int hour){
		if(hour >= 12 || hour <= 9){
			System.out.println(super.getName() + " is Sleeping");
			super.setSleeping(true);
		} else {
			System.out.println(Cat.SPECIES + " only sleep from midday onwards");
		}
	}
	
	@Override
	public String makeNoise(){
		return super.makeNoise() + " and I say, Meow";
	}
}
