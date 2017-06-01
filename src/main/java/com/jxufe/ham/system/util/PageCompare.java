package com.jxufe.ham.system.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jxufe.ham.common.entity.BaseBean;

public class PageCompare<E extends BaseBean> implements Comparator<E>{
	
	private Log log = LogFactory.getLog(PageCompare.class);
	
//	private String sortKey;
	
	private String methodName;//实体类比较   getXXX方法
	
	private PageCompare(){
		
	}
	
	public PageCompare(String methodName) {
		super();
		this.methodName = methodName;
	}

	public int compare(E o1, E o2) {
		try {
			Method methodO1 = o1.getClass().getDeclaredMethod(methodName);
			Method methodO2 = o2.getClass().getDeclaredMethod(methodName);
			Object valueO1 = methodO1.invoke(o1);//通过判断的属性
			Object valueO2 = methodO2.invoke(o2);//通过判断的属性
			if(valueO1 instanceof String && valueO2 instanceof String){//属性为String时
				String valueO1String = (String)valueO1;
				String valueO2String = (String)valueO2;
				return valueO1String.compareToIgnoreCase(valueO2String);
			} else if (valueO1 instanceof Integer) {//属性为Integer时
				Integer valueO1Integer = (Integer)valueO1;
				Integer valueO2Integer = (Integer)valueO2;
				return valueO1Integer.compareTo(valueO2Integer);
			} else if (valueO1 instanceof Date && valueO2 instanceof Date) {//属性为Date
				Date valueO1Date = (Date)valueO1;
				Date valueO2Date = (Date)valueO2;
				return valueO1Date.compareTo(valueO2Date);
			}
		} catch (NoSuchMethodException e) {
			log.error(e.getMessage());
		} catch (SecurityException e) {
			log.error(e.getMessage());
		} catch (IllegalAccessException e) {
			log.error(e.getMessage());
		} catch (IllegalArgumentException e) {
			log.error(e.getMessage());
		} catch (InvocationTargetException e) {
			log.error(e.getMessage());
		}
		return 0;
	}

}
