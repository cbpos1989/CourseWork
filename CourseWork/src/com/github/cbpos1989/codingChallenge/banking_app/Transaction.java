package com.github.cbpos1989.codingChallenge.banking_app;

import java.util.Calendar;

public class Transaction{
	//state
	Calendar date;
	double amount;
	//constructor
	public Transaction(){
	}

	public Transaction(Calendar date, double amount){
		this.date = date;
		this.amount = amount;
	}
	
	
	//get and set date
	public void setDate(Calendar date){
		this.date = date;
	}
		public Calendar getDate(){
		return this.date;
	}

	//get and set amount
	public void setAmount(double amount){
		this.amount = amount;
	}
		public double getAmount(){
		return this.amount;
	}
}
