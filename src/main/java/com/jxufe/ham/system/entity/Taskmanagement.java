package com.jxufe.ham.system.entity;

import com.jxufe.ham.common.entity.BaseBean;
import com.jxufe.ham.system.entity.Employee;
import com.jxufe.ham.system.entity.Task;

/**
 * @Description: 任务分配实体类
 * @ClassName: Taskmanagement
 * @author halu
 * @date 2017年3月23日 下午5:47:39
 */
public class Taskmanagement extends BaseBean {

	//序列化ID
	private static final long serialVersionUID = -3011993280777513510L;

	private int taskmanagementId;//任务分配编号
	
	private Employee employee; //执行任务员工
	
	private Task task; //任务

	public Taskmanagement() {
		super();
	}
	
	public Taskmanagement(int taskmanagementId,Employee employee, Task task) {
		super();
		this.taskmanagementId = taskmanagementId;
		this.employee = employee;
		this.task = task;
	}

	

	public int getTaskmanagementId() {
		return taskmanagementId;
	}



	public void setTaskmanagementId(int taskmanagementId) {
		this.taskmanagementId = taskmanagementId;
	}



	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
	
	@Override
	public String toString() {
		return "Taskmanagement [taskmanagementId=" + taskmanagementId + ", employee=" + employee.getEmployeeName() +
				",task=" + task.getTaskId() +"]";
	}
	
	
}
