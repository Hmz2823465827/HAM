package com.jxufe.ham.system.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jxufe.ham.common.entity.BaseBean;
import com.jxufe.ham.system.entity.Employee;

/**
 * @Description: 留言实体类
 * @ClassName: Leaveword
 * @author hmz
 * @date 2017年3月23日 下午4:07:08
 */
public class Leaveword extends BaseBean{

	//序列ID
	private static final long serialVersionUID = 6237758949904689739L;

	private int leavewordId;//留言编号
	
	private Employee employee;//留言员工
	
	private Leaveword leaveword;//父留言
	
	private String leavewordContent;//留言内容
	
	private Date leavewordDate;//留言日期
	
	private Boolean anonymousStatue;//是否匿名
	
	@JsonIgnore
	private Set<Leaveword> leavewords = new HashSet<Leaveword>(0);//留言回复

	public Leaveword() {
		super();
	}

	public Leaveword(int leavewordId, Employee employee, String leavewordContent, Date leavewordDate) {
		super();
		this.leavewordId = leavewordId;
		this.employee = employee;
		this.leavewordContent = leavewordContent;
		this.leavewordDate = leavewordDate;
	}

	public Leaveword(int leavewordId, Employee employee, Leaveword leaveword, String leavewordContent,
			Date leavewordDate, Boolean anonymousStatue, Set<Leaveword> leavewords) {
		super();
		this.leavewordId = leavewordId;
		this.employee = employee;
		this.leaveword = leaveword;
		this.leavewordContent = leavewordContent;
		this.leavewordDate = leavewordDate;
		this.anonymousStatue = anonymousStatue;
		this.leavewords = leavewords;
	}

	public int getLeavewordId() {
		return this.leavewordId;
	}

	public void setLeavewordId(int leavewordId) {
		this.leavewordId = leavewordId;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Leaveword getLeaveword() {
		return this.leaveword;
	}

	public void setLeaveword(Leaveword leaveword) {
		this.leaveword = leaveword;
	}

	public String getLeavewordContent() {
		return this.leavewordContent;
	}

	public void setLeavewordContent(String leavewordContent) {
		this.leavewordContent = leavewordContent;
	}

	public Date getLeavewordDate() {
		return this.leavewordDate;
	}

	public void setLeavewordDate(Date leavewordDate) {
		this.leavewordDate = leavewordDate;
	}

	public Boolean getAnonymousStatue() {
		return this.anonymousStatue;
	}

	public void setAnonymousStatue(Boolean anonymousStatue) {
		this.anonymousStatue = anonymousStatue;
	}

	public Set<Leaveword> getLeavewords() {
		return this.leavewords;
	}

	public void setLeavewords(Set<Leaveword> leavewords) {
		this.leavewords = leavewords;
	}
	
	@Override
	public String toString() {
		return "Leaveword [leavewordId=" + leavewordId + ", employee=" + employee.getEmployeeName() +
				",leaveword=" + leaveword.leavewordId + ",leavewordContent=" + leavewordContent +
				", anonymousStatue=" + anonymousStatue + 
				",leavewords="+ leavewords.toString() +"]";
	}

}
