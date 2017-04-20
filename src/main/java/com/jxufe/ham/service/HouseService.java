package com.jxufe.ham.service;

import com.jxufe.ham.bean.House;

/**
 * 
 * @Description: 房屋service接口
 * @ClassName: HouseService
 * @author halu
 * @date 2017年4月16日 下午5:15:19
 */
public interface HouseService {
	
	/**
	 * 
	* @Title: load 
	* @Description: 通过id加载房屋
	* @param id
	* @return 是否添加成功
	 */
	public House load(int id);
	
	/**
	 * 
	* @Title: sava 
	* @Description: 保存房屋数据
	* @param e 
	* @return 实体类主键
	 */
	public int sava(House e);
	
	/**
	 * 
	* @Title: delete 
	* @Description:删除房屋
	* @param id
	* @return
	 */
	public void delete(House e);
	
	/**
	 * 
	* @Title: update 
	* @Description:更新数据
	* @param e
	* @return
	 */
	public void update(House e);
	
}
