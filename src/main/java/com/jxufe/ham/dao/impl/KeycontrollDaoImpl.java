package com.jxufe.ham.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jxufe.ham.bean.Keymanagement;
import com.jxufe.ham.bean.Log;
import com.jxufe.ham.dao.BaseDao;
import com.jxufe.ham.dao.KeycontrollDao;

@Repository
public class KeycontrollDaoImpl extends  KeycontrollDao<Keymanagement> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
     
/*    public void setSessionFactory(SessionFactory sessionFactory)  
    {  
        this.sessionFactory = sessionFactory;  
    }  */
    
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
	* @see com.jxufe.ham.test.dao.KeycontrollDao#insert(com.jxufe.ham.bean.Keycontroll)
	 */
	@Override
	public int insert(Keymanagement bean) {
		return (Integer) getSession().save(bean);
	}

	@Override
	public void delete(Keymanagement bean) {
//		getSession().delete(bean);
		getSession().delete(bean);
//		return null;
	}


	@Override
	public Keymanagement select(int id) {
//		List<Keycontroll> list = getSession().createQuery(SELECT).
//				setInteger(1, id).list();
		Session session = getSession();
		Keymanagement list = (Keymanagement) session.get(Keymanagement.class, new Integer(id));		
		return list;
	}

	@Override
	public void update(Keymanagement bean) {
		Session session = getSession();
		Transaction transaction = session.getTransaction();
		session.update(bean);
		transaction.commit();
	}

	@Override
	public List<Keymanagement> queryForPage(String hql, int offset, int length) {
		return null;
	}

	@Override
	public int getCount(String hql) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	

}
