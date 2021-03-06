package com.jxufe.ham.system.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jxufe.ham.common.entity.BaseBean;

/**
 * @Description:部门类 
 * @ClassName: Depart
 * @author hmz
 * @date 2017年3月23日 上午10:17:01
 */
public class Depart extends BaseBean{

	//序列ID
	private static final long serialVersionUID = 6033286629137050077L;

	private int departId;//部门编号
	
	private String departName;//部门名称
	
	private String departInfo;//部门信息
	
	private Integer departRank;//部门等级
	
	private Employee employeeId;//部门经理编号
	
	@JsonIgnore
	private Set<Employee> employeesForDepartId = new HashSet<Employee>(0);//部门员工

	public Depart() {
		super();
	}

	public Depart(int departId, String departName) {
		super();
		this.departId = departId;
		this.departName = departName;
	}

	public Depart(int departId, String departName, String departInfo, Integer departRank, 
			Set<Employee> employeesForDepartId) {
		super();
		this.departId = departId;
		this.departName = departName;
		this.departInfo = departInfo;
		this.departRank = departRank;
		this.employeesForDepartId = employeesForDepartId;
	}

	public int getDepartId() {
		return this.departId;
	}

	public void setDepartId(int departId) {
		this.departId = departId;
	}

	public String getDepartName() {
		return this.departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public String getDepartInfo() {
		return this.departInfo;
	}

	public void setDepartInfo(String departInfo) {
		this.departInfo = departInfo;
	}

	public Integer getDepartRank() {
		return this.departRank;
	}

	public void setDepartRank(Integer departRank) {
		this.departRank = departRank;
	}

	public Set<Employee> getEmployeesForDepartId() {
		return this.employeesForDepartId;
	}

	public void setEmployeesForDepartId(Set<Employee> employeesForDepartId) {
		this.employeesForDepartId = employeesForDepartId;
	}

	public Employee getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Employee employeeId) {
		this.employeeId = employeeId;
	}
	
	@Override
	public String toString() {
		return "Depart [departId=" +departId + ", departName=" + departName +
				",departInfo=" + departInfo + ",departRank=" + departRank +
				", employeeId=" + employeeId +", employeesForDepartId=" + employeesForDepartId.toString() +"]";
	}

}
