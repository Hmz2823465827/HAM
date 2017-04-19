package com.jxufe.ham.service;

import com.jxufe.ham.bean.Housekey;

/**
 * 
 * @Description: 房屋钥匙service接口
 * @ClassName: HousekeyService
 * @author halu
 * @date 2017年4月16日 下午5:15:19
 */
public interface HousekeyService {
	
	/**
	 * 
	* @Title: load 
	* @Description: 通过id加载房屋钥匙
	* @param id
	* @return 是否添加成功
	 */
	public Housekey load(int id);
	
	/**
	 * 
	* @Title: sava 
	* @Description: 保存房屋钥匙数据
	* @param e 
	* @return 实体类主键
	 */
	public int sava(Housekey e);
	
	/**
	 * 
	* @Title: delete 
	* @Description:删除房屋钥匙
	* @param id
	* @return
	 */
	public void delete(Housekey e);
	
	/**
	 * 
	* @Title: update 
	* @Description:更新数据
	* @param e
	* @return
	 */
	public void update(Housekey e);
	
}
