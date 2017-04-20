package com.jxufe.ham.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jxufe.ham.bean.Task;
import com.jxufe.ham.dao.TaskDao;
import com.jxufe.ham.dao.impl.TaskDaoImpl;
import com.jxufe.ham.service.TaskService;

/**
 * 
 * @Description: 任务service层实现类
 * @ClassName: TaskServiceImpl
 * @author halu
 * @date 2017年4月16日 下午5:18:35
 */
@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskDao<Task> dao;//自动注入TaskDao层实现类
	
	public Task load(int id) {
		Task bean = dao.select(id);
		return bean;
	}

	public int sava(Task bean) {
		int eId= dao.insert(bean);
		return eId;
	}

	public void delete(Task bean) {
		dao.delete(bean);
	}

	public void update(Task bean) {
		dao.update(bean);
	}


}
