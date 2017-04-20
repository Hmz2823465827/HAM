package com.jxufe.ham.service;

import com.jxufe.ham.bean.Followup;

/**
 * 
 * @Description: 跟进记录service接口
 * @ClassName: FollowupService
 * @author halu
 * @date 2017年4月16日 下午5:15:19
 */
public interface FollowupService {
	
	/**
	 * 
	* @Title: load 
	* @Description: 通过id加载跟进记录
	* @param id
	* @return 是否添加成功
	 */
	public Followup load(int id);
	
	/**
	 * 
	* @Title: sava 
	* @Description: 保存跟进记录数据
	* @param e 
	* @return 实体类主键
	 */
	public int sava(Followup e);
	
	/**
	 * 
	* @Title: delete 
	* @Description:删除跟进记录
	* @param id
	* @return
	 */
	public void delete(Followup e);
	
	/**
	 * 
	* @Title: update 
	* @Description:更新数据
	* @param e
	* @return
	 */
	public void update(Followup e);
	
}
