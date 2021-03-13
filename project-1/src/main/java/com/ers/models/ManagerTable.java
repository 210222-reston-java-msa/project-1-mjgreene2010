package com.ers.models;

public class ManagerTable {
	
	private int id;
	private String resolveDate;
	private Employee employee;
	private int reimbursementId;
	private Reimbursement reimbursement;
	
	public ManagerTable() {
		super();
	}

	public ManagerTable(int id, String resolveDate, Employee employee, int reimbursementId,
			Reimbursement reimbursement) {
		super();
		this.id = id;
		this.resolveDate = resolveDate;
		this.employee = employee;
		this.reimbursementId = reimbursementId;
		this.reimbursement = reimbursement;
	}

	public ManagerTable(String resolveDate, Employee employee, int reimbursementId, Reimbursement reimbursement) {
		super();
		this.resolveDate = resolveDate;
		this.employee = employee;
		this.reimbursementId = reimbursementId;
		this.reimbursement = reimbursement;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getResolveDate() {
		return resolveDate;
	}

	public void setResolveDate(String resolveDate) {
		this.resolveDate = resolveDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
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
		result = prime * result + id;
		result = prime * result + ((reimbursement == null) ? 0 : reimbursement.hashCode());
		result = prime * result + reimbursementId;
		result = prime * result + ((resolveDate == null) ? 0 : resolveDate.hashCode());
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
		ManagerTable other = (ManagerTable) obj;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (id != other.id)
			return false;
		if (reimbursement == null) {
			if (other.reimbursement != null)
				return false;
		} else if (!reimbursement.equals(other.reimbursement))
			return false;
		if (reimbursementId != other.reimbursementId)
			return false;
		if (resolveDate == null) {
			if (other.resolveDate != null)
				return false;
		} else if (!resolveDate.equals(other.resolveDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ManagerTable [id=" + id + ", resolveDate=" + resolveDate + ", employee=" + employee
				+ ", reimbursementId=" + reimbursementId + ", reimbursement=" + reimbursement + "]";
	}
	
	

}