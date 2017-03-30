package com.jxufe.ham.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.jxufe.ham.bean.abstractBean.SerializeToJsonBean;

/**
 * @Description: 留言实体类
 * @ClassName: Leaveword
 * @author hmz
 * @date 2017年3月23日 下午4:07:08
 */
public class Leaveword extends SerializeToJsonBean{

	//序列ID
	private static final long serialVersionUID = 6237758949904689739L;

	private int leaveWordId;//留言编号
	
	private Employee employee;//留言员工
	
	private Leaveword leaveword;//父留言
	
	private String leaveWordContent;//留言内容
	
	private Date leaveWordDate;//留言日期
	
	private Boolean anonymousStatue;//是否匿名
	
	private Set<Leaveword> leavewords = new HashSet<Leaveword>(0);//留言回复

	public Leaveword() {
		super();
	}

	public Leaveword(int leaveWordId, Employee employee, String leaveWordContent, Date leaveWordDate) {
		super();
		this.leaveWordId = leaveWordId;
		this.employee = employee;
		this.leaveWordContent = leaveWordContent;
		this.leaveWordDate = leaveWordDate;
	}

	public Leaveword(int leaveWordId, Employee employee, Leaveword leaveword, String leaveWordContent,
			Date leaveWordDate, Boolean anonymousStatue, Set<Leaveword> leavewords) {
		super();
		this.leaveWordId = leaveWordId;
		this.employee = employee;
		this.leaveword = leaveword;
		this.leaveWordContent = leaveWordContent;
		this.leaveWordDate = leaveWordDate;
		this.anonymousStatue = anonymousStatue;
		this.leavewords = leavewords;
	}

	public int getLeaveWordId() {
		return this.leaveWordId;
	}

	public void setLeaveWordId(int leaveWordId) {
		this.leaveWordId = leaveWordId;
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

	public String getLeaveWordContent() {
		return this.leaveWordContent;
	}

	public void setLeaveWordContent(String leaveWordContent) {
		this.leaveWordContent = leaveWordContent;
	}

	public Date getLeaveWordDate() {
		return this.leaveWordDate;
	}

	public void setLeaveWordDate(Date leaveWordDate) {
		this.leaveWordDate = leaveWordDate;
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

}
