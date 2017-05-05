package com.jxufe.ham.shiro;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.config.Ini;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.jxufe.ham.bean.Authoritymanagement;
import com.jxufe.ham.bean.Function;
import com.jxufe.ham.service.AuthoritymanagementService;
import com.jxufe.ham.service.FunctionService;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 
 * @Description:
 * @ClassName: ChainDefinitionSectionMetaSource
 * @author halu
 * @date 2017年5月5日 上午10:19:59
 */
public class ChainDefinitionSectionMetaSource implements FactoryBean<Ini.Section> {

	@Autowired
	private FunctionService functionService;

	// 静态资源访问权限
	private String filterChainDefinitions = "/plugin/**=anon";

	public Ini.Section getObject() throws Exception {
		List<Function> list = functionService.findAll();
		Ini ini = new Ini();
		// 加载默认的url
		ini.load(filterChainDefinitions);
		Ini.Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
		// 循环Resource的url,逐个添加到section中。section就是filterChainDefinitionMap,
		// 里面的键就是链接URL,值就是存在什么条件才能访问该链接
		for (Iterator<Function> it = list.iterator(); it.hasNext();) {
			Function function = it.next();
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
					permission = "perms[" + function.getAuthority().getAuthorityname() + "]";
					break;
				case 3:
					permission = "roles[" + function.getRole().getRolename() + "]";
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
	}

	public Class<?> getObjectType() {
		return this.getClass();
	}

	public boolean isSingleton() {
		return false;
	}
}