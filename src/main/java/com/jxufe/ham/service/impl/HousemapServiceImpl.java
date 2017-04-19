package com.jxufe.ham.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jxufe.ham.bean.Housemap;
import com.jxufe.ham.dao.HousemapDao;
import com.jxufe.ham.dao.impl.HousemapDaoImpl;
import com.jxufe.ham.service.HousemapService;

/**
 * 
 * @Description: 房屋地图service层实现类
 * @ClassName: HousemapServiceImpl
 * @author halu
 * @date 2017年4月16日 下午5:18:35
 */
@Service
public class HousemapServiceImpl implements HousemapService {

	@Autowired
	private HousemapDao<Housemap> dao;//自动注入HousemapDao层实现类
	
	public Housemap load(int id) {
		Housemap bean = dao.select(id);
		return bean;
	}

	public int sava(Housemap bean) {
		int eId= dao.insert(bean);
		return eId;
	}

	public void delete(Housemap bean) {
		dao.delete(bean);
	}

	public void update(Housemap bean) {
		dao.update(bean);
	}


}
