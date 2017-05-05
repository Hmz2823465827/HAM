package com.jxufe.ham.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jxufe.ham.bean.Authoritymanagement;
import com.jxufe.ham.bean.Log;
import com.jxufe.ham.dao.BaseDao;
import com.jxufe.ham.dao.AuthoritymanagementDao;

@Repository
public class AuthoritymanagementDaoImpl extends  AuthoritymanagementDao<Authoritymanagement> {
	
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
	* @see com.jxufe.ham.test.dao.AuthoritymanagementDao#insert(com.jxufe.ham.bean.Authoritymanagement)
	 */
	@Override
	public int insert(Authoritymanagement bean) {
		return (Integer) getSession().save(bean);
	}

	@Override
	public void delete(Authoritymanagement bean) {
//		getSession().delete(bean);
		getSession().delete(bean);
//		return null;
	}


	@Override
	public Authoritymanagement select(int id) {
//		List<Authoritymanagement> list = getSession().createQuery(SELECT).
//				setInteger(1, id).list();
		Session session = getSession();
		Authoritymanagement list = (Authoritymanagement) session.get(Authoritymanagement.class, new Integer(id));		
		return list;
	}

	@Override
	public void update(Authoritymanagement bean) {
		Session session = getSession();
		Transaction transaction = session.getTransaction();
		session.update(bean);
		transaction.commit();
	}

	@Override
	public List<Authoritymanagement> queryForPage(String hql, int offset, int length) {
		return null;
	}

	@Override
	public int getCount(String hql) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	

}
