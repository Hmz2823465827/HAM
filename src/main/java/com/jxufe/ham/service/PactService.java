package com.jxufe.ham.service;

import com.jxufe.ham.bean.Pact;

/**
 * 
 * @Description: 合同service接口
 * @ClassName: PactService
 * @author halu
 * @date 2017年4月16日 下午5:15:19
 */
public interface PactService {
	
	/**
	 * 
	* @Title: load 
	* @Description: 通过id加载合同
	* @param id
	* @return 是否添加成功
	 */
	public Pact load(int id);
	
	/**
	 * 
	* @Title: sava 
	* @Description: 保存合同数据
	* @param e 
	* @return 实体类主键
	 */
	public int sava(Pact e);
	
	/**
	 * 
	* @Title: delete 
	* @Description:删除合同
	* @param id
	* @return
	 */
	public void delete(Pact e);
	
	/**
	 * 
	* @Title: update 
	* @Description:更新数据
	* @param e
	* @return
	 */
	public void update(Pact e);
	
}
