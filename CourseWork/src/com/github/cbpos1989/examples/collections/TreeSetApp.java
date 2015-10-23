/**
 * 
 */
package com.github.cbpos1989.examples.collections;

import java.util.TreeSet;

/**
 * @author User1
 *
 */
public class TreeSetApp {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeSet<Person> personSet = new TreeSet<Person>();
		
		personSet.add(new Person("Mike", 29, "9839839P"));
		personSet.add(new Person("Ashley", 26, "8494894P"));
		personSet.add(new Person("Sam", 24, "7484848P"));
		personSet.add(new Person("Chris", 23, "0909383P"));
		personSet.add(new Person("Matt", 25, "8399292P"));
		personSet.add(new Person("Jessica", 24, "1718828P"));
		personSet.add(new Person("Josh", 27, "3899393P"));
		personSet.add(new Person("Emily", 20, "8489393P"));
		
		for (Person p: personSet) {
			System.out.println(p + "\n");
		}
		
	}

}
