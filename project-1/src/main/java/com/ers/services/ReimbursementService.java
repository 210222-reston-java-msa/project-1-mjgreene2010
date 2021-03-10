package com.ers.services;

import java.util.List;

import com.ers.models.Reimbursement;
import com.ers.repositories.ReimbursementDao;
import com.ers.repositories.ReimbursementDaoImpl;

public class ReimbursementService {
	
	public static ReimbursementDao rDao = new ReimbursementDaoImpl();
	
	public static boolean insert(Reimbursement r) {
		
		return rDao.insert(r);	
	}
	
	public static boolean update(Reimbursement r) {
	
		return rDao.update(r);	
	}

	public static List<Reimbursement> findAll(){
	return rDao.findAll();
	}
	
	public static Reimbursement findByEmployeeId(int employeeId) {
		
		List<Reimbursement> all = rDao.findAll();
		
		for(Reimbursement r : all) {
			if (r.getEmployee().getId() == employeeId) {
				return r;
			}
		}
		return null;
	}
}
