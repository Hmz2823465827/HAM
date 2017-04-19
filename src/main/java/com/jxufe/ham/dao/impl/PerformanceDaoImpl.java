package com.jxufe.ham.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jxufe.ham.bean.Performance;
import com.jxufe.ham.dao.PerformanceDao;

@Repository
public class PerformanceDaoImpl extends  PerformanceDao<Performance> {
	
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
	* @see com.jxufe.ham.test.dao.PerformanceDao#insert(com.jxufe.ham.bean.Performance)
	 */
	@Override
	public int insert(Performance bean) {
		return (Integer) getSession().save(bean);
	}

	@Override
	public void delete(Performance bean) {
//		getSession().delete(bean);
		getSession().delete(bean);
//		return null;
	}


	@Override
	public Performance select(int id) {
//		List<Performance> list = getSession().createQuery(SELECT).
//				setInteger(1, id).list();
		Session session = getSession();
		Performance list = (Performance) session.get(Performance.class, new Integer(id));		
		return list;
	}

	@Override
	public void update(Performance bean) {
		Session session = getSession();
//		Performance updatePerformance = (Performance)session.load(bean.getClass(), bean.getPerformanceId());
//		updatePerformance.setPerformanceName(bean.getPerformanceName());
		Transaction transaction = session.getTransaction();
		session.update(bean);
		transaction.commit();
//		return null;
	}

	@Override
	public List<Performance> queryForPage(String hql, int offset, int length) {
		return null;
	}

	@Override
	public int getCount(String hql) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	

}
