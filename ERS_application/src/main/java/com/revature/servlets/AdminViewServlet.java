package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.jamesartacho.dao.EmployeeDAOImpl;
import com.revature.jamesartacho.model.Employee;

/**
 * Servlet implementation class AdminViewServlet
 */
public class AdminViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Employee emp = new Employee();
		emp = (Employee)session.getAttribute("employee");
		
		//CHECK FOR UPDATED EMPLOYEE 
		EmployeeDAOImpl eDao = new EmployeeDAOImpl();
		Employee emp1 = new Employee();
		emp1 = eDao.selectEmployee(emp.getEmp_id());
		
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
				+ "      <a class=\"navbar-brand\" href=\"#\">ERS</a>\r\n"
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
				+ "\r\n"
				
				//ADMIN MENUS
				
				+ "       <div class=\"container\">\r\n"
				+ "            <div class=\"jumbotron\">\r\n"
				+ "              <h1>Welcome "+emp1.getEmp_fname()+"</h1>      \r\n"
				+ "              <p id=\"dateHere\"></p>\r\n"
				+ "            </div>\r\n"
				+ "\r\n"
				+ "            <div class=\"container\">\r\n"
				+ "                <h2><strong>ADMIN OPTIONS</strong></h2>\r\n"
				+ "                <p>Please choose one of the following options:</p>\r\n"
				+ "                <div class=\"btn-group btn-group-justified\">\r\n"
				+ "                  <a href=\"ApproveDeny\" class=\"btn btn-primary\">Approve/Deny Reimbursement</a>\r\n"
				+ "                  <a href=\"Resolved\" class=\"btn btn-warning\">View all Resolved</a>\r\n"
				+ "                  <a href=\"ViewRequest\" class=\"btn btn-info\">View Request Reimbursement</a>\r\n"
				+ "                  <a href=\"ViewAllEmployee\" class=\"btn btn-danger\">View all Employees</a>\r\n"
				+ "                </div>\r\n"
				+ "              </div>    \r\n"
				+ "          </div>"
				
		
				
				+ "</body> ";
		
		PrintWriter out = response.getWriter();
		out.print(html);
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
