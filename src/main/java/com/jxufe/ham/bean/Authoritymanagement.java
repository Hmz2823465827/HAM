package com.jxufe.ham.bean;

import com.jxufe.ham.bean.abstractBean.BaseBean;

public class Authoritymanagement extends BaseBean{

	private static final long serialVersionUID = 1847900226283142336L;

	private int authoritymanagementId;//权限控制编号
	
	private Role role;//角色
	
	private Authority authority;//操作权限


	public void setRole(Role role) {
		this.role = role;
	}

	public Role getRoleID() {
		return role;
	}

	public void setRoleID(Role role) {
		this.role = role;
	}

	public Object getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getType() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Object getPermission() {
		// TODO Auto-generated method stub
		return null;
	}

	public Role getRole() {
		// TODO Auto-generated method stub
		return null;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	public int getAuthoritymanagementId() {
		return authoritymanagementId;
	}

	public void setAuthoritymanagementId(int authoritymanagementId) {
		this.authoritymanagementId = authoritymanagementId;
	}
}
