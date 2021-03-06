package com.github.cbpos1989.codingChallenge.banking_app;
/**
 *  Class to hold state and behaviour for an customer Object
 *   
 * @author Colm O'Sullivan, Alex Scanlan, Joe Murphy & Przemek Stepien (Sam)
 *
 */
import java.util.ArrayList;


public abstract class Customer implements Auditable{

	
	//States of Customer class

	private String name;
	private String address;
	private String phoneNum;
	ArrayList<Account> accList = new ArrayList<Account>();



	
	//Constructors for Customer class	
	
	public Customer(){
		this("","","");
	}

	public Customer(String name, String address, String phoneNum){
		this.name = name;
		this.address = address;
		this.phoneNum = phoneNum;
	}



	//Getter and Setter Methods for Customer class

	public String getName (){
		return this.name;
	}
	
	public void setName (String name){
		this.name = name;
	}
	
	public String getAddress(){
		return this.address;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public String getPhoneNum(){
		return this.phoneNum;
	}
	
	public void setPhoneNumber(String phoneNum){
		this.phoneNum = phoneNum;
	}	

	public Account getAccount(int i){	
		return this.accList.get(i);

	}
	
	public void setAccount(Account acc){
		accList.add(acc);
	}

	public int checkAccQty(){
		return this.accList.size();
	}

	public String toString(){
		return "Name: " + this.name + "\nAddress: " +  this.address + "\nPhone Num: " + this.phoneNum; 
	}

}