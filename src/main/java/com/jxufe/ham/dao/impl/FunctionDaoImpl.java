package com.jxufe.ham.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jxufe.ham.bean.Function;
import com.jxufe.ham.dao.FunctionDao;

@Repository
public class FunctionDaoImpl extends FunctionDao<Function> {

	@Autowired
	private SessionFactory sessionFactory;

	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/*
	 * 
	 * Title: insert Description:
	 * 
	 * @param bean
	 * 
	 * @return
	 * 
	 * @see
	 * com.jxufe.ham.test.dao.FunctionDao#insert(com.jxufe.ham.bean.Function)
	 */
	@Override
	public int insert(Function bean) {
		return (Integer) getSession().save(bean);
	}

	@Override
	public void delete(Function bean) {
		getSession().delete(bean);
	}

	@Override
	@Transactional
	public Function select(int id) {
		Session session = getSession();
		Function list = (Function) session.get(Function.class, new Integer(id));
		return list;
	}

	@Override
	public void update(Function bean) {
		Session session = getSession();
		Transaction transaction = session.getTransaction();
		session.update(bean);
		transaction.commit();
	}

	@Override
	public List<Function> queryForPage(String hql, int offset, int length) {
		return null;
	}

	@Override
	public int getCount(String hql) {
		return 0;
	}

	@Override
	public List findAll() {
		Session session = getSession();
//		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from Function");
//		transaction.commit();
		return query.list();
	}

}
