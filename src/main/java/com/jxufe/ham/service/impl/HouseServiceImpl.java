package com.jxufe.ham.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jxufe.ham.bean.House;
import com.jxufe.ham.dao.HouseDao;
import com.jxufe.ham.dao.impl.HouseDaoImpl;
import com.jxufe.ham.service.HouseService;

/**
 * 
 * @Description: 房屋service层实现类
 * @ClassName: HouseServiceImpl
 * @author halu
 * @date 2017年4月16日 下午5:18:35
 */
@Service
public class HouseServiceImpl implements HouseService {

	@Autowired
	private HouseDao<House> dao;//自动注入HouseDao层实现类
	
	public House load(int id) {
		House bean = dao.select(id);
		return bean;
	}

	public int sava(House bean) {
		int eId= dao.insert(bean);
		return eId;
	}

	public void delete(House bean) {
		dao.delete(bean);
	}

	public void update(House bean) {
		dao.update(bean);
	}


}
