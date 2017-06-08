package com.jxufe.ham.authority.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jxufe.ham.common.entity.BaseBean;

public class Role extends BaseBean{

	

	private static final long serialVersionUID = -7573667182853507192L;

	private int roleId;//编号ID
	
	private String roleName;//角色名
	
	@JsonIgnore
	private Set<Rolemanagement> rolemanagements = new HashSet<Rolemanagement>(0);
	
	@JsonIgnore
	private Set<Authoritymanagement> authoritymanagements = new HashSet<Authoritymanagement>(0);
	
	@JsonIgnore
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

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
		result = prime * result + roleId;
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
		Role other = (Role) obj;
		if (roleId != other.roleId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
	
	
}
