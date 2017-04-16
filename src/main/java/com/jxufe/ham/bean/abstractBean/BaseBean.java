package com.jxufe.ham.bean.abstractBean;

import java.io.Serializable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @Description:实体类的父类 
 * @ClassName: BaseBean
 * @author hongch
 * @date 2017年3月23日 上午10:10:21
 */
public class BaseBean implements Serializable{
	
	//序列ID
	private static final long serialVersionUID = 9187569369641399689L;

	public BaseBean() {
	}
	
	/**
	 * 
	* @Title: ToJson 
	* @Description:将object转为json字符串
	* @return string json字符串
	 */
	public String ToJson(){
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "{}";
	}
}
