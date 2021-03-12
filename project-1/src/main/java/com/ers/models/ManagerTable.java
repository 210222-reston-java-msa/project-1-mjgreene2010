package com.ers.models;

public class ManagerTable {
	
	private int id;
	private Employee managerId;
	private String resolveDate;
	private Reimbursement reimbursement;
	
	public ManagerTable() {
		super();
	}

	public ManagerTable(int id, Employee managerId, String resolveDate, Reimbursement reimbursement) {
		super();
		this.id = id;
		this.managerId = managerId;
		this.resolveDate = resolveDate;
		this.reimbursement = reimbursement;
	}
	
	public ManagerTable(Employee managerId, String resolveDate, Reimbursement reimbursement) {
		super();
		this.managerId = managerId;
		this.resolveDate = resolveDate;
		this.reimbursement = reimbursement;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee getManagerId() {
		return managerId;
	}

	public void setManagerId(Employee managerId) {
		this.managerId = managerId;
	}

	public String getResolveDate() {
		return resolveDate;
	}

	public void setResolveDate(String resolveDate) {
		this.resolveDate = resolveDate;
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
		result = prime * result + id;
		result = prime * result + ((managerId == null) ? 0 : managerId.hashCode());
		result = prime * result + ((reimbursement == null) ? 0 : reimbursement.hashCode());
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
		if (id != other.id)
			return false;
		if (managerId == null) {
			if (other.managerId != null)
				return false;
		} else if (!managerId.equals(other.managerId))
			return false;
		if (reimbursement == null) {
			if (other.reimbursement != null)
				return false;
		} else if (!reimbursement.equals(other.reimbursement))
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
		return "ManagerTable [id=" + id + ", managerId=" + managerId + ", resolveDate=" + resolveDate
				+ ", reimbursement=" + reimbursement + "]";
	}
	
	
	
	
	

}
