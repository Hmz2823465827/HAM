package com.jxufe.ham.bean;


import java.util.HashSet;
import java.util.Set;

import com.jxufe.ham.bean.Depart;
import com.jxufe.ham.bean.Followup;
import com.jxufe.ham.bean.House;
import com.jxufe.ham.bean.Keycontroll;
import com.jxufe.ham.bean.Leaveword;
import com.jxufe.ham.bean.Log;
import com.jxufe.ham.bean.Performance;
import com.jxufe.ham.bean.Task;
import com.jxufe.ham.bean.TaskAllot;
import com.jxufe.ham.bean.Workrecord;
import com.jxufe.ham.bean.abstractBean.SerializeToJsonBean;

/**
 * @Description: 员工实体类
 * @ClassName: Employee
 * @author hmz
 * @date 2017年3月23日 上午10:32:54
 */
public class Employee extends SerializeToJsonBean {

	//序列化ID
	private static final long serialVersionUID = 7031407605308824083L;

	private int employeeId;//员工编号
	
	private Depart departByDepartId;//所属部门
	
	private Task task;//任务
	
	private String employeeName;//员工名称
	
	private Boolean employeeSex;//员工性别
	
	private String employeePhone;//员工联系方式
	
	private String passWord;//登入密码
	
	private int employeePosition;//员工职位
	
	private Set<Leaveword> leavewords = new HashSet<Leaveword>(0);//员工留言
	
	private Set<Performance> performances = new HashSet<Performance>(0);//员工绩效
	
	private Set<House> houses = new HashSet<House>(0);//员工负责房屋集合
	
	private Set<Followup> followups = new HashSet<Followup>(0);//员工跟进记录
	
	private Set<Workrecord> workrecords = new HashSet<Workrecord>(0);//员工考勤集合
	
	private Set<Log> logs = new HashSet<Log>(0);//员工登入日志集合
	
	private Set<Keycontroll> keycontrolls = new HashSet<Keycontroll>(0);//员工钥匙接管记录集合
	
	private Set<Task> tasks = new HashSet<Task>(0);//员工发布任务集合
	
	private Set<Depart> departs = new HashSet<Depart>(0);//员工担任部门经理集合
	
	private Set<TaskAllot> taskAllots = new HashSet<TaskAllot>();//员工接受任务集合
	

	public Employee() {
		super();
	}

	public Employee(int employeeId, String employeeName, int employeePosition) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeePosition = employeePosition;
	}

	public Employee(int employeeId, Depart departByDepartId, Depart departByDepDepartId, Task task, String employeeName,
			Boolean employeeSex, String employeePhone, int employeePosition, Set<Leaveword> leavewords, Set<Performance> performances,
			Set<House> houses, Set<Followup> followups, Set<Workrecord> workrecords, Set<Log> logs, Set<Keycontroll> keycontrolls, Set<Task> tasks,Set<TaskAllot> taskAllots) {
		super();
		this.employeeId = employeeId;
		this.departByDepartId = departByDepartId;
		this.task = task;
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
		this.keycontrolls = keycontrolls;
		this.tasks = tasks;
		this.taskAllots = taskAllots;
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

	public Depart getDepartByDepartId() {
		return this.departByDepartId;
	}

	public void setDepartByDepartId(Depart departByDepartId) {
		this.departByDepartId = departByDepartId;
	}

	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
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

	public Set<Keycontroll> getKeycontrolls() {
		return this.keycontrolls;
	}

	public void setKeycontrolls(Set<Keycontroll> keycontrolls) {
		this.keycontrolls = keycontrolls;
	}

	public Set<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	public Set<Depart> getDeparts() {
		return departs;
	}

	public void setDeparts(Set<Depart> departs) {
		this.departs = departs;
	}

	public Set<TaskAllot> getTaskAllots() {
		return taskAllots;
	}

	public void setTaskAllots(Set<TaskAllot> taskAllots) {
		this.taskAllots = taskAllots;
	}

	
}
