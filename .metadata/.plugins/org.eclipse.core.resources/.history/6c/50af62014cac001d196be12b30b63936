package com.practice;

import java.util.Objects;
import java.util.Scanner;

public class Banking {
	static User u1 = new User();
	public static void main(String[] args) {
		
		int choice=0;
		Scanner scan = new Scanner(System.in);
		
		try {
			while(choice!=6){
				System.out.println("Choose the option: ");
				System.out.println("1. Create account: ");
				System.out.println("2. Withdraw money: ");
				System.out.println("3. Deposit money: ");
				System.out.println("4. Check balence: ");
				System.out.println("5. Check User detail: ");
				System.out.println("6. Exit: ");
				
				System.out.println("Enter Your Choice: ");
				choice=scan.nextInt();
				scan.nextLine();
				
				switch(choice) {
				
				case 1:u1.createAccount();
					break;	
					
				case 2:
					if(!u1.getUser_name().equals(null)) {
					u1.withdrawMoney();
					}
					break;	
					
				case 3:
					if(!u1.getUser_name().equals(null)) {
					u1.depositMoney();
				}
					break;
					
				case 4:
					if(!u1.getUser_name().equals(null)) {
					u1.checkBalance();
					}
					break;	
					
				case 5:
					if(!u1.getUser_name().equals(null)) {
					System.out.println(u1.toString());
					}
					break;	
					
				case 6:System.exit(0);
					break;	
				default : System.out.println("\nEnter valid choice!!\n");
					}
				
				}
		}
		
		catch(Exception e){
			System.out.println("\nUser dose not exist!!");
			System.out.println("Please create new account!!\n");
			main(args);
		}
	}
}
