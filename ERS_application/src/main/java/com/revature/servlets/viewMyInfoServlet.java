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
 * Servlet implementation class viewMyInfoServlet
 */
public class viewMyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewMyInfoServlet() {
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
				
				
				
		
		PrintWriter out = response.getWriter();
		if(emp.getEmp_type().equals("user")) {
			out.print(html);
		}
		else {
			out.print(html2);	
		}
		
		//CHECK FOR UPDATED EMPLOYEE 
		EmployeeDAOImpl eDao = new EmployeeDAOImpl();
		Employee emp1 = new Employee();
		emp1 = eDao.selectEmployee(emp.getEmp_id());
		
		String admin = "        <div class=\"container\">\r\n"
				+ "            <h2>"+emp1.getEmp_fname()+"</h2>\r\n"
				+ "            <div>\r\n"
				+ "            <span class=\"label label-danger\">ADMIN</span>\r\n"
				+ "            </div>\r\n"
				+ "                   \r\n"
				+ "            <img src=\"E:\\My Projects\\ERS Project\\ERS_application\\src\\myPictures\\funny-cat.jpeg\" class=\"img-circle\" alt=\"myPicture\" width=\"304\" height=\"236\"> \r\n"
				+ "          </div>\r\n"
				+ "\r\n"
				+ "          <div class=\"container\">\r\n"
				+ "            <div class=\"page-header\">\r\n"
				+ "              <h1>My Info</h1>      \r\n"
				+ "            </div>\r\n"
				+ "            <div>\r\n"
				+ "                <h4><strong>Employee ID #:</strong>1</h4>\r\n"
				+ "                \r\n"
				+ "                <div class=\"panel-group\">\r\n"
				+ "                    <div class=\"panel panel-default\">\r\n"
				+ "                      <div class=\"panel-heading\">\r\n"
				+ "                        <h4 class=\"panel-title\">\r\n"
				+ "                          <a data-toggle=\"collapse\" href=\"#collapse1\">User Info</a>\r\n"
				+ "                        </h4>\r\n"
				+ "                      </div>\r\n"
				+ "                      <div id=\"collapse1\" class=\"panel-collapse collapse\">\r\n"
				+ "                        <div class=\"panel-body\"><strong>First Name: </strong>"+emp1.getEmp_fname()+"</div>\r\n"
				+ "                        <div class=\"panel-footer\"><strong>Last Name: </strong>"+emp1.getEmp_lname()+"</div>\r\n"
				+ "                        <div class=\"panel-body\"><strong>Address: </strong>"+emp1.getEmp_address()+"</div>\r\n"
				+ "                        <div class=\"panel-footer\"><strong>Email Address: </strong>"+emp1.getEmp_email()+"</div>\r\n"
				+ "                      </div>\r\n"
				+ "                    </div>\r\n"
				+ "                  </div>\r\n"
				+ "\r\n"
				+ "                  <div class=\"panel-group\">\r\n"
				+ "                    <div class=\"panel panel-default\">\r\n"
				+ "                      <div class=\"panel-heading\">\r\n"
				+ "                        <h4 class=\"panel-title\">\r\n"
				+ "                          <a data-toggle=\"collapse\" href=\"#collapse2\">Account Info</a>\r\n"
				+ "                        </h4>\r\n"
				+ "                      </div>\r\n"
				+ "                      <div id=\"collapse2\" class=\"panel-collapse collapse\">\r\n"
				+ "                        <div class=\"panel-body\"><strong>Username: </strong>"+emp.getUsr_name()+"</div>\r\n"
				+ "                        <div class=\"panel-footer\"><strong>Password: </strong>"+emp.getPass()+"</div>\r\n"
				+ "                        <div class=\"panel-body\"><strong>User type: </strong>"+emp.getEmp_type()+"</div>\r\n"
				+ "                      </div>\r\n"
				+ "                    </div>\r\n"
				+ "                  </div>\r\n"
				+ "\r\n"
				+ "        \r\n"
				+ "                \r\n"
				+ "          </div>\r\n"
				+ "\r\n"
				+ "    </body>";
		
		String user = " <div class=\"container\">\r\n"
				+ "            <h2>"+emp1.getEmp_fname()+"</h2>\r\n"
				+ "        \r\n"
				+ "                   \r\n"
				+ "            <img src=\"E:\\My Projects\\ERS Project\\ERS_application\\src\\myPictures\\funny-cat.jpeg\" class=\"img-circle\" alt=\"myPicture\" width=\"304\" height=\"236\"> \r\n"
				+ "          </div>\r\n"
				+ "\r\n"
				+ "          <div class=\"container\">\r\n"
				+ "            <div class=\"page-header\">\r\n"
				+ "              <h1>My Info</h1>      \r\n"
				+ "            </div>\r\n"
				+ "            <div>\r\n"
				+ "                <h4><strong>Employee ID #:</strong>1</h4>\r\n"
				+ "                \r\n"
				+ "                <div class=\"panel-group\">\r\n"
				+ "                    <div class=\"panel panel-default\">\r\n"
				+ "                      <div class=\"panel-heading\">\r\n"
				+ "                        <h4 class=\"panel-title\">\r\n"
				+ "                          <a data-toggle=\"collapse\" href=\"#collapse1\">User Info</a>\r\n"
				+ "                        </h4>\r\n"
				+ "                      </div>\r\n"
				+ "                      <div id=\"collapse1\" class=\"panel-collapse collapse\">\r\n"
				+ "                        <div class=\"panel-body\"><strong>First Name: </strong>"+emp1.getEmp_fname()+"</div>\r\n"
				+ "                        <div class=\"panel-footer\"><strong>Last Name: </strong>"+emp1.getEmp_lname()+"</div>\r\n"
				+ "                        <div class=\"panel-body\"><strong>Address: </strong>"+emp1.getEmp_address()+"</div>\r\n"
				+ "                        <div class=\"panel-footer\"><strong>Email Address: </strong>"+emp1.getEmp_email()+"</div>\r\n"
				+ "                      </div>\r\n"
				+ "                    </div>\r\n"
				+ "                  </div>\r\n"
				+ "\r\n"
				+ "                  <div class=\"panel-group\">\r\n"
				+ "                    <div class=\"panel panel-default\">\r\n"
				+ "                      <div class=\"panel-heading\">\r\n"
				+ "                        <h4 class=\"panel-title\">\r\n"
				+ "                          <a data-toggle=\"collapse\" href=\"#collapse2\">Account Info</a>\r\n"
				+ "                        </h4>\r\n"
				+ "                      </div>\r\n"
				+ "                      <div id=\"collapse2\" class=\"panel-collapse collapse\">\r\n"
				+ "                        <div class=\"panel-body\"><strong>Username: </strong>"+emp.getUsr_name()+"</div>\r\n"
				+ "                        <div class=\"panel-footer\"><strong>Password: </strong>"+emp.getPass()+"</div>\r\n"
				+ "                        <div class=\"panel-body\"><strong>User type: </strong>"+emp.getEmp_type()+"</div>\r\n"
				+ "                      </div>\r\n"
				+ "                    </div>\r\n"
				+ "                  </div>\r\n"
				+ "\r\n"
				+ "        \r\n"
				+ "                \r\n"
				+ "          </div>\r\n"
				+ "\r\n"
				+ "    </body>";
		
		if(emp.getEmp_type().equals("admin")) {
			out.print(admin);
		}
		else {
			out.print(user);
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
