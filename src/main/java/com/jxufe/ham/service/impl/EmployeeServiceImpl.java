package com.jxufe.ham.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jxufe.ham.bean.Employee;
import com.jxufe.ham.dao.EmployeeDao;
import com.jxufe.ham.dao.impl.EmployeeDaoImpl;
import com.jxufe.ham.service.EmployeeService;

/**
 * 
 * @Description: 雇员service层实现类
 * @ClassName: EmployeeServiceImpl
 * @author halu
 * @date 2017年4月5日 下午8:32:07
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao<Employee> dao;//自动注入employeeDao层实现类
	
	public Employee load(int id) {
		Employee bean = dao.select(id);
		return bean;
	}

	public int sava(Employee bean) {
		int eId= dao.insert(bean);
		return eId;
	}

	public void delete(Employee bean) {
		dao.delete(bean);
	}

	public void update(Employee bean) {
		dao.update(bean);
	}

	public Employee login(Employee bean) {
		Employee eLoad;
		eLoad = load(bean.getEmployeeId());
		if(eLoad!=null){//通过id加载雇员不为空
			//验证通过
			if(eLoad.getEmployeeName().equals(bean.getEmployeeName())){
				return eLoad;
			}
		}
		return null;
	}

}
