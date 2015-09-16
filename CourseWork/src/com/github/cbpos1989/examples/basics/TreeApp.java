/**
 * 
 */
package com.github.cbpos1989.examples.basics;

/**
 * Class to run TreeApp main method
 * 
 * @author Colm O'Sullivan & James MacMahon
 *
 */
public class TreeApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tree oakTree = new Tree();
		oakTree.setSpecies("Oak");
		oakTree.setTrunkDiameter(25);
		oakTree.setEvergreen(false);
		
		System.out.println("Species: " + oakTree.getSpecies() +  "\nTrunk Diameter: " + oakTree.getTrunkDiameter() + "\nEvergreen: " + oakTree.isEvergreen());
	}

}
