package com.jxufe.ham.bean;

import java.util.HashSet;
import java.util.Set;

import com.jxufe.ham.bean.abstractBean.BaseBean;

public class Authority extends BaseBean{

	private static final long serialVersionUID = 6272337420044047378L;
	
	private int authorityId;//权限编号
	
//	private String table;//相关表
	
	private String operation;//操作
	
	private Set<Authoritymanagement> authoritymanagements = new HashSet<Authoritymanagement>(0);
		
	public Set<Authoritymanagement> getAuthoritymanagements() {
		return authoritymanagements;
	}


	public void setAuthoritymanagements(HashSet<Authoritymanagement> authoritymanagements) {
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

	
}
