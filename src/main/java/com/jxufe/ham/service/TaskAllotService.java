package com.jxufe.ham.service;

import com.jxufe.ham.bean.TaskAllot;

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
	public TaskAllot load(int id);
	
	/**
	 * 
	* @Title: sava 
	* @Description: 保存任务分配数据
	* @param e 
	* @return 实体类主键
	 */
	public int sava(TaskAllot e);
	
	/**
	 * 
	* @Title: delete 
	* @Description:删除任务分配
	* @param id
	* @return
	 */
	public void delete(TaskAllot e);
	
	/**
	 * 
	* @Title: update 
	* @Description:更新数据
	* @param e
	* @return
	 */
	public void update(TaskAllot e);
	
}
