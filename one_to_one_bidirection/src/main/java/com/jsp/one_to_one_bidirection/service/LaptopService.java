package com.jsp.one_to_one_bidirection.service;

import java.util.List;

import com.jsp.one_to_one_bidirection.dao.LaptopDao;
import com.jsp.one_to_one_bidirection.dto.Laptop;

public class LaptopService {

	LaptopDao dao=new LaptopDao();
	
	// saveLaptop method
		public void saveLaptop(Laptop laptop) {
			dao.saveLaptop(laptop);
		}
		
		// searchLaptop method
		public Laptop searchLaptop(int laptopId) {
			return dao.searchLaptop(laptopId);
		}
		
		// updateLaptop method
		public void updateLaptop(Laptop laptop) {
			dao.updateLaptop(laptop);
		}
		
		// deleteLaptop method
		public void deleteLaptop(int laptopId) {
			dao.deleteLaptop(laptopId);
		}
		
		// displayLaptop method
		public List<Laptop> dispalyAllLaptop(){
			return dao.dispalyAllLaptop();
		}
}
