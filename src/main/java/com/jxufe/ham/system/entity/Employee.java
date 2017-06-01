package com.jxufe.ham.system.entity;


import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jxufe.ham.authority.entity.Rolemanagement;
import com.jxufe.ham.common.entity.BaseBean;
import com.jxufe.ham.system.entity.Depart;
import com.jxufe.ham.system.entity.Followup;
import com.jxufe.ham.system.entity.House;
import com.jxufe.ham.system.entity.Keymanagement;
import com.jxufe.ham.system.entity.Leaveword;
import com.jxufe.ham.system.entity.Log;
import com.jxufe.ham.system.entity.Performance;
import com.jxufe.ham.system.entity.Task;
import com.jxufe.ham.system.entity.Taskmanagement;
import com.jxufe.ham.system.entity.Workrecord;

/**
 * @Description: 员工实体类
 * @ClassName: Employee
 * @author hmz
 * @date 2017年3月23日 上午10:32:54
 */
public class Employee extends BaseBean {

	//序列化ID
	private static final long serialVersionUID = 7031407605308824083L;

	private int employeeId;//员工编号
	
//	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//	@JsonIgnore
	private Depart departID;//所属部门
	
	private String employeeName;//员工名称
	
	private Boolean employeeSex;//员工性别
	
	private String employeePhone;//员工联系方式
	
	private String passWord;//登入密码
	
	private int employeePosition;//员工职位
	
	@JsonIgnore
	private Set<Leaveword> leavewords = new HashSet<Leaveword>(0);//员工留言
	
	@JsonIgnore
	private Set<Performance> performances = new HashSet<Performance>(0);//员工绩效
	
	@JsonIgnore
	private Set<House> houses = new HashSet<House>(0);//员工负责房屋集合
	
	@JsonIgnore
	private Set<Followup> followups = new HashSet<Followup>(0);//员工跟进记录
	
	@JsonIgnore
	private Set<Workrecord> workrecords = new HashSet<Workrecord>(0);//员工考勤集合
	
	@JsonIgnore
	private Set<Log> logs = new HashSet<Log>(0);//员工登入日志集合
	
	@JsonIgnore
	private Set<Keymanagement> keymanagements = new HashSet<Keymanagement>(0);//员工钥匙接管记录集合
	
	@JsonIgnore
	private Set<Depart> departs = new HashSet<Depart>(0);//员工担任部门经理集合
	
	@JsonIgnore
	private Set<Taskmanagement> taskmanagements = new HashSet<Taskmanagement>(0);//员工接受任务集合
	
	private Set<Rolemanagement> rolemanagements = new HashSet<Rolemanagement>(0);//角色集合
	
	public Employee() {
		super();
	}

	public Employee(int employeeId, String employeeName, int employeePosition) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeePosition = employeePosition;
	}

	public Employee(int employeeId, Depart departID, Depart departByDepDepartId, Task task, String employeeName,
			Boolean employeeSex, String employeePhone, int employeePosition, Set<Leaveword> leavewords, Set<Performance> performances,
			Set<House> houses, Set<Followup> followups, Set<Workrecord> workrecords, Set<Log> logs, Set<Keymanagement> keymanagements, Set<Task> tasks,Set<Taskmanagement> taskmanagements) {
		super();
		this.employeeId = employeeId;
		this.departID = departID;
		this.employeeName = employeeName;
		this.employeeSex = employeeSex;
		this.employeePhone = employeePhone;
		this.employeePosition = employeePosition;
		this.leavewords = leavewords;
		this.performances = performances;
		this.houses = houses;
		this.followups = followups;
		this.workrecords = workrecords;
		this.logs = logs;
		this.keymanagements = keymanagements;
		this.taskmanagements = taskmanagements;
	}

	
	
	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public int getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public Depart getDepartID() {
		return this.departID;
	}

	public void setDepartID(Depart departID) {
		this.departID = departID;
	}

	public String getEmployeeName() {
		return this.employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Boolean getEmployeeSex() {
		return this.employeeSex;
	}

	public void setEmployeeSex(Boolean employeeSex) {
		this.employeeSex = employeeSex;
	}

	public String getEmployeePhone() {
		return this.employeePhone;
	}

	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}

	public int getEmployeePosition() {
		return this.employeePosition;
	}

	public void setEmployeePosition(int employeePosition) {
		this.employeePosition = employeePosition;
	}

	public Set<Leaveword> getLeavewords() {
		return this.leavewords;
	}

	public void setLeavewords(Set<Leaveword> leavewords) {
		this.leavewords = leavewords;
	}

	public Set<Performance> getPerformances() {
		return this.performances;
	}

	public void setPerformances(Set<Performance> performances) {
		this.performances = performances;
	}

	public Set<House> getHouses() {
		return this.houses;
	}

	public void setHouses(Set<House> houses) {
		this.houses = houses;
	}

	public Set<Followup> getFollowups() {
		return this.followups;
	}

	public void setFollowups(Set<Followup> followups) {
		this.followups = followups;
	}

	public Set<Workrecord> getWorkrecords() {
		return this.workrecords;
	}

	public void setWorkrecords(Set<Workrecord> workrecords) {
		this.workrecords = workrecords;
	}

	public Set<Log> getLogs() {
		return this.logs;
	}

	public void setLogs(Set<Log> logs) {
		this.logs = logs;
	}

	public Set<Keymanagement> getKeymanagements() {
		return this.keymanagements;
	}

	public void setKeymanagements(Set<Keymanagement> keymanagements) {
		this.keymanagements = keymanagements;
	}

	public Set<Depart> getDeparts() {
		return departs;
	}

	public void setDeparts(Set<Depart> departs) {
		this.departs = departs;
	}
	

	public Set<Taskmanagement> getTaskmanagements() {
		return taskmanagements;
	}

	public void setTaskmanagements(Set<Taskmanagement> taskmanagements) {
		this.taskmanagements = taskmanagements;
	}

	public Set<Rolemanagement> getRolemanagements() {
		return rolemanagements;
	}

	public void setRolemanagements(Set<Rolemanagement> rolemanagements) {
		this.rolemanagements = rolemanagements;
	}

	
}
