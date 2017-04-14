package com.jxufe.ham.controller;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	* @param employee 雇员实体类
	* @return
	 */
	@RequestMapping(value ="/login",method = RequestMethod.POST)
	public @ResponseBody HashMap<String, Object> login(Employee employee){
		HashMap<String, Object> hashMap = new HashMap<>();
		final String isLogin = "isLogin";//是否登入成功
		final String errMsg = "errorMsg";//错误信息
		final String msg ="msg";//信息
		try {
			if(employee==null){
				hashMap.put(isLogin, false);
				hashMap.put(errMsg, "账户为空登录失败");
				log.debug("账户为空登录失败");
			}
			Employee eFromData = employeeService.load(employee.getEmployeeId());
			if(eFromData==null){
				hashMap.put(isLogin, false);
				hashMap.put(errMsg, "账户不存在");
				log.debug(employee.getEmployeeId()+":账户不存在");
			}
			else{
				if(eFromData.getPassWord().equals(employee.getPassWord())){
					hashMap.put(isLogin, true);
					hashMap.put(msg, "密码匹配成功");
					log.debug(employee.getEmployeeId()+":登入成功");
				}else {
					hashMap.put(isLogin, false);
					hashMap.put(msg, "密码匹配失败");
					log.debug(employee.getEmployeeId()+":登入失败");
				} 
			}
		} catch (Exception e) {
			log.equals(e.getMessage());
		} 
		return hashMap;
	}
	
	@RequestMapping(value = "toIndex",method = RequestMethod.GET)
	public ModelAndView toIndex(){
		return new ModelAndView("index");
	}
}
