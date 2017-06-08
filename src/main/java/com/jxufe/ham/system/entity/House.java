package com.jxufe.ham.system.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jxufe.ham.common.entity.BaseBean;
import com.jxufe.ham.system.entity.Employee;
import com.jxufe.ham.system.entity.Followup;
import com.jxufe.ham.system.entity.Housekey;
import com.jxufe.ham.system.entity.Housemap;
import com.jxufe.ham.system.entity.Pact;

/**
 * @Description: 房屋实体类
 * @ClassName: House
 * @author hongch
 * @date 2017年3月23日 下午3:28:20
 */
public class House extends BaseBean {

	//序列化ID
	private static final long serialVersionUID = -3370860611583081783L;

	private int houseId;//房屋编号
	
	@JsonIgnore
	private Employee employee;//负责员工

	@JsonIgnore
	private Housekey housekey;//房屋钥匙
	
	private boolean rentStatue;//租赁状态
	
	private boolean saleStatue;//销售状态
	
	private String houseAddress;//房屋地址
	
	private Float unitRentPrice;//单位（price/area）出租价格
	
	private Float unitSalePrice;//单位出售价格
	
	private String clientName;//房主姓名
	
	private String clientPhone;//房主联系方式
	
	@JsonIgnore
	private Set<Pact> pacts = new HashSet<Pact>(0);//合同
	
	@JsonIgnore
	private Set<Followup> followups = new HashSet<Followup>(0);//跟进记录
	
	@JsonIgnore
	private Set<Housemap> housemaps = new HashSet<Housemap>(0);//房屋地图

	public House() {
		super();
	}

	public House(int houseId, Housekey housekey, boolean rentStatue, boolean saleStatue, String houseAddress,
			String clientName) {
		super();
		this.houseId = houseId;
		this.housekey = housekey;
		this.rentStatue = rentStatue;
		this.saleStatue = saleStatue;
		this.houseAddress = houseAddress;
		this.clientName = clientName;
	}

	public House(int houseId, Employee employee, Housekey housekey, boolean rentStatue, boolean saleStatue,
			String houseAddress, Float unitRentPrice, Float unitSalePrice, String clientName, String clientPhone, Set<Pact> pacts,
			Set<Followup> followups, Set<Housemap> housemaps) {
		super();
		this.houseId = houseId;
		this.employee = employee;
		this.housekey = housekey;
		this.rentStatue = rentStatue;
		this.saleStatue = saleStatue;
		this.houseAddress = houseAddress;
		this.unitRentPrice = unitRentPrice;
		this.unitSalePrice = unitSalePrice;
		this.clientName = clientName;
		this.clientPhone = clientPhone;
		this.pacts = pacts;
		this.followups = followups;
		this.housemaps = housemaps;
	}

	public int getHouseId() {
		return this.houseId;
	}

	public void setHouseId(int houseId) {
		this.houseId = houseId;
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

	public boolean getRentStatue() {
		return this.rentStatue;
	}

	public void setRentStatue(boolean rentStatue) {
		this.rentStatue = rentStatue;
	}

	public boolean getSaleStatue() {
		return this.saleStatue;
	}

	public void setSaleStatue(boolean saleStatue) {
		this.saleStatue = saleStatue;
	}

	public String getHouseAddress() {
		return this.houseAddress;
	}

	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
	}

	public Float getUnitRentPrice() {
		return this.unitRentPrice;
	}

	public void setUnitRentPrice(Float unitRentPrice) {
		this.unitRentPrice = unitRentPrice;
	}

	public Float getUnitSalePrice() {
		return this.unitSalePrice;
	}

	public void setUnitSalePrice(Float unitSalePrice) {
		this.unitSalePrice = unitSalePrice;
	}

	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientPhone() {
		return this.clientPhone;
	}

	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}

	public Set<Pact> getPacts() {
		return this.pacts;
	}

	public void setPacts(Set<Pact> pacts) {
		this.pacts = pacts;
	}

	public Set<Followup> getFollowups() {
		return this.followups;
	}

	public void setFollowups(Set<Followup> followups) {
		this.followups = followups;
	}

	public Set<Housemap> getHousemaps() {
		return this.housemaps;
	}

	public void setHousemaps(Set<Housemap> housemaps) {
		this.housemaps = housemaps;
	}
	
	@Override
	public String toString() {
		return "House [houseId=" + houseId  +
				",rentStatue=" + rentStatue + ", saleStatue=" + saleStatue + ", houseAddress=" + houseAddress + 
				",unitRentPrice="+ unitRentPrice + ",unitSalePrice="+unitSalePrice+
				",clientName=" + clientName + ",clientPhone="+clientPhone+"]";
	}

}
