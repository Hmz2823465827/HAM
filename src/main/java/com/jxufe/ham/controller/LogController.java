package com.jxufe.ham.controller;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jxufe.ham.bean.Employee;
import com.jxufe.ham.service.EmployeeService;

@Controller
@RequestMapping("/index")
public class LogController {
	
	@Autowired
	private EmployeeService employeeService;
	
	private Log log = LogFactory.getLog(LogController.class);
	
	
	/**
	 * 
	* @Title: login 
	* @Description:雇员实体类登录
	* @param e 雇员实体类
	* @return
	 */
	@RequestMapping("/login")
	public HashMap<String, Object> login(Employee e){
		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		if(e==null){
			hashMap.put("isLogin", false);
			log.debug("账户为空登录失败");
		}
		return null;
	}
}
