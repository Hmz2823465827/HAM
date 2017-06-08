package com.jxufe.ham.authority.shiro;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.config.Ini;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.expression.spel.ast.Selection;
import org.springframework.stereotype.Component;

import com.jxufe.ham.authority.entity.Authority;
import com.jxufe.ham.authority.entity.Function;
import com.jxufe.ham.authority.entity.Role;
import com.jxufe.ham.common.entity.PropertyFilter;
import com.jxufe.ham.system.entity.Custom;
import com.jxufe.ham.system.entity.Employee;
import com.jxufe.ham.system.entity.Followup;
import com.jxufe.ham.system.service.FunctionService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

/**
 * 
 * @Description:
 * @ClassName: ChainDefinitionSectionMetaSource
 * @author halu
 * @date 2017年5月5日 上午10:19:59
 */
// @Component
public class ChainDefinitionSectionMetaSource implements FactoryBean<Ini.Section> {

	
	
	Log log = LogFactory.getLog(ChainDefinitionSectionMetaSource.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private FunctionService functionService;
	
	// 静态资源访问权限
	private String filterChainDefinitions = "/plugin/**=anon";

	public Ini.Section getObject() throws Exception {
		// Session session = sessionFactory.Session();
		// session.beginTransaction();
		List<Function> list = functionService.getAll();
		Ini ini = new Ini();
		// 加载默认的url
		ini.load(filterChainDefinitions);
		Ini.Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
		// 循环Resource的url,逐个添加到section中。section就是filterChainDefinitionMap,
		// 里面的键就是链接URL,值就是存在什么条件才能访问该链接
		for (Iterator<Function> it = list.iterator(); it.hasNext();) {
			Function function = it.next();
//			List<PropertyFilter> listFilter = new ArrayList<PropertyFilter>();
//			listFilter.add(new PropertyFilter("EQS_",))
//			functionService.search(new {})
			// 构成permission字符串
			if (StringUtils.isNotEmpty(function.getValue()) && StringUtils.isNotEmpty(function.getType())) {
				String permission = "";
				Map<String, Integer> map = new HashMap<String, Integer>();
				map.put("anon", 1);
				map.put("perms", 2);
				map.put("roles", 3);
				switch (map.get(function.getType())) {
				case 1:
					permission = "anon";
					break;
				case 2:
					Authority authority = function.getAuthorityID();
					permission = "perms[" + authority.getOperation() + "]";
					System.out.println("perms[" + authority.getOperation() + "]");
					break;
				case 3:
					Role role = function.getRoleID();
					permission = "roles[" + role.getRoleName() + "]";
					System.out.println("roles[" + role.getRoleName() + "]");
					break;
				default:
					break;
				}
				section.put(function.getValue(), permission);
			}

		}
		// 所有资源的访问权限，必须放在最后
		section.put("/**", "authc");
		return section;
		/*
		 * Ini ini = new Ini(); // 加载默认的url ini.load(filterChainDefinitions);
		 * return ini.getSection(Ini.DEFAULT_SECTION_NAME);
		 */
	}

	public Class<?> getObjectType() {
		return this.getClass();
	}

	public boolean isSingleton() {
		return false;
	}
}