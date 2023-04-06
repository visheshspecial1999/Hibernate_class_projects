package com.jsp.one_to_one_bidirection.controller;

import java.util.List;
import java.util.Scanner;

import com.google.protobuf.Service;
import com.jsp.one_to_one_bidirection.dto.Employee;
import com.jsp.one_to_one_bidirection.dto.Laptop;
import com.jsp.one_to_one_bidirection.service.EmployeeService;

public class EmployeeController {

	public static void main(String[] args) {
		while (true) {
			Scanner s = new Scanner(System.in);
			EmployeeService service = new EmployeeService();
			System.out.println();
			System.out.println("1.Insert\n2.Search\n3.Update\n4.Delete\n5.Display\n6.Exit");
			System.out.print("enter your choice: ");
			int choice = s.nextInt();
			switch (choice) {
			case 1: {
				Employee employee = new Employee();
				employee.setEmployeeId(102);
				employee.setEmployeeName("Ashish");
				employee.setEmployeeEmail("ashish@gmail.com");

				Laptop laptop = new Laptop();
				laptop.setLaptopId(202);
				laptop.setLaptopColor("red");
				laptop.setLaptopPrice(20000);
				employee.setLaptop(laptop);
				service.saveEmployee(employee);
			}
			case 2: {
				System.out.println("enter employeeId: ");
				Employee employee = service.searchEmployee(s.nextInt());
				if (employee != null) {
					System.out.println("----------------employee-details---------------------");
					System.out.println("employeeId: " + employee.getEmployeeId());
					System.out.println("employeeName: " + employee.getEmployeeName());
					System.out.println("employeeEmail: " + employee.getEmployeeEmail());
					System.out.println();
					System.out.println(".................laptop-details----------------------");
					System.out.println("laptopId: " + employee.getLaptop().getLaptopId());
					System.out.println("laptopColor: " + employee.getLaptop().getLaptopColor());
					System.out.println("laptopPrice: " + employee.getLaptop().getLaptopPrice());
				} else {
					System.out.println("invalid employeeId or id has been deleted");
				}
			}
				break;

			case 3: {
				Employee employee = new Employee();
				employee.setEmployeeId(103);
				employee.setEmployeeName("suma");
				employee.setEmployeeEmail("sumn@gmail.com");

				Laptop laptop = new Laptop();
				laptop.setLaptopId(203);
				laptop.setLaptopColor("siver");
				laptop.setLaptopPrice(4000);
				employee.setLaptop(laptop);
				service.updateEmployee(employee);
			}
				break;

			case 4: {
				System.out.println("enter employeeId: ");
				service.deleteEmployee(s.nextInt());
			}
				break;

			case 5: {
				List<Employee> list = service.displayAllEmployee();
				for (Employee employee : list) {
					System.out.println("----------------employee-details---------------------");
					System.out.println("employeeId: " + employee.getEmployeeId());
					System.out.println("employeeName: " + employee.getEmployeeName());
					System.out.println("employeeEmail: " + employee.getEmployeeEmail());
					System.out.println();
					System.out.println(".................laptop-details----------------------");
					System.out.println("laptopId: " + employee.getLaptop().getLaptopId());
					System.out.println("laptopColor: " + employee.getLaptop().getLaptopColor());
					System.out.println("laptopPrice: " + employee.getLaptop().getLaptopPrice());
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