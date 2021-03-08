package com.ers.util;
	
	import java.io.IOException;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.util.Properties;
	import org.apache.log4j.Logger;

//	import com.ers.models.Employee;
//	import com.ers.services.EmployeeService;

	public class ConnectionUtil {

		private static Logger log = Logger.getLogger(ConnectionUtil.class);

		public static Connection getConnection() {

			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				log.warn("Cannot load the driver");
				e.printStackTrace();
			}

			Properties props = new Properties();
			// it's an object (built into Java) used to search through our entire project
			// to find our connection.properties file to give us the connection credentials
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			Connection conn = null;
			

			try {
				//getResourceAsStream - load credentials as byte stream
				props.load(loader.getResourceAsStream("connection.properties"));
				String url = props.getProperty("url");
				String username = props.getProperty("username");
				String password = props.getProperty("password");
				
				
				try {
					conn = DriverManager.getConnection(url, username, password);
					log.info("connection successful");
				} catch (SQLException e) {
					log.warn("unable to obtain a connection to the database");
				}

			} catch (IOException ex) {
				ex.printStackTrace();
			}

			log.info("connected to db");
			return conn;
		}
		
//		public static void main(String[] args) {
//			Employee e = new Employee();
//			
//			EmployeeService.insert(e);
//		}

	}

