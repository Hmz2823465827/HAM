package com.jxufe.ham.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jxufe.ham.bean.Rolemanagement;
import com.jxufe.ham.bean.Log;
import com.jxufe.ham.dao.BaseDao;
import com.jxufe.ham.dao.RolemanagementDao;

@Repository
public class RolemanagementDaoImpl extends  RolemanagementDao<Rolemanagement> {
	
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
	* @see com.jxufe.ham.test.dao.RolemanagementDao#insert(com.jxufe.ham.bean.Rolemanagement)
	 */
	@Override
	public int insert(Rolemanagement bean) {
		return (Integer) getSession().save(bean);
	}

	@Override
	public void delete(Rolemanagement bean) {
		getSession().delete(bean);
	}


	@Override
	public Rolemanagement select(int id) {
		Session session = getSession();
		Rolemanagement list = (Rolemanagement) session.get(Rolemanagement.class, new Integer(id));		
		return list;
	}

	@Override
	public void update(Rolemanagement bean) {
		Session session = getSession();
		Transaction transaction = session.getTransaction();
		session.update(bean);
		transaction.commit();
	}

	@Override
	public List<Rolemanagement> queryForPage(String hql, int offset, int length) {
		return null;
	}

	@Override
	public int getCount(String hql) {
		return 0;
	}

	

	

}
