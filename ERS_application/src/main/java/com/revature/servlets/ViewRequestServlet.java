package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.jamesartacho.dao.EmployeeDAOImpl;
import com.revature.jamesartacho.model.Employee;

/**
 * Servlet implementation class ViewRequestServlet
 */
public class ViewRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeeDAOImpl edao = new EmployeeDAOImpl();
		List<Employee> eList;
		
		eList = edao.selectAllEmployee();
		
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
				
				// SEARCH BAR & FORM SUBMIT
				+"<div class=\"container\">\r\n"
				+"  <h2>Search Employee</h2>\r\n"
				+ "  <p>Type something in the input field to search the table for first names, last names or emails:</p>  \r\n"
				+ "  <input class=\"form-control\" id=\"myInput\" type=\"text\" placeholder=\"Search..\">\r\n"
				
				+"       <div class=\"container\">\r\n"
				+ "          <form action=\"ProcessViewRequest\" method=\"POST\">\r\n"
				+"  <h4>Enter Employee ID #: </h2>\r\n"
				
				+ "          <input type=\"number\" name=\"eid\">\r\n"
				+ "      </div>"
				+"       <div class=\"container\">\r\n"
				+ "          <button type=\"submit\" class=\"btn btn-primary\">Primary</button>\r\n"
				+ "        </form>\r\n"
			
				
				+ "  <br>"
				
				//VIEW ALL EMPLOYEE TABLE
				
				+ "            <h2>Employees</h2>\r\n"
				+ "            <p>List of Associates</p>            \r\n"
				+ "            <table class=\"table table-hover\">\r\n"
				+ "              <thead>\r\n"
				+ "                <tr>\r\n"
				+ "                  <th>Employee ID</th>\r\n"
				+ "                  <th>First Name</th>\r\n"
				+ "                  <th>Last Name</th>\r\n"
				+ "                  <th>Address</th>\r\n"
				+ "                  <th>Email</th>\r\n"
				+ "                </tr>\r\n"
				+ "              </thead>\r\n"
				+ "              <tbody id=\"data\">\r\n"
				+ "              \r\n"
				+ "                \r\n"
				+ "              </tbody>\r\n"
				+ "            </table>\r\n"
				+ "          </div>\r\n"
				+ "          \r\n"
				+ "    </body>";
		
		PrintWriter out = response.getWriter();
		out.print(html);
		
		for(Employee e: eList) {
			out.print("<script>\r\n"
					+ "            var DisplayData = function(){\r\n"
					+ "            var newData = document.getElementById(\"data\");\r\n"
					+ "            var newTr = document.createElement(\"tr\");\r\n"
					+ "            var newTd = document.createElement(\"td\");\r\n"
					+ "  \r\n"
					+ "            newData.appendChild(newTr);\r\n"
					+ "  \r\n"
					+ "            newTr.appendChild(newTd);\r\n"
					+ "            newTd.innerHTML=\""+e.getEmp_id()+"\";\r\n"
					+ "  \r\n"
					+ "            var newTd = document.createElement(\"td\");\r\n"
					+ "            newTr.appendChild(newTd);\r\n"
					+ "            newTd.innerHTML=\""+e.getEmp_fname()+"\";\r\n"
					+ "  \r\n"
					+ "            var newTd = document.createElement(\"td\");\r\n"
					+ "            newTr.appendChild(newTd);\r\n"
					+ "            newTd.innerHTML=\""+e.getEmp_lname()+"\";\r\n"
					+ "  \r\n"
					+ "            var newTd = document.createElement(\"td\");\r\n"
					+ "            newTr.appendChild(newTd);\r\n"
					+ "            newTd.innerHTML=\""+e.getEmp_address()+"\";\r\n"
					+ "  \r\n"
					+ "            var newTd = document.createElement(\"td\");\r\n"
					+ "            newTr.appendChild(newTd);\r\n"
					+ "            newTd.innerHTML=\""+e.getEmp_email()+"\";\r\n"
					+ "            }();\r\n"
					+ "  \r\n"
					+ "          </script>");
		}
		
		String search = "<script>\r\n"
				+ "$(document).ready(function(){\r\n"
				+ "  $(\"#myInput\").on(\"keyup\", function() {\r\n"
				+ "    var value = $(this).val().toLowerCase();\r\n"
				+ "    $(\"#data tr\").filter(function() {\r\n"
				+ "      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)\r\n"
				+ "    });\r\n"
				+ "  });\r\n"
				+ "});\r\n"
				+ "</script>";
		out.print(search);
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
