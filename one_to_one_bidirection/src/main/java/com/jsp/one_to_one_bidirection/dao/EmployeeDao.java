package com.jsp.one_to_one_bidirection.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.one_to_one_bidirection.dto.Employee;

public class EmployeeDao {
EntityManager entityManager=Persistence.createEntityManagerFactory("vishesh").createEntityManager();public EmployeeDao() {
	
}
	// saveEmployee method
	public void saveEmployee(Employee employee) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		System.out.println("data inserted");
	}
	
	// searchEmployee method
	public Employee searchEmployee(int employeeId) {
		Employee employee=entityManager.find(Employee.class, employeeId);
		return employee;
	}
	
	// updateEmployee method
	public void  updateEmployee(Employee employee) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(employee);
		entityTransaction.commit();
		System.out.println("data updated");
	}
	
	// deleteEmployee method
	public void deleteEmployee(int employeeId) {
		Employee employee=entityManager.find(Employee.class, employeeId);
		if(employee!=null) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(employee);
		entityTransaction.commit();
		System.out.println("data deleted");
		}
		else {
			System.out.println("id not found in database");
		}
	}
	
	// displayAllEmployee method
	public List<Employee> displayAllEmployee(){
		String st="SELECT c FROM Employee c";
		Query query=entityManager.createQuery(st);
		return query.getResultList();
	}
}
