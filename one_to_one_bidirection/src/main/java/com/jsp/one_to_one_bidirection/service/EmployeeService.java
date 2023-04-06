package com.jsp.one_to_one_bidirection.service;

import java.util.List;

import com.jsp.one_to_one_bidirection.dao.EmployeeDao;
import com.jsp.one_to_one_bidirection.dto.Employee;

public class EmployeeService {

	EmployeeDao dao=new EmployeeDao();
	
	// saveEmployee method
		public void saveEmployee(Employee employee) {
			dao.saveEmployee(employee);
		}
		// searchEmployee method
		public Employee searchEmployee(int employeeId) {
			return dao.searchEmployee(employeeId);
		}
		
		// updateEmployee method
		public void  updateEmployee(Employee employee) {
			dao.updateEmployee(employee);
		}
		
		// deleteEmployee method
		public void deleteEmployee(int employeeId) {
			dao.deleteEmployee(employeeId);
		}
		
		// displayAllEmployee method
		public List<Employee> displayAllEmployee(){
			return dao.displayAllEmployee();
		}
}
