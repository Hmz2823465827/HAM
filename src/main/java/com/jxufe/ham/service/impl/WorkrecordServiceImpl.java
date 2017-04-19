package com.jxufe.ham.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jxufe.ham.bean.Workrecord;
import com.jxufe.ham.dao.WorkrecordDao;
import com.jxufe.ham.dao.impl.WorkrecordDaoImpl;
import com.jxufe.ham.service.WorkrecordService;

/**
 * 
 * @Description: 工作记录service层实现类
 * @ClassName: WorkrecordServiceImpl
 * @author halu
 * @date 2017年4月16日 下午5:18:35
 */
@Service
public class WorkrecordServiceImpl implements WorkrecordService {

	@Autowired
	private WorkrecordDao<Workrecord> dao;//自动注入WorkrecordDao层实现类
	
	public Workrecord load(int id) {
		Workrecord bean = dao.select(id);
		return bean;
	}

	public int sava(Workrecord bean) {
		int eId= dao.insert(bean);
		return eId;
	}

	public void delete(Workrecord bean) {
		dao.delete(bean);
	}

	public void update(Workrecord bean) {
		dao.update(bean);
	}


}
