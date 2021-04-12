package com.revature.jamesartacho.model;

public class Employee {

	private Integer emp_id;
	private String emp_fname;
	private String emp_lname;
	private String emp_address;
	private String emp_email;
	private String emp_type;
	
	private String usr_name;
	private String pass;
	
	public Employee() {
		super();
	}
	
	public Employee(Integer emp_id, String emp_fname, String emp_lname, String emp_address, String emp_email,
			String emp_type, String usr_name, String pass) {
		super();
		this.emp_id = emp_id;
		this.emp_fname = emp_fname;
		this.emp_lname = emp_lname;
		this.emp_address = emp_address;
		this.emp_email = emp_email;
		this.emp_type = emp_type;
		this.usr_name = usr_name;
		this.pass = pass;
	}

	public Integer getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_fname() {
		return emp_fname;
	}

	public void setEmp_fname(String emp_fname) {
		this.emp_fname = emp_fname;
	}

	public String getEmp_lname() {
		return emp_lname;
	}

	public void setEmp_lname(String emp_lname) {
		this.emp_lname = emp_lname;
	}

	public String getEmp_address() {
		return emp_address;
	}

	public void setEmp_address(String emp_address) {
		this.emp_address = emp_address;
	}

	public String getEmp_email() {
		return emp_email;
	}

	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}

	public String getEmp_type() {
		return emp_type;
	}

	public void setEmp_type(String emp_type) {
		this.emp_type = emp_type;
	}

	public String getUsr_name() {
		return usr_name;
	}

	public void setUsr_name(String usr_name) {
		this.usr_name = usr_name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
	
	
}
