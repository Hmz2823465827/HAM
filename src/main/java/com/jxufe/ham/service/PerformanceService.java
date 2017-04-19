package com.jxufe.ham.service;

import com.jxufe.ham.bean.Performance;

/**
 * 
 * @Description: 绩效service接口
 * @ClassName: PerformanceService
 * @author halu
 * @date 2017年4月16日 下午5:15:19
 */
public interface PerformanceService {
	
	/**
	 * 
	* @Title: load 
	* @Description: 通过id加载绩效
	* @param id
	* @return 是否添加成功
	 */
	public Performance load(int id);
	
	/**
	 * 
	* @Title: sava 
	* @Description: 保存绩效数据
	* @param e 
	* @return 实体类主键
	 */
	public int sava(Performance e);
	
	/**
	 * 
	* @Title: delete 
	* @Description:删除绩效
	* @param id
	* @return
	 */
	public void delete(Performance e);
	
	/**
	 * 
	* @Title: update 
	* @Description:更新数据
	* @param e
	* @return
	 */
	public void update(Performance e);
	
}
