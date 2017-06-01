package com.jxufe.ham.system.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.jxufe.ham.common.dao.HibernateDao;
import com.jxufe.ham.common.service.BaseService;
import com.jxufe.ham.system.dao.WorkrecordDao;
import com.jxufe.ham.system.dao.impl.WorkrecordDaoImpl;
import com.jxufe.ham.system.entity.Workrecord;

public class WorkrecordService extends BaseService<Workrecord, Integer>{

	@Autowired
	private WorkrecordDao workrecordDao;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public HibernateDao<Workrecord, Integer> getEntityDao() {
		return workrecordDao;
	}

}
