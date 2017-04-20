package com.jxufe.ham.service;

import com.jxufe.ham.bean.Housemap;

/**
 * 
 * @Description: 房屋地图service接口
 * @ClassName: HousemapService
 * @author halu
 * @date 2017年4月16日 下午5:15:19
 */
public interface HousemapService {
	
	/**
	 * 
	* @Title: load 
	* @Description: 通过id加载房屋地图
	* @param id
	* @return 是否添加成功
	 */
	public Housemap load(int id);
	
	/**
	 * 
	* @Title: sava 
	* @Description: 保存房屋地图数据
	* @param e 
	* @return 实体类主键
	 */
	public int sava(Housemap e);
	
	/**
	 * 
	* @Title: delete 
	* @Description:删除房屋地图
	* @param id
	* @return
	 */
	public void delete(Housemap e);
	
	/**
	 * 
	* @Title: update 
	* @Description:更新数据
	* @param e
	* @return
	 */
	public void update(Housemap e);
	
}
