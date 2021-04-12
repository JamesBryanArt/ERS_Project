package com.revature.jamesartacho.dao;

import java.util.List;

import com.revature.jamesartacho.model.Pending;

public interface ReimbursementDAO {
	public Boolean requestReimburse(String purpose, Double amount, Integer id);
	
	public List<Pending> viewPending(Integer id);
	public List<Pending> viewResolved(Integer id);
	
	public List<Pending> viewAllPending();
	public List<Pending> viewAllResolved();
	
	public Boolean approveDeny(Integer id, String choice);
	

}
