package com.jxufe.ham.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jxufe.ham.bean.Housekey;
import com.jxufe.ham.dao.HousekeyDao;
import com.jxufe.ham.dao.impl.HousekeyDaoImpl;
import com.jxufe.ham.service.HousekeyService;

/**
 * 
 * @Description: 房屋钥匙service层实现类
 * @ClassName: HousekeyServiceImpl
 * @author halu
 * @date 2017年4月16日 下午5:18:35
 */
@Service
public class HousekeyServiceImpl implements HousekeyService {

	@Autowired
	private HousekeyDao<Housekey> dao;//自动注入HousekeyDao层实现类
	
	public Housekey load(int id) {
		Housekey bean = dao.select(id);
		return bean;
	}

	public int sava(Housekey bean) {
		int eId= dao.insert(bean);
		return eId;
	}

	public void delete(Housekey bean) {
		dao.delete(bean);
	}

	public void update(Housekey bean) {
		dao.update(bean);
	}


}
