package com.ers.models;

public class DecisionTemplate {
	
	private Employee employee;
	private Reimbursement reimbursement;
	
	public DecisionTemplate() {
		super();
	}

	public DecisionTemplate(Employee employee, Reimbursement reimbursement) {
		super();
		this.employee = employee;
		this.reimbursement = reimbursement;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Reimbursement getReimbursement() {
		return reimbursement;
	}

	public void setReimbursement(Reimbursement reimbursement) {
		this.reimbursement = reimbursement;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((reimbursement == null) ? 0 : reimbursement.hashCode());
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
		DecisionTemplate other = (DecisionTemplate) obj;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (reimbursement == null) {
			if (other.reimbursement != null)
				return false;
		} else if (!reimbursement.equals(other.reimbursement))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DecisionTemplate [employee=" + employee + ", reimbursement=" + reimbursement + "]";
	}
	
	
	

}
