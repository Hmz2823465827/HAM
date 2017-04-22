package com.jxufe.ham.bean;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jxufe.ham.bean.abstractBean.BaseBean;

/**
 * @Description: 用户实体类
 * @ClassName: Custom
 * @author hmz
 * @date 2017年3月23日 上午10:12:03
 */
public class Custom extends BaseBean {

	//序列ID
	private static final long serialVersionUID = 5349459242972743720L;

	private int customId;//客户ID
	
	private String customName;//客户名称
	
	private boolean customSex;//客户性别
	
	private String customInfo;//客户详细信息
	
	private int customRank;//客户等级
	
	private Float purposePrice;//意向价格
	
	private Float purposeArea;//意向面积
	
	private String purposePosition;//意向位置
	
	@JsonIgnore
	private Set<Performance> performances = new HashSet<Performance>(0);//绩效
	
	@JsonIgnore
	private Set<Followup> followups = new HashSet<Followup>(0);//跟进

	public Custom() {
		super();
	}

	public Custom(int customId, String customName, boolean customSex, int customRank) {
		super();
		this.customId = customId;
		this.customName = customName;
		this.customSex = customSex;
		this.customRank = customRank;
	}

	public Custom(int customId, String customName, boolean customSex, String customInfo, int customRank,
			Float purposePrice, Float purposeArea, String purposePosition, Set<Performance> performances, Set<Followup> followups) {
		super();
		this.customId = customId;
		this.customName = customName;
		this.customSex = customSex;
		this.customInfo = customInfo;
		this.customRank = customRank;
		this.purposePrice = purposePrice;
		this.purposeArea = purposeArea;
		this.purposePosition = purposePosition;
		this.performances = performances;
		this.followups = followups;
	}

	public int getCustomId() {
		return this.customId;
	}

	public void setCustomId(int customId) {
		this.customId = customId;
	}

	public String getCustomName() {
		return this.customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	public boolean isCustomSex() {
		return this.customSex;
	}

	public void setCustomSex(boolean customSex) {
		this.customSex = customSex;
	}

	public String getCustomInfo() {
		return this.customInfo;
	}

	public void setCustomInfo(String customInfo) {
		this.customInfo = customInfo;
	}

	public int getCustomRank() {
		return this.customRank;
	}

	public void setCustomRank(int customRank) {
		this.customRank = customRank;
	}

	public Float getPurposePrice() {
		return this.purposePrice;
	}

	public void setPurposePrice(Float purposePrice) {
		this.purposePrice = purposePrice;
	}

	public Float getPurposeArea() {
		return this.purposeArea;
	}

	public void setPurposeArea(Float purposeArea) {
		this.purposeArea = purposeArea;
	}

	public String getPurposePosition() {
		return this.purposePosition;
	}

	public void setPurposePosition(String purposePosition) {
		this.purposePosition = purposePosition;
	}

	public Set<Performance> getPerformances() {
		return this.performances;
	}

	public void setPerformances(Set<Performance> performances) {
		this.performances = performances;
	}

	public Set<Followup> getFollowups() {
		return this.followups;
	}

	public void setFollowups(Set<Followup> followups) {
		this.followups = followups;
	}
	
	@Override
	public String toString() {
		return "Custom [customId=" + customId + ", customName=" + customName +
				",customSex=" + customSex + ", customInfo=" + customInfo + ", customRank=" + customRank + 
				",purposePrice="+ purposePrice + ",purposeArea="+purposeArea+
				",purposePosition="+purposePosition+",performances="+performances.toString()+
				",followups="+ followups.toString() +"]";
	}

}
