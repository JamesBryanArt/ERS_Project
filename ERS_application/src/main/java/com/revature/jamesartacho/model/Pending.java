package com.revature.jamesartacho.model;

public class Pending {
	
	private Integer rid;
	private Integer eid;
	private String purpose;
	private Double amount;
	private String status;
	
	public Pending() {
		super();
	}
	
	public Pending(Integer rid, Integer eid, String purpose, Double amount, String status) {
		super();
		this.rid = rid;
		this.eid = eid;
		this.purpose = purpose;
		this.amount = amount;
		this.status = status;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
