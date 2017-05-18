package com.jxufe.ham.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jxufe.ham.bean.Followup;
import com.jxufe.ham.dao.FollowupDao;
import com.jxufe.ham.service.FollowupService;

/**
 * 
 * @Description: 跟进记录service层实现类
 * @ClassName: FollowupServiceImpl
 * @author halu
 * @date 2017年4月5日 下午8:32:07
 */
@Service
public class FollowupServiceImpl implements FollowupService {

	@Autowired
	private FollowupDao<Followup> dao;//自动注入FollowupDao层实现类
	
	public Followup load(int id) {
		Followup bean = dao.select(id);
		return bean;
	}

	public int sava(Followup bean) {
		int eId= dao.insert(bean);
		return eId;
	}

	public void delete(Followup bean) {
		dao.delete(bean);
	}

	public void update(Followup bean) {
		dao.update(bean);
	}

}
