package com.jxufe.ham.bean;

import java.util.Date;

import com.jxufe.ham.bean.House;
import com.jxufe.ham.bean.abstractBean.BaseBean;

/**
 * @Description:房屋地图实体类 
 * @ClassName: Housemap
 * @author hmz
 * @date 2017年3月23日 下午3:58:38
 */
public class Housemap extends BaseBean{

	//序列ID
	private static final long serialVersionUID = -1035216073781582274L;

	private int houseMapId;//房屋地图编号
	
	private House house;//房屋地图所属房屋
	
	private String position;//位置
	
	private String image;//位置图片
	
	private Date updateTime;//上传时间

	public Housemap() {
		super();
	}

	public Housemap(int houseMapId, House house, String position, Date updateTime) {
		super();
		this.houseMapId = houseMapId;
		this.house = house;
		this.position = position;
		this.updateTime = updateTime;
	}

	public Housemap(int houseMapId, House house, String position, String image, Date updateTime) {
		super();
		this.houseMapId = houseMapId;
		this.house = house;
		this.position = position;
		this.image = image;
		this.updateTime = updateTime;
	}

	public int getHouseMapId() {
		return this.houseMapId; 
	}

	public void setHouseMapId(int houseMapId) {
		this.houseMapId = houseMapId;
	}

	public House getHouse() {
		return this.house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	@Override
	public String toString() {
		return "Housemap [houseMapId=" + houseMapId + ", house=" + house.getHouseId() +
				",position=" + position + ", image=" + image + ", updateTime=" + updateTime +"]";
	}

}
