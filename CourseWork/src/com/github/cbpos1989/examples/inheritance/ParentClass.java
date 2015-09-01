/**
 * 
 */
package com.github.cbpos1989.examples.inheritance;

/**
 * App to demonstrate constructors and inheritance.
 * 
 * @author Colm O'Sullivan
 *
 */
public class ParentClass {
	public ParentClass(){
		System.out.println("ParentClass Constructor");
	}
	
	public ParentClass(String s){
		System.out.println("ParentClass Constructor" + s);
	}
	
	public static void main(String[] args){
		ChildClass childClass1 = new ChildClass();
		ChildClass childClass2 = new ChildClass(" Test");
		System.out.println(childClass1.className());
	}
	
	public String className(){
		return "ParentClass ";
	}
}

 class ChildClass extends ParentClass{
	public ChildClass(){
		System.out.println("ChildClass Constructor");
	}
	
	public ChildClass(String s){
		super(s);
		System.out.println("ChildClass Constructor" + s);
	}
	
	public String className(){
		return "ChildClass -> " + super.className();
	}
}
