package com.jxufe.ham.dao;

import java.util.List;

import com.jxufe.ham.bean.Function;

/**
 * @Description: 权限过滤dao层接口
 * @ClassName: FunctionDao
 * @author halu
 * @date 2017年3月30日 上午8:58:15
 */

public abstract class FunctionDao<E> extends BaseDao<E>{
	
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

	/**
	 * 
	* @Title: findAll 
	* @Description:获取所有记录
	* @return
	 */
	public abstract List<Function> findAll();

}
