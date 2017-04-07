package com.jxufe.ham.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.jxufe.ham.bean.Custom;
import com.jxufe.ham.bean.Employee;
import com.jxufe.ham.bean.Pact;
import com.jxufe.ham.bean.abstractBean.SerializeToJsonBean;

/**
 * @Description: 绩效记录实体类
 * @ClassName: Performance
 * @author hmz
 * @date 2017年3月23日 下午4:26:59
 */
public class Performance extends SerializeToJsonBean{

	//序列化ID
	private static final long serialVersionUID = 4373359589941032482L;
	
	private int performanceId;//绩效编号
	
	private Custom custom;//客户
	
	private Employee employee;//员工
	
	private Pact pact;//合同
	
	private int employeeCoustomState;//绩效状态
	
	private int customType;//客户类别
	
	private Date registerDate;//登记时间
	
	private Date completeDate;//完成时间
	
	private String performanceInfo;//绩效时间
	
	private Set<Pact> pacts = new HashSet<Pact>(0);//绩效相关合同

	public Performance() {
		super();
	}

	public Performance(int performanceId, Employee employee, int employeeCoustomState, int customType,
			Date registerDate) {
		super();
		this.performanceId = performanceId;
		this.employee = employee;
		this.employeeCoustomState = employeeCoustomState;
		this.customType = customType;
		this.registerDate = registerDate;
	}

	public Performance(int performanceId, Custom custom, Employee employee, Pact pact, int employeeCoustomState,
			int customType, Date registerDate, Date completeDate, String performanceInfo, Set<Pact> pacts) {
		super();
		this.performanceId = performanceId;
		this.custom = custom;
		this.employee = employee;
		this.pact = pact;
		this.employeeCoustomState = employeeCoustomState;
		this.customType = customType;
		this.registerDate = registerDate;
		this.completeDate = completeDate;
		this.performanceInfo = performanceInfo;
		this.pacts = pacts;
	}

	public int getPerformanceId() {
		return this.performanceId;
	}

	public void setPerformanceId(int performanceId) {
		this.performanceId = performanceId;
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

	public Pact getPact() {
		return this.pact;
	}

	public void setPact(Pact pact) {
		this.pact = pact;
	}

	public int getEmployeeCoustomState() {
		return this.employeeCoustomState;
	}

	public void setEmployeeCoustomState(int employeeCoustomState) {
		this.employeeCoustomState = employeeCoustomState;
	}

	public int getCustomType() {
		return this.customType;
	}

	public void setCustomType(int customType) {
		this.customType = customType;
	}

	public Date getRegisterDate() {
		return this.registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Date getCompleteDate() {
		return this.completeDate;
	}

	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
	}

	public String getPerformanceInfo() {
		return this.performanceInfo;
	}

	public void setPerformanceInfo(String performanceInfo) {
		this.performanceInfo = performanceInfo;
	}

	public Set<Pact> getPacts() {
		return this.pacts;
	}

	public void setPacts(Set<Pact> pacts) {
		this.pacts = pacts;
	}
	
	@Override
	public String toString() {
		return "Performance [performanceId=" + performanceId + ", custom=" + custom.getCustomName() +
				",employee=" + employee.getEmployeeName() + ", pact=" + pact.getPactId() +
				", employeeCoustomState=" + employeeCoustomState + 
				",customType="+ customType + ",registerDate="+registerDate+
				",completeDate="+completeDate+",performanceInfo="+performanceInfo.toString()+
				",pacts="+ pacts.toString() +"]";
	}

}
