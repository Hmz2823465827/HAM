package com.jxufe.ham.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
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
	protected <E extends BaseBean> List sortOnSet(Set<E> set,int page,int row,Comparator<BaseBean> comparable) {
//		Object[] list =  set.toArray();
		ArrayList<E> arrayList = new ArrayList<E>(set);
		arrayList.sort(comparable);
		int numTotal = page * row;//之前数据
		List<E> aList;
		if(numTotal < arrayList.size()){
			if(numTotal+row<arrayList.size()){
				aList = arrayList.subList(numTotal, numTotal+row);
			} else {
				aList = arrayList.subList(numTotal, arrayList.size());
			}
		} else {
			if(row<arrayList.size()){
				aList = arrayList.subList(0, row);
			} else {
				aList = arrayList.subList(0, arrayList.size());
			}
		}
		return aList;
	}

}
