package com.jxufe.ham.system.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jxufe.ham.common.entity.BaseBean;
import com.jxufe.ham.system.entity.Employee;
import com.jxufe.ham.system.myInterface.AutoAuthorization;
import com.jxufe.ham.system.service.EmployeeService;
import com.jxufe.ham.system.util.StaticKey;

/**
 * 
 * @Description:登入模块Controller层 
 * @ClassName: LogController
 * @author halu
 * @date 2017年4月16日 上午11:17:47
 */
@Controller
@RequestMapping("/index")
public class LoginController {
	
	@Autowired
	private EmployeeService employeeService;//雇员service
	
	private Log log = LogFactory.getLog(LoginController.class);
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		System.out.println("/HAM/index/login.htmls");
		return "/welcome";
	}
	
	/**
	 * 
	* @Title: login 
	* @Description:雇员实体类登录
	* @param employee 雇员实体类
	* @return
	 */
	@RequestMapping(value ="/login",method = RequestMethod.POST)
	public @ResponseBody Map login(Employee employee,HttpServletRequest request){
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		final String isLogin = "isLogin";//是否登入成功
		final String errMsg = "errorMsg";//错误信息 q
		final String msg ="msg";//信息
		try {
			if(employee==null){
				hashMap.put(isLogin, false);
				hashMap.put(errMsg, "账户为空登录失败");
				log.debug("账户为空登录失败");
			}
			SecurityUtils.getSubject().login(new UsernamePasswordToken(employee.getEmployeeId()+"", employee.getPassWord()));
			Employee eFromData = employeeService.get(employee.getEmployeeId());
			if(eFromData==null){
				hashMap.put(isLogin, false);
				hashMap.put(errMsg, "账户不存在");
				log.debug(employee.getEmployeeId()+":账户不存在");
			}
			else{
				if(eFromData.getPassWord().equals(employee.getPassWord())){
					hashMap.put(isLogin, true);
					putSession(request,eFromData);
					hashMap.put(msg, "密码匹配成功");
					log.debug(employee.getEmployeeId()+":登入成功");
				}else {
					hashMap.put(isLogin, false);
					hashMap.put(errMsg, "密码匹配失败");
					log.debug(employee.getEmployeeId()+":登入失败");
				} 
			}
			
		} catch (Exception e) {
			log.equals(e.getMessage());
		} 
		return hashMap;
//		return new ModelAndView("index");
	}
	
	private void putSession(HttpServletRequest request, BaseBean bean) {
		HttpSession session = request.getSession();
		session.setAttribute(StaticKey.LOGIN_E,bean);
		
	}

	/**
	 * 
	* @Title: toIndex 
	* @Description:登入成功返回ModelAndView视图模型跳转
	* @return
	 */
//	@AutoAuthorization
	@RequestMapping(value = "toIndex",method = RequestMethod.POST)
	public ModelAndView toIndex(){

		return new ModelAndView("index");//返回WEB-INF下的view目录下index.jsp文件
	}
	
	@RequestMapping("403")
	public ModelAndView error(){
		return new ModelAndView("403");
	}
}
