package com.jxufe.ham.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.jboss.logging.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jxufe.ham.bean.Employee;
import com.jxufe.ham.bean.abstractBean.BaseBean;
import com.jxufe.ham.dao.EmployeeDao;
import com.jxufe.ham.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService eService;// 自动注入 employeeServer

	private Log log = LogFactory.getLog(EmployeeController.class);

	private final String LOGIN_E = "loginEmployee";// session登入用户key

	private final String ISDONE = "isDone";// 操作是否成功

	private final String MSG = "msg";// 操作成功信息

	private final String ERROR_MSG = "errorMsg";

	@RequestMapping("/load")
	public HashMap<String, Object> load(HttpServletRequest request) {
		Employee e = (Employee) getSessionValue(request, LOGIN_E);
		return null;
	}

	/**
	 * 
	 * @Title: quit
	 * @Description:用户退出
	 * @param request
	 * @return 登入界面视图模型
	 */
	@RequestMapping("quit")
	public ModelAndView quit(HttpServletRequest request) {
		request.getSession().removeAttribute(LOGIN_E);
		ModelAndView modelAndView = new ModelAndView("login.jsp");
		return modelAndView;

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
			Employee eFromData = eService.load(e.getEmployeeId());
			if (eFromData == null) {
				hashMap.put(ISDONE, false);
				hashMap.put(ERROR_MSG, "该用户不存在");
				throw new Exception("用户修改密码失败");
			}
			eFromData.setPassWord(passWord);
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

	@RequestMapping(value = "/loadWordrecord", method = RequestMethod.GET)
	public @ResponseBody HashMap<String, Object> loadWordrecord(HttpServletRequest request,
			@RequestParam Integer pageSize, @RequestParam Integer pageNumber) {
		Employee employee = eService.load(1);
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		try {
			List<BaseBean> list = eService.loadByWordrecord(employee, pageNumber, pageSize);
			hashMap.put("list", list);
			hashMap.put(ISDONE, true);
			hashMap.put(MSG, "获取成功");
		} catch (Exception e) {
			hashMap.put(ISDONE, false);
			hashMap.put(MSG, "获取失败");
			log.error(e.getMessage());
		}
		return hashMap;
	}
	
	@RequestMapping(value = "/loadworkRecordAll", method = RequestMethod.GET)
	public @ResponseBody HashMap<String, Object> loadWordrecordALL(HttpServletRequest request
		) {
		Employee employee = eService.load(1);
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		try {
					hashMap.put("list", employee.getWorkrecords());
			hashMap.put(ISDONE, true);
			hashMap.put(MSG, "获取成功");
		} catch (Exception e) {
			hashMap.put(ISDONE, false);
			hashMap.put(MSG, "获取失败");
			log.error(e.getMessage());
		}
		return hashMap;
	}
	
	@RequestMapping(value = "/loadhouseAll",method = RequestMethod.GET)
	public @ResponseBody HashMap<String, Object> loadHouse(HttpServletRequest request){
		Employee employee = eService.load(1);
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		try {
			hashMap.put("list", employee.getHouses());
			hashMap.put(ISDONE, true);
			hashMap.put(MSG, "获取成功");
		} catch (Exception e) {
			hashMap.put(ISDONE, false);
			hashMap.put(MSG, "获取失败");
			log.error(e.getMessage());
		}
		return hashMap;
	}
	
}