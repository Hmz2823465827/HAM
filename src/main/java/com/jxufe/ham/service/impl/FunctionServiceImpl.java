package com.jxufe.ham.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jxufe.ham.bean.Function;
import com.jxufe.ham.dao.FunctionDao;
import com.jxufe.ham.dao.impl.FunctionDaoImpl;
import com.jxufe.ham.service.FunctionService;

/**
 * 
 * @Description: 权限过滤service层实现类
 * @ClassName: FunctionServiceImpl
 * @author halu
 * @date 2017年4月5日 下午8:32:07
 */

@Service
public class FunctionServiceImpl implements FunctionService {

	@Autowired
	private FunctionDao<Function> dao;//自动注入FunctionDao层实现类
	
	public Function load(int id) {
		Function bean = dao.select(id);
		return bean;
	}

	public int sava(Function bean) {
		int eId= dao.insert(bean);
		return eId;
	}

	public void delete(Function bean) {
		dao.delete(bean);
	}

	public void update(Function bean) {
		dao.update(bean);
	}

	public List findAll() {
		return dao.findAll();
	}


}
