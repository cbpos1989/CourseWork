/**
 * 
 */
package com.github.cbpos1989.examples.threads;

/**
 * Class to demonstrate how to create a multi-threaded application
 * 
 * @author Colm O'Sullivan
 *
 */
public class Counter implements Runnable {

	public static void main(String[] args){
		Counter cnt = new Counter();
		cnt.startProgram();
	}
	
	private void startProgram(){
		createThreads(4);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		for (int i = 0; ; ++i) {
			if (checkForPrime(i + 1)) {
				System.out.println( Thread.currentThread().getName() + ": " + (i + 1) + " ");
			}
			
		}
	}
	
	private boolean checkForPrime(int number){
	
		for(int i = number - 1; i > 1; --i){
				if (number % i == 0) {
					return false;
				}
		}
		
		return true;
		
	}
	
	private void createThreads(int index){
		for (int i = 0; i < index; ++i) {
			Thread t = new Thread(new Counter(),"Thread " + (i + 1));
			t.start();
		}
	}

}
