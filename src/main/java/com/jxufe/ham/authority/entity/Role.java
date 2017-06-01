package com.jxufe.ham.authority.entity;

import java.util.HashSet;
import java.util.Set;

import com.jxufe.ham.common.entity.BaseBean;

public class Role extends BaseBean{

	private static final long serialVersionUID = -7573667182853507192L;

	private int roleId;//编号ID
	
	private String roleName;//角色名
	
	private Set<Rolemanagement> rolemanagements = new HashSet<Rolemanagement>(0);

	private Set<Authoritymanagement> authoritymanagements = new HashSet<Authoritymanagement>(0);
	
	private Set<Function> functions = new HashSet<Function>(0);
	
	

	public Role() {
		super();
	}

	public Role(int roleId, String roleName, Set<Rolemanagement> rolemanagements,
			Set<Authoritymanagement> authoritymanagements, Set<Function> functions) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.rolemanagements = rolemanagements;
		this.authoritymanagements = authoritymanagements;
		this.functions = functions;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRolename() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Rolemanagement> getRolemanagements() {
		return rolemanagements;
	}

	public void setRolemanagements(Set<Rolemanagement> rolemanagements) {
		this.rolemanagements = rolemanagements;
	}

	public Set<Authoritymanagement> getAuthoritymanagements() {
		return authoritymanagements;
	}

	public void setAuthoritymanagements(Set<Authoritymanagement> authoritymanagements) {
		this.authoritymanagements = authoritymanagements;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public Set<Function> getFunctions() {
		return functions;
	}

	public void setFunctions(Set<Function> functions) {
		this.functions = functions;
	}

	
}
