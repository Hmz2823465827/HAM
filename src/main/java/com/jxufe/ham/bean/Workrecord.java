package com.jxufe.ham.bean;

import java.util.Date;

import com.jxufe.ham.bean.Employee;
import com.jxufe.ham.bean.abstractBean.SerializeToJsonBean;

/**
 * @Description: 考勤实体类
 * @ClassName: Workrecord
 * @author hmz
 * @date 2017年3月23日 下午4:42:54
 */
public class Workrecord extends SerializeToJsonBean{

	//序列化ID
	private static final long serialVersionUID = 4683325736254304171L;
	
	private int workRecordId;//考勤编号
	
	private Employee employee;//员工
	
	private Date workRecordDate;//考勤日期
	
	private Date actualSignIn;//上班打卡时间
	
	private Date leaveSignIn;//下班打卡时间

	public Workrecord() {
		super();
	}

	public Workrecord(int workRecordId, Employee employee, Date workRecordDate) {
		super();
		this.workRecordId = workRecordId;
		this.employee = employee;
		this.workRecordDate = workRecordDate;
	}

	public Workrecord(int workRecordId, Employee employee, Date workRecordDate, Date actualSignIn, Date leaveSignIn) {
		super();
		this.workRecordId = workRecordId;
		this.employee = employee;
		this.workRecordDate = workRecordDate;
		this.actualSignIn = actualSignIn;
		this.leaveSignIn = leaveSignIn;
	}

	public int getWorkRecordId() {
		return this.workRecordId;
	}

	public void setWorkRecordId(int workRecordId) {
		this.workRecordId = workRecordId;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getWorkRecordDate() {
		return this.workRecordDate;
	}

	public void setWorkRecordDate(Date workRecordDate) {
		this.workRecordDate = workRecordDate;
	}

	public Date getActualSignIn() {
		return this.actualSignIn;
	}

	public void setActualSignIn(Date actualSignIn) {
		this.actualSignIn = actualSignIn;
	}

	public Date getLeaveSignIn() {
		return this.leaveSignIn;
	}

	public void setLeaveSignIn(Date leaveSignIn) {
		this.leaveSignIn = leaveSignIn;
	}
	
	@Override
	public String toString() {
		return "Workrecord [workRecordId=" + workRecordId + ", employee=" + employee.getEmployeeName() +
				",workRecordDate=" + workRecordDate + ", actualSignIn=" + actualSignIn +
				", leaveSignIn=" + leaveSignIn +"]";
	}

}
