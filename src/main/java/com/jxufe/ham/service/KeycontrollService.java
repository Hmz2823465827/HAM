package com.jxufe.ham.service;

import com.jxufe.ham.bean.Keycontroll;

/**
 * 
 * @Description: 钥匙控制service接口
 * @ClassName: KeycontrollService
 * @author halu
 * @date 2017年4月16日 下午5:15:19
 */
public interface KeycontrollService {
	
	/**
	 * 
	* @Title: load 
	* @Description: 通过id加载钥匙控制
	* @param id
	* @return 是否添加成功
	 */
	public Keycontroll load(int id);
	
	/**
	 * 
	* @Title: sava 
	* @Description: 保存钥匙控制数据
	* @param e 
	* @return 实体类主键
	 */
	public int sava(Keycontroll e);
	
	/**
	 * 
	* @Title: delete 
	* @Description:删除钥匙控制
	* @param id
	* @return
	 */
	public void delete(Keycontroll e);
	
	/**
	 * 
	* @Title: update 
	* @Description:更新数据
	* @param e
	* @return
	 */
	public void update(Keycontroll e);
	
}
