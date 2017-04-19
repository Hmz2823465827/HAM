package com.jxufe.ham.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jxufe.ham.bean.TaskAllot;
import com.jxufe.ham.dao.TaskAllotDao;

@Repository
public class TaskAllotDaoImpl extends  TaskAllotDao<TaskAllot> {
	
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
	* @see com.jxufe.ham.test.dao.TaskAllotDao#insert(com.jxufe.ham.bean.TaskAllot)
	 */
	@Override
	public int insert(TaskAllot bean) {
		return (Integer) getSession().save(bean);
	}

	@Override
	public void delete(TaskAllot bean) {
//		getSession().delete(bean);
		getSession().delete(bean);
//		return null;
	}


	@Override
	public TaskAllot select(int id) {
//		List<TaskAllot> list = getSession().createQuery(SELECT).
//				setInteger(1, id).list();
		Session session = getSession();
		TaskAllot list = (TaskAllot) session.get(TaskAllot.class, new Integer(id));		
		return list;
	}

	@Override
	public void update(TaskAllot bean) {
		Session session = getSession();
//		TaskAllot updateTaskAllot = (TaskAllot)session.load(bean.getClass(), bean.getTaskAllotId());
//		updateTaskAllot.setTaskAllotName(bean.getTaskAllotName());
		Transaction transaction = session.getTransaction();
		session.update(bean);
		transaction.commit();
//		return null;
	}

	@Override
	public List<TaskAllot> queryForPage(String hql, int offset, int length) {
		return null;
	}

	@Override
	public int getCount(String hql) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	

}
