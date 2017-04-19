package com.jxufe.ham.test.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.jxufe.ham.bean.Employee;
import com.jxufe.ham.service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml",
		"classpath:spring-hibernate.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class EmployeeServiceTest {
	
	@Autowired
	private EmployeeService eService;
	
	/*
	 * employee Service层 加载junit测试
	 */
	@Test
	public void loadTest(){
		Employee employee =  new Employee();
		employee.setEmployeeId(1);
		employee = eService.load(1);
		assert(employee.getEmployeeName().equals("test"));
	}
}
