package com.jxufe.ham.system.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.jxufe.ham.common.dao.HibernateDao;
import com.jxufe.ham.common.entity.BaseBean;
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

	@SuppressWarnings("unchecked")
	public <E extends BaseBean> Set<E> loadSetByParam(Integer id, String setName) {
		Employee bean = get(id);
		Assert.notNull(bean, "用户不存在");
		Assert.notNull(bean.getHouses(),"房屋集合不存在");
		Object object = Reflections.invokeGetter(bean, setName);
		
		Assert.isInstanceOf(Set.class, object);
		System.out.println(bean.getHouses().toString());
		return (Set<E>)object;
	}
}
