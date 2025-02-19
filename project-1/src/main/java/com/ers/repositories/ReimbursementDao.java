package com.ers.repositories;

import java.util.List;

import com.ers.models.Employee;
import com.ers.models.ManagerTable;
import com.ers.models.Reimbursement;


public interface ReimbursementDao {
	
	public boolean insert(Reimbursement r);
	
	public boolean update(Reimbursement r);
	
	public List<Reimbursement> findAll();
	
	public List<Reimbursement> findAllM();
	
	public Reimbursement delete();

	public boolean insert(double amount, String reimbursementType, String description, Employee e);
	
	public boolean insert(ManagerTable mt, ManagerTable mt2, String status);

}
