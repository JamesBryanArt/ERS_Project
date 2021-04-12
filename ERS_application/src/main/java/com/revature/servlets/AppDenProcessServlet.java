package com.revature.servlets;

import java.io.IOException;


import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.revature.jamesartacho.dao.ReimbursementDAOImpl;
import com.revature.jamesartacho.model.Pending;

/**
 * Servlet implementation class AppDenProcessServlet
 */
public class AppDenProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static Logger log = LogManager.getLogger(AppDenProcessServlet.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppDenProcessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ReimbursementDAOImpl rdao = new ReimbursementDAOImpl();
		List<Pending> penList;
		penList = rdao.viewAllPending();
		
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
				+ "\r\n";
		PrintWriter out = response.getWriter();
		out.print(html);
		
		String seid = request.getParameter("meid");
		String rad = request.getParameter("rad");
		
		
		String success ="<div class=\"container\">\r\n"
				+ "  <h2>Approved!</h2>\r\n"
				+ "  <div class=\"alert alert-success\">\r\n"
				+ "    <strong>Success!</strong> reimbursement has been approved.\r\n"
				+ "  </div>"
				
				+" <form action=\"ApproveDeny\" method=\"POST\">\r\n"
				+ "  <button type=\"submit\" class=\"btn btn-info\" >Info</button>\r\n"
				+ "  </form>"
				+ "</body> ";
		
		
		String deny = "<div class=\"container\">\r\n"
				+ "  <h2>Denied!</h2>\r\n"
				+ "  <div class=\"alert alert-danger\">\r\n"
				+ "    <strong>Denied!</strong> reimbursement has been denied.\r\n"
				+ "  </div>"
				
				+" <form action=\"ApproveDeny\" method=\"POST\">\r\n"
				+ "  <button type=\"submit\" class=\"btn btn-info\" >Info</button>\r\n"
				+ "  </form>"
				+ "</body> ";
		
		String error =  "<div class=\"container\">\r\n"
				+ "  <h2>Error!</h2>\r\n"
				+ "  <div class=\"alert alert-danger\">\r\n"
				+ "    <strong>Failed!</strong> Please fill out the required filled.\r\n"
				+ "  </div>"
				
				+"<div class=\"container\">\r\n"
				+ "    \r\n"
				+ "    <form action=\"AppDenProcess\" method=\"POST\">\r\n"
				+ "      <div class=\"form-group\">\r\n"
				+ "        <label for=\"eid\">Enter Employee ID#:</label>\r\n"
				+ "        <input type=\"number\" class=\"form-control\" id=\"usr\" name=\"meid\">\r\n"
				+ "      </div>\r\n"
				+ "      <div>\r\n"
				+ "      <label class=\"radio-inline\">\r\n"
				+ "        <input type=\"radio\" name=\"rad\" value=\"Approve\" checked>Approve\r\n"
				+ "      </label>\r\n"
				+ "      <label class=\"radio-inline\">\r\n"
				+ "        <input type=\"radio\" name=\"rad\" value=\"Deny\">Deny\r\n"
				+ "      </label>\r\n"
				+ "      </div>\r\n"
				+ "      <br>\r\n"
				+ "      <button type=\"submit\" class=\"btn btn-success\">Submit</button>\r\n"
				+ "      \r\n"
				+ "    </form>\r\n"
				+ "  </div>\r\n"
				+ "          \r\n"
				
				+"<div class=\"container\">\r\n"
				+ "            <h2>Pending Request</h2>\r\n"
				+ "            <p>Approve/Deny:</p>            \r\n"
				+ "            <table class=\"table table-hover\">\r\n"
				+ "              <thead>\r\n"
				+ "                <tr>\r\n"
				+ "                  <th>#</th>\r\n"
				+ "                  <th>Employee ID #</th>\r\n"
				+ "                  <th>Purpose</th>\r\n"
				+ "                  <th>Amount</th>\r\n"
				+ "                  <th>Status</th>\r\n"
				+ "                </tr>\r\n"
				+ "              </thead>\r\n"
				+ "              <tbody id=\"data\">\r\n"
				+ "              \r\n"
				+ "                \r\n"
				+ "              </tbody>\r\n"
				+ "            </table>\r\n"
				+ "          </div>\r\n"
				+ "          \r\n"
				+ "</body> ";
		
	
		if(rad.equals("approved") && !seid.equals("")) {
			int eid =Integer.parseInt(seid);
			rdao.approveDeny(eid,rad);
			out.print(success);
			log.info("Approved pending reimbursement");
		}
		else if(rad.equals("denied") && !seid.equals("")) {
			int eid =Integer.parseInt(seid);
			rdao.approveDeny(eid,rad);
			out.print(deny);
			log.warn("Denied pending reimbursement");
			
		}
		else if(seid.equals("")){
			
			out.print(error);
			
			for(Pending p : penList) {
				out.print("<script>\r\n"
						+ "            var DisplayData = function(){\r\n"
						+ "            var newData = document.getElementById(\"data\");\r\n"
						+ "            var newTr = document.createElement(\"tr\");\r\n"
						+ "            var newTd = document.createElement(\"td\");\r\n"
						+ "  \r\n"
						+ "            newData.appendChild(newTr);\r\n"
						+ "  \r\n"
						+ "            newTr.appendChild(newTd);\r\n"
						+ "            newTd.innerHTML=\""+p.getRid()+"\";\r\n"
						+ "  \r\n"
						+ "            var newTd = document.createElement(\"td\");\r\n"
						+ "            newTr.appendChild(newTd);\r\n"
						+ "            newTd.innerHTML=\""+p.getEid()+"\";\r\n"
						+ "  \r\n"
						+ "            var newTd = document.createElement(\"td\");\r\n"
						+ "            newTr.appendChild(newTd);\r\n"
						+ "            newTd.innerHTML=\""+p.getPurpose()+"\";\r\n"
						+ "  \r\n"
						+ "            var newTd = document.createElement(\"td\");\r\n"
						+ "            newTr.appendChild(newTd);\r\n"
						+ "            newTd.innerHTML=\""+p.getAmount()+"\";\r\n"
						+ "  \r\n"
						+ "            var newTd = document.createElement(\"td\");\r\n"
						+ "            newTr.appendChild(newTd);\r\n"
						+ "            newTd.innerHTML=\""+p.getStatus()+"\";\r\n"
						+ "            }();\r\n"
						+ "  \r\n"
						+ "          </script>");
			}
			
			
		}
		
		
		
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
