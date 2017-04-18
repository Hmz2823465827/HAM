package com.jxufe.ham.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jxufe.ham.bean.Custom;
import com.jxufe.ham.dao.CustomDao;

@Repository
public class CustomDaoImpl extends  CustomDao<Custom> {
	
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
	* @see com.jxufe.ham.test.dao.CustomDao#insert(com.jxufe.ham.bean.Custom)
	 */
	@Override
	public int insert(Custom bean) {
		return (Integer) getSession().save(bean);
	}

	@Override
	public void delete(Custom bean) {
//		getSession().delete(bean);
		getSession().delete(bean);
//		return null;
	}


	@Override
	public Custom select(int id) {
//		List<Custom> list = getSession().createQuery(SELECT).
//				setInteger(1, id).list();
		Session session = getSession();
		Custom list = (Custom) session.get(Custom.class, new Integer(id));		
		return list;
	}

	@Override
	public void update(Custom bean) {
		Session session = getSession();
//		Custom updateCustom = (Custom)session.load(bean.getClass(), bean.getCustomId());
//		updateCustom.setCustomName(bean.getCustomName());
		Transaction transaction = session.getTransaction();
		session.update(bean);
		transaction.commit();
//		return null;
	}

	@Override
	public List<Custom> queryForPage(String hql, int offset, int length) {
		return null;
	}

	@Override
	public int getCount(String hql) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	

}
