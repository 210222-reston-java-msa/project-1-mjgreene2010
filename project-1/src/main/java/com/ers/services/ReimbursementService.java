package com.ers.services;

import java.util.List;

import com.ers.models.Employee;
import com.ers.models.Reimbursement;
import com.ers.repositories.ReimbursementDao;
import com.ers.repositories.ReimbursementDaoImpl;

public class ReimbursementService {
	
	public static ReimbursementDao rDao = new ReimbursementDaoImpl();
	
	public static boolean insert(Reimbursement r) {
		
		return rDao.insert(r);	
	}
	
	public static boolean addExpense(double amount, String reimbursementType, String description, Employee e) {
		
		return rDao.insert(amount, reimbursementType, description, e);	
	}
	
	public static boolean update(Reimbursement r) {
	
		return rDao.update(r);	
	}

	public static List<Reimbursement> findAll(){
	return rDao.findAll();
	}
	
	public static List<Reimbursement> findAllM() {
		return rDao.findAllM();
	}
 	
	@SuppressWarnings("unlikely-arg-type")
	public static Reimbursement findByEmployeeId(Employee e) {
		
		List<Reimbursement> all = rDao.findAll();
		
		for(Reimbursement r : all) {
			if (r.getEmployee().equals(e.getId())) {
				return r;
			}
		}
		return null;
	}
	
	
	

	
	public static Reimbursement confirmExpPost(double amount, String reimbursementType, String description, Employee employeeId) {
		
		//from the method above
		Reimbursement r = findByEmployeeId(employeeId);
	
		
		if (r == null) {
			return null;
		}
		
		if (r.getAmount() == (amount) && r.getReimbursementType().equals(reimbursementType) && r.getDescription().equals(description)) {
			return r;
		} else {
			return null;
		}
	}
		
	
}
