package com.jxufe.ham.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jxufe.ham.bean.Log;
import com.jxufe.ham.bean.Log;
import com.jxufe.ham.dao.BaseDao;
import com.jxufe.ham.dao.LogDao;

@Repository
public class LogDaoImpl extends  LogDao<Log> {
	
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
	* @see com.jxufe.ham.test.dao.LogDao#insert(com.jxufe.ham.bean.Log)
	 */
	@Override
	public int insert(Log bean) {
		return (Integer) getSession().save(bean);
	}

	@Override
	public void delete(Log bean) {
//		getSession().delete(bean);
		getSession().delete(bean);
//		return null;
	}


	@Override
	public Log select(int id) {
//		List<Log> list = getSession().createQuery(SELECT).
//				setInteger(1, id).list();
		Session session = getSession();
		Log list = (Log) session.get(Log.class, new Integer(id));		
		return list;
	}

	@Override
	public void update(Log bean) {
		Session session = getSession();
//		Log updateLog = (Log)session.load(bean.getClass(), bean.getLogId());
//		updateLog.setLogName(bean.getLogName());
		Transaction transaction = session.getTransaction();
		session.update(bean);
		transaction.commit();
//		return null;
	}

	@Override
	public List<Log> queryForPage(String hql, int offset, int length) {
		return null;
	}

	@Override
	public int getCount(String hql) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	

}
