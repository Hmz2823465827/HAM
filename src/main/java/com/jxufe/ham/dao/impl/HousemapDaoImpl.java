package com.jxufe.ham.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jxufe.ham.bean.Housemap;
import com.jxufe.ham.bean.Log;
import com.jxufe.ham.dao.BaseDao;
import com.jxufe.ham.dao.HousemapDao;

@Repository
public class HousemapDaoImpl extends  HousemapDao<Housemap> {
	
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
	* @see com.jxufe.ham.test.dao.HousemapDao#insert(com.jxufe.ham.bean.Housemap)
	 */
	@Override
	public int insert(Housemap bean) {
		return (Integer) getSession().save(bean);
	}

	@Override
	public void delete(Housemap bean) {
//		getSession().delete(bean);
		getSession().delete(bean);
//		return null;
	}


	@Override
	public Housemap select(int id) {
//		List<Housemap> list = getSession().createQuery(SELECT).
//				setInteger(1, id).list();
		Session session = getSession();
		Housemap list = (Housemap) session.get(Housemap.class, new Integer(id));		
		return list;
	}

	@Override
	public void update(Housemap bean) {
		Session session = getSession();
		Transaction transaction = session.getTransaction();
		session.update(bean);
		transaction.commit();
	}

	@Override
	public List<Housemap> queryForPage(String hql, int offset, int length) {
		return null;
	}

	@Override
	public int getCount(String hql) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	

}
