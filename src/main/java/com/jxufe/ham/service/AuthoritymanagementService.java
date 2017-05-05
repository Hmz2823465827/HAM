package com.jxufe.ham.service;

import java.util.List;

import com.jxufe.ham.bean.Authoritymanagement;

/**
 * 
 * @Description: 权限管理service接口
 * @ClassName: AuthoritymanagementService
 * @author halu
 * @date 2017年4月16日 下午5:15:19
 */
public interface AuthoritymanagementService {
	
	/**
	 * 
	* @Title: load 
	* @Description: 通过id加载权限管理
	* @param id
	* @return 是否添加成功
	 */
	public Authoritymanagement load(int id);
	
	/**
	 * 
	* @Title: sava 
	* @Description: 保存权限管理数据
	* @param e 
	* @return 实体类主键
	 */
	public int sava(Authoritymanagement e);
	
	/**
	 * 
	* @Title: delete 
	* @Description:删除权限管理
	* @param id
	* @return
	 */
	public void delete(Authoritymanagement e);
	
	/**
	 * 
	* @Title: update 
	* @Description:更新数据
	* @param e
	* @return
	 */
	public void update(Authoritymanagement e);

	public List<Authoritymanagement> findAll();
	
}
