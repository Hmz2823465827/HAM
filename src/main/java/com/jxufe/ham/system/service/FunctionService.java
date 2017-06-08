package com.jxufe.ham.system.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxufe.ham.authority.dao.FunctionDao;
import com.jxufe.ham.authority.entity.Authority;
import com.jxufe.ham.authority.entity.Function;
import com.jxufe.ham.authority.entity.Role;
import com.jxufe.ham.common.dao.HibernateDao;
import com.jxufe.ham.common.service.BaseService;

@Service
@Transactional(readOnly = true)
public class FunctionService extends BaseService<Function, Integer>{
	
	@Autowired
	private FunctionDao functionDao;

	@Override
	public HibernateDao<Function, Integer> getEntityDao() {
		return functionDao;
	}
	
	@Override
	public List<Function> getAll() {
		// TODO Auto-generated method stub
		return super.getAll();
		
	}

}
