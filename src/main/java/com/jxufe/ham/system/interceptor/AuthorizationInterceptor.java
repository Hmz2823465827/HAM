package com.jxufe.ham.system.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jxufe.ham.system.exception.SessionOutException;
import com.jxufe.ham.system.myInterface.AutoAuthorization;
import com.jxufe.ham.system.myInterface.AutoAuthorizationClass;
import com.jxufe.ham.system.util.StaticKey;


/**
 * 
 * @Description:判断session中用户是否已登入 
 * @ClassName: AuthorizationInterceptor
 * @author halu
 * @date 2017年4月23日 下午7:21:41
 */
public class AuthorizationInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(handler.getClass().isAssignableFrom(HandlerMethod.class)){
			Object object = ((HandlerMethod)handler).getBean();
//			AutoAuthorizationClass authorizationClass = object.getClass().getAnnotation(AutoAuthorizationClass.class);
			AutoAuthorization authorization = ((HandlerMethod)handler).getMethodAnnotation(AutoAuthorization.class);
			if((authorization != null && authorization.validate() == true)/*||(authorizationClass != null && authorizationClass.validate() == true)*/){
				if(request.getSession().getAttribute(StaticKey.LOGIN_E)!=null){
					return true;
//					throw new SessionOutException();
				} 
				else throw new SessionOutException();
			}
		}	
		return true;
	}
}
