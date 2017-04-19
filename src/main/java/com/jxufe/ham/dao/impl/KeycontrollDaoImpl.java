package com.jxufe.ham.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jxufe.ham.bean.Keycontroll;
import com.jxufe.ham.bean.Log;
import com.jxufe.ham.dao.BaseDao;
import com.jxufe.ham.dao.KeycontrollDao;

@Repository
public class KeycontrollDaoImpl extends  KeycontrollDao<Keycontroll> {
	
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
	public int insert(Keycontroll bean) {
		return (Integer) getSession().save(bean);
	}

	@Override
	public void delete(Keycontroll bean) {
//		getSession().delete(bean);
		getSession().delete(bean);
//		return null;
	}


	@Override
	public Keycontroll select(int id) {
//		List<Keycontroll> list = getSession().createQuery(SELECT).
//				setInteger(1, id).list();
		Session session = getSession();
		Keycontroll list = (Keycontroll) session.get(Keycontroll.class, new Integer(id));		
		return list;
	}

	@Override
	public void update(Keycontroll bean) {
		Session session = getSession();
		Transaction transaction = session.getTransaction();
		session.update(bean);
		transaction.commit();
	}

	@Override
	public List<Keycontroll> queryForPage(String hql, int offset, int length) {
		return null;
	}

	@Override
	public int getCount(String hql) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	

}
