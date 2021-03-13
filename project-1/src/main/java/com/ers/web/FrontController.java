package com.ers.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.util.RequestHelper;

//a special servlet - it will take a request and then send it to a helper, who then processes the request
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public FrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Universal Resource Identifier //rewrite the URL's
		String URI = request.getRequestURI().replace("/project-1/", "");

		switch (URI) {
			case "login":
				RequestHelper.processLogin(request, response);
				break;
			case "logout":
				RequestHelper.processLogout(request, response);
				break;
			case "employees":
				RequestHelper.processEmployees(request, response);
				break;
			case "reimbursements":
				RequestHelper.processReimbursements(request, response);
				break;
			case "expensepost":
				RequestHelper.processExpense(request, response);
				break;
			case "managerpost":
				RequestHelper.processManagerDecision(request, response);
				break;
			case "managertable":
				RequestHelper.processManagerTable(request, response);
				break;
				
		}
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
