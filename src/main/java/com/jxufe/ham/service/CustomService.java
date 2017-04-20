package com.jxufe.ham.service;

import com.jxufe.ham.bean.Custom;

/**
 * 
 * @Description: 顾客service接口
 * @ClassName: CustomService
 * @author halu
 * @date 2017年4月16日 下午5:15:19
 */
public interface CustomService {
	
	/**
	 * 
	* @Title: load 
	* @Description: 通过id加载顾客
	* @param id
	* @return 是否添加成功
	 */
	public Custom load(int id);
	
	/**
	 * 
	* @Title: sava 
	* @Description: 保存顾客数据
	* @param e 
	* @return 实体类主键
	 */
	public int sava(Custom e);
	
	/**
	 * 
	* @Title: delete 
	* @Description:删除顾客
	* @param id
	* @return
	 */
	public void delete(Custom e);
	
	/**
	 * 
	* @Title: update 
	* @Description:更新数据
	* @param e
	* @return
	 */
	public void update(Custom e);
	
}
