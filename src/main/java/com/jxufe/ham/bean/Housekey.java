package com.jxufe.ham.bean;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jxufe.ham.bean.House;
import com.jxufe.ham.bean.Keymanagement;
import com.jxufe.ham.bean.abstractBean.BaseBean;

/**
 * @Description: 房屋钥匙
 * @ClassName: Housekey
 * @author hmz
 * @date 2017年3月23日 下午3:39:28
 */
public class Housekey extends BaseBean{

	//序列ID
	private static final long serialVersionUID = 2489409115101982577L;

	private int houseKey;//房屋钥匙编号
	
	private boolean houseKeyStatue;//房屋钥匙状态
	
	@JsonIgnore
	private Set<Keymanagement> keymanagements = new HashSet<Keymanagement>(0);//房屋钥匙关系集合
	
	@JsonIgnore
	private Set<House> houses = new HashSet<House>(0);//钥匙所属房屋

	public Housekey() {
		super();
	}

	public Housekey(int houseKey, boolean houseKeyStatue) {
		super();
		this.houseKey = houseKey;
		this.houseKeyStatue = houseKeyStatue;
	}

	public Housekey(int houseKey, boolean houseKeyStatue, Set<Keymanagement> keymanagements, Set<House> houses) {
		super();
		this.houseKey = houseKey;
		this.houseKeyStatue = houseKeyStatue;
		this.keymanagements = keymanagements;
		this.houses = houses;
	}

	public int getHouseKey() {
		return this.houseKey;
	}

	public void setHouseKey(int houseKey) {
		this.houseKey = houseKey;
	}

	public boolean getHouseKeyStatue() {
		return this.houseKeyStatue;
	}

	public void setHouseKeyStatue(boolean houseKeyStatue) {
		this.houseKeyStatue = houseKeyStatue;
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
		return "HouseKey [houseKey=" + houseKey + ", houseKeyStatue=" + houseKeyStatue +
				",keymanagements=" + keymanagements.toString() + ", houses="+
				houses.toString() +"]";
	}

}
