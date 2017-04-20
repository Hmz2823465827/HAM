package com.jxufe.ham.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

import com.jxufe.ham.bean.Employee;
import com.jxufe.ham.bean.Workrecord;
import com.jxufe.ham.bean.abstractBean.BaseBean;

public class BaseService {
	
	/**
	 * 
	* @Title: sortOnSet 
	* @Description: 在集合中通过页码来排序
	* @return
	 */
	protected <E extends BaseBean> ArrayList<E> sortOnSet(Set<E> set,int page,int row,Comparator<? super E> comparable) {
		E[] list = (E[])set.toArray();
		Arrays.sort(list, comparable);
		ArrayList<E> arrayList = (ArrayList<E>) Arrays.asList(list);
		int numTotal = page * row;//之前数据
		ArrayList<E> aList = (ArrayList<E>)arrayList.subList(numTotal, numTotal+row);
		return arrayList;
	}

}
