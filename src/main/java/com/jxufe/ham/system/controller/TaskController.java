package com.jxufe.ham.system.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jxufe.ham.system.entity.Task;
import com.jxufe.ham.system.service.TaskService;

@RequestMapping("/task")
@Controller
public class TaskController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private final String IS_DO = "isDo";
	
	private final String MSG = "msg";
	
	private final String ERROR_MSG = "errorMsg";
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value="/getTaskByEmployeeId",method=RequestMethod.POST)
	public HashMap<String, Object> getTaskByEmployeeId(){
		Integer employeeId = (Integer)SecurityUtils.getSubject().getPrincipal();
		HashMap<String,Object> hashMap = new HashMap<String, Object>();
		List<Task> tasks;
		try {
			tasks = taskService.getTaskByEmployeeId(employeeId);
		} catch (Exception e) {
			hashMap.put(IS_DO,true);
			hashMap.put(ERROR_MSG, "查询失败");
		}
		hashMap.put(IS_DO, true);
		hashMap.put(MSG, "查询成功");
		return hashMap;
	}
}
