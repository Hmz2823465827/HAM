package com.jxufe.ham.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jxufe.ham.bean.Pact;
import com.jxufe.ham.dao.PactDao;

@Repository
public class PactDaoImpl extends  PactDao<Pact> {
	
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
	* @see com.jxufe.ham.test.dao.PactDao#insert(com.jxufe.ham.bean.Pact)
	 */
	@Override
	public int insert(Pact bean) {
		return (Integer) getSession().save(bean);
	}

	@Override
	public void delete(Pact bean) {
//		getSession().delete(bean);
		getSession().delete(bean);
//		return null;
	}


	@Override
	public Pact select(int id) {
//		List<Pact> list = getSession().createQuery(SELECT).
//				setInteger(1, id).list();
		Session session = getSession();
		Pact list = (Pact) session.get(Pact.class, new Integer(id));		
		return list;
	}

	@Override
	public void update(Pact bean) {
		Session session = getSession();
//		Pact updatePact = (Pact)session.load(bean.getClass(), bean.getPactId());
//		updatePact.setPactName(bean.getPactName());
		Transaction transaction = session.getTransaction();
		session.update(bean);
		transaction.commit();
//		return null;
	}

	@Override
	public List<Pact> queryForPage(String hql, int offset, int length) {
		return null;
	}

	@Override
	public int getCount(String hql) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	

}
