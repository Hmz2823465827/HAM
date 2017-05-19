package com.jxufe.ham.dao.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jxufe.ham.bean.Authority;
import com.jxufe.ham.bean.Function;
import com.jxufe.ham.bean.Role;
import com.jxufe.ham.dao.FunctionDao;

@Repository
public class FunctionDaoImpl extends FunctionDao<Function> {
	
	private Log log = LogFactory.getLog(FunctionDaoImpl.class);

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
		query.setCacheable(true);
		List list = query.list();
		//Hiberate 懒加载 在session未关闭的dao层 实例化关联对象
		Iterator<Object> iterable = list.iterator();
		for (Object object : list) {
			Function function = (Function)object;
			if (function.getType().equals("perms")) {
				Hibernate.initialize(function.getAuthorityID());
			} else if (function.getType().equals("roles")) {
				Hibernate.initialize(function.getRole());
			}
			
		}
		return list;
	}

}
