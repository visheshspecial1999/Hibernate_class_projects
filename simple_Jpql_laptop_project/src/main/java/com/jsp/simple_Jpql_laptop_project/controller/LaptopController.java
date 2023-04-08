package com.jsp.simple_Jpql_laptop_project.controller;

import java.util.List;
import java.util.Scanner;

import com.jsp.simple_Jpql_laptop_project.dto.Laptop;
import com.jsp.simple_Jpql_laptop_project.service.LaptopService;

public class LaptopController {

	public static void main(String[] args) {

		while (true) {
			Scanner s = new Scanner(System.in);
			LaptopService service = new LaptopService();
			System.out.println("1.Insert\n2.GetById\n3.Update\n4.Delete\n5.Display\n6.Exit");
			System.out.print("enter your choice: ");
			int choice = s.nextInt();
			switch (choice) {
			case 1: {
				Laptop laptop = new Laptop();
				System.out.print("enter laptopId: ");
				laptop.setLaptopId(s.nextInt());
				System.out.print("enter laptopName: ");
				String laptopName = s.next();
				laptopName += s.nextLine();
				laptop.setLaptopName(laptopName);
				System.out.println("enter laptopPrice: ");
				laptop.setLaptopPrice(s.nextDouble());
				service.insertLaptop(laptop);
			}
				break;

			case 2: {
				System.out.print("enter laptopId: ");
				Laptop laptop = service.getByLaptopId(s.nextInt());
				if (laptop != null) {
					System.out.println("laptopId: " + laptop.getLaptopId());
					System.out.println("laptopName: " + laptop.getLaptopName());
					System.out.println("laptopPrice: " + laptop.getLaptopPrice());
				} else {
					System.out.println("laptopId is not present in database");
				}
			}
				break;
			case 3: {
				Laptop laptop = new Laptop();
				System.out.print("enter laptopId: ");
				laptop.setLaptopId(s.nextInt());
				System.out.print("enter laptopName: ");
				String laptopName = s.next();
				laptopName += s.nextLine();
				laptop.setLaptopName(laptopName);
				System.out.println("enter laptopPrice: ");
				laptop.setLaptopPrice(s.nextDouble());
				service.updateLaptop(laptop);
			}
				break;
			case 4: {
				System.out.print("enter laptopId: ");
				service.deleteLaptop(s.nextInt());
			}
				break;
			case 5: {
				List<Laptop> list = service.displayLaptop();
				System.out.println("...........................laptop-details.........................");
				for (Laptop laptop : list) {
					System.out.println("laptopId: " + laptop.getLaptopId());
					System.out.println("laptopName: " + laptop.getLaptopName());
					System.out.println("laptopPrice: " + laptop.getLaptopPrice());
					System.out.println();
				}
			}
				break;
			case 6: {
				System.out.println("System closed successfully...");
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
