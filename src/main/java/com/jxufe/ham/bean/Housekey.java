package com.jxufe.ham.bean;

import java.util.HashSet;
import java.util.Set;

import com.jxufe.ham.bean.abstractBean.SerializeToJsonBean;
import com.jxufe.ham.bean.House;
import com.jxufe.ham.bean.Keycontroll;

/**
 * @Description: 房屋钥匙
 * @ClassName: Housekey
 * @author hmz
 * @date 2017年3月23日 下午3:39:28
 */
public class Housekey extends SerializeToJsonBean{

	//序列ID
	private static final long serialVersionUID = 2489409115101982577L;

	private int houseKey;//房屋钥匙编号
	
	private boolean houseKeyStatue;//房屋钥匙状态
	
	private Set<Keycontroll> keycontrolls = new HashSet<Keycontroll>(0);//房屋钥匙关系集合
	
	private Set<House> houses = new HashSet<House>(0);//钥匙所属房屋

	public Housekey() {
		super();
	}

	public Housekey(int houseKey, boolean houseKeyStatue) {
		super();
		this.houseKey = houseKey;
		this.houseKeyStatue = houseKeyStatue;
	}

	public Housekey(int houseKey, boolean houseKeyStatue, Set<Keycontroll> keycontrolls, Set<House> houses) {
		super();
		this.houseKey = houseKey;
		this.houseKeyStatue = houseKeyStatue;
		this.keycontrolls = keycontrolls;
		this.houses = houses;
	}

	public int getHouseKey() {
		return this.houseKey;
	}

	public void setHouseKey(int houseKey) {
		this.houseKey = houseKey;
	}

	public boolean isHouseKeyStatue() {
		return this.houseKeyStatue;
	}

	public void setHouseKeyStatue(boolean houseKeyStatue) {
		this.houseKeyStatue = houseKeyStatue;
	}

	public Set<Keycontroll> getKeycontrolls() {
		return this.keycontrolls;
	}

	public void setKeycontrolls(Set<Keycontroll> keycontrolls) {
		this.keycontrolls = keycontrolls;
	}

	public Set<House> getHouses() {
		return this.houses;
	}

	public void setHouses(Set<House> houses) {
		this.houses = houses;
	}

}
