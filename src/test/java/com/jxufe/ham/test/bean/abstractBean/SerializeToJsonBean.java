package com.jxufe.ham.test.bean.abstractBean;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @Description:实体类的父类 
 * @ClassName: SerializeToJsonBean
 * @author hongch
 * @date 2017年3月23日 上午10:10:21
 */
public class SerializeToJsonBean implements Serializable{
	
	public SerializeToJsonBean() {
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
