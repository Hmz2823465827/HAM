package com.jxufe.ham.service;

import com.jxufe.ham.bean.Log;

/**
 * 
 * @Description: 工作日志service接口
 * @ClassName: LogService
 * @author halu
 * @date 2017年4月16日 下午5:15:19
 */
public interface LogService {
	
	/**
	 * 
	* @Title: load 
	* @Description: 通过id加载工作日志
	* @param id
	* @return 是否添加成功
	 */
	public Log load(int id);
	
	/**
	 * 
	* @Title: sava 
	* @Description: 保存工作日志数据
	* @param e 
	* @return 实体类主键
	 */
	public int sava(Log e);
	
	/**
	 * 
	* @Title: delete 
	* @Description:删除工作日志
	* @param id
	* @return
	 */
	public void delete(Log e);
	
	/**
	 * 
	* @Title: update 
	* @Description:更新数据
	* @param e
	* @return
	 */
	public void update(Log e);
	
}
