package com.jxufe.ham.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.jxufe.ham.bean.House;
import com.jxufe.ham.bean.Performance;
import com.jxufe.ham.bean.abstractBean.SerializeToJsonBean;

/**
 * @Description: 合同实体类
 * @ClassName: Pact
 * @author hmz
 * @date 2017年3月23日 下午4:15:14
 */
public class Pact extends SerializeToJsonBean{

	//序列化ID
	private static final long serialVersionUID = 8768850238249330372L;

	private int pactId;//合同编号
	
	private House house;//关联房屋
	
	private int pactStatue;//合同进度
	
	private Date pactDate;//创建时间
	
	private String pactInfo;//合同详细信息
	
	private Set<Performance> performances = new HashSet<Performance>(0);//绩效

	public Pact() {
		super();
	}

	public Pact(int pactId, House house, int pactStatue, Date pactDate) {
		super();
		this.pactId = pactId;
		this.house = house;
		this.pactStatue = pactStatue;
		this.pactDate = pactDate;
	}

	public Pact(int pactId, House house, int pactStatue, Date pactDate, String pactInfo,
			Set<Performance> performances) {
		super();
		this.pactId = pactId;
		this.house = house;
		this.pactStatue = pactStatue;
		this.pactDate = pactDate;
		this.pactInfo = pactInfo;
		this.performances = performances;
	}

	public int getPactId() {
		return this.pactId;
	}

	public void setPactId(int pactId) {
		this.pactId = pactId;
	}

	public House getHouse() {
		return this.house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public int getPactStatue() {
		return this.pactStatue;
	}

	public void setPactStatue(int pactStatue) {
		this.pactStatue = pactStatue;
	}

	public Date getPactDate() {
		return this.pactDate;
	}

	public void setPactDate(Date pactDate) {
		this.pactDate = pactDate;
	}

	public String getPactInfo() {
		return this.pactInfo;
	}

	public void setPactInfo(String pactInfo) {
		this.pactInfo = pactInfo;
	}

	public Set<Performance> getPerformances() {
		return this.performances;
	}

	public void setPerformances(Set<Performance> performances) {
		this.performances = performances;
	}

	
}
