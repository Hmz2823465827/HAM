package com.jxufe.ham.bean;

import com.jxufe.ham.bean.Employee;
import com.jxufe.ham.bean.Task;
import com.jxufe.ham.bean.abstractBean.SerializeToJsonBean;

/**
 * @Description: 任务分配实体类
 * @ClassName: TaskAllot
 * @author halu
 * @date 2017年3月23日 下午5:47:39
 */
public class TaskAllot extends SerializeToJsonBean {

	//序列化ID
	private static final long serialVersionUID = -3011993280777513510L;

	private int taskAllotId;//任务分配编号
	
	private Employee employee; //执行任务员工
	
	private Task task; //任务

	
	
	public TaskAllot() {
		super();
	}

	
	
	public TaskAllot(int taskAllotId,Employee employee, Task task) {
		super();
		this.taskAllotId = taskAllotId;
		this.employee = employee;
		this.task = task;
	}

	

	public int getTaskAllotId() {
		return taskAllotId;
	}



	public void setTaskAllotId(int taskAllotId) {
		this.taskAllotId = taskAllotId;
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
		return "TaskAllot [taskAllotId=" + taskAllotId + ", employee=" + employee.getEmployeeName() +
				",task=" + task.getTaskId() +"]";
	}
	
	
}
