package com.jxufe.ham.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.jboss.logging.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jxufe.ham.bean.Employee;
import com.jxufe.ham.dao.EmployeeDao;
import com.jxufe.ham.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeContrllor {

	@Autowired
	private EmployeeDao<Employee> eService;// 自动注入 employeeServer

	private Log log = LogFactory.getLog(EmployeeContrllor.class);

	private final String LOGIN_E = "loginEmployee";// session登入用户key

	private final String ISDONE = "isDone";// 操作是否成功

	private final String MSG = "msg";// 操作成功信息

	private final String ERROR_MSG = "errorMsg";

	@RequestMapping("/load")
	public HashMap<String, Object> load(HttpServletRequest request) {
		Employee e = (Employee) getSessionValue(request, LOGIN_E);
		return null;
	}

	@RequestMapping("quit")
	public ModelAndView quit(HttpServletRequest request) {
		request.getSession().removeAttribute(LOGIN_E);
		ModelAndView modelAndView = new ModelAndView("login.jsp");
		return null;

	}

	/**
	 * 
	 * @Title: modify
	 * @Description:雇员用户修改密码
	 * @return:操作参数
	 */
	@RequestMapping("/modifyPassword")
	public HashMap<String, Object> modify(HttpServletRequest request, @Param String passWord) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		try {
			Employee e = (Employee) getSessionValue(request, LOGIN_E);
			Employee eFromData = eService.select(e.getEmployeeId());
			if (eFromData == null) {
				hashMap.put(ISDONE, false);
				hashMap.put(ERROR_MSG, "该用户不存在");
				throw new Exception("用户修改密码失败");
			}
			eService.update(e);
			hashMap.put(ISDONE, true);
			hashMap.put(MSG, "修改成功");
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return hashMap;
	}

	private Object getSessionValue(HttpServletRequest request, String key) {
		HttpSession session = request.getSession();
		Object value = session.getAttribute(key);
		return value;

	}

	// @RequestMapping("/log")
	// public ModelAndView log(Employee e){
	// Employee eLogin = eService.login(e);
	// if(eLogin!=null)
	// return new ModelAndView("test");
	// else return new ModelAndView("index");
	// }

}
