package com.ers.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ers.models.Employee;
import com.ers.models.LoginCredentials;
import com.ers.services.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RequestHelper {
	
	private static Logger log = Logger.getLogger(RequestHelper.class);
	
	private static ObjectMapper om = new ObjectMapper();
	
	public static void processLogin(HttpServletRequest req, HttpServletResponse res) throws IOException {
		//turn info we receive as the request into a string to process
		BufferedReader reader = req.getReader();
		StringBuilder s = new StringBuilder();
		
		//Transfer everything from our reader to our string builder
		String line = reader.readLine();
		while (line != null) {
			s.append(line);
			line = reader.readLine();
		}
		
		//body that represents our request in string format
		String body = s.toString();
		log.info(body);
		
		//Build a model call LoginCredentials which holds a username and password (from JSON --> Java Object)
		LoginCredentials loginAttempt = om.readValue(body, LoginCredentials.class);
		
		String username = loginAttempt.getUsername();
		String password = loginAttempt.getPassword();
		
		log.info("User attempted to login with username " + username);
		Employee e = EmployeeService.confirmLogin(username, password);
		
		if (e != null) {
			//get the current session or create one if it doesn't exist
			HttpSession session = req.getSession();
			session.setAttribute("username", username);
			
			PrintWriter pw = res.getWriter();
			res.setContentType("application/json");
			
			//this is converting our Java Object (with property firstName!) to JSON format ... that means we can grab the firstName property after we parse it
			pw.println(om.writeValueAsString(e));
			
			log.info(username + " has successfully logged in");	
		} else {
			res.setStatus(204);//have a connection but no user
		}
		
	}
		
	public static void processLogout(HttpServletRequest req, HttpServletResponse res) throws IOException {
			
			HttpSession  session = req.getSession(false);//I'm capturing the session, but if there isn't one, I don't create a new one
			
			log.info("Processing logout");
			
			if (session != null) {
				String username = (String) session.getAttribute("username");
				log.info(username + " has logged out" );
				
				session.invalidate();
			}
			
			res.setStatus(200);
		}
		
	public static void processEmployees(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		//The method's purpose is to return all Employees from the DB in JSON form
		
		//1. Set the content type to app/json because we will be sending json data back to the client, alongside the response
		
		res.setContentType("application/json");
		
		//2. Get a list of all Employees in the DB
		
		List<Employee> allEmps = EmployeeService.findAll();
		
		//3. Turn the list of Java Objects into a JSON string
		String json = om.writeValueAsString(allEmps);
		
		//4. Use getWriter() from the response object to return the json string
		PrintWriter pw = res.getWriter();
		pw.println(json);
		
	}

}
