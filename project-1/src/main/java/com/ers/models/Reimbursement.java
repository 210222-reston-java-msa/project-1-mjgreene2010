package com.ers.models;

import java.util.Date;
public class Reimbursement {
	
	private int id;
	private String postingDate;
	private double amount;
	private String reimbursementType;
	private String description;
	private String status;
	private Employee employee;
	
	public Reimbursement() {
		super();
	}

	public Reimbursement(int id, String postingDate, double amount, String reimbursementType, String description,
			String status, Employee employee) {
		super();
		this.id = id;
		this.postingDate = postingDate;
		this.amount = amount;
		this.reimbursementType = reimbursementType;
		this.description = description;
		this.status = status;
		this.employee = employee;
	}
	
	public Reimbursement(int id, String postingDate, double amount, String reimbursementType, String description,
			String status) {
		super();
		this.id = id;
		this.postingDate = postingDate;
		this.amount = amount;
		this.reimbursementType = reimbursementType;
		this.description = description;
		this.status = status;
	
	}
	
	public Reimbursement(double amount, String reimbursementType, String description,
			String status, Employee employee) {
		super();
	
		this.amount = amount;
		this.reimbursementType = reimbursementType;
		this.description = description;
		this.status = status;
		this.employee = employee;
	}

	public Reimbursement(int id2, String posting_date, Double amount2, String reimbursement_type, String description2,
			String status2, String employee_id) {
		super();
		this.id = id;
		this.postingDate = posting_date;
		this.amount = amount;
		this.reimbursementType = reimbursementType;
		this.description = description;
		this.status = status;
		this.employee = employee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getReimbursementType() {
		return reimbursementType;
	}

	public void setReimbursementType(String reimbursementType) {
		this.reimbursementType = reimbursementType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((postingDate == null) ? 0 : postingDate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + id;
		result = prime * result + ((reimbursementType == null) ? 0 : reimbursementType.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		if (postingDate == null) {
			if (other.postingDate != null)
				return false;
		} else if (!postingDate.equals(other.postingDate))
			return false;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (id != other.id)
			return false;
		if (reimbursementType == null) {
			if (other.reimbursementType != null)
				return false;
		} else if (!reimbursementType.equals(other.reimbursementType))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", PostingDate=" + postingDate + ", amount=" + amount
				+ ", reimbursementType=" + reimbursementType + ", description=" + description + ", status=" + status
				+ ", employee=" + employee + "]";
	}
	
	
	

}