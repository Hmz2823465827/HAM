package com.jxufe.ham.bean;

import java.util.Date;

import com.jxufe.ham.test.bean.Custom;
import com.jxufe.ham.test.bean.Employee;
import com.jxufe.ham.test.bean.House;

/**
 * @Description:跟进记录实体类 
 * @ClassName: Followup
 * @author hmz
 * @date 2017年3月23日 下午4:52:39
 */
public class Followup implements java.io.Serializable {

	//序列化ID
	private static final long serialVersionUID = 7304111280048835420L;
	
	private int followUpId;//跟进记录编号
	
	private Custom custom;//客户
	
	private Employee employee;//员工
	
	private House house;//房屋
	
	private int followUpStatue;//跟进状态
	
	private Date followUpDate;//跟进日期

	public Followup() {
		super();
	}

	public Followup(int followUpId, Custom custom, Employee employee, House house, int followUpStatue,
			Date followUpDate) {
		super();
		this.followUpId = followUpId;
		this.custom = custom;
		this.employee = employee;
		this.house = house;
		this.followUpStatue = followUpStatue;
		this.followUpDate = followUpDate;
	}

	public int getFollowUpId() {
		return this.followUpId;
	}

	public void setFollowUpId(int followUpId) {
		this.followUpId = followUpId;
	}

	public Custom getCustom() {
		return this.custom;
	}

	public void setCustom(Custom custom) {
		this.custom = custom;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public House getHouse() {
		return this.house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public int getFollowUpStatue() {
		return this.followUpStatue;
	}

	public void setFollowUpStatue(int followUpStatue) {
		this.followUpStatue = followUpStatue;
	}

	public Date getFollowUpDate() {
		return this.followUpDate;
	}

	public void setFollowUpDate(Date followUpDate) {
		this.followUpDate = followUpDate;
	}

}
