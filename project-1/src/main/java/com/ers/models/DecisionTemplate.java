package com.ers.models;

public class DecisionTemplate {
	
	private String status;
	private ManagerTable mt;
	private ManagerTable mt2;
	
	public DecisionTemplate() {
		super();
	}

	public DecisionTemplate(String status, ManagerTable mt, ManagerTable mt2) {
		super();
		this.status = status;
		this.mt2 = mt2;
		this.mt = mt;
	}
	
	
//
//	public void setStatus(String status) {
//		this.status = status;
//	}
//
//	public DecisionTemplate(String status, ManagerTable mt) {
//		super();
//		this.status = status;
//		this.mt = mt;
//	}

	public String getStatus() {
		return status;
	}
	
	
	public void setStatus(String status) {
		this.status = status;
	}

	public ManagerTable getMt() {
		return mt;
	}

	public void setMt(ManagerTable mt) {
		this.mt = mt;
	}

	public ManagerTable getMt2() {
		return mt2;
	}

	public void setMt2(ManagerTable mt2) {
		this.mt2 = mt2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mt == null) ? 0 : mt.hashCode());
		result = prime * result + ((mt2 == null) ? 0 : mt2.hashCode());
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
		DecisionTemplate other = (DecisionTemplate) obj;
		if (mt == null) {
			if (other.mt != null)
				return false;
		} else if (!mt.equals(other.mt))
			return false;
		if (mt2 == null) {
			if (other.mt2 != null)
				return false;
		} else if (!mt2.equals(other.mt2))
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
		return "DecisionTemplate [status=" + status + ", mt=" + mt + ", mt2=" + mt2 + "]";
	}
	
	
	
	

}