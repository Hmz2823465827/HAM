package com.jxufe.ham.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jxufe.ham.bean.Performance;
import com.jxufe.ham.dao.PerformanceDao;
import com.jxufe.ham.dao.impl.PerformanceDaoImpl;
import com.jxufe.ham.service.PerformanceService;

/**
 * 
 * @Description: 绩效service层实现类
 * @ClassName: PerformanceServiceImpl
 * @author halu
 * @date 2017年4月16日 下午5:18:35
 */
@Service
public class PerformanceServiceImpl implements PerformanceService {

	@Autowired
	private PerformanceDao<Performance> dao;//自动注入PerformanceDao层实现类
	
	public Performance load(int id) {
		Performance bean = dao.select(id);
		return bean;
	}

	public int sava(Performance bean) {
		int eId= dao.insert(bean);
		return eId;
	}

	public void delete(Performance bean) {
		dao.delete(bean);
	}

	public void update(Performance bean) {
		dao.update(bean);
	}


}
