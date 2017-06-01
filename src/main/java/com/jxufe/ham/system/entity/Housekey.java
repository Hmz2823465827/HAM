package com.jxufe.ham.system.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jxufe.ham.common.entity.BaseBean;
import com.jxufe.ham.system.entity.House;
import com.jxufe.ham.system.entity.Keymanagement;

/**
 * @Description: 房屋钥匙
 * @ClassName: Housekey
 * @author hmz
 * @date 2017年3月23日 下午3:39:28
 */
public class Housekey extends BaseBean {

	// 序列ID
	private static final long serialVersionUID = 2489409115101982577L;

	private int housekeyID;// 房屋钥匙编号

	private boolean housekeyStatue;// 房屋钥匙状态

	@JsonIgnore
	private Set<Keymanagement> keymanagements = new HashSet<Keymanagement>(0);// 房屋钥匙关系集合

	@JsonIgnore
	private Set<House> houses = new HashSet<House>(0);// 钥匙所属房屋

	public Housekey() {
		super();
	}

	public Housekey(int housekeyID, boolean housekeyStatue) {
		super();
		this.housekeyID = housekeyID;
		this.housekeyStatue = housekeyStatue;
	}

	public Housekey(int housekeyID, boolean housekeyStatue, Set<Keymanagement> keymanagements, Set<House> houses) {
		super();
		this.housekeyID = housekeyID;
		this.housekeyStatue = housekeyStatue;
		this.keymanagements = keymanagements;
		this.houses = houses;
	}

	public int getHousekeyID() {
		return housekeyID;
	}

	public void setHousekeyID(int housekeyID) {
		this.housekeyID = housekeyID;
	}

	public boolean isHousekeyStatue() {
		return housekeyStatue;
	}

	public void setHousekeyStatue(boolean housekeyStatue) {
		this.housekeyStatue = housekeyStatue;
	}

	public Set<Keymanagement> getKeymanagements() {
		return this.keymanagements;
	}

	public void setKeymanagements(Set<Keymanagement> keymanagements) {
		this.keymanagements = keymanagements;
	}

	public Set<House> getHouses() {
		return this.houses;
	}

	public void setHouses(Set<House> houses) {
		this.houses = houses;
	}

	@Override
	public String toString() {
		return "HouseKey [housekeyID=" + housekeyID + ", housekeyStatue=" + housekeyStatue + ",keymanagements="
				+ keymanagements.toString() + ", houses=" + houses.toString() + "]";
	}

}
