/**
 * 
 */
package com.github.cbpos1989.examples.inheritance;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * App to demonstrate inheritance and polymorphism
 * 
 * @author Colm O'Sullivan
 *
 */
public class InheritanceApp {
	ArrayList<Animal> animals = new ArrayList<Animal>();
	Calendar time = Calendar.getInstance();
	
	public static void main(String[] args) {
		//System.out.println("Working");
		InheritanceApp ia = new InheritanceApp();
		ia.startProgram();
	}

	private void startProgram() {
		Person humanAlpha = new Person("Adam");
		Person humanOmega = new Person("Eve");
		Snake evilSnake = new Snake("Snakey");
		Cat cat = new Cat("Rover");
		Dog dog = new Dog("Whiskers");
		Duck duck = new Duck("Donald");
		animals.add(humanAlpha);
		animals.add(humanOmega);
		animals.add(evilSnake);
		animals.add(dog);
		animals.add(cat);
		animals.add(duck);
		
		startAction();
	}

	private boolean isPM(int hour){
		if(hour > 11 && hour < 23){
			return true;
		} else {
			return false;
		}
		
	}
	
	private void startAction(){
		int hour = time.get(Calendar.HOUR_OF_DAY);
		int min = time.get(Calendar.MINUTE);
	
		
		String outputTime = "It is ";
		
		if(isPM(hour)){
			outputTime += (hour -12) + ":" + min + " P.M.";	
		} else {
			outputTime += hour + ":" + min + " A.M.";	
		}
		
		System.out.println(outputTime + "\n");
		
		
		for(Animal a: animals){
			a.spawn();
			System.out.println(a.makeNoise());
			a.sleep(hour);
			if (!a.isSleeping()) {
				System.out.println(a.move());
			}
			System.out.println("");
		
		}
		
	}

}
