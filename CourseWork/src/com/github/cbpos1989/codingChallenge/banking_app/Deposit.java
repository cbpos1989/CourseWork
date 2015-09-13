package com.github.cbpos1989.codingChallenge.banking_app;
/**
 *  Class to hold state and behaviour for an deposit account Object
 *   
 * @author Colm O'Sullivan, Alex Scanlan, Joe Murphy & Przemek Stepien (Sam)
 *
 */
class Deposit extends Account{

	//state
	double rate;

	//constructor
	public Deposit(double balance, int accountNumber, Transaction transaction, double rate){
		super(balance, accountNumber, transaction);
		this.rate = balance * rate;
	}

	//behaviour
	public void setRate(Double rate){
		this.rate = rate;
	}

	public double getRate(){
		return this.rate;
	}
}