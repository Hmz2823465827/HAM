package com.jxufe.ham.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jxufe.ham.bean.Pact;
import com.jxufe.ham.dao.PactDao;
import com.jxufe.ham.dao.impl.PactDaoImpl;
import com.jxufe.ham.service.PactService;

/**
 * 
 * @Description: 合同service层实现类
 * @ClassName: PactServiceImpl
 * @author halu
 * @date 2017年4月16日 下午5:18:35
 */
@Service
public class PactServiceImpl implements PactService {

	@Autowired
	private PactDao<Pact> dao;//自动注入PactDao层实现类
	
	public Pact load(int id) {
		Pact bean = dao.select(id);
		return bean;
	}

	public int sava(Pact bean) {
		int eId= dao.insert(bean);
		return eId;
	}

	public void delete(Pact bean) {
		dao.delete(bean);
	}

	public void update(Pact bean) {
		dao.update(bean);
	}


}
