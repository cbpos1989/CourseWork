/**
 * 
 */
package com.github.cbpos1989.examples.threads;

/**
 * Class to demonstrate how a threads can become deadlocked
 * 
 * @author Colm O'Sullivan
 *
 */
public class DeadLockApp{

	
	private Object a = new Object();
	private Object b = new Object();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DeadLockApp dla = new DeadLockApp();
		dla.startProgram();

	}
	
	private void startProgram(){
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				try {
					MethodA();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				try {
					MethodB();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		t1.start();
		t2.start();
	}

	private void MethodA() throws InterruptedException{
		synchronized(a){
			Thread.sleep(1000);
			synchronized(b){
				System.out.println("In Method A");
			}
		}
	}
	
	private void MethodB() throws InterruptedException{
		synchronized(b){
			Thread.sleep(1000);
			synchronized(a){
				System.out.println("In Method B");
			}
		}
	}
}
