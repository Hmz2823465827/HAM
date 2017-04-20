package com.jxufe.ham.service;

import com.jxufe.ham.bean.Depart;

/**
 * 
 * @Description: 部门service接口
 * @ClassName: DepartService
 * @author halu
 * @date 2017年4月16日 下午5:15:19
 */
public interface DepartService {
	
	/**
	 * 
	* @Title: load 
	* @Description: 通过id加载部门
	* @param id
	* @return 是否添加成功
	 */
	public Depart load(int id);
	
	/**
	 * 
	* @Title: sava 
	* @Description: 保存部门数据
	* @param e 
	* @return 实体类主键
	 */
	public int sava(Depart e);
	
	/**
	 * 
	* @Title: delete 
	* @Description:删除部门
	* @param id
	* @return
	 */
	public void delete(Depart e);
	
	/**
	 * 
	* @Title: update 
	* @Description:更新数据
	* @param e
	* @return
	 */
	public void update(Depart e);
	
}
