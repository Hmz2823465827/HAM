package com.jxufe.ham.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jxufe.ham.bean.Task;
import com.jxufe.ham.dao.TaskDao;

@Repository
public class TaskDaoImpl extends  TaskDao<Task> {
	
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
	* @see com.jxufe.ham.test.dao.TaskDao#insert(com.jxufe.ham.bean.Task)
	 */
	@Override
	public int insert(Task bean) {
		return (Integer) getSession().save(bean);
	}

	@Override
	public void delete(Task bean) {
//		getSession().delete(bean);
		getSession().delete(bean);
//		return null;
	}


	@Override
	public Task select(int id) {
//		List<Task> list = getSession().createQuery(SELECT).
//				setInteger(1, id).list();
		Session session = getSession();
		Task list = (Task) session.get(Task.class, new Integer(id));		
		return list;
	}

	@Override
	public void update(Task bean) {
		Session session = getSession();
//		Task updateTask = (Task)session.load(bean.getClass(), bean.getTaskId());
//		updateTask.setTaskName(bean.getTaskName());
		Transaction transaction = session.getTransaction();
		session.update(bean);
		transaction.commit();
//		return null;
	}

	@Override
	public List<Task> queryForPage(String hql, int offset, int length) {
		return null;
	}

	@Override
	public int getCount(String hql) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	

}
