/**
 * 
 */
package com.github.cbpos1989.examples.threads;

/**
 * @author User1
 *
 */
public class BankingApp {

	
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args){
		BankingApp ba = new BankingApp();
		try {
			for (int i = 0; i < 20; ++i) {
				ba.startProgram();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private void startProgram() throws InterruptedException {
		Thread david = new Thread(new Person(),"David");
		Thread trisha = new Thread(new Person(), "Trisha");
		
		david.start();
		trisha.start();
		
		Thread.sleep(500);
		
		System.out.println("Balance: " + Person.getBankBalance());
		Person.setBankBalance(100);
		
	}

}
