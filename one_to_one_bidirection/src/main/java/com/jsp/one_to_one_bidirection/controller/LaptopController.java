package com.jsp.one_to_one_bidirection.controller;

import java.util.List;
import java.util.Scanner;

import com.jsp.one_to_one_bidirection.dto.Employee;
import com.jsp.one_to_one_bidirection.dto.Laptop;
import com.jsp.one_to_one_bidirection.service.LaptopService;

public class LaptopController {

	public static void main(String[] args) {
		while (true) {
			Scanner s = new Scanner(System.in);
			LaptopService service = new LaptopService();
			System.out.println("1.Insert\n2.Search\n3.Update\n4.Delete\n5.Display\n6.Exit");
			System.out.print("Enter your choice: ");
			int choice = s.nextInt();
			switch (choice) {
			case 1: {
				Laptop laptop = new Laptop();
				laptop.setLaptopId(204);
				laptop.setLaptopColor("white");
				laptop.setLaptopPrice(60000);

				Employee employee = new Employee();
				employee.setEmployeeId(104);
				employee.setEmployeeName("jitendra");
				employee.setEmployeeEmail("jitendra@gmal.com");
				laptop.setEmployee(employee);
				employee.setLaptop(laptop);
				service.saveLaptop(laptop);

			}
				break;
			case 2: {
				System.out.print("enter laptopId: ");
				Laptop laptop = service.searchLaptop(s.nextInt());
				if (laptop != null) {
					System.out.println("-------------laptop_details----------------");
					System.out.println("laptopId: " + laptop.getLaptopId());
					System.out.println("laptopcolor: " + laptop.getLaptopColor());
					System.out.println("laptopPrice: " + laptop.getLaptopPrice());
					System.out.println();
					System.out.println("................employee_details.................");
					System.out.println("employeeId: " + laptop.getEmployee().getEmployeeId());
					System.out.println("employeeName: " + laptop.getEmployee().getEmployeeName());
					System.out.println("employeeEmail: " + laptop.getEmployee().getEmployeeEmail());
				} else {
					System.out.println("laptopId not found in database");
				}
			}
				break;
			case 3: {
				Laptop laptop = new Laptop();
				laptop.setLaptopId(204);
				laptop.setLaptopColor("gblue");
				laptop.setLaptopPrice(75000);

				Employee employee = new Employee();
				employee.setEmployeeId(104);
				employee.setEmployeeName("safiq");
				employee.setEmployeeEmail("safiqr@gmal.com");
				laptop.setEmployee(employee);
				employee.setLaptop(laptop);
				service.updateLaptop(laptop);
			}
				break;
			case 4: {
				System.out.print("enter laptopId: ");
				service.deleteLaptop(s.nextInt());

			}
				break;
			case 5: {
				List<Laptop> list = service.dispalyAllLaptop();
				for (Laptop laptop : list) {
					System.out.println("-------------laptop_details----------------");
					System.out.println("laptopId: " + laptop.getLaptopId());
					System.out.println("laptopcolor: " + laptop.getLaptopColor());
					System.out.println("laptopPrice: " + laptop.getLaptopPrice());
					System.out.println();
					System.out.println("................employee_details.................");
					System.out.println("employeeId: " + laptop.getEmployee().getEmployeeId());
					System.out.println("employeeName: " + laptop.getEmployee().getEmployeeName());
					System.out.println("employeeEmail: " + laptop.getEmployee().getEmployeeEmail());
					System.out.println();
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