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
 * Servlet implementation class updateMyInfoServlet
 */
public class updateMyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateMyInfoServlet() {
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
				+ "\r\n"
		
				//UPDATE FORM
				+"        <div class=\"container\">\r\n"
				+ "            \r\n"
				+ "            <h2>Update</h2>\r\n"
				+ "            <p>Update my information</p>\r\n"
				+ "            \r\n"
				+ "            <form action=\"updateSubmitted\" method=\"POST\" id=\"requestForm\">\r\n"
				+ "              <div class=\"form-group\">\r\n"
				+ "                <label for=\"fn\">First Name:</label>\r\n"
				+ "                <input type=\"text\" class=\"form-control\" id=\"fname\" name=\"fname\" placeholder=\""+emp1.getEmp_fname()+"\">\r\n"
				+ "              </div>\r\n"
				+ "              <div class=\"form-group\">\r\n"
				+ "                <label for=\"ln\">Last Name:</label>\r\n"
				+ "                <input type=\"text\" class=\"form-control\" id=\"lname\" name=\"lname\" placeholder=\""+emp1.getEmp_lname()+"\">\r\n"
				+ "              </div>\r\n"
				+ "\r\n"
				+ "              <div class=\"form-group\">\r\n"
				+ "                <label for=\"ad\">Address:</label>\r\n"
				+ "                <input type=\"text\" class=\"form-control\" id=\"adrs\" name=\"adrs\" placeholder=\""+emp1.getEmp_address()+"\">\r\n"
				+ "              </div>\r\n"
				+ "\r\n"
				+ "              <div class=\"form-group\">\r\n"
				+ "                <label for=\"em\">Email:</label>\r\n"
				+ "                <input type=\"text\" class=\"form-control\" id=\"eml\" name=\"eml\" placeholder=\""+emp1.getEmp_email()+"\">\r\n"
				+ "              </div>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "              <button type=\"submit\" class=\"btn btn-success\" data-toggle=\"tooltip\" title=\"SUBMIT\" >Update</button>\r\n"
				+ "            </form>\r\n"
				+ "          </div>\r\n"
				+ "\r\n"
				+ "          \r\n"
				+ "    </body>";
		
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
				+ "\r\n"
		
				//UPDATE FORM
				+"        <div class=\"container\">\r\n"
				+ "            \r\n"
				+ "            <h2>Update</h2>\r\n"
				+ "            <p>Update my information</p>\r\n"
				+ "            \r\n"
				+ "            <form action=\"updateSubmitted\" method=\"POST\" id=\"requestForm\">\r\n"
				+ "              <div class=\"form-group\">\r\n"
				+ "                <label for=\"fn\">First Name:</label>\r\n"
				+ "                <input type=\"text\" class=\"form-control\" id=\"fname\" name=\"fname\" placeholder=\""+emp1.getEmp_fname()+"\">\r\n"
				+ "              </div>\r\n"
				+ "              <div class=\"form-group\">\r\n"
				+ "                <label for=\"ln\">Last Name:</label>\r\n"
				+ "                <input type=\"text\" class=\"form-control\" id=\"lname\" name=\"lname\" placeholder=\""+emp1.getEmp_lname()+"\">\r\n"
				+ "              </div>\r\n"
				+ "\r\n"
				+ "              <div class=\"form-group\">\r\n"
				+ "                <label for=\"ad\">Address:</label>\r\n"
				+ "                <input type=\"text\" class=\"form-control\" id=\"adrs\" name=\"adrs\" placeholder=\""+emp1.getEmp_address()+"\">\r\n"
				+ "              </div>\r\n"
				+ "\r\n"
				+ "              <div class=\"form-group\">\r\n"
				+ "                <label for=\"em\">Email:</label>\r\n"
				+ "                <input type=\"text\" class=\"form-control\" id=\"eml\" name=\"eml\" placeholder=\""+emp1.getEmp_email()+"\">\r\n"
				+ "              </div>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "              <button type=\"submit\" class=\"btn btn-success\" data-toggle=\"tooltip\" title=\"SUBMIT\" >Update</button>\r\n"
				+ "            </form>\r\n"
				+ "          </div>\r\n"
				+ "\r\n"
				+ "          \r\n"
				+ "    </body>";
		
		PrintWriter out = response.getWriter();
		if(emp.getEmp_type().equals("user")) {
			out.print(html);
		}
		else {
			out.print(html2);	
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
