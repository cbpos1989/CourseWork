/**
 * 
 */
package com.github.cbpos1989.examples.collections;

/**
 * Class to hold state and behavior for Person object.
 * 
 * @author Colm O'Sullivan
 *
 */
public class Person implements Comparable<Person>{
	private String name;
	private int age;
	private String ppsNumber;

	public Person(){
		this("unknown",-1,"0000000P");
	}
	
	public Person(String name, int age, String ppsNumber){
		setName(name);
		setAge(age);
		setPPSNumber(ppsNumber);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPPSNumber() {
		return ppsNumber;
	}

	public void setPPSNumber(String ppsNumber) {
		this.ppsNumber = ppsNumber;
	}

	@Override
	public int compareTo(Person p) {
		int result =   p.getAge() - this.getAge();
		
		if (result == 0 && !this.equals(p)) {
			return 1;
		}
		
		return result;
	}
	
	public boolean equals(Object o){
		if(this == o){
			return true;
		}
		
		if(o instanceof Person){
			if(this.ppsNumber.equals(((Person)o).getPPSNumber())){
				return true;
			}
		}
		return false;
	}

	public String toString(){
		return "Name: " + getName() + "\nAge: " + getAge() + "\nPPS Number: " + getPPSNumber();
	}
	
	
}
