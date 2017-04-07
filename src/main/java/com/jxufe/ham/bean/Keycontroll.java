package com.jxufe.ham.bean;

import java.util.Date;

import com.jxufe.ham.bean.Employee;
import com.jxufe.ham.bean.Housekey;
import com.jxufe.ham.bean.abstractBean.SerializeToJsonBean;

/**
 * @Description: 钥匙接管记录实体类
 * @ClassName: Keycontroll
 * @author hmz
 * @date 2017年3月23日 下午4:06:21
 */
public class Keycontroll extends SerializeToJsonBean {

	//序列ID
	private static final long serialVersionUID = -4165822806960168304L;

	private int keyControllId;//钥匙接管记录编号
	
	private Employee employee;//接管钥匙员工
	
	private Housekey housekey;//房屋钥匙
	
	private boolean isApprove;//是否批准
	
	private Date approveDate;//接管时间
	
	private Date planReturnDate;//计划归还时间
	
	private Date actualReturnDate;//实际归还时间

	public Keycontroll() {
		super();
	}

	public Keycontroll(int keyControllId, Employee employee, Housekey housekey, boolean isApprove, Date approveDate) {
		super();
		this.keyControllId = keyControllId;
		this.employee = employee;
		this.housekey = housekey;
		this.isApprove = isApprove;
		this.approveDate = approveDate;
	}

	public Keycontroll(int keyControllId, Employee employee, Housekey housekey, boolean isApprove, Date approveDate,
			Date planReturnDate, Date actualReturnDate) {
		super();
		this.keyControllId = keyControllId;
		this.employee = employee;
		this.housekey = housekey;
		this.isApprove = isApprove;
		this.approveDate = approveDate;
		this.planReturnDate = planReturnDate;
		this.actualReturnDate = actualReturnDate;
	}

	public int getKeyControllId() {
		return this.keyControllId;
	}

	public void setKeyControllId(int keyControllId) {
		this.keyControllId = keyControllId;
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

	public boolean isIsApprove() {
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
		return "Keycontroll [keyControllId=" + keyControllId + ", employee=" + employee.getEmployeeName() +
				",housekey=" + housekey.getHouseKey() + ", isApprove=" + isApprove + ", approveDate=" + approveDate + 
				",planReturnDate="+ planReturnDate + ",actualReturnDate="+actualReturnDate+"]";
	}

}
