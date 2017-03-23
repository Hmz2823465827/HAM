package com.jxufe.ham.test.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 
 * @ClassName: Task
 * @author hongch
 * @date 2017年3月23日 下午4:35:42
 */
public class Task implements java.io.Serializable {

	//序列化ID
	private static final long serialVersionUID = 423611441373822314L;
	
	private int taskId;//任务编号
	
	private Employee employee;//发布任务员工
	
	private Date planDo;//计划完成时间
	
	private Date publishDate;//发布时间
	
	private boolean taskStatue;//任务状态
	
	private Integer taskLevel;//任务优先级
	
	private String taskInfo;//任务详情
	
	private Set<Employee> employees = new HashSet<Employee>(0);
	

	public Task() {
		super();
	}

	public Task(int taskId, Employee employee, Date planDo, Date publishDate, boolean taskStatue) {
		super();
		this.taskId = taskId;
		this.employee = employee;
		this.planDo = planDo;
		this.publishDate = publishDate;
		this.taskStatue = taskStatue;
	}

	public Task(int taskId, Employee employee, Date planDo, Date publishDate, boolean taskStatue, Integer taskLevel,
			String taskInfo, Set<Employee> employees) {
		super();
		this.taskId = taskId;
		this.employee = employee;
		this.planDo = planDo;
		this.publishDate = publishDate;
		this.taskStatue = taskStatue;
		this.taskLevel = taskLevel;
		this.taskInfo = taskInfo;
		this.employees = employees;
	}

	public int getTaskId() {
		return this.taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getPlanDo() {
		return this.planDo;
	}

	public void setPlanDo(Date planDo) {
		this.planDo = planDo;
	}

	public Date getPublishDate() {
		return this.publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public boolean isTaskStatue() {
		return this.taskStatue;
	}

	public void setTaskStatue(boolean taskStatue) {
		this.taskStatue = taskStatue;
	}

	public Integer getTaskLevel() {
		return this.taskLevel;
	}

	public void setTaskLevel(Integer taskLevel) {
		this.taskLevel = taskLevel;
	}

	public String getTaskInfo() {
		return this.taskInfo;
	}

	public void setTaskInfo(String taskInfo) {
		this.taskInfo = taskInfo;
	}

	public Set<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}
