package com.jsp.many_to_many_bidirection.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jsp.many_to_many_bidirection.dto.Bank;
import com.jsp.many_to_many_bidirection.dto.Customer;
import com.jsp.many_to_many_bidirection.service.CustomerService;

public class CustomerController {

	public static void main(String[] args) {
		while (true) {
			Scanner s = new Scanner(System.in);
			CustomerService service = new CustomerService();
			System.out.println("1.Insert\n2.Search\n3.Update\n4.Delete\n5.Display\n6.Exit");
			System.out.print("enter your choice: ");
			int choice = s.nextInt();
			switch (choice) {
			case 1: {
				Customer customer = new Customer(203, "shivam", 43454565, 3233234, 2312123);
				Customer customer1 = new Customer(204, "vikas", 878225, 30998923, 8899999);
				List<Bank> list = new ArrayList<Bank>();
				Bank bank = new Bank(103, "BARODA", "Noida sec-19", "BOB000019");
				Bank bank1 = new Bank(104, "Union", "Noida sec-20", "UNI000020");
				list.add(bank);
				list.add(bank1);
				customer.setBank(list);
				service.insertCustomer(customer);
				service.insertCustomer(customer1);
			}
				break;

			case 2: {
				System.out.println("enter customerId: ");
				int customerId = s.nextInt();
				Customer customer = service.searchCustomer(customerId);
				if (customer != null) {
					System.out.println(".............customer_details...............");
					System.out.println("customerId: " + customer.getCustomerId());
					System.out.println("customerName: " + customer.getCustomerName());
					System.out.println("customerAccountNumber: " + customer.getCustomerAccountNumber());
					System.out.println("customerAadharNumber: " + customer.getCustomerAddharNumber());
					System.out.println("customerPhoneNumber: " + customer.getCustomerPhoneNumber());
					System.out.println();
					System.out.println("...............bank_details..................");
					List<Bank> list = customer.getBank();
					for (Bank bank : list) {
						System.out.println("bankId: " + bank.getBankId());
						System.out.println("bankName: " + bank.getBankName());
						System.out.println("bankIfscCode: " + bank.getBankIfscCode());
						System.out.println("bankAddress: " + bank.getBankAddress());
						System.out.println();
					}
				} else {
					System.out.println("please check customerId you have passed");
				}
			}
				break;
			case 3: {
				Customer customer = new Customer(203, "shivani", 433365, 323111, 234443);
				Customer customer1 = new Customer(204, "neharika", 879925, 3077923, 866999);
				List<Bank> list = new ArrayList<Bank>();
				Bank bank = new Bank(103, "IDFC", "Noida sec-19B", "IDF000019");
				Bank bank1 = new Bank(104, "OBC", "Noida sec-20A", "OBC000020");
				list.add(bank);
				list.add(bank1);
				customer.setBank(list);
				service.updateCustomer(customer);
				service.updateCustomer(customer1);
			}
				break;
			case 4: {
				System.out.println("enter customerId: ");
				int customerId = s.nextInt();
				service.deleteCustomer(customerId);

			}
				break;
			case 5: {
				List<Customer> list = service.displayCustomer();
				if (list != null) {
					for (Customer customer : list) {
						System.out.println("............customer_details.....................");
						System.out.println("customerId: " + customer.getCustomerId());
						System.out.println("customerName: " + customer.getCustomerName());
						System.out.println("customerAccountNumber: " + customer.getCustomerAccountNumber());
						System.out.println("customerAadharNumber: " + customer.getCustomerAddharNumber());
						System.out.println("customerPhoneNumber: " + customer.getCustomerPhoneNumber());
						System.out.println();
						System.out.println("...............bank_details..................");
						List<Bank> list1 = customer.getBank();
						for (Bank bank : list1) {
							System.out.println("bankId: " + bank.getBankId());
							System.out.println("bankName: " + bank.getBankName());
							System.out.println("bankIfscCode: " + bank.getBankIfscCode());
							System.out.println("bankAddress: " + bank.getBankAddress());
							System.out.println();
						}
					}
				} else {
					System.out.println("No data present in table");
				}

			}
				break;
			case 6: {
				System.out.println("System closed");
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