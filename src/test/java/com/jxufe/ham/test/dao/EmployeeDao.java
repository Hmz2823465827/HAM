package com.jxufe.ham.test.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.jxufe.ham.bean.Employee;

/**
 * @Description: 雇员dao层借口
 * @ClassName: EmployeeDao
 * @author halu
 * @date 2017年3月30日 上午8:58:15
 */
public interface EmployeeDao<E> {
	
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

	
	/**
	 * 
	* @Title: queryForPage 
	* @Description:分页查询
	* @param hql sql语句
	* @param offset 起始页码
	* @param length 一页保存数据
	* @return
	 */
	public List<Employee> queryForPage(String hql,int offset,int length);
	
	/**
	 * 
	* @Title: getCount 
	* @Description:获得计数
	* @param hql
	* @return
	 */
	public int getCount(String hql);
}
