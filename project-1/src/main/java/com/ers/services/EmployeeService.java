package com.ers.services;

import java.util.List;

import com.ers.models.Employee;
import com.ers.repositories.EmployeeDao;
import com.ers.repositories.EmployeeDaoImpl;

public class EmployeeService {
	
	//Dao and DaoImpl only works with the database
	
	public static EmployeeDao empDao = new EmployeeDaoImpl();
	
	public static boolean insert(Employee e) {
		return new EmployeeDaoImpl().insert(e);
	}
	
	public static boolean update(Employee e) {
		return empDao.update(e);
	}
	
	public static List<Employee> findAll() {
		return empDao.findAll();
	}
	
	public static Employee findByUsername(String username) {
		List<Employee> allEmp = empDao.findAll();
		
		for (Employee e : allEmp) {
			if (e.getUsername().equals(username)) {
				return e;	
			}
		}
		return null;
	}
	
	public static Employee confirmLogin(String username, String password) {
		
		//from the method above
		Employee e = findByUsername(username);
		
		if (e == null) return null;
		
		return (e.getPassword().equals(password)) ? e : null;
	}

}
