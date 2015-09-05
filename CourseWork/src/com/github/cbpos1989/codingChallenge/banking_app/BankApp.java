package com.github.cbpos1989.codingChallenge.banking_app;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 *  App made as part of one day code challenge on the course.
 * @author Colm O'Sullivan, Alex Scanlan, Joe Murphy & Sam
 *
 */
public class BankApp{
	private ArrayList<Customer> customersList = new ArrayList<Customer>();
	private final String HEADING = "=============";
	private Random rand = new Random();

	public static void main(String[] args){
		//System.out.println("Banking App Working");
		BankApp ba = new BankApp();
		ba.runProgram();
	}

	private void runProgram(){
		populateArrayList(customersList);
		displayMenu();

	}

	private void displayMenu(){
		Scanner scan = new Scanner(System.in);
		boolean invalidInput = true;

		System.out.println(HEADING + "Banking App Menu" + HEADING);
		System.out.println("1) List all Customers, and their Accounts\n2) List all Accounts, and their Customers\n3) Audit all Customers\n4) Exit");
		do{
			

			System.out.print("Enter Your Choice: ");
			
			String userInput = scan.nextLine();

			try{
				int userNumber = Integer.parseInt(userInput);
				
				switch(userNumber){
				case 1: listCustomers();
					//invalidInput = false; 
					break;
				case 2: listAccounts();
					//invalidInput = false; 
					break;
				case 3: auditAllCustomers();
					//invalidInput = false; 
					break;
				case 4:  System.out.println("\nExiting Program...");
					invalidInput = false; break;
				default: System.out.println("\nPlease enter digit between (1-4)"); 
					invalidInput = true; break;
				}
			} catch (NumberFormatException nfe) {
				//nfe.printStackTrace();
				System.out.println("\nInvalid Input can't use alpha characters");
			}
		} while(invalidInput);	

		scan.close();
	}

	private void populateArrayList(ArrayList<Customer> list){
		for(int i = 0; i < 100; ++i){
			list.add(new Personal("alex", "129 Cashel Raod" , "0858349667", "18/07/78",("4803" + i)+ "83Y"));
			list.add(new Business("alex", "212312 Cashel Road", "0-39103312", "18/31/33", true));
		}

		for(Customer c: customersList){
			assignAccount(c);
		}
	}

	private void assignAccount(Customer c){
		
		for(int i = 0;i < (randomGenerator(2)+1); ++i){

			boolean temp = randomGenerator(2) == 1? true : false;		

			Account acc = randomGenerator(2) == 1? new Deposit((randomGenerator(200000) - 100000), randomGenerator(10000) + i,new Transaction(), 0.04D): new Current((randomGenerator(200000) - 100000), randomGenerator(10000) + i,new Transaction(), temp); 
			c.setAccount(acc);
		}
	}

	private int randomGenerator(int index){
		return rand.nextInt(index);
	}

	private void listCustomers(){
		System.out.println("");
		System.out.println(HEADING + "Customers" + HEADING);
		for(Customer c: customersList){
			System.out.println(c);
		}
	}
	
	private void listAccounts(){
		System.out.println("");
		System.out.println(HEADING + "Accounts" + HEADING);
		for(Customer c: customersList){
			for(int i = 0; i < c.checkAccQty(); ++i){
				System.out.println(c.getAccount(i) + " " + c);
			}
		}
	}

	private void auditAllCustomers(){
		System.out.println("");
		System.out.println(HEADING + "Audits" + HEADING);

		for(Customer c : customersList){
			c.audit();
		}
	}

}