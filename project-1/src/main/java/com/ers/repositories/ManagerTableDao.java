package com.ers.repositories;

import java.util.List;

import com.ers.models.Employee;
import com.ers.models.ManagerTable;
import com.ers.models.Reimbursement;

public interface ManagerTableDao {
	
		
		public boolean insert(ManagerTable mt);
		
		public boolean update(ManagerTable mt);
		
		public List<ManagerTable> findAll();
		
		public void delete(ManagerTable mt);
		
		public boolean insert(int resolveManagerId, Reimbursement rId);

	
}
