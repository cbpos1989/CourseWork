package com.github.cbpos1989.examples.collections;

enum Planet implements Runnable{
	EARTH(12_742), SATURN(116_464), JUPITER(139_822), MARS(6_779);

	int diameter;

	private Planet(int diameter){
		this.diameter = diameter;
	}

	public int getRadius(){
		return diameter/2;
	}

	public String toString(){
		return this.name();



	}

	public void run(){
	}
}

public class MainClass{
	public static void main(String[] args){
		for(Planet p : Planet.values()){
			System.out.println(p);
		}
		//System.out.println(Planet.SATURN.getRadius());
	}
}