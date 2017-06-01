package com.jxufe.ham.system.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.jxufe.ham.system.exception.SessionOutException;


/**
 * 
 * @Description: 异常解析器
 * @ClassName: OverallExceptionResolver
 * @author halu
 * @date 2017年4月23日 下午7:25:21
 */
//@Controller
public class OverallExceptionResolver /*implements HandlerExceptionResolver*/{

	//日志输出类
	private Logger logger = Logger.getLogger(OverallExceptionResolver.class);
	
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ModelAndView modelAndView = new ModelAndView();
		logger.error("**************************************************************");
        logger.error("Exception class: " + ex.getClass().getName());
        logger.error("ex.getMessage():" + ex.getMessage());
        logger.error("**************************************************************");
		if(ex instanceof SessionOutException){
			logger.error("seesion超时");
			if (request.getHeader("x-requested-with") != null   
					&& request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){
				response.setHeader("sessionstatus", "timeout"); // 响应头设置session状态   
			}
			try {
				logger.info(response.isCommitted());
				response.sendRedirect("http://localhost:8080/HAM");
//				return null;
				modelAndView.addObject("errorMsg", "系统出错啦，稍后再试试！");
		        modelAndView.setViewName("error");
		        return modelAndView;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String  message = "系统出错啦，稍后再试试！";
		modelAndView.addObject("errorMsg", message);
        modelAndView.setViewName("error");
        return modelAndView;
	}

}
