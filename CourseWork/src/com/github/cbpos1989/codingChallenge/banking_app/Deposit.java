package com.github.cbpos1989.codingChallenge.banking_app;

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