/**
 * 
 */
package com.github.cbpos1989.examples.threads;

/**
 * @author Colm O'Sullivan
 *
 */
public class Person implements Runnable{
	private static BankAccount ba = new BankAccount(100);
	
	@Override
	public void run() {
		ba.witdraw(70);
	}

	public static int getBankBalance() {
		return ba.getBalance();
	}
	
	public static void setBankBalance(int value) {
		ba.setBalance(value);
	}

}
