package com.ers.repositories;

import java.util.List;

import com.ers.models.Employee;
import com.ers.models.Reimbursement;


public interface ReimbursementDao {
	
	public boolean insert(Reimbursement r);
	
	public boolean update(Reimbursement r);
	
	public List<Reimbursement> findAll();
	
	public void delete(Reimbursement r);

	public boolean insert(double amount, String reimbursementType, String description, Employee e);

}
