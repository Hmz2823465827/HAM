package com.jxufe.ham.service;

import com.jxufe.ham.bean.Task;

/**
 * 
 * @Description: 任务service接口
 * @ClassName: TaskService
 * @author halu
 * @date 2017年4月16日 下午5:15:19
 */
public interface TaskService {
	
	/**
	 * 
	* @Title: load 
	* @Description: 通过id加载任务
	* @param id
	* @return 是否添加成功
	 */
	public Task load(int id);
	
	/**
	 * 
	* @Title: sava 
	* @Description: 保存任务数据
	* @param e 
	* @return 实体类主键
	 */
	public int sava(Task e);
	
	/**
	 * 
	* @Title: delete 
	* @Description:删除任务
	* @param id
	* @return
	 */
	public void delete(Task e);
	
	/**
	 * 
	* @Title: update 
	* @Description:更新数据
	* @param e
	* @return
	 */
	public void update(Task e);
	
}
