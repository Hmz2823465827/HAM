package com.jxufe.ham.bean;

import java.util.Date;

import com.jxufe.ham.bean.Employee;
import com.jxufe.ham.bean.abstractBean.SerializeToJsonBean;

/**
 * @Description: 系统日志实体类
 * @ClassName: Log
 * @author hmz
 * @date 2017年3月23日 下午4:11:55
 */
public class Log extends SerializeToJsonBean {

	//序列ID
	private static final long serialVersionUID = -1768221857188736658L;

	private int logId;//日志编号
	
	private Employee employee;//操作员工
	
	private Date logDate;//登入时间
	
	private Date quitDate;//登出时间

	public Log() {
		super();
	}

	public Log(int logId, Date logDate) {
		super();
		this.logId = logId;
		this.logDate = logDate;
	} 

	
	public Log(int logId, Employee employee, Date logDate, Date quitDate) {
		super();
		this.logId = logId;
		this.employee = employee;
		this.logDate = logDate;
		this.quitDate = quitDate;
	}

	public int getLogId() {
		return this.logId;
	}

	public void setLogId(int logId) {
		this.logId = logId;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getLogDate() {
		return this.logDate;
	}

	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}

	public Date getQuitDate() {
		return this.quitDate;
	}

	public void setQuitDate(Date quitDate) {
		this.quitDate = quitDate;
	}

}
