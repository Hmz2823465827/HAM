package com.jxufe.ham.service;

import com.jxufe.ham.bean.Workrecord;

/**
 * 
 * @Description: 工作记录service接口
 * @ClassName: WorkrecordService
 * @author halu
 * @date 2017年4月16日 下午5:15:19
 */
public interface WorkrecordService {
	
	/**
	 * 
	* @Title: load 
	* @Description: 通过id加载工作记录
	* @param id
	* @return 是否添加成功
	 */
	public Workrecord load(int id);
	
	/**
	 * 
	* @Title: sava 
	* @Description: 保存工作记录数据
	* @param e 
	* @return 实体类主键
	 */
	public int sava(Workrecord e);
	
	/**
	 * 
	* @Title: delete 
	* @Description:删除工作记录
	* @param id
	* @return
	 */
	public void delete(Workrecord e);
	
	/**
	 * 
	* @Title: update 
	* @Description:更新数据
	* @param e
	* @return
	 */
	public void update(Workrecord e);
	
}
