package com.jxufe.ham.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jxufe.ham.bean.Depart;
import com.jxufe.ham.dao.DepartDao;
import com.jxufe.ham.dao.impl.DepartDaoImpl;
import com.jxufe.ham.service.DepartService;

/**
 * 
 * @Description: 部门service层实现类
 * @ClassName: DepartServiceImpl
 * @author halu
 * @date 2017年4月5日 下午8:32:07
 */
@Service
public class DepartServiceImpl implements DepartService {

	@Autowired
	private DepartDao<Depart> dao;//自动注入DepartDao层实现类
	
	public Depart load(int id) {
		Depart bean = dao.select(id);
		return bean;
	}

	public int sava(Depart bean) {
		int eId= dao.insert(bean);
		return eId;
	}

	public void delete(Depart bean) {
		dao.delete(bean);
	}

	public void update(Depart bean) {
		dao.update(bean);
	}


}
