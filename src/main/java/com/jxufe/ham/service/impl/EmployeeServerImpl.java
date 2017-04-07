package com.jxufe.ham.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jxufe.ham.bean.Employee;
import com.jxufe.ham.dao.EmployeeDao;
import com.jxufe.ham.dao.Impl.EmployeeDaoImpl;
import com.jxufe.ham.service.EmployeeService;

/**
 * 
 * @Description: 雇员service层实现类
 * @ClassName: EmployeeServerImpl
 * @author halu
 * @date 2017年4月5日 下午8:32:07
 */
@Service
public class EmployeeServerImpl implements EmployeeService {

	@Autowired
	private EmployeeDao<Employee> eDao;//自动注入employeeDao层实现类
	
	public Employee load(int id) {
		Employee e = eDao.select(id);
		return e;
	}

	public int sava(Employee e) {
		int eId= eDao.insert(e);
		return eId;
	}

	public void delete(Employee e) {
		eDao.delete(e);
	}

	public Employee update(Employee e) {
		Employee employee = eDao.update(e);
		return employee;
	}

}
