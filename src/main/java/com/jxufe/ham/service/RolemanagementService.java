package com.jxufe.ham.service;

import com.jxufe.ham.bean.Rolemanagement;

/**
 * 
 * @Description: 权限管理service接口
 * @ClassName: RolemanagementService
 * @author halu
 * @date 2017年4月16日 下午5:15:19
 */
public interface RolemanagementService {
	
	/**
	 * 
	* @Title: load 
	* @Description: 通过id加载权限管理
	* @param id
	* @return 是否添加成功
	 */
	public Rolemanagement load(int id);
	
	/**
	 * 
	* @Title: sava 
	* @Description: 保存权限管理数据
	* @param e 
	* @return 实体类主键
	 */
	public int sava(Rolemanagement e);
	
	/**
	 * 
	* @Title: delete 
	* @Description:删除权限管理
	* @param id
	* @return
	 */
	public void delete(Rolemanagement e);
	
	/**
	 * 
	* @Title: update 
	* @Description:更新数据
	* @param e
	* @return
	 */
	public void update(Rolemanagement e);
	
}
