package com.jxufe.ham.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jxufe.ham.bean.Workrecord;
import com.jxufe.ham.dao.WorkrecordDao;

@Repository
public class WorkrecordDaoImpl extends  WorkrecordDao<Workrecord> {
	
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
	* @see com.jxufe.ham.test.dao.WorkrecordDao#insert(com.jxufe.ham.bean.Workrecord)
	 */
	@Override
	public int insert(Workrecord bean) {
		return (Integer) getSession().save(bean);
	}

	@Override
	public void delete(Workrecord bean) {
//		getSession().delete(bean);
		getSession().delete(bean);
//		return null;
	}


	@Override
	public Workrecord select(int id) {
//		List<Workrecord> list = getSession().createQuery(SELECT).
//				setInteger(1, id).list();
		Session session = getSession();
		Workrecord list = (Workrecord) session.get(Workrecord.class, new Integer(id));		
		return list;
	}

	@Override
	public void update(Workrecord bean) {
		Session session = getSession();
//		Workrecord updateWorkrecord = (Workrecord)session.load(bean.getClass(), bean.getWorkrecordId());
//		updateWorkrecord.setWorkrecordName(bean.getWorkrecordName());
		Transaction transaction = session.getTransaction();
		session.update(bean);
		transaction.commit();
//		return null;
	}

	@Override
	public List<Workrecord> queryForPage(String hql, int offset, int length) {
		return null;
	}

	@Override
	public int getCount(String hql) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	

}
