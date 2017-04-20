package com.jxufe.ham.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jxufe.ham.bean.Custom;
import com.jxufe.ham.dao.CustomDao;
import com.jxufe.ham.dao.impl.CustomDaoImpl;
import com.jxufe.ham.service.CustomService;

/**
 * 
 * @Description: 顾客service层实现类
 * @ClassName: CustomServiceImpl
 * @author halu
 * @date 2017年4月5日 下午8:32:07
 */
@Service
public class CustomServiceImpl implements CustomService {

	@Autowired
	private CustomDao<Custom> dao;//自动注入CustomDao层实现类
	
	public Custom load(int id) {
		Custom bean = dao.select(id);
		return bean;
	}

	public int sava(Custom bean) {
		int eId= dao.insert(bean);
		return eId;
	}

	public void delete(Custom bean) {
		dao.delete(bean);
	}

	public void update(Custom bean) {
		dao.update(bean);
	}

	public Custom login(Custom bean) {
		Custom beanLoad;
		beanLoad = load(bean.getCustomId());
		if(beanLoad!=null){//通过id加载顾客不为空
			//验证通过
			if(beanLoad.getCustomName().equals(bean.getCustomName())){
				return beanLoad;
			}
		}
		return null;
	}

}
