package com.github.cbpos1989.codingChallenge.banking_app;
/**
 *  Class to hold state and behaviour for an current account Object
 *   
 * @author Colm O'Sullivan, Alex Scanlan, Joe Murphy & Przemek Stepien (Sam)
 *
 */
class Current extends Account{
	
	//state
	boolean hasChequebook;
	double maxOverdraw;

	//constructor
	public Current(double balance, int accountNumber, Transaction transaction, boolean hasChequebook){
		super(balance, accountNumber, transaction);
		this.hasChequebook = hasChequebook;
	}

	//behaviour
	//get and setHasChequebook
	public void setChequebook(boolean hasChecquebook){
		this.hasChequebook = hasChecquebook;
	}

	public boolean getHasChequebook(){
		return hasChequebook;
	}
}