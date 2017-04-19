package com.jxufe.ham.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jxufe.ham.bean.Depart;
import com.jxufe.ham.bean.Log;
import com.jxufe.ham.dao.BaseDao;
import com.jxufe.ham.dao.DepartDao;

@Repository
public class DepartDaoImpl extends  DepartDao<Depart> {
	
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
	* @see com.jxufe.ham.test.dao.DepartDao#insert(com.jxufe.ham.bean.Depart)
	 */
	@Override
	public int insert(Depart bean) {
		return (Integer) getSession().save(bean);
	}

	@Override
	public void delete(Depart bean) {
//		getSession().delete(bean);
		getSession().delete(bean);
//		return null;
	}


	@Override
	public Depart select(int id) {
//		List<Depart> list = getSession().createQuery(SELECT).
//				setInteger(1, id).list();
		Session session = getSession();
		Depart list = (Depart) session.get(Depart.class, new Integer(id));		
		return list;
	}

	@Override
	public void update(Depart bean) {
		Session session = getSession();
		Depart updateDepart = (Depart)session.load(bean.getClass(), bean.getDepartId());
		updateDepart.setDepartName(bean.getDepartName());
	}

	@Override
	public List<Depart> queryForPage(String hql, int offset, int length) {
		return null;
	}

	@Override
	public int getCount(String hql) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	

}
