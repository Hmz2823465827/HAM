package com.jxufe.ham.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jxufe.ham.bean.TaskAllot;
import com.jxufe.ham.dao.TaskAllotDao;
import com.jxufe.ham.dao.impl.TaskAllotDaoImpl;
import com.jxufe.ham.service.TaskAllotService;

/**
 * 
 * @Description: 任务分配service层实现类
 * @ClassName: TaskAllotServiceImpl
 * @author halu
 * @date 2017年4月16日 下午5:18:35
 */
@Service
public class TaskAllotServiceImpl implements TaskAllotService {

	@Autowired
	private TaskAllotDao<TaskAllot> dao;//自动注入TaskAllotDao层实现类
	
	public TaskAllot load(int id) {
		TaskAllot bean = dao.select(id);
		return bean;
	}

	public int sava(TaskAllot bean) {
		int eId= dao.insert(bean);
		return eId;
	}

	public void delete(TaskAllot bean) {
		dao.delete(bean);
	}

	public void update(TaskAllot bean) {
		dao.update(bean);
	}


}
