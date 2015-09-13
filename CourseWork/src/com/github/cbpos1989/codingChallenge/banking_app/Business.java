package com.github.cbpos1989.codingChallenge.banking_app;
/**
 *  Class to hold state and behaviour for an Business customer Object
 *   
 * @author Colm O'Sullivan, Alex Scanlan, Joe Murphy & Przemek Stepien (Sam)
 *
 */
public class Business extends Customer{

	//States of Business class
	
	private String VAT;
	private boolean taxClearance;

	
	//Constructors for Business class
	
	public Business(){
	
		this("", "", "", "", false);
	}

	public Business(String name, String address, String phoneNum, String vat, boolean taxClear){
		
		super(name, address, phoneNum);
		this.VAT = vat;
		this.taxClearance = taxClear;

	}

	//Behaviour

	public void audit(){
		
		if(super.checkAccQty() > 1){
			
			Account tempAcc = super.getAccount(1);

			if(tempAcc instanceof Deposit && tempAcc.getBalance() * 0.04D > 1000){

				System.out.println(this);
				System.out.println(tempAcc);

			} else if(super.getAccount(1).getBalance() < 0){

				//print all details
				System.out.println(this);
				System.out.println(tempAcc);

			}


		} else {

			Account tempAcc = super.getAccount(0);
		
			if(tempAcc instanceof Deposit && tempAcc.getBalance() * 0.04D > 1000){

				//print all details
				System.out.println(this);
				System.out.println(tempAcc);

			} else if(super.getAccount(0).getBalance() < 0){

				//print all details
				System.out.println(this);
				System.out.println(tempAcc);

			}

		}
	}


	public boolean getTaxClearnace(){
		return this.taxClearance;
	}

	public void setTaxClearnace(boolean bool){
		this.taxClearance = bool;
	}


	public String getVAT(){
		return this.VAT;
	}

	public void setVAT(String vat){
		this.VAT = vat;
	}

	public String toString(){
		return "\nBusiness Customer\n" + super.toString() + "\nVAT: " + this.VAT + "\nTax Clearance: " + this.taxClearance + "\n";
	}


}