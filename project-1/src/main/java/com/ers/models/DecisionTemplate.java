package com.ers.models;

public class DecisionTemplate {
	
	private int resolvedManagerId;
	private Reimbursement reimbursement;
	
	public DecisionTemplate() {
		super();
	}

	public DecisionTemplate(int resolvedManagerId, Reimbursement reimbursement) {
		super();
		this.resolvedManagerId = resolvedManagerId;
		this.reimbursement = reimbursement;
	}

	public int getResolvedManagerId() {
		return resolvedManagerId;
	}

	public void setResolvedManagerId(int resolvedManagerId) {
		this.resolvedManagerId = resolvedManagerId;
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
		result = prime * result + ((reimbursement == null) ? 0 : reimbursement.hashCode());
		result = prime * result + resolvedManagerId;
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
		if (reimbursement == null) {
			if (other.reimbursement != null)
				return false;
		} else if (!reimbursement.equals(other.reimbursement))
			return false;
		if (resolvedManagerId != other.resolvedManagerId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DecisionTemplate [resolvedManagerId=" + resolvedManagerId + ", reimbursement=" + reimbursement + "]";
	}
	
	

}