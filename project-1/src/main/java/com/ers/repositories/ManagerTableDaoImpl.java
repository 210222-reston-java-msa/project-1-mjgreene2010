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

public class ManagerTableDaoImpl implements ManagerTableDao{
	
	private static Logger log = Logger.getLogger(ManagerTable.class);

	@Override
	public boolean insert(ManagerTable mt) {
		
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		
		try {
			
			Connection conn = ConnectionUtil.getConnection();
			
			String sql = "INSERT INTO manager (resolved_manager, reimbursment_id) VALUES ( ?, ? )";
			String sql2 = "INSERT INTO reimbursement (status) VALUES (?)";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, mt.getEmployee().getId());
			stmt.setInt(2, mt.getReimbursement().getId());
			
			stmt2 = conn.prepareStatement(sql2);
			stmt2.setString(1, mt.getReimbursement().getStatus());
			
			if(!stmt.execute() && !stmt2.execute()) {
				return false;
			}
			
		} catch (SQLException e) {
			
			log.warn("Unable to insert into manager's table", e);
			return false;	
		}
		return true;
	}

	@Override
	public boolean update(ManagerTable mt) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ManagerTable> findAll() {
		
		List<ManagerTable> managerList = new ArrayList<ManagerTable>();
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			
			String sql = "SELECT * FROM manager FULL JOIN reimbursement ON manager.reimbursement_id = reimbursement.id";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			
			ResultSet rs = stmt.executeQuery();
			
				while(rs.next()) {
					
				int id = rs.getInt("id");
				String resolve_date = rs.getString("resolved_date");
				int reimbursement_id = rs.getInt("reimbursement_id");
				int id2 = rs.getInt("id");
				String posting_date = rs.getString("posting_date");
				Double amount = rs.getDouble("amount");
				String reimbursement_type = rs.getString("reimbursement_type");
				String description = rs.getString("description");
				String status = rs.getString("status");
				String employee_id = rs.getString("employee_id");
				
				Employee em = new Employee(Integer.parseInt(employee_id));
				Reimbursement r = new Reimbursement(id2, posting_date, amount, reimbursement_type, description, status, employee_id);
				ManagerTable mt = new ManagerTable(id, resolve_date, em, reimbursement_id , r);
				
				managerList.add(mt);
				}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return managerList;
	}

	@Override
	public void delete(ManagerTable mt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean insert(Employee em, Reimbursement r) {

		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		
		try {
			
			Connection conn = ConnectionUtil.getConnection();
			
			String sql = "INSERT INTO manager (resolved_manager, reimbursment_id) VALUES ( ?, ? )";
			String sql2 = "INSERT INTO reimbursement (status) VALUES (?)";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, em.getId());
			stmt.setInt(2, r.getId());
			
			stmt2 = conn.prepareStatement(sql2);
			stmt2.setString(1, r.getStatus());
			
			if(!stmt.execute() && !stmt2.execute()) {
				return false;
			}
			
		} catch (SQLException e) {
			
			log.warn("Unable to insert into manager's table", e);
			return false;	
		}
		return true;
		
	}
	
	

}
