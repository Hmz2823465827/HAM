package com.jxufe.ham.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jxufe.ham.bean.Log;
import com.jxufe.ham.dao.LogDao;
import com.jxufe.ham.dao.impl.LogDaoImpl;
import com.jxufe.ham.service.LogService;

/**
 * 
 * @Description: 工作日志service层实现类
 * @ClassName: LogServiceImpl
 * @author halu
 * @date 2017年4月16日 下午5:18:35
 */
@Service
public class LogServiceImpl implements LogService {

	@Autowired
	private LogDao<Log> dao;//自动注入LogDao层实现类
	
	public Log load(int id) {
		Log bean = dao.select(id);
		return bean;
	}

	public int sava(Log bean) {
		int eId= dao.insert(bean);
		return eId;
	}

	public void delete(Log bean) {
		dao.delete(bean);
	}

	public void update(Log bean) {
		dao.update(bean);
	}


}
