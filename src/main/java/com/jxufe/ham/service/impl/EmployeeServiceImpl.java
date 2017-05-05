package com.jxufe.ham.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jxufe.ham.bean.Employee;
import com.jxufe.ham.bean.Workrecord;
import com.jxufe.ham.bean.abstractBean.BaseBean;
import com.jxufe.ham.dao.EmployeeDao;
import com.jxufe.ham.dao.impl.EmployeeDaoImpl;
import com.jxufe.ham.service.EmployeeService;
import com.jxufe.ham.util.PageCompare;
import com.sun.tools.internal.ws.wsdl.document.jaxws.Exception;

/**
 * 
 * @Description: 雇员service层实现类
 * @ClassName: EmployeeServiceImpl
 * @author halu
 * @date 2017年4月5日 下午8:32:07
 */
@Service
public class EmployeeServiceImpl extends BaseService implements EmployeeService {

	@Autowired
	private EmployeeDao<Employee> dao;//自动注入employeeDao层实现类
	
	public Employee load(int id) {
		Employee bean = dao.select(id);
		return bean;
	}

	public int sava(Employee bean) {
		int eId= dao.insert(bean);
		return eId;
	}

	public void delete(Employee bean) {
		dao.delete(bean);
	}

	public void update(Employee bean) {
		dao.update(bean);
	}

	public Employee login(Employee bean) {
		Employee eLoad;
		eLoad = load(bean.getEmployeeId());
		if(eLoad!=null){//通过id加载雇员不为空
			//验证通过
			if(eLoad.getEmployeeName().equals(bean.getEmployeeName())){
				return eLoad;
			}
		}
		return null;
	}

	public List<BaseBean> loadByWordrecord(Employee employee, int page, int row) {
		return loadByWordrecord(employee, "getWordrecord", page, row);
	}

	
	public List<BaseBean> loadByWordrecord(Employee employee,String compareString,int page,int row){
		Set<Workrecord> wordrecordSet = employee.getWorkrecords();
		PageCompare<BaseBean> comparable = new PageCompare<BaseBean>(compareString);
		List<BaseBean> arrayList = sortOnSet(wordrecordSet, page, row,comparable);
		return arrayList;
	}
	
	/**
	* 
	* @Title: loadSetByParam 
	* @Description:通过参数加载相关数据集合
	* @return
	*/
	public Set<BaseBean> loadSetByParam(BaseBean bean,String param) throws java.lang.Exception{
//		param.Character.toUpperCase(param.charAt(0));
		Method getIdMethod = bean.getClass().getDeclaredMethod("getEmployeeId");
		int beanId = (Integer) getIdMethod.invoke(bean);
		Employee loadBean = load(beanId);
		StringBuilder builder = new StringBuilder(param);
		builder.replace(0, 1, Character.toUpperCase(param.charAt(0))+"");
		builder.append("s");
		String methodName = "get"+ builder.toString();
		Method method = loadBean.getClass().getDeclaredMethod(methodName);
		Object objectSet = method.invoke(loadBean);
		if(objectSet instanceof Set){
			@SuppressWarnings("unchecked")
			Set<BaseBean> paramSet = (Set<BaseBean>)objectSet;
			return paramSet;
		}
		return null;
	}

	public BaseBean findByName(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}
