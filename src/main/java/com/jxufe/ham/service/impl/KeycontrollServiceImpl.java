package com.jxufe.ham.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jxufe.ham.bean.Keycontroll;
import com.jxufe.ham.dao.KeycontrollDao;
import com.jxufe.ham.dao.impl.KeycontrollDaoImpl;
import com.jxufe.ham.service.KeycontrollService;

/**
 * 
 * @Description: 钥匙控制service层实现类
 * @ClassName: KeycontrollServiceImpl
 * @author halu
 * @date 2017年4月16日 下午5:18:35
 */
@Service
public class KeycontrollServiceImpl implements KeycontrollService {

	@Autowired
	private KeycontrollDao<Keycontroll> dao;//自动注入KeycontrollDao层实现类
	
	public Keycontroll load(int id) {
		Keycontroll bean = dao.select(id);
		return bean;
	}

	public int sava(Keycontroll bean) {
		int eId= dao.insert(bean);
		return eId;
	}

	public void delete(Keycontroll bean) {
		dao.delete(bean);
	}

	public void update(Keycontroll bean) {
		dao.update(bean);
	}


}
