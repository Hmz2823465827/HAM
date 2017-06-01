package com.jxufe.ham.authority.entity;

import java.util.Collection;

import com.jxufe.ham.common.entity.BaseBean;
import com.jxufe.ham.system.entity.Employee;

public class Rolemanagement extends BaseBean{

	private static final long serialVersionUID = -6321765075213299243L;
	
	private int RolemanagementId;//角色控制编号
	
	private Role role;//角色
	
	private Employee employee;//用户

	

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Rolemanagement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rolemanagement(int rolemanagementId, Role role, Employee employee) {
		super();
		RolemanagementId = rolemanagementId;
		this.role = role;
		this.employee = employee;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getRolemanagementId() {
		return RolemanagementId;
	}

	public void setRolemanagementId(int rolemanagementId) {
		RolemanagementId = rolemanagementId;
	}
	
}
