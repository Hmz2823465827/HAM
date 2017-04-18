package com.jxufe.ham.dao;

import java.util.List;

/**
 * @Description: 房屋钥匙dao层接口
 * @ClassName: HousekeyDao
 * @author halu
 * @date 2017年3月30日 上午8:58:15
 */

public abstract class HousekeyDao<E> extends BaseDao<E>{
	
	/**
	 * 
	* @Title: queryForPage 
	* @Description:分页查询
	* @param hql sql语句
	* @param offset 起始页码
	* @param length 一页保存数据
	* @return
	 */
	public abstract List<E> queryForPage(String hql,int offset,int length);
	
	/**
	 * 
	* @Title: getCount 
	* @Description:获得计数
	* @param hql
	* @return
	 */
	public abstract int getCount(String hql);

}
