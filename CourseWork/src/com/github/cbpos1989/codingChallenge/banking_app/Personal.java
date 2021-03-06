package com.github.cbpos1989.codingChallenge.banking_app;
/**
 *  Class to hold state and behaviour for an personal customer Object
 *   
 * @author Colm O'Sullivan, Alex Scanlan, Joe Murphy & Przemek Stepien (Sam)
 *
 */
public class Personal extends Customer{

	//States of Personals class
	
	private String DOB;
	private String PPS;

	
	//Constructor for Customer class	
	public Personal(){
	}

	public Personal(String name, String address, String phoneNum, String dob, String pps){
		super(name, address, phoneNum);
		this.DOB = dob;
		this.PPS = pps;
	}

	public void audit(){
		
		if(super.checkAccQty() > 1){
			
			Account tempAcc = super.getAccount(1);

			if((tempAcc instanceof Deposit) && (tempAcc.getBalance() * 0.04 > 1000)){

				//print all details
				System.out.println(this);
				System.out.println(tempAcc);
				System.out.println("Rate: " + tempAcc.getBalance() * 0.04);

			} else if(super.getAccount(1).getBalance() < 0){

				//print all details
				System.out.println(this);
				System.out.println(tempAcc);
			}


		} else {
			Account tempAcc = super.getAccount(0);
		
			if(super.getAccount(0) instanceof Deposit && (tempAcc.getBalance() * 0.04 > 1000)){

				//print all details
				System.out.println(this);
				System.out.println(tempAcc);
				System.out.println("Rate: " + tempAcc.getBalance() * 0.04);


			} else if(super.getAccount(0).getBalance() < 0){

				//print all details
				System.out.println(this);
				System.out.println(tempAcc);

			}

		}
	}

	public String getDOB(){
		return this.DOB;
	}

	public void setDOB(String dob){
		this.DOB = dob;
	}

	public String getPPS(){
		return this.PPS;
	}

	public void setPPS(String pps){
		this.PPS = pps;
	}

	public String toString(){
		return "\nPersonal Customer\n" + super.toString() + "\nD.O.B:" + this.DOB + "\nPPS:" + this.PPS + "\n";
	}

}