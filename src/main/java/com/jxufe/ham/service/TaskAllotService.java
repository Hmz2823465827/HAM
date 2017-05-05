package com.jxufe.ham.service;

import com.jxufe.ham.bean.Taskmanagement;

/**
 * 
 * @Description: 任务分配service接口
 * @ClassName: TaskAllotService
 * @author halu
 * @date 2017年4月16日 下午5:15:19
 */
public interface TaskAllotService {
	
	/**
	 * 
	* @Title: load 
	* @Description: 通过id加载任务分配
	* @param id
	* @return 是否添加成功
	 */
	public Taskmanagement load(int id);
	
	/**
	 * 
	* @Title: sava 
	* @Description: 保存任务分配数据
	* @param e 
	* @return 实体类主键
	 */
	public int sava(Taskmanagement e);
	
	/**
	 * 
	* @Title: delete 
	* @Description:删除任务分配
	* @param id
	* @return
	 */
	public void delete(Taskmanagement e);
	
	/**
	 * 
	* @Title: update 
	* @Description:更新数据
	* @param e
	* @return
	 */
	public void update(Taskmanagement e);
	
}
