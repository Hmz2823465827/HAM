package com.jxufe.ham.dao;

import java.util.List;

import com.jxufe.ham.bean.Employee;

/**
 * 
 * @Description: dao类的父类
 * @ClassName: BaseDao
 * @author halu
 * @date 2017年3月31日 上午8:15:29
 */
public abstract class BaseDao<E> {
	/**
	 * 
	* @Title: insert 
	* @Description:增
	* @param e
	* @return
	 */
	public abstract int insert(E e);

	/**
	 * 
	* @Title: delete 
	* @Description:删
	* @param e
	* @return
	 */
	public abstract void delete(E e);
	
	/**
	 * 
	* @Title: select 
	* @Description:查
	* @param e
	* @return
	 */
	public abstract Employee select(int id);
	
	/**
	 * 
	* @Title: update 
	* @Description:改
	* @param e
	* @return
	 */
	public abstract Employee update(E e);

	

}
