package com.revature.jamesartacho.services;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.jamesartacho.connectionutil.ConnectionUtility;
import com.revature.jamesartacho.dao.EmployeeDAOImpl;
import com.revature.jamesartacho.model.Employee;

public class Authenticate {

	public static PreparedStatement ps =  null;
	public static ResultSet myRs=null;
	
	
	public Employee emp_authenticate(String usr, String pass) {
		Employee emp = new Employee();
		EmployeeDAOImpl edao = new EmployeeDAOImpl();
		System.out.println("inside function");
		
		try(Connection conn = ConnectionUtility.getConnection()){
			ps = conn.prepareStatement("SELECT * FROM ers_schema.Employee "
					+"WHERE usr_name=? AND pass=?");
			System.out.println("inside inside function yehey");
			ps.setString(1, usr);
			ps.setString(2, pass);
			myRs = ps.executeQuery();
			
			if(myRs.next()) {
				int emp_id =myRs.getInt(1);
				System.out.println("Login Successfull");
				emp = edao.selectEmployee(emp_id);
				
				if(emp.getEmp_type().equals("admin")) {
					//show admin menu
				}
				else {
					//show employee menu
					
				}
				return emp;
			}
			else {
				System.out.println("INVALID USER");
				return emp;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			return emp;
		}
	}

	
}
