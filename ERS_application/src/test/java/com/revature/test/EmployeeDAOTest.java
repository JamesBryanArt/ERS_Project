package com.revature.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.revature.jamesartacho.dao.EmployeeDAOImpl;
import com.revature.jamesartacho.model.Employee;

public class EmployeeDAOTest {
	
	@InjectMocks
	private EmployeeDAOImpl eDao;
	
	private List<Employee> mockEmployees;
	
	@Mock
	private Employee emp;
	
	@Before
	public void setUp() {
		System.out.println("Before");
		
		MockitoAnnotations.initMocks(this);
		
		eDao = Mockito.mock(EmployeeDAOImpl.class);
		
		this.mockEmployees = new ArrayList<Employee>();
		
		mockEmployees.add(new Employee(1,"Test Fname","Test Lname","Test addr","Test email", "Test type", "username","password"));
		mockEmployees.add(new Employee(2,"Test Fname","Test Lname","Test addr","Test email", "Test type", "username","password"));
	}
	
	@Test
	public void selectAllEmployees() {
		Mockito.when(this.eDao.selectAllEmployee()).thenReturn(this.mockEmployees);
		assertEquals(eDao.selectAllEmployee().get(1),mockEmployees.get(1));
	}
	
//	@Test
//	public void UpdateEmployee() {
//		Mockito.when(this.eDao.updateEmployee(null, null, null, null, null)).thenReturn(this.mockEmployees);
//	}

}
