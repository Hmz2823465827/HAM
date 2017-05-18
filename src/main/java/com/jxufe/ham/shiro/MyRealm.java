package com.jxufe.ham.shiro;



import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import com.jxufe.ham.service.EmployeeService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxufe.ham.bean.Rolemanagement;
import com.jxufe.ham.bean.abstractBean.BaseBean;
import com.jxufe.ham.bean.Employee;

/**
 * Created by Jeremie on 2014/10/1.
 */

@Service
@Transactional
public class MyRealm extends AuthorizingRealm{
	
	Log log = LogFactory.getLog(MyRealm.class);

    @Inject
    private EmployeeService employeeService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录时输入的用户名  
        String loginName=(String) principalCollection.fromRealm(getName()).iterator().next();
        //到数据库获取此用户
        Employee employee=employeeService.load(Integer.parseInt(loginName));
        if(employee!=null){
            //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）  
            SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
            //用户的角色集合
            Set<Rolemanagement> rolemanagements = employee.getRolemanagements();
            Set<String> roleNameSet = new HashSet<String>();
			try {
				roleNameSet = getParamFromManagement(rolemanagements,"role","roleName");
			} catch (Exception e) {
				log.error(e.getMessage());
			}//从管理表中获取属性中的属性
            info.setRoles(roleNameSet);
            //用户的角色对应的所有权限，如果只使用角色定义访问权限
            Set<Rolemanagement> roleMangementSet= employee.getRolemanagements();
            
            for (Rolemanagement rolemanagement : roleMangementSet) {
                try {
					info.addStringPermissions(getParamFromManagement(rolemanagement.getRole().getAuthoritymanagements(),"authority","authorityName"));
				} catch (Exception e) {
					log.error(e.getMessage());
				}
            }
            return info;
        }
        return null;
    }

    /**
     * 
    * @Title: getParamFromManagement 
    * @Description:从管理表中获取属性中的属性
    * @param managementSet 管理表集合
    * @param paramName 属性名称
    * @param sonParamName 子属性名称
    * @return
     * @throws Exception 
     */
    private Set<String> getParamFromManagement(Set<? extends BaseBean> managementSet, String paramName, String sonParamName) throws Exception {
    	Set<String> sonParamSet = new HashSet<String>();
		for (BaseBean baseBean : managementSet) {
			String paramMethodName;//方法名称
			paramMethodName = "get" + toUpperCase4Index(paramName);
			Method paramMethod = baseBean.getClass().getDeclaredMethod(paramMethodName);
			Object object = paramMethod.invoke(baseBean);
			String sonParamMethodName;//获取到的实体类的方法名
			sonParamMethodName = "get" + toUpperCase4Index(sonParamName);
			Method sonParamMethod = object.getClass().getDeclaredMethod(sonParamMethodName);
			Object stringObject = sonParamMethod.invoke(object);
			if(!(stringObject instanceof String)){
				throw new Exception("获取字符串属性集合失败");
			}
			sonParamSet.add((String)stringObject);
		}
		return sonParamSet;
	}
    
    /** 
     * 首字母大写 
     *  
     * @param string 
     * @return 
     */  
    public static String toUpperCase4Index(String string) {  
        char[] methodName = string.toCharArray();  
        methodName[0] = toUpperCase(methodName[0]);  
        return String.valueOf(methodName);  
    }  
      
    /** 
     * 字符转成大写 
     *  
     * @param chars 
     * @return 
     */  
    public static char toUpperCase(char chars) {  
        if (97 <= chars && chars <= 122) {  
            chars ^= 32;  
        }  
        return chars;  
    }  
	/**
     * 获取身份验证相关信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authenticationToken) throws AuthenticationException {
        //UsernamePasswordToken对象用来存放提交的登录信息  
        UsernamePasswordToken token=(UsernamePasswordToken) authenticationToken;
        //查出是否有此用户  
        Employee employee=employeeService.load(Integer.parseInt(token.getUsername()));
        if(employee!=null){
            //若存在，将此用户存放到登录认证info中  
            return new SimpleAuthenticationInfo(employee.getEmployeeId(), employee.getPassWord(), getName());
        }
        return null;
    }

}