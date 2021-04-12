package com.revature.jamesartacho.dao;

import java.util.List;

import com.revature.jamesartacho.model.Employee;

public interface EmployeeDAO {
	
	public Employee selectEmployee(Integer id);
	public List<Employee> selectAllEmployee();
	public Boolean updateEmployee(Integer id, String fname, String lname, String addr, String email);
	
}
