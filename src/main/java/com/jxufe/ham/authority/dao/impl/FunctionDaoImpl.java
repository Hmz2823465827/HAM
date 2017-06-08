package com.jxufe.ham.authority.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import com.jxufe.ham.authority.dao.FunctionDao;
import com.jxufe.ham.authority.entity.Authority;
import com.jxufe.ham.authority.entity.Function;
import com.jxufe.ham.authority.entity.Role;
import com.jxufe.ham.common.entity.BaseBean;
import com.jxufe.ham.common.util.Reflections;
import com.jxufe.ham.common.util.StringUtils;

@Repository
public class FunctionDaoImpl extends FunctionDao {
	
	@Override
	public List<Function> findAll() {
		List<Function> list = super.findAll();
		Iterator<Function> iterator = list.iterator();
		for (Function function : list) {
			if (function.getType().equals("perms")) {
				Hibernate.initialize(function.getAuthorityID());
			}else if(function.getType().equals("roles")){
				Hibernate.initialize(function.getRoleID());
			}
		}
		return list;
	}

	/**
	 * 
	* @Title: initializeParam 
	* @Description:在seesion未关闭时初始化参数
	 */
	protected <E extends BaseBean> void initializeParam(List<E> list,String paramName) {
		for (Iterator<E> iterator = list.iterator(); iterator.hasNext();) {
			E e = iterator.next();
			initializeParam(e,paramName);
		}
		
	}

	protected <E extends BaseBean> void initializeParam(Object e, String paramName) {
//		Method method = Reflections.getAccessibleMethodByName(e, StringUtils.capitalize("get"+paramName));//在session未关闭是初始化参数
		Hibernate.initialize(Reflections.getFieldValue(e, paramName));
	}
}
