package com.ers.repositories;

import java.util.List;

import com.ers.models.Employee;

//Dao is for CRUD methods (insert, select, update, delete)
//Design pattern to separate business logic(java) from our persistence layer

public interface EmployeeDao {
	
	public boolean insert(Employee e);
	
	public boolean update(Employee e);
	
	public List<Employee> findAll();
}
