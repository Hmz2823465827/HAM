package com.jxufe.ham.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxufe.ham.common.dao.HibernateDao;
import com.jxufe.ham.common.service.BaseService;
import com.jxufe.ham.system.dao.HouseDao;
import com.jxufe.ham.system.entity.House;

@Service
@Transactional(readOnly = true)
public class HouseService extends BaseService<House, Integer>{

	@Autowired
	private HouseDao houseDao;
	
	@Override
	public HibernateDao<House, Integer> getEntityDao() {
		return this.houseDao;
	}

}