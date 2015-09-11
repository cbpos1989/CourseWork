/**
 * 
 */
package com.github.cbpos1989.examples.arrays;


/**
 *  App to demonstrate the concept of a binary search of a sorted array.
 * 
 * @author Colm O'Sullivan
 *
 */

public class SearchingArrays{
	int[] testingArray;
	int userValue = 96;

	public static void main(String[] args){
		SearchingArrays sa = new SearchingArrays();
		sa.startProgram();
	}

	private void startProgram(){
		testingArray = populateArray(1000);
		int indexPos = binarySearch(testingArray,userValue);
		System.out.println("Value of " + userValue + " found at index: " + indexPos);	
	}

	private int[] populateArray(int index){
		int[] array = new int[index];
		
		for (int i = 0; i < array.length -1; ++i) {
			array[i] = (int)(Math.random() * 10) + i;
			//System.out.println(array[i]);
		}

		return array;	
	}

	private int binarySearch(int[] array, int value){
		int lowestPossibleLoc = 0;
		int highestPossibleLoc = array.length -1;

		while (highestPossibleLoc >= lowestPossibleLoc) {
			int middle = (lowestPossibleLoc + highestPossibleLoc)/2;
			
			if(array[middle] == value) {
				return middle;
			} else if (array[middle] > value) {
				highestPossibleLoc = middle -1;
			} else {
				lowestPossibleLoc = middle + 1;
			}
		}

		return -1;


	}


}