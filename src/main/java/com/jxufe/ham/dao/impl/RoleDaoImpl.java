package com.jxufe.ham.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jxufe.ham.bean.Role;
import com.jxufe.ham.bean.Log;
import com.jxufe.ham.dao.BaseDao;
import com.jxufe.ham.dao.RoleDao;

@Repository
public class RoleDaoImpl extends  RoleDao<Role> {
	
	@Autowired
	private SessionFactory sessionFactory;
    
    public Session getSession()  
    {  
        return sessionFactory.getCurrentSession();  
    } 
	/*
	 * 
	* Title: insert
	* Description: 
	* @param bean
	* @return
	* @see com.jxufe.ham.test.dao.RoleDao#insert(com.jxufe.ham.bean.Role)
	 */
	@Override
	public int insert(Role bean) {
		return (Integer) getSession().save(bean);
	}

	@Override
	public void delete(Role bean) {
		getSession().delete(bean);
	}


	@Override
	public Role select(int id) {
		Session session = getSession();
		Role list = (Role) session.get(Role.class, new Integer(id));		
		return list;
	}

	@Override
	public void update(Role bean) {
		Session session = getSession();
		Transaction transaction = session.getTransaction();
		session.update(bean);
		transaction.commit();
	}

	@Override
	public List<Role> queryForPage(String hql, int offset, int length) {
		return null;
	}

	@Override
	public int getCount(String hql) {
		return 0;
	}

	

	

}
