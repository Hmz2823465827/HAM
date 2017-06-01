package com.jxufe.ham.system.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jxufe.ham.common.entity.BaseBean;
import com.jxufe.ham.system.entity.Employee;
import com.jxufe.ham.system.entity.Housekey;

/**
 * @Description: 钥匙接管记录实体类
 * @ClassName: Keycontroll
 * @author hmz
 * @date 2017年3月23日 下午4:06:21
 */
public class Keymanagement extends BaseBean {

	//序列ID
	private static final long serialVersionUID = -4165822806960168304L;

	private int keymanagementId;//钥匙接管记录编号
	
	@JsonIgnore
	private Employee employee;//接管钥匙员工
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Housekey housekey;//房屋钥匙
	
	private boolean isApprove;//是否批准
	
	private Date approveDate;//接管时间
	
	private Date planReturnDate;//计划归还时间
	
	private Date actualReturnDate;//实际归还时间

	public Keymanagement() {
		super();
	}

	public Keymanagement(int keymanagementId, Employee employee, Housekey housekey, boolean isApprove, Date approveDate) {
		super();
		this.keymanagementId = keymanagementId;
		this.employee = employee;
		this.housekey = housekey;
		this.isApprove = isApprove;
		this.approveDate = approveDate;
	}

	public Keymanagement(int keymanagementId, Employee employee, Housekey housekey, boolean isApprove, Date approveDate,
			Date planReturnDate, Date actualReturnDate) {
		super();
		this.keymanagementId = keymanagementId;
		this.employee = employee;
		this.housekey = housekey;
		this.isApprove = isApprove;
		this.approveDate = approveDate;
		this.planReturnDate = planReturnDate;
		this.actualReturnDate = actualReturnDate;
	}

	public int getKeymanagementId() {
		return this.keymanagementId;
	}

	public void setKeymanagementId(int keymanagementId) {
		this.keymanagementId = keymanagementId;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Housekey getHousekey() {
		return this.housekey;
	}

	public void setHousekey(Housekey housekey) {
		this.housekey = housekey;
	}

	public boolean getIsApprove() {
		return this.isApprove;
	}

	public void setIsApprove(boolean isApprove) {
		this.isApprove = isApprove;
	}

	public Date getApproveDate() {
		return this.approveDate;
	}

	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}

	public Date getPlanReturnDate() {
		return this.planReturnDate;
	}

	public void setPlanReturnDate(Date planReturnDate) {
		this.planReturnDate = planReturnDate;
	}

	public Date getActualReturnDate() {
		return this.actualReturnDate;
	}

	public void setActualReturnDate(Date actualReturnDate) {
		this.actualReturnDate = actualReturnDate;
	}
	
	@Override
	public String toString() {
		return "Keycontroll [keymanagementId=" + keymanagementId + ", employee=" + employee.getEmployeeName() +
				  ", isApprove=" + isApprove + ", approveDate=" + approveDate + 
				",planReturnDate="+ planReturnDate + ",actualReturnDate="+actualReturnDate+"]";
	}

}
