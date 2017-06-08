package com.jxufe.ham.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.jboss.logging.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jxufe.ham.system.entity.Employee;
import com.jxufe.ham.system.myInterface.AutoAuthorizationClass;
import com.jxufe.ham.system.service.EmployeeService;
import com.jxufe.ham.system.util.StaticKey;

@AutoAuthorizationClass
@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService eService;// 自动注入 employeeServer

	private Log log = LogFactory.getLog(EmployeeController.class);

	private final String ISDONE = "isDone";// 操作是否成功

	private final String MSG = "msg";// 操作成功信息

	private final String ERROR_MSG = "errorMsg";

	@RequestMapping("/load")
	public HashMap<String, Object> load(HttpServletRequest request) {
		Employee e = (Employee) getSessionValue(request, StaticKey.LOGIN_E);
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
		request.getSession().removeAttribute(StaticKey.LOGIN_E);
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
			Employee e = (Employee) getSessionValue(request, StaticKey.LOGIN_E);
			Employee eFromData = eService.get(e.getEmployeeId());
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
	
	@RequestMapping(value = "/loadSetbyParam",method = RequestMethod.GET)
	public @ResponseBody HashMap<String, Object> loadSetByParam(HttpServletRequest request,@RequestParam String setName){
//		Employee employee = (Employee) getSessionValue(request, StaticKey.LOGIN_E); 
		Integer id =(Integer)SecurityUtils.getSubject().getPrincipal();
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		try {
			hashMap.put("list", eService.loadSetByParam(id,setName));
			hashMap.put(ISDONE, true);
			hashMap.put(MSG, "获取成功");
		} catch (Exception e) {
			hashMap.put(ISDONE, false);
			hashMap.put(MSG, "获取失败");
			log.error(e.getMessage());
		}
		return hashMap;
		
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> add(HttpServletRequest request,Employee employee){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			Assert.notNull(employee, "员工信息为空");
			eService.save(employee);
		}catch (Exception e) {
			log.error(e.getMessage());
			result.put(ISDONE, false);
			result.put(ERROR_MSG, e.getMessage());
			return result;
		}
		result.put(ISDONE, true);
		result.put(MSG, "删除成功");
		return result;
	}
	
	@RequestMapping("/test")
	public void add(){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
//			Employee emp = new Employee(null, 2, "asdf", "ads", "asdf","1", null, null, null, null, null, null, null, null, null, null, null)；
			Employee employee =new Employee();
			employee.setEmployeeName("test");		
			employee.setPassWord("1");
			
			Assert.notNull(employee, "员工信息为空");
			eService.save(employee);
		}catch (Exception e) {
			log.error(e.getMessage());
			result.put(ISDONE, false);
			result.put(ERROR_MSG, e.getMessage());
			return;
		}
		result.put(ISDONE, true);
		result.put(MSG, "删除成功");
		return;
	}
	
	@RequestMapping("/batchDel")
	public HashMap<String,Object> batchDel(List<Integer> idList){
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		try {
			eService.delete(idList); 
		} catch (Exception e) {
			hashMap.put(ISDONE, false);
			hashMap.put(ERROR_MSG, "批量删除失败");
			return hashMap;
		}
		hashMap.put(ISDONE, true);
		hashMap.put(MSG, "批量删除成功");
		return hashMap;
	}
	
}
