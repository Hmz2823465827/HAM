package com.jxufe.ham.authority.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jxufe.ham.common.entity.BaseBean;

public class Authority extends BaseBean{
	
	private static final long serialVersionUID = 6272337420044047378L;
	
	private int authorityId;//权限编号
	
	private String operation;//操作
	
	@JsonIgnore
	private Set<Authoritymanagement> authoritymanagements = new HashSet<Authoritymanagement>(0);
	
	@JsonIgnore
	private Set<Function> functions = new HashSet<Function>(0);

	public Authority() {
		super();
	}

	public Authority(int authorityId, String operation, Set<Authoritymanagement> authoritymanagements,
			Set<Function> functions) {
		super();
		this.authorityId = authorityId;
		this.operation = operation;
		this.authoritymanagements = authoritymanagements;
		this.functions = functions;
	}

	public int getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(int authorityId) {
		this.authorityId = authorityId;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Set<Authoritymanagement> getAuthoritymanagements() {
		return authoritymanagements;
	}

	public void setAuthoritymanagements(Set<Authoritymanagement> authoritymanagements) {
		this.authoritymanagements = authoritymanagements;
	}

	public Set<Function> getFunctions() {
		return functions;
	}

	public void setFunctions(Set<Function> functions) {
		this.functions = functions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + authorityId;
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
		Authority other = (Authority) obj;
		if (authorityId != other.authorityId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Authority [authorityId=" + authorityId + ", operation=" + operation + "]";
	}
	
	
	
}
