package com.jxufe.ham.test.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.jxufe.ham.bean.Employee;
import com.jxufe.ham.bean.Log;
import com.jxufe.ham.dao.BaseDao;
import com.jxufe.ham.dao.EmployeeDao;
import com.jxufe.ham.dao.Impl.EmployeeDaoImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml",
		"classpath:spring-hibernate.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class EmployeeDaoTest {

	
	
	private BaseDao<Employee> eDao;
	
	
	private Employee employee;

	@Autowired
	public void setEmployeeDao(EmployeeDaoImpl eDao) {
		this.eDao = eDao;
	}

	@Before
	public void init() {
	}

//	@Test
	public void select() {
		try {
			Employee log= eDao.select(1);
			System.out.println(log.getEmployeeName());
//			assertNotNull(employee.getEmployeeId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 插入方法junit测试
	 */
//	@Test
	public void insertTest(){
		Employee e = new Employee(new Integer(8), "test", 1);
		assertNotNull(eDao.insert(e));
	}
	
	/*
	 * 删除方法junit测试
	 */
//	@Test
	public void deleteTest(){
		eDao.delete(new Employee(8,"test",1));
		assert(eDao.select(8)==null);
	}
	
	@Test
	public void updateTest(){
		eDao.update(new Employee(2,"tese2",2));
		Employee e = eDao.select(2);
//		assertNotNull(e);
		assert(e.getEmployeeName().equals("test2")==true);
	}
}
