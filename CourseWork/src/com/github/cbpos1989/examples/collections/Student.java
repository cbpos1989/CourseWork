/**
 * 
 */
package com.github.cbpos1989.examples.collections;

/**
 * @author Colm O'Sullivan
 *
 */
public class Student implements Comparable<Student>{
	private String name;
	private int studentNumber;
	
	public Student(){
		
	}
	
	public Student(String name, int studentNumber){
		setName(name);
		setStudentNumber(studentNumber);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}

	
	public boolean equals(Object o){
		if(this == o){
			return true;
		}
		
		if(o instanceof Student){
			if(this.studentNumber == getStudentNumber()){
				return true;
			}
		}
		return false;
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String toString(){
		return "Name: " + getName() + "\nStudent Number: " + getStudentNumber();
	}
}
