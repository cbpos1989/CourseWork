/**
 * 
 */
package com.github.cbpos1989.examples;

/**
 * @author User1
 *
 */
public class MyPersonApp{


	public static void main(String[] args){
		MyPersonApp myApp = new MyPersonApp();
		myApp.createPerson();
	}
	
	void createPerson(){
		OtherPerson p = new OtherPerson(21,"Mule",'m');
		OtherPerson p1 = new OtherPerson(100,"Muley", 'f');
		OtherPerson p2 = new OtherPerson();
//		p.setName("Mule");
//		p1.setName("Muley");
//		p.setAge(21);
//		p1.setAge(100);
//		p.setGender('m');
//		p1.setGender('f');
		System.out.println("Name: " + p.getName() + "\nAge: " + p.getAge() + "\nGender: " + p.getGender());
		System.out.println("Name: " + p1.getName() + "\nAge: " + p1.getAge() + "\nGender: " + p1.getGender());
		System.out.println("Name: " + p2.getName() + "\nAge: " + p2.getAge() + "\nGender: " + p2.getGender());
	}
}

class OtherPerson{
	private int age;
	private String name;
	private char gender;
	
	OtherPerson(){
		this(-1, "Muley Muleson",'?');
	}
	
	OtherPerson(int age, String name, char gender){
		this.setAge(age);
		this.setName(name);
		this.setGender(gender);
	}
	
	int getAge(){
		return age;
	}
	
	void setAge(int age){
		this.age = age;
	}
	
	String getName(){
		return name;
	}
	
	void setName(String name){
		this.name = name;
	}
	
	char getGender(){
		return gender;
	}
	
	void setGender(char gender){
		this.gender = gender;
	}
}



