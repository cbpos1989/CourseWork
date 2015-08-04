/**
 * 
 */
package com.github.cbpos1989.examples;

/**
 * Class to hold state and behaviour for Animal object
 * 
 * @author Colm O'Sullivan
 *
 */
public abstract class Animal {
	private String name;
	private String species;
	private boolean isSleeping;
	
	

	public Animal(){
		this("Unknown","Unknown");
	}
	
	public Animal(String name, String species){
		this.name = name;
		this.species = species;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isSleeping() {
		return this.isSleeping;
	}
	
	public void setSleeping(boolean isSleeping) {
		this.isSleeping = isSleeping;
	}
	
	abstract public void sleep(int hour);

	public String makeNoise(){
		return "I'm a " + this.species + " and my name is " + this.name;
	}
	
	public String move(){
			return "Is Moving..";
	
	}
	
	@Override
	public String toString(){
		return this.name;
	}
}
