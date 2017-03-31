package com.jxufe.ham.dao.employee;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jxufe.ham.bean.Employee;

public class EmployeeDaoImpl extends BaseDao<Employee> implements EmployeeDao {
	
	private final String SELECT =  "from employee where "
			+ "employeeID = ?";//查询sql语句
	
	private SessionFactory sessionFactory;
	
    public Session getSession()  
    {  
        return sessionFactory.getCurrentSession();  
    }  
  
    @Resource  
    public void setSessionFactory(SessionFactory sessionFactory)  
    {  
        this.sessionFactory = sessionFactory;  
    }  
	
	/*
	 * 
	* Title: insert
	* Description: 
	* @param e
	* @return
	* @see com.jxufe.ham.dao.employee.EmployeeDao#insert(com.jxufe.ham.bean.Employee)
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
		List<Employee> list = getSession().createQuery(SELECT).list();
		if(list.isEmpty())
			return null;
		return list.get(1);
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
