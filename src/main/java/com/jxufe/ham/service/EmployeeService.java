package com.jxufe.ham.service;

import java.util.ArrayList;
import java.util.List;

import com.jxufe.ham.bean.Employee;
import com.jxufe.ham.bean.Workrecord;
import com.jxufe.ham.bean.abstractBean.BaseBean;

/**
 * 
 * @Description: 雇员service接口
 * @ClassName: EmployeeService
 * @author halu
 * @date 2017年4月5日 下午8:27:33
 */
public interface EmployeeService {
	
	/**
	 * 
	* @Title: load 
	* @Description: 通过id加载雇员
	* @param id
	* @return 是否添加成功
	 */
	public Employee load(int id);
	
	/**
	 * 
	* @Title: sava 
	* @Description: 保存雇员数据
	* @param e 
	* @return 实体类主键
	 */
	public int sava(Employee e);
	
	/**
	 * 
	* @Title: delete 
	* @Description:删除雇员
	* @param id
	* @return
	 */
	public void delete(Employee e);
	
	/**
	 * 
	* @Title: update 
	* @Description:更新数据
	* @param e
	* @return
	 */
	public void update(Employee e);
	
	public Employee login(Employee e);

	/**
	 * 
	* @Title: loadByWordrecord 
	* @Description:获得该员工的任务记录
	* @param employee 员工
	* @param page 页码
	* @param row 一页的数据量
	* @return
	 */
	public abstract List<BaseBean> loadByWordrecord(Employee employee, int page, int row);
}
