package com.jxufe.ham.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jxufe.ham.bean.Authority;
import com.jxufe.ham.dao.AuthorityDao;

@Repository
public class AuthorityDaoImpl extends AuthorityDao<Authority> {

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
	 * com.jxufe.ham.test.dao.AuthorityDao#insert(com.jxufe.ham.bean.Authority)
	 */
	@Override
	public int insert(Authority bean) {
		return (Integer) getSession().save(bean);
	}

	@Override
	public void delete(Authority bean) {
		getSession().delete(bean);
	}

	@Override
	public Authority select(int id) {
		Session session = getSession();
		Authority list = (Authority) session.get(Authority.class, new Integer(id));
		return list;
	}

	@Override
	public void update(Authority bean) {
		Session session = getSession();
		Transaction transaction = session.getTransaction();
		session.update(bean);
		transaction.commit();
	}

	@Override
	public List<Authority> queryForPage(String hql, int offset, int length) {
		return null;
	}

	@Override
	public int getCount(String hql) {
		return 0;
	}

}
