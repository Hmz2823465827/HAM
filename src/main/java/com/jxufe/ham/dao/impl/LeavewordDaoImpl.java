package com.jxufe.ham.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jxufe.ham.bean.Leaveword;
import com.jxufe.ham.dao.LeavewordDao;

@Repository
public class LeavewordDaoImpl extends  LeavewordDao<Leaveword> {
	
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
	* @see com.jxufe.ham.test.dao.LeavewordDao#insert(com.jxufe.ham.bean.Leaveword)
	 */
	@Override
	public int insert(Leaveword bean) {
		return (Integer) getSession().save(bean);
	}

	@Override
	public void delete(Leaveword bean) {
//		getSession().delete(bean);
		getSession().delete(bean);
//		return null;
	}


	@Override
	public Leaveword select(int id) {
//		List<Leaveword> list = getSession().createQuery(SELECT).
//				setInteger(1, id).list();
		Session session = getSession();
		Leaveword list = (Leaveword) session.get(Leaveword.class, new Integer(id));		
		return list;
	}

	@Override
	public void update(Leaveword bean) {
		Session session = getSession();
//		Leaveword updateLeaveword = (Leaveword)session.load(bean.getClass(), bean.getLeavewordId());
//		updateLeaveword.setLeavewordName(bean.getLeavewordName());
		Transaction transaction = session.getTransaction();
		session.update(bean);
		transaction.commit();
//		return null;
	}

	@Override
	public List<Leaveword> queryForPage(String hql, int offset, int length) {
		return null;
	}

	@Override
	public int getCount(String hql) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	

}
