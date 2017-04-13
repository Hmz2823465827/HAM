package com.jxufe.ham.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jxufe.ham.bean.Employee;
import com.jxufe.ham.dao.EmployeeDao;
import com.jxufe.ham.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeContrllor {
	
	@Autowired
	private EmployeeDao<Employee> eService;//自动注入 employeeServer
	
	@RequestMapping("/get")
	public String get(int id){
		Employee e = eService.select(id);
		return e.ToJson();
	}
	
//	@RequestMapping("/log")
//	public ModelAndView log(Employee e){
//		Employee eLogin = eService.login(e);
//		if(eLogin!=null)
//		return new ModelAndView("test");
//		else return new ModelAndView("index");
//	}
	
}
