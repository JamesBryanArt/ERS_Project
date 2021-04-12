package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.jamesartacho.dao.ReimbursementDAOImpl;
import com.revature.jamesartacho.model.Employee;
import com.revature.jamesartacho.model.Pending;

/**
 * Servlet implementation class viewResolvedServlet
 */
public class viewResolvedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewResolvedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		ReimbursementDAOImpl rdao = new ReimbursementDAOImpl();
		List<Pending> penList;
		
		Employee emp = new Employee();
		emp = (Employee)session.getAttribute("employee");
		
		penList = rdao.viewResolved(emp.getEmp_id());

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
				+ "</body> "
		
				//TABLE
				+ "<div class=\"container\">\r\n"
				+ "            <h2>Resolved</h2>\r\n"
				+ "            <p>Contact staff if you have any concerns </p>\r\n"
				+ "            \r\n"
				+ "            <table class=\"table\">\r\n"
				+ "              <thead>\r\n"
				+ "                <tr>\r\n"
				+ "                  <th>#</th>\r\n"
				+ "                  <th>Employee ID</th>\r\n"
				+ "                  <th>Purpose</th>\r\n"
				+ "                  <th>Amount</th>\r\n"
				+ "                  <th>Status</th>\r\n"
				+ "                </tr>\r\n"
				+ "              </thead>\r\n"
				+ "              <tbody id=\"data\">    \r\n"
				+ "               \r\n"
				+ "              \r\n"
				+ "              </tbody>\r\n"
				+ "            </table>\r\n"
				+ "          </div>";
		
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
				+ "</body> "
		
				//TABLE
				+ "<div class=\"container\">\r\n"
				+ "            <h2>Resolved</h2>\r\n"
				+ "            <p>Contact staff if you have any concerns </p>\r\n"
				+ "            \r\n"
				+ "            <table class=\"table\">\r\n"
				+ "              <thead>\r\n"
				+ "                <tr>\r\n"
				+ "                  <th>#</th>\r\n"
				+ "                  <th>Employee ID</th>\r\n"
				+ "                  <th>Purpose</th>\r\n"
				+ "                  <th>Amount</th>\r\n"
				+ "                  <th>Status</th>\r\n"
				+ "                </tr>\r\n"
				+ "              </thead>\r\n"
				+ "              <tbody id=\"data\">    \r\n"
				+ "               \r\n"
				+ "              \r\n"
				+ "              </tbody>\r\n"
				+ "            </table>\r\n"
				+ "          </div>";
		
		PrintWriter out = response.getWriter();
		if(emp.getEmp_type().equals("user")) {
			out.print(html);
		}
		else {
			out.print(html2);	
		}
		
		for(Pending p : penList) {
			if(p.getStatus().equals("approved")) {
			out.print(" <script>\r\n"
					+ "            //approved\r\n"
					+ "            var displayApproved = function(){\r\n"
					+ "            var newData = document.getElementById(\"data\");\r\n"
					+ "         \r\n"
					+ "            var newTr = document.createElement(\"tr\");\r\n"
					+ "            newTr.className = \"success\";\r\n"
					+ "\r\n"
					+ "            var newTd = document.createElement(\"td\");\r\n"
					+ "\r\n"
					+ "            newData.appendChild(newTr);\r\n"
					+ "            newTr.appendChild(newTd);\r\n"
					+ "            \r\n"
					+ "            newTd.innerHTML=\""+p.getRid()+"\";\r\n"
					+ "\r\n"
					+ "            var newTd = document.createElement(\"td\");\r\n"
					+ "            newTr.appendChild(newTd);\r\n"
					+ "            newTd.innerHTML=\""+p.getEid()+"\";\r\n"
					+ "\r\n"
					+ "            var newTd = document.createElement(\"td\");\r\n"
					+ "            newTr.appendChild(newTd);\r\n"
					+ "            newTd.innerHTML=\""+p.getPurpose()+"\";\r\n"
					+ "\r\n"
					+ "            var newTd = document.createElement(\"td\");\r\n"
					+ "            newTr.appendChild(newTd);\r\n"
					+ "            newTd.innerHTML=\""+p.getAmount()+"\";\r\n"
					+ "\r\n"
					+ "            var newTd = document.createElement(\"td\");\r\n"
					+ "            newTr.appendChild(newTd);\r\n"
					+ "            newTd.innerHTML=\""+p.getStatus()+"\";\r\n"
					+ "\r\n"
					+ "         \r\n"
					+ "            }();\r\n"
					+ "            </script>");
			}
			else {
				
			}
				
		}
		
		for(Pending p : penList) {
			if(p.getStatus().equals("denied")) {
			out.print("<script>\r\n"
					+ "            //denied\r\n"
					+ "            var displayDenied = function(){\r\n"
					+ "            var newData = document.getElementById(\"data\");\r\n"
					+ "         \r\n"
					+ "            var newTr = document.createElement(\"tr\");\r\n"
					+ "            newTr.className = \"danger\";\r\n"
					+ "\r\n"
					+ "            var newTd = document.createElement(\"td\");\r\n"
					+ "\r\n"
					+ "            newData.appendChild(newTr);\r\n"
					+ "            newTr.appendChild(newTd);\r\n"
					+ "            \r\n"
					+ "            newTd.innerHTML=\""+p.getRid()+"\";\r\n"
					+ "\r\n"
					+ "            var newTd = document.createElement(\"td\");\r\n"
					+ "            newTr.appendChild(newTd);\r\n"
					+ "            newTd.innerHTML=\""+p.getEid()+"\";\r\n"
					+ "\r\n"
					+ "            var newTd = document.createElement(\"td\");\r\n"
					+ "            newTr.appendChild(newTd);\r\n"
					+ "            newTd.innerHTML=\""+p.getPurpose()+"\";\r\n"
					+ "\r\n"
					+ "            var newTd = document.createElement(\"td\");\r\n"
					+ "            newTr.appendChild(newTd);\r\n"
					+ "            newTd.innerHTML=\""+p.getAmount()+"\";\r\n"
					+ "\r\n"
					+ "            var newTd = document.createElement(\"td\");\r\n"
					+ "            newTr.appendChild(newTd);\r\n"
					+ "            newTd.innerHTML=\""+p.getStatus()+"\";\r\n"
					+ "            }();\r\n"
					+ "            \r\n"
					+ "          </script>");
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

}
