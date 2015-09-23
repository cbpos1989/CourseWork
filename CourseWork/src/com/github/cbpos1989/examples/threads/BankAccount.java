/**
 * 
 */
package com.github.cbpos1989.examples.threads;

/**
 * Class that holds the state and behaviour for a BankAccount object.
 * 
 * @author Colm O'Sullivan
 *
 */
public class BankAccount {
	private int balance;

	BankAccount(){
		this(0);
	}
	
	BankAccount(int balance){
		this.balance = balance;
	}
	
	public synchronized void witdraw(int amount){
		if(balance > amount) {
			System.out.println(Thread.currentThread().getName() + " is withdrawing from account");
			balance = balance - amount;
			System.out.println(Thread.currentThread().getName() + " has withdrawn €" + amount + " from the account");
		}
	}
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
}
