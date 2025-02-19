package com.ers.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ers.models.Employee;
import com.ers.util.ConnectionUtil;

//This is where we write some statements (prepared)
public class EmployeeDaoImpl implements EmployeeDao{
	
	private static final Logger log = Logger.getLogger(EmployeeDaoImpl.class);

	@Override
	public boolean insert(Employee e) {
		
		PreparedStatement stmt = null;
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			
			String sql = "INSERT INTO employee (first_name, last_name, username, pass_word, is_manager) VALUES (?, ?, ?, ?, ?)";
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, e.getFirstName());
			stmt.setString(2, e.getLastName());
			stmt.setString(3, e.getUsername());
			stmt.setString(4, e.getPassword());
			stmt.setBoolean(5, e.getIsManager());;
			
			if (!stmt.execute()) {
				return false;
			}
			
		} catch (SQLException ex) {
			log.warn("Unable to insert employee", ex);
			return false;
		}
		
		return true;
	}

	@Override
	public boolean update(Employee e) {
		return false;
	}

	@Override
	public List<Employee> findAll() {
		
		List<Employee> list = new ArrayList<Employee>();
		
		try {
			
			Connection conn = ConnectionUtil.getConnection();
			
			String sql = "SELECT * FROM employee";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String username = rs.getString("username");
				String password = rs.getString("pass_word");
				Boolean isManager = rs.getBoolean("is_manager");
				
				Employee e = new Employee(id, first_name, last_name, username, password, isManager);
				
				list.add(e);
				
				
			}
			
		} catch (SQLException ex) {
			
			log.warn("Unable to retrieve list of employees", ex);
			
			
		}
		return list;
	}

}
