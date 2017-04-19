package com.jxufe.ham.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jxufe.ham.bean.Housekey;
import com.jxufe.ham.bean.Log;
import com.jxufe.ham.dao.BaseDao;
import com.jxufe.ham.dao.HousekeyDao;

@Repository
public class HousekeyDaoImpl extends  HousekeyDao<Housekey> {
	
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
	* @see com.jxufe.ham.test.dao.HousekeyDao#insert(com.jxufe.ham.bean.Housekey)
	 */
	@Override
	public int insert(Housekey bean) {
		return (Integer) getSession().save(bean);
	}

	@Override
	public void delete(Housekey bean) {
//		getSession().delete(bean);
		getSession().delete(bean);
//		return null;
	}


	@Override
	public Housekey select(int id) {
//		List<Housekey> list = getSession().createQuery(SELECT).
//				setInteger(1, id).list();
		Session session = getSession();
		Housekey list = (Housekey) session.get(Housekey.class, new Integer(id));		
		return list;
	}

	@Override
	public void update(Housekey bean) {
		Session session = getSession();
		Transaction transaction = session.getTransaction();
		session.update(bean);
		transaction.commit();
	}

	@Override
	public List<Housekey> queryForPage(String hql, int offset, int length) {
		return null;
	}

	@Override
	public int getCount(String hql) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	

}
