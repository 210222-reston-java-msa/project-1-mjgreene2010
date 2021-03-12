package com.ers.models;

public class ExpenseTemplate {
	
	private double amount;
	private String reimbursement_type;
	private String description;
	private Employee employee;
	
	public ExpenseTemplate() {
		super();
	}

	public ExpenseTemplate(double amount, String reimbursement_type, String description, Employee employee) {
		super();
		this.amount = amount;
		this.reimbursement_type = reimbursement_type;
		this.description = description;
		this.employee = employee;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getReimbursement_type() {
		return reimbursement_type;
	}

	public void setReimbursement_type(String reimbursement_type) {
		this.reimbursement_type = reimbursement_type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((reimbursement_type == null) ? 0 : reimbursement_type.hashCode());
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
		ExpenseTemplate other = (ExpenseTemplate) obj;
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
		if (reimbursement_type == null) {
			if (other.reimbursement_type != null)
				return false;
		} else if (!reimbursement_type.equals(other.reimbursement_type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ExpenseTemplate [amount=" + amount + ", reimbursement_type=" + reimbursement_type + ", description="
				+ description + ", employee=" + employee + "]";
	}
	
	
	
	

}