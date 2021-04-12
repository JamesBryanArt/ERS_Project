package com.revature.jamesartacho.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.jamesartacho.connectionutil.ConnectionUtility;
import com.revature.jamesartacho.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	public static Employee emp = null;
	public static ResultSet rs = null;
	public static PreparedStatement ps = null;
	
	ArrayList<Employee> e_list = new ArrayList<Employee>();
	
	public Employee selectEmployee(Integer id) {
		try(Connection conn = ConnectionUtility.getConnection()){
			ps = conn.prepareStatement("SELECT * FROM ers_schema.Employee WHERE emp_id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				emp = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return emp;
	}

	
	public Boolean updateEmployee(Integer id, String fname, String lname, String addr, String email) {
		try(Connection conn = ConnectionUtility.getConnection()){
			ps = conn.prepareStatement("UPDATE ers_schema.Employee SET emp_fname=? , emp_lname=? , emp_address=? , emp_email=? "
					+ "WHERE emp_id=?");
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, addr);
			ps.setString(4, email);
			ps.setInt(5, id);
			
			ps.executeUpdate();
			
			
			
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public List<Employee> selectAllEmployee() {
		
		try(Connection conn = ConnectionUtility.getConnection()){
			ps = conn.prepareStatement("SELECT * FROM ers_schema.Employee");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmp_id(rs.getInt(1));
				emp.setEmp_fname(rs.getString(2));
				emp.setEmp_lname(rs.getString(3));
				emp.setEmp_address(rs.getString(4));
				emp.setEmp_email(rs.getString(5));
				emp.setEmp_type(rs.getString(6));
				emp.setUsr_name(rs.getString(7));
				emp.setPass(rs.getString(8));
				
				e_list.add(emp);
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return e_list;
	}
	
	
}
