package com.jxufe.ham.dao.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jxufe.ham.bean.Employee;
import com.jxufe.ham.bean.Log;
import com.jxufe.ham.dao.BaseDao;
import com.jxufe.ham.dao.EmployeeDao;

@Repository
public class EmployeeDaoImpl extends  EmployeeDao<Employee> {
	
	private final String SELECT =  "SELECT * from employee where "
			+ "employeeID = ?";//查询sql语句
	
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
	* @param e
	* @return
	* @see com.jxufe.ham.test.dao.EmployeeDao#insert(com.jxufe.ham.bean.Employee)
	 */
	@Override
	public int insert(Employee e) {
		return (int)getSession().save(e);
	}

	@Override
	public void delete(Employee e) {
//		getSession().delete(e);
		getSession().delete(e);
//		return null;
	}


	@Override
	public Employee select(int id) {
//		List<Employee> list = getSession().createQuery(SELECT).
//				setInteger(1, id).list();
		Session session = getSession();
		Employee list = (Employee) session.get(Employee.class, new Integer(id));		
		return list;
	}

	@Override
	public Employee update(Employee e) {
		Session session = getSession();
		Employee updateEmployee = (Employee)session.load(e.getClass(), e.getEmployeeId());
		updateEmployee.setEmployeeName(e.getEmployeeName());
		return null;
	}

	@Override
	public List<Employee> queryForPage(String hql, int offset, int length) {
		return null;
	}

	@Override
	public int getCount(String hql) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	

}
