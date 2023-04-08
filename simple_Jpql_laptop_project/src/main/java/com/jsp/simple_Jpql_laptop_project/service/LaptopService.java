package com.jsp.simple_Jpql_laptop_project.service;

import java.util.List;

import com.jsp.simple_Jpql_laptop_project.dao.LaptopDao;
import com.jsp.simple_Jpql_laptop_project.dto.Laptop;

public class LaptopService {

	LaptopDao dao = new LaptopDao();

	// insertLaptop method
	public void insertLaptop(Laptop laptop) {
		if (dao.insertLaptop(laptop) == 1) {
			System.out.println("data inserted successfully");
		} else {
			System.out.println("data not saved in database.you  have passed wrong parameter");
		}
	}

	// getByLaptopId method
	public Laptop getByLaptopId(int laptopId) {
		return dao.getByLaptopId(laptopId);
	}

	// updateLaptop method
	public void updateLaptop(Laptop laptop) {
		int feedback = dao.updateLaptop(laptop);
		if (feedback == 1) {
			System.out.println("data updated successfully");
		} else {
			System.out.println("data not updated.please check laptopId");
		}
	}

	// deleteLaptop method
	public void deleteLaptop(int laptopId) {
		int feedback = dao.deleteLaptop(laptopId);
		if (feedback == 1) {
			System.out.println("data deleted successfully...");
		} else {
			System.out.println("laptopId not found.please check what you have passed");
		}
	}

	// displayLaptop method
	public List<Laptop> displayLaptop() {
		return dao.displayLaptop();
	}
}