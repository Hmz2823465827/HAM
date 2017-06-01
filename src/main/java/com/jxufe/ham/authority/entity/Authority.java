package com.jxufe.ham.authority.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jxufe.ham.common.entity.BaseBean;

public class Authority extends BaseBean{

	private static final long serialVersionUID = 6272337420044047378L;
	
	private int authorityId;//权限编号
	
//	private String table;//相关表
	
	private String operation;//操作
	
	@JsonIgnore
	private Set<Authoritymanagement> authoritymanagements = new HashSet<Authoritymanagement>(0);
	
	@JsonIgnore
	private Set<Function> functions = new HashSet<Function>(0);
	
	
	
	public Authority() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Authority(int authorityId, String operation, Set<Authoritymanagement> authoritymanagements,Set<Function> functions) {
		super();
		this.authorityId = authorityId;
		this.operation = operation;
		this.authoritymanagements = authoritymanagements;
		this.functions = functions;
	}


	public Set<Authoritymanagement> getAuthoritymanagements() {
		return authoritymanagements;
	}


	public void setAuthoritymanagements(Set<Authoritymanagement> authoritymanagements) {
		this.authoritymanagements = authoritymanagements;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getAuthorityname() {
		// TODO Auto-generated method stub
		return null;
	}


	public int getAuthorityId() {
		return authorityId;
	}


	public void setAuthorityId(int authorityId) {
		this.authorityId = authorityId;
	}


	public Set<Function> getFunctions() {
		return functions;
	}


	public void setFunctions(Set<Function> functions) {
		this.functions = functions;
	}

	
}
