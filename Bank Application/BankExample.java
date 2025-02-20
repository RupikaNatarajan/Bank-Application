package com.celcom.saturday_assignments_08_feb_2025;

import java.util.HashMap;
import java.util.Scanner;


class Account
{
	String accountHolderName;
	String branchName;
	long phone;
	String accountType;
	double balance;
	
	public Account(String accountHolderName, String branchName, long phone, String accountType) {
		this.accountHolderName = accountHolderName;
		this.branchName = branchName;
		this.phone = phone;
		this.accountType = accountType;
		this.balance=0;
	}
	
}
class Bank
{
	Scanner sc = new Scanner(System.in);
	
	private HashMap<Long,Account> bank = new HashMap<>();
	
	//To add a new account
	void addAccount()
	{
		System.out.println("Enter the name");
		String name = sc.next();
		System.out.println("Enter your phone number");
		long phone = sc.nextLong();
		System.out.println("Enter Account Type");
		String type = sc.next();
		System.out.println("Enter the branch name");
		String branch = sc.next();
		
		Account account = new Account(name,branch,phone,type);
		long newaccountnumber = bank.size()+1;
		bank.put(newaccountnumber,account);
		System.out.println("Created Successfully and the account number is " + newaccountnumber);
		return;
	}
	
	
	//To delete an Account
	void deleteAccount()
	{
		System.out.println("Enter the account number of the account holder");
		long accountnumber = sc.nextLong();
		if(bank.containsKey(accountnumber))
		{
			bank.remove(accountnumber);
			System.out.println("Removed Successfully");
			return;
		}
		System.out.println("Invalid Input");
	}
	
	
	//To display the account details
	void accountDetails()
	{
		System.out.println("Enter the account number");
		long accountnumber = sc.nextLong();
		if(!bank.containsKey(accountnumber))
		{
			System.out.println("Account Not Found");
			return;
		}
		Account account = bank.get(accountnumber);
		System.out.println("Name : " + account.accountHolderName);
		System.out.println("Account Type : " + account.accountType);
		System.out.println("Balance : " + account.balance);
	}
	
	//To deposit an amount
	void deposit()
	{
		System.out.println("Enter the account number");
		long accountnumber=sc.nextLong();
		System.out.println("Enter the amount");
		double amount=sc.nextDouble();
		if(bank.containsKey(accountnumber))
		{
			Account account = bank.get(accountnumber);
			account.balance+=amount;
			System.out.println("Deposited");
			return;
		}
		System.out.println("Account Not Found");
		
	}
	
	//To withdraw money
	void withDraw()
	{
		System.out.println("Enter the account number");
		long accountnumber=sc.nextLong();
		System.out.println("Enter the amount");
		double amount=sc.nextDouble();
		if(bank.containsKey(accountnumber))
		{
			Account account = bank.get(accountnumber);
			if(account.balance<amount)
			{
				System.out.println("Insufficient balance");
				return;
			}
			account.balance-=amount;
			System.out.println("Transaction completed");
			System.out.println("Available balance : " + account.balance);
			return;
		}
		System.out.println("Account Not Found");
	}
}

public class BankExample {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Bank bank = new Bank();
		while(true)
		{
			System.out.println("*========================*\n");
			System.out.println("Enter your choice");
			System.out.println("1. Create new acount");
			System.out.println("2. View Account Details");
			System.out.println("3. Delete Account");
			System.out.println("4. Deposit");
			System.out.println("5. Withdraw");
			int choice = sc.nextInt();
			switch(choice)
			{
			case 1:
				bank.addAccount();
				break;
			case 2:
				bank.accountDetails();
				break;
			case 3:
				bank.deleteAccount();
				break;
			case 4:
				bank.deposit();
				break;
			case 5:
				bank.withDraw();
				break;
			default:
				System.out.println("Invalid");
			}
			System.out.println("*========================*\n\n");
		}
		
		
	}
	

}
