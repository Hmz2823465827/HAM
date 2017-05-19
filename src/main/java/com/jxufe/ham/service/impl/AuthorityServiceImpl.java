package com.jxufe.ham.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jxufe.ham.bean.Authority;
import com.jxufe.ham.dao.AuthorityDao;
import com.jxufe.ham.dao.impl.AuthorityDaoImpl;
import com.jxufe.ham.service.AuthorityService;

/**
 * 
 * @Description: 权限service层实现类
 * @ClassName: AuthorityServiceImpl
 * @author halu
 * @date 2017年4月5日 下午8:32:07
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	private AuthorityDao<Authority> dao;//自动注入AuthorityDao层实现类
	
	public Authority load(int id) {
		Authority bean = dao.select(id);
		return bean;
	}

	public int sava(Authority bean) {
		int eId= dao.insert(bean);
		return eId;
	}

	public void delete(Authority bean) {
		dao.delete(bean);
	}

	public void update(Authority bean) {
		dao.update(bean);
	}


}
