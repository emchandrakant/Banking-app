package com.boi.account;

import java.util.Scanner;

public class BankAccount {
	
	int balance;
	int previousTransaction;
	String customerName;
	String customerId;
	
	public BankAccount() {
		super();
	}

	public BankAccount(String customerName, String customerId) {
		super();
		this.customerName = customerName;
		this.customerId = customerId;
	}

	void deposite(int amount) {
		if(amount != 0) {
			balance = balance + amount;
			previousTransaction = amount;
		}
	}
	
	void withdraw(int amount) {
		if(amount != 0) {
			balance = balance - amount;
			previousTransaction = - amount;
		}
	}
	
	void getPreviousTransaction(){
		if(previousTransaction > 0)
			System.out.println("Deposited: "+ previousTransaction);
		else if(previousTransaction < 0)
			System.out.println("Withdrawn: "+ Math.abs(previousTransaction));
		else
			System.out.println("No tansaction occured");
	}
	
	void showMenu() {
		char option='\0';
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Welcome "+customerName);
		System.out.println("Your ID is "+customerId);
		System.out.println("\n");
		System.out.println("A. Check Balance");
		System.out.println("B. Deposite");
		System.out.println("C. Withdraw");
		System.out.println("D. Previous Transaction");
		System.out.println("E. Exit");
		
		do {
			System.out.println("===================================================================================");
			System.out.println("Enter an option");
			System.out.println("===================================================================================");
			option = sc.next().toLowerCase().charAt(0);
			System.out.println("\n");
			
			switch(option) {
			
			case 'a':
				System.out.println("----------------------------------------------------------------------------------");
				System.out.println("Balance = "+balance);
				System.out.println("----------------------------------------------------------------------------------");
				System.out.println("\n");
				break;
			
			case 'b':
				System.out.println("----------------------------------------------------------------------------------");
				System.out.println("Enter an amount to deposite: ");
				System.out.println("----------------------------------------------------------------------------------");
				int amount =sc.nextInt();
				deposite(amount);
				System.out.println("\n");
				break;
				
			case 'c':
				System.out.println("----------------------------------------------------------------------------------");
				System.out.println("Enter an amount to withdraw: ");
				System.out.println("----------------------------------------------------------------------------------");
				int amount2 =sc.nextInt();
				withdraw(amount2);
				System.out.println("\n");
				break;
				
			case 'd':
				System.out.println("----------------------------------------------------------------------------------");
				getPreviousTransaction();
				System.out.println("----------------------------------------------------------------------------------");
				System.out.println("\n");
				break;
				
			case 'e':
				System.out.println("***********************************************************************************");
				sc.close();
				break;
			}
		}
		while(option != 'e');
		System.out.println("Thank you for using our services");
	}
	 
}