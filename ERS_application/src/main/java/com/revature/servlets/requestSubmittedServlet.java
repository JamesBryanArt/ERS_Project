package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.jamesartacho.dao.ReimbursementDAOImpl;
import com.revature.jamesartacho.model.Employee;

/**
 * Servlet implementation class requestSubmittedServlet
 */
public class requestSubmittedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public requestSubmittedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReimbursementDAOImpl rdao = new ReimbursementDAOImpl();
		HttpSession session = request.getSession();
		
		Employee emp = new Employee();
		emp = (Employee)session.getAttribute("employee");
		
		response.setContentType("text/html");
		String html = "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Employee Page</title>\r\n"
				+ "<!-- BOOTSTRAP -->\r\n"
				+ " <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
				+ "  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\r\n"
				+ "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n"
				+ "  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "\r\n"
				+ "<nav class=\"navbar navbar-inverse\">\r\n"
				+ "  <div class=\"container-fluid\">\r\n"
				+ "    <div class=\"navbar-header\">\r\n"
				+ "      <a class=\"navbar-brand\" href=\"Employee\">ERS</a>\r\n"
				+ "    </div>\r\n"
				+ "    <ul class=\"nav navbar-nav\">\r\n"
				+ "      <li class=\"active\"><a href=\"Employee\">Home</a></li>\r\n"
				+ "      <li class=\"dropdown\"><a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">Reimbursement <span class=\"caret\"></span></a>\r\n"
				+ "        <ul class=\"dropdown-menu\">\r\n"
				+ "          <li><a href=\"request\">Request</a></li>\r\n"
				+ "          <li><a href=\"viewPending\">View Pending</a></li>\r\n"
				+ "          <li><a href=\"viewResolved\">View Resolved</a></li>\r\n"
				+ "        </ul>\r\n"
				+ "      </li>\r\n"
				+ "      <li class=\"dropdown\"><a class=\"dropdwon-toggle\" data-toggle=\"dropdown\" href=\"#\">My Info<span class=\"caret\"></span></a>\r\n"
				+ "        <ul class=\"dropdown-menu\">\r\n"
				+ "          <li><a href=\"viewMyInfo\">View info</a></li>\r\n"
				+ "          <li><a href=\"updateMyInfo\">Update info</a></li>\r\n"
				+ "        </ul>\r\n"
				+ "      </li>\r\n"
				+ "      <li><a href=\"about\">About</a></li>\r\n"
				+ "      <li><a href=\"logout\">Logout</a></li>\r\n"
				+ "    </ul>\r\n"
				+ "    \r\n"
				+ "  </div>\r\n"
				+ "</nav>\r\n"
				+ "\r\n";
		
		String html2 = "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Employee Page</title>\r\n"
				+ "<!-- BOOTSTRAP -->\r\n"
				+ " <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
				+ "  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\r\n"
				+ "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n"
				+ "  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "\r\n"
				+ "<nav class=\"navbar navbar-inverse\">\r\n"
				+ "  <div class=\"container-fluid\">\r\n"
				+ "    <div class=\"navbar-header\">\r\n"
				+ "      <a class=\"navbar-brand\" href=\"AdminView\">ERS</a>\r\n"
				+ "    </div>\r\n"
				+ "    <ul class=\"nav navbar-nav\">\r\n"
				+ "      <li class=\"active\"><a href=\"AdminView\">Home</a></li>\r\n"
				+ "      <li class=\"dropdown\"><a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">Reimbursement <span class=\"caret\"></span></a>\r\n"
				+ "        <ul class=\"dropdown-menu\">\r\n"
				+ "          <li><a href=\"request\">Request</a></li>\r\n"
				+ "          <li><a href=\"viewPending\">View Pending</a></li>\r\n"
				+ "          <li><a href=\"viewResolved\">View Resolved</a></li>\r\n"
				+ "        </ul>\r\n"
				+ "      </li>\r\n"
				+ "      <li class=\"dropdown\"><a class=\"dropdwon-toggle\" data-toggle=\"dropdown\" href=\"#\">My Info<span class=\"caret\"></span></a>\r\n"
				+ "        <ul class=\"dropdown-menu\">\r\n"
				+ "          <li><a href=\"viewMyInfo\">View info</a></li>\r\n"
				+ "          <li><a href=\"updateMyInfo\">Update info</a></li>\r\n"
				+ "        </ul>\r\n"
				+ "      </li>\r\n"
				+ "      <li><a href=\"about\">About</a></li>\r\n"
				+ "      <li><a href=\"logout\">Logout</a></li>\r\n"
				+ "    </ul>\r\n"
				+ "    \r\n"
				+ "  </div>\r\n"
				+ "</nav>\r\n"
				+ "\r\n";
				
				
		
		
		String success ="<div class=\"container\">\r\n"
				+ "  <h2>Submitted</h2>\r\n"
				+ "  <div class=\"alert alert-success\">\r\n"
				+ "    <strong>Success!</strong> we will notify you once your request has been resolved.\r\n"
				+ "  </div>"
				+ "</body> ";
		
		String failed ="<div class=\"container\">\r\n"
				+ "  <h2>Failed</h2>\r\n"
				+ "  <div class=\"alert alert-danger\">\r\n"
				+ "    <strong>Failed!</strong> Please fill out the required filled.\r\n"
				+ "  </div>"
				
				+"        <div class=\"container\">\r\n"
				+ "            \r\n"
				+ "            <h2>Request Reimbursement</h2>\r\n"
				+ "            <p>Please specify the purpose of the claim and amount</p>\r\n"
				+ "            \r\n"
				+ "            <form action=\"requestSubmitted\" method=\"POST\">\r\n"
				+ "              <div class=\"form-group\">\r\n"
				+ "                <label for=\"usr\">Purpose:</label>\r\n"
				+ "                <input type=\"text\" class=\"form-control\" id=\"purp\" name=\"prp\">\r\n"
				+ "              </div>\r\n"
				+ "              <div class=\"form-group\">\r\n"
				+ "                <label for=\"pwd\">Amount:</label>\r\n"
				+ "                <input type=\"number\" class=\"form-control\" id=\"amnt\" name=\"amt\">\r\n"
				+ "              </div>\r\n"
				+ "\r\n"
				+ "              <button type=\"submit\" class=\"btn btn-success\" data-toggle=\"tooltip\" title=\"SUBMIT\">Submit</button>\r\n"
				+ "            </form>\r\n"
				+ "          </div>\r\n"
				+ "          "
				+ "</body> ";
		
		PrintWriter out = response.getWriter();
		
		if(emp.getEmp_type().equals("user")) {
			out.print(html);
		}
		else {
			out.print(html2);	
		}
		
		String purpose = request.getParameter("prp");
		String samnt = request.getParameter("amt");
		
		
		
		
		if(purpose.equals("") || samnt.equals("")) {
			out.print(failed);
		}
		else {
			Double at = Double.parseDouble(samnt);
			out.print(success);
			
			System.out.println(rdao.requestReimburse(purpose, at, emp.getEmp_id()));
		}
		
		
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

}
