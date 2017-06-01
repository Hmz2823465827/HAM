package com.jxufe.ham.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxufe.ham.common.dao.HibernateDao;
import com.jxufe.ham.common.service.BaseService;
import com.jxufe.ham.common.util.Reflections;
import com.jxufe.ham.system.dao.EmployeeDao;
import com.jxufe.ham.system.entity.Employee;

/**
 * 用户service
 * @author halu
 * @date 2015年1月13日
 */
@Service
@Transactional(readOnly = true)
public class EmployeeService extends BaseService<Employee, Integer>{
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public HibernateDao<Employee, Integer> getEntityDao() {
		return employeeDao;
	}

	public Employee login(Employee bean) {
		Employee eLoad;
		eLoad = employeeDao.find(bean.getEmployeeId());
		if(eLoad!=null){//通过id加载雇员不为空
			//验证通过
			if(eLoad.getEmployeeName().equals(bean.getEmployeeName())){
				return eLoad;
			}
		}
		return null;
	}

	public List<Employee> loadSetByParam(Employee employee, String setName) {
		
//		this.search(page, filters)
		return null;
	}
}
