package banking;

import java.util.Scanner;

public class Account {
	
	
	int balance;
	int previousTrans;
	String name;
	String id;
	
	//class constructor
	Account(String customerName, String customerID) {
		name = customerName;
		id = customerID;
		
	}
	//deposit function
	void deposit(int amount) {
		if (amount != 0) {
			balance = balance + amount;
			previousTrans = amount;
		}
	}
	
	//withdraw function
	void withdraw(int amount) {
		if (amount != 0) {
			balance = balance - amount;
			previousTrans = -amount;  //want amount set to negative so it actually withdrawals $
		}
	
}

	//previous Transaction function
	
	
	void getPreviousTrans() {
		if (previousTrans > 0) {
			System.out.println("Depoosited: " + previousTrans);
		} else if (previousTrans < 0) {
			System.out.println("Withdrawn: " + Math.abs(previousTrans));
		} else {
			System.out.println("No transaction");
		}
	}
	
	//interest calculator function
	void interest(int years) {
		double interestRate = .02;
		double newBalance = (balance * interestRate * years) + balance;
		System.out.println("The current interest rate is: " + (100 * interestRate) + "%");
		System.out.println("After" + years + "years, your balance will be: " + newBalance);
	}
	
	//menu function
	void menu() {
		char option = '\0';
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome, " + name);
		System.out.println("Your ID is : " + id);
		System.out.println();
		System.out.println("Pick an option");
		System.out.println();
		System.out.println("A. Check balance");
		System.out.println("B. Deposit money");
		System.out.println("C. Withdraw money");
		System.out.println("D. View previous transaction");
		System.out.println("E. calculate interest");
		System.out.println("F. Exit");
		
		do {
			System.out.println();
			System.out.println("Enter option: ");
			char option1 = scan.next().charAt(0);
			option = Character.toUpperCase(option1);
			System.out.println();
			
			switch (option) {
			
			case 'A' :
				System.out.println("Balance = $" + balance);
				
				break;
				
			case 'B':
				System.out.println("Enter amount to deposit: ");
				int amount = scan.nextInt();
				deposit(amount);
				System.out.println();
				break;
				
			case 'C':
				System.out.println("Enter amount to withdraw: ");
				int amount2 = scan.nextInt();
				withdraw(amount2);
				System.out.println();break;
				
			case 'D':
				getPreviousTrans();
				break;
				
			case 'E':
				System.out.println("Enter years for interest added: ");
				int years = scan.nextInt();
				interest(years);
				break;
				
			case 'F':
				System.out.println();
				break;
				
				default: //default will let user know they entered invalid char
					System.out.println("invalid option was entered");
					break;
			}
		}while(option != 'F');
		System.out.println("Log out");
			}
		
	}

