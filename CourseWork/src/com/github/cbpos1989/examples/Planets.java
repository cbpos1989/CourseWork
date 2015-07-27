package com.github.cbpos1989.examples;

/**
 * Enum to hold list of planets
 * 
 * @author Colm O'Sullivan
 *
 */

public enum Planets{

    MERCURY (2.4397e6),
    VENUS   (6.0518e6),
    EARTH   (6.37814e6),
    MARS    (3.3972e6),
    JUPITER (7.1492e7),
    SATURN  (6.0268e7),
    URANUS  (2.5559e7),
    NEPTUNE (2.4746e7);

    private double radius;
	Planets(double radius){
		this.radius = radius;
	
	}
	
	public double getRadius(){
		return this.radius;
	}


}