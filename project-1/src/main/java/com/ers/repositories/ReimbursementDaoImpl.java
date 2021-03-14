package com.ers.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ers.models.Employee;
import com.ers.models.ManagerTable;
import com.ers.models.Reimbursement;
import com.ers.util.ConnectionUtil;

public class ReimbursementDaoImpl implements ReimbursementDao {
	
	private static Logger log = Logger.getLogger(Reimbursement.class);

	@Override
	public boolean insert(Reimbursement r) {
		
		PreparedStatement stmt = null;
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			String sql = "INSERT INTO reimbursement (amount, reimbursement_type, description, employee_id) " +
						"VALUES ( ? , ? , ? , ? )";
			
			stmt = conn.prepareStatement(sql);
			stmt.setDouble(1, r.getAmount());
			stmt.setString(2, r.getReimbursementType());
			stmt.setString(3, r.getDescription());
			stmt.setInt(4, r.getEmployee().getId());
			
			if (!stmt.execute()) {
				return false;
			}
			
		} catch (SQLException e) {
			
			log.warn("Unable to insert expense", e);
			return false;
		}
		
		return true;
	}

	@Override
	public boolean update(Reimbursement r) {
		return false;
	}

	@Override
	public List<Reimbursement> findAll() {
		
		List<Reimbursement> expenseList = new ArrayList<Reimbursement>();
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			
			String sql = "SELECT * FROM reimbursement";
					
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				int id = rs.getInt("id");
				String posting_date = rs.getString("posting_date");
				Double amount = rs.getDouble("amount");
				String reimbursement_type = rs.getString("reimbursement_type");
				String description = rs.getString("description");
				String status = rs.getString("status");
				String employee_id = rs.getString("employee_id");
		
			
			
			Employee em = new Employee(Integer.parseInt(employee_id));
			Reimbursement r = new Reimbursement(id, posting_date, amount, reimbursement_type, description, status, em);
			
			System.out.println(r);
			
			expenseList.add(r);
			}
			
		
		} catch (SQLException e) {
			
			log.warn("Unable to populate list of reimbursements", e);
//			return new ArrayList<Reimbursement>();
			
		}
		
		return expenseList;
	}

	@Override
	public Reimbursement delete() {
		return null;
	}

	@Override
	public boolean insert(double amount, String reimbursementType, String description, Employee em) {
		PreparedStatement stmt = null;
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			String sql = "INSERT INTO reimbursement (amount, reimbursement_type, description, employee_id) " +
						"VALUES ( ? , ? , ? , ? )";
			
			stmt = conn.prepareStatement(sql);
			stmt.setDouble(1, amount);
			stmt.setString(2, reimbursementType);
			stmt.setString(3, description);
			stmt.setInt(4, em.getId());
			
			if (!stmt.execute()) {
				return false;
			}
			
		} catch (SQLException e) {
			
			log.warn("Unable to insert expense", e);
			return false;
		}
		
		return true;

	}

	@Override
	public List<Reimbursement> findAllM() {
		
			
			List<Reimbursement> managerList = new ArrayList<Reimbursement>();
			
			try {
				Connection conn = ConnectionUtil.getConnection();
				
				String sql = "SELECT * FROM reimbursement FULL JOIN manager ON reimbursement.id = manager.reimbursement_id ";
				
				PreparedStatement stmt = conn.prepareStatement(sql);
				
				
				ResultSet rs = stmt.executeQuery();
				
					while(rs.next()) {
						
						int id= rs.getInt("id");
						String posting_date = rs.getString("posting_date");
						Double amount = rs.getDouble("amount");
						String reimbursement_type = rs.getString("reimbursement_type");
						String description = rs.getString("description");
						String status = rs.getString("status");
						String employee_id = rs.getString("employee_id");
//						int id = rs.getInt("id");
						String resolve_date = rs.getString("resolved_date");
						int resolve_manager = rs.getInt("resolved_manager");
						int reimbursement_id = rs.getInt("reimbursement_id");
					
					
					
					Employee em = new Employee(Integer.parseInt(employee_id));
					ManagerTable mt = new ManagerTable(resolve_date, resolve_manager , reimbursement_id);
					Reimbursement r = new Reimbursement(id, posting_date, amount, reimbursement_type, description, status, mt, em);
				
					
					System.out.println(stmt);
					managerList.add(r);
					}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return managerList;
		}

	


	
	

}
