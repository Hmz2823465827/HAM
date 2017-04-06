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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml",
		"classpath:spring-hibernate.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class EmployeeDaoTest {

	private EmployeeDao eDao;
	
	private Employee employee;
	
	@Autowired
	public void setEmployeeDao(EmployeeDao eDao) {
		this.eDao = eDao;
	}

	@Before
	public void init() {
	}

	@Test
	public void getList() {
		try {
			this.employee = eDao.select(1);
			assertNotNull(employee.getEmployeeId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
