package com.jxufe.ham.bean;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.jxufe.ham.bean.abstractBean.BaseBean;

public class Function extends BaseBean{

	
	private static final long serialVersionUID = 4832132372549417852L;
	
	private int functionId;//权限过滤编号
	
	private String value;//过滤url
	
	private Authority authorityID;//权限
	
	private Role role;//角色
	
	private String type;//类型

	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
//	public Authority getAuthority() {
//		return authority;
//	}
//	public void setAuthority(Authority authority) {
//		this.authority = authority;
//	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getFunctionId() {
		return functionId;
	}
	public void setFunctionId(int functionId) {
		this.functionId = functionId;
	}
	
	@OneToOne
    @JoinColumn(name = "authorityid")
	public Authority getAuthorityID() {
		return authorityID;
	}
	public void setAuthorityID(Authority authorityID) {
		this.authorityID = authorityID;
	}
	
}
