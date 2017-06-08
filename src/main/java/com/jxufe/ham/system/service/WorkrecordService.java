package com.jxufe.ham.system.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxufe.ham.common.dao.HibernateDao;
import com.jxufe.ham.common.entity.PropertyFilter;
import com.jxufe.ham.common.service.BaseService;
import com.jxufe.ham.system.dao.WorkrecordDao;
import com.jxufe.ham.system.dao.impl.WorkrecordDaoImpl;
import com.jxufe.ham.system.entity.Employee;
import com.jxufe.ham.system.entity.Workrecord;

@Service
public class WorkrecordService extends BaseService<Workrecord, Integer>{

	@Autowired
	private WorkrecordDao workrecordDao;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public HibernateDao<Workrecord, Integer> getEntityDao() {
		return workrecordDao;
	}

	/**
	 * 
	* @Title: signIn 
	* @Description:签到
	* @param employeeId
	 * @throws ParseException 
	 */
	public boolean signIn(Integer employeeId) throws ParseException {
		List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
		Date nowDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		filters.add(new PropertyFilter("GTD_workRecordDate", dateFormat.format(nowDate)));
		List<Workrecord> list = search(filters);
		if(!list.isEmpty()){
			return false;
		}
		Workrecord workrecord = new Workrecord();		
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		workrecord.setEmployee(employee);
		workrecord.setWorkRecordDate(new java.sql.Date(nowDate.getTime()));
		System.out.println(workrecord+"/n"+nowDate.getTime());
		save(workrecord);
		return true;
	}

}
