package com.ers.services;

import java.util.List;

import com.ers.models.Employee;
import com.ers.models.ManagerTable;
import com.ers.models.Reimbursement;
import com.ers.repositories.ManagerTableDao;
import com.ers.repositories.ManagerTableDaoImpl;
import com.ers.repositories.ReimbursementDao;
import com.ers.repositories.ReimbursementDaoImpl;

public class ManagerTableService {
	
	public static ManagerTableDao mtDao = new ManagerTableDaoImpl();
	public static ReimbursementDao rDao = new ReimbursementDaoImpl();
	
	public static boolean insert(ManagerTable mt) {
		
		return mtDao.insert(mt);
	};
	
//public static boolean addExpense(double amount, String reimbursementType, String description, Employee e) {
//		
//		return rDao.insert(amount, reimbursementType, description, e);	
//	}
	
	public static boolean approveDeny(int resolveManagerId, Reimbursement r1, Reimbursement r2) {
		return mtDao.insert(resolveManagerId, r1) && rDao.insert(r2);
	}
	
	public static boolean update(ManagerTable mt) {
		return mtDao.update(mt);
	};
	
	public static List<ManagerTable> findAll() {
		return mtDao.findAll();
	}
	
public static ManagerTable findByEmployeeId(Employee e) {
		
		List<ManagerTable> all = mtDao.findAll();
		
		for(ManagerTable mt : all) {
			if (mt.getReimbursement().getEmployee().getId() == e.getId()) {
				return mt;
			}
		}
		return null;
	}


public static ManagerTable findByReimbursementId(Reimbursement r) {
	
	List<ManagerTable> all = mtDao.findAll();
	
	for(ManagerTable mt : all) {
		if (mt.getReimbursement().getId() == r.getId()) {
			return mt;
		}
	}
	return null;
}


public static ManagerTable confirmManagerDecision( int resolved_manager, Reimbursement reimbursementId, Reimbursement reimbursementStatus) {
	
	ManagerTable mt = findByReimbursementId(reimbursementId);
	
	if (mt == null) {
		return null;
	}
	
	if (mt.getResolveManagerId() == (resolved_manager) && (mt.getReimbursement().equals(reimbursementId)) /*&& mt.getReimbursement().equals(reimbursementStatus)*/ ){
		return mt;
	} else {
		return null;
		
	}


}


	
}

//public static Reimbursement confirmExpPost(double amount, String reimbursementType, String description, Employee employeeId) {
//	
//	//from the method above
//	Reimbursement r = findByEmployeeId(employeeId);
//	
//	if (r == null) {
//		return null;
//	}
//	
//	if (r.getAmount() == (amount) && r.getReimbursementType().equals(reimbursementType) && r.getDescription().equals(description)) {
//		return r;
//	} else {
//		return null;
//	}
//}
