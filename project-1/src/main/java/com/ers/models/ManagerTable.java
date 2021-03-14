package com.ers.models;

public class ManagerTable {
	
	private int id;
	private String resolveDate;
	private int resolveManagerId;
	private int reimbursementId;
	private Reimbursement reimbursement;
	
	public ManagerTable() {
		super();
	}

	public ManagerTable(int id, String resolveDate, int resolveManagerId, int reimbursementId,
			Reimbursement reimbursement) {
		super();
		this.id = id;
		this.resolveDate = resolveDate;
		this.resolveManagerId = resolveManagerId;
		this.reimbursementId = reimbursementId;
		this.reimbursement = reimbursement;
	}

	public ManagerTable(String resolveDate, int resolveManagerId, int reimbursementId, Reimbursement reimbursement) {
		super();
		this.resolveDate = resolveDate;
		this.resolveManagerId = resolveManagerId;
		this.reimbursementId = reimbursementId;
		this.reimbursement = reimbursement;
	}
	
	
	
	

	public ManagerTable(String resolveDate, int resolveManagerId, int reimbursementId) {
		super();
		this.resolveDate = resolveDate;
		this.resolveManagerId = resolveManagerId;
		this.reimbursementId = reimbursementId;
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

	public int getResolveManagerId() {
		return resolveManagerId;
	}

	public void setResolveManagerId(int resolveManagerId) {
		this.resolveManagerId = resolveManagerId;
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
		result = prime * result + id;
		result = prime * result + ((reimbursement == null) ? 0 : reimbursement.hashCode());
		result = prime * result + reimbursementId;
		result = prime * result + ((resolveDate == null) ? 0 : resolveDate.hashCode());
		result = prime * result + resolveManagerId;
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
		if (resolveManagerId != other.resolveManagerId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ManagerTable [id=" + id + ", resolveDate=" + resolveDate + ", resolveManagerId=" + resolveManagerId
				+ ", reimbursementId=" + reimbursementId + ", reimbursement=" + reimbursement + "]";
	}
	
	
	
	

	}