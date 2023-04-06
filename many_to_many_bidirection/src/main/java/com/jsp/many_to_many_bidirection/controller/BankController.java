package com.jsp.many_to_many_bidirection.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.AbstractDocument.BranchElement;

import com.jsp.many_to_many_bidirection.dto.Bank;
import com.jsp.many_to_many_bidirection.dto.Customer;
import com.jsp.many_to_many_bidirection.service.BankService;

public class BankController {

	public static void main(String[] args) {

		while (true) {
			Scanner s = new Scanner(System.in);
			BankService service = new BankService();
			System.out.println("1.Insert\n2.Search\n3.Update\n4.Delete\n5.Display\n6.Exit");
			System.out.print("enter your choice: ");
			int choice = s.nextInt();
			switch (choice) {
			case 1: {
				Bank bank = new Bank(101, "HDFC", "Noida-sec-3", "HDFC0001");
				Bank bank1 = new Bank(102, "ICICI", "Noida-sec-2", "ICICI0001");
				Customer customer = new Customer(201, "vishesh", 7778992, 678626873, 956557);
				Customer customer1 = new Customer(202, "aman", 87382738, 83289129, 1921021);
				List<Customer> list1 = new ArrayList<Customer>(Arrays.asList(customer, customer1));
				bank.setCustomer(list1);
				service.insertBank(bank);
				service.insertBank(bank1);
			}
				break;

			case 2: {
				System.out.println("enter bankId: ");
				int branchId = s.nextInt();
				Bank bank = service.searchBank(branchId);
				if (bank != null) {
					System.out.println("..............Bank_details....................");
					System.out.println("bankId: " + bank.getBankId());
					System.out.println("bankName: " + bank.getBankName());
					System.out.println("bankAddress: " + bank.getBankAddress());
					System.out.println("bankIfscCode: " + bank.getBankIfscCode());
					List<Customer> list = bank.getCustomer();
					System.out.println("...............Customer_details.................");
					for (Customer customer : list) {
						System.out.println("customerId: " + customer.getCustomerId());
						System.out.println("customerName: " + customer.getCustomerName());
						System.out.println("customerAccount: " + customer.getCustomerAccountNumber());
						System.out.println("customerAadhra: " + customer.getCustomerAddharNumber());
						System.out.println("customerPhoneNumber: " + customer.getCustomerPhoneNumber());
						System.out.println();
					}
				} else {
					System.out.println("bankId not found in database");
				}
			}
				break;
			case 3: {
				Bank bank = new Bank(103, "CBI", "Noida-sec-4", "CBI0001");
				Bank bank1 = new Bank(104, "BOI", "Noida-sec-3", "BOI0001");
				Customer customer = new Customer(201, "vijay", 777842, 678336873, 9333457);
				Customer customer1 = new Customer(202, "jitendra", 8743438, 833434, 12323421);
				List<Customer> list1 = new ArrayList<Customer>(Arrays.asList(customer, customer1));
				bank.setCustomer(list1);
				service.updateBank(bank);
				service.updateBank(bank1);

			}
				break;
			case 4: {
				System.out.println("enter bankId: ");
				int bankId = s.nextInt();
				service.deleteBank(bankId);
			}
				break;
			case 5: {
				List<Bank> list = service.displayBank();
				if (list != null) {
					for (Bank bank : list) {
						System.out.println("..............Bank_details....................");
						System.out.println("bankId: " + bank.getBankId());
						System.out.println("bankName: " + bank.getBankName());
						System.out.println("bankAddress: " + bank.getBankAddress());
						System.out.println("bankIfscCode: " + bank.getBankIfscCode());
						System.out.println();
						List<Customer> list2 = bank.getCustomer();
						System.out.println("...............Customer_details.................");
						for (Customer customer : list2) {
							System.out.println("customerId: " + customer.getCustomerId());
							System.out.println("customerName: " + customer.getCustomerName());
							System.out.println("customerAccount: " + customer.getCustomerAccountNumber());
							System.out.println("customerAadhra: " + customer.getCustomerAddharNumber());
							System.out.println("customerPhoneNumber: " + customer.getCustomerPhoneNumber());
							System.out.println();

						}

					}
				} else {
					System.out.println("table is empty in database");
				}
			}
				break;
			case 6: {
				System.out.println("system closed");
				System.exit(choice);
			}
				break;
			default: {
				System.out.println("invalid choice!!!");
			}
			}
		}

	}

}
