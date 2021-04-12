package com.revature.servlets;

import java.io.IOException;



import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.jamesartacho.connectionutil.ConnectionUtility;
import com.revature.jamesartacho.dao.EmployeeDAOImpl;
import com.revature.jamesartacho.model.Employee;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static PreparedStatement ps =  null;
	public static ResultSet myRs=null;
	

	
	
	//for JDBC
	static {
	    try {
	      Class.forName("org.postgresql.Driver");
	    } catch (ClassNotFoundException e) {
	      System.err.println("PostgreSQL DataSource unable to load PostgreSQL JDBC Driver");
	    }
	  }
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    //login logic
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Creating Objects
		Employee emp = new Employee();
		EmployeeDAOImpl edao = new EmployeeDAOImpl();
		
		//HTTP SESSION
		HttpSession session = request.getSession();
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String usr = request.getParameter("username");
		String pass = request.getParameter("password");
		
		
		
		//Authenticate
		try(Connection conn = ConnectionUtility.getConnection()){
			ps = conn.prepareStatement("SELECT * FROM ers_schema.Employee "
					+"WHERE usr_name=? AND pass=?");
			
			ps.setString(1, usr);
			ps.setString(2, pass);
			myRs = ps.executeQuery();
			
			if(myRs.next()) {
				int emp_id =myRs.getInt(1);
				System.out.println("Login Successful");
				out.print("SUCCESSFULLY LOGIN\n");
				
				emp = edao.selectEmployee(emp_id);
				
				if(emp.getEmp_type().equals("admin")) {
					//show admin menu
					session.setAttribute("employee", emp);
					response.sendRedirect("http://localhost:8080/ERS_application/AdminView");
					
					
				}
				else {
					//show employee menu
					session.setAttribute("employee", emp);
					response.sendRedirect("http://localhost:8080/ERS_application/Employee#");			
					
				}
				
			}
			else {
				System.out.println("INVALID USER");
				String str = String.format("alert(%s)","INVALID" );
				out.print(str);
				response.sendRedirect("http://localhost:8080/ERS_application/index.html");
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		
	}

	
	//doGet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//doPost
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request,response);
	}
	

}
