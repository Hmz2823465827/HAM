package com.jxufe.ham.common.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.factory.annotation.Autowired;

import com.jxufe.ham.common.entity.BaseBean;
import com.jxufe.ham.common.util.Reflections;

/**
 * 封装Hibernate原生API的DAO泛型基类.
 * 可在Service层直接使用, 也可以扩展泛型DAO子类使用, 见两个构造函数的注释.
 * 取消了HibernateTemplate, 直接使用Hibernate原生API.
 * 
 * @param <T> DAO操作的对象类型
 * @param <PK> 主键类型
 * 
 * @author halu
 */
public class SimpleBaseDao<E extends BaseBean, PK extends Serializable> {

	@Autowired
	SessionFactory sessionFactory;

	protected Class<E> entityClass;

	protected Log logger = LogFactory.getLog(getClass());

	/**
	 * 用于Dao层子类使用的构造函数. 通过子类的泛型定义取得对象类型Class. eg. public class UserDao extends
	 * SimpleHibernateDao<User, Long>
	 */
	@SuppressWarnings("unchecked")
	public SimpleBaseDao() {

		this.entityClass = Reflections.getClassGenricType(getClass());

	}

	/**
	 * 用于用于省略Dao层, 在Service层直接使用通用SimpleHibernateDao的构造函数. 在构造函数中定义对象类型Class.
	 * eg. SimpleHibernateDao<User, Long> userDao = new SimpleHibernateDao<User,
	 * Long>(sessionFactory, User.class);
	 */
	public SimpleBaseDao(final SessionFactory sessionFactory, final Class<E> entityClass) {
		this.sessionFactory = sessionFactory;
		this.entityClass = entityClass;
	}

	/**
	 * 
	* @Title: insert 
	* @Description:增
	* @param e
	* @return
	 */
	@SuppressWarnings("unchecked")
	public PK save(E e) {
		Session session = getCurrentSession();
		return (PK) session.save(e);
	}

	/**
	 * 
	* @Title: delete 
	* @Description:根据对象删除
	* @param e
	 */
	public void delete(E e) {
		Session session = getCurrentSession();
		session.delete(e);
	}

	/**
	 * 
	* @Title: delete 
	* @Description:根据主键id删除
	* @param id
	 */
	public void delete(PK id) {
		delete(find(id));
	}
	
	/**
	 * 
	* @Title: update 
	* @Description:改
	* @param e
	 */
	public void update(E e) {
		Session session = getCurrentSession();
		session.update(e);

	}

	/**
	 * 
	* @Title: find 
	* @Description:通过ID列表查询对象列表
	* @param id
	* @return
	 */
	@SuppressWarnings("unchecked")
	public E find(PK id) {
		Session session = getCurrentSession();
		return (E) session.get(entityClass, id);
	}

	/**
	 * 
	* @Title: find 
	* @Description:通过ID列表查询对象列表
	* @param idList
	* @return
	 */
	public List<E> find(Collection<PK> idList) {
		return find(Restrictions.in(getIdName(), idList));
	}

	/**
	 * 
	* @Title: findAll 
	* @Description:获取全部对象.
	* @return
	 */
	public List<E> findAll() {
		return find();
	}

	/**
	 * 获取全部对象.
	 * 
	 * @param isCache
	 *            是否缓存
	 * @return 对象集合.
	 */
	public List<E> findAll(Boolean isCache) {
		return find(isCache);
	}

	/**
	 * 获取全部对象, 支持按属性行序.
	 * 
	 * @param orderByProperty
	 *            排序属性name
	 * @param isAsc
	 *            是否升序排序
	 * @return 查询结果集合
	 */
	@SuppressWarnings("unchecked")
	public List<E> findAll(String orderByProperty, boolean isAsc) {
		Criteria c = createCriteria();
		if (isAsc) {
			c.addOrder(Order.asc(orderByProperty));
		} else {
			c.addOrder(Order.desc(orderByProperty));
		}
		return c.list();
	}

	/**
	 * 按属性查找对象列表, 匹配方式为相等
	 * 
	 * @param propertyName
	 *            属性name
	 * @param value
	 *            属性值
	 * @return 结果集合
	 */
	public List<E> findBy(final String propertyName, final Object value) {
		Criterion criterion = Restrictions.eq(propertyName, value);
		return find(criterion);
	}

	/**
	 * 按属性查找唯一对象, 匹配方式为相等
	 * 
	 * @param propertyName 属性name
	 * @param value 属性值
	 * @return 结果对象
	 */
	@SuppressWarnings("unchecked")
	public E findUniqueBy(final String propertyName, final Object value) {
		Criterion criterion = Restrictions.eq(propertyName, value);
		return (E) createCriteria(criterion).uniqueResult();
	}
	
	/**
	 * 按HQL查询对象列表.
	 * @param hql
	 * @param values 数量可变的参数,按顺序绑定.
	 * @return 结果集合
	 */
	@SuppressWarnings("unchecked")
	public <X> List<X> find(final String hql, final Object... values) {
		return createQuery(hql, values).list();
	}
	
	/**
	 * 按HQL查询对象列表.
	 * 
	 * @param hql
	 * @param values 命名参数,按名称绑定.
	 * @return 对象集合
	 */
	@SuppressWarnings("unchecked")
	public <X> List<X> find(final String hql, final Map<String, ?> values) {
		return createQuery(hql, values).list();
	}
	
	/**
	 * 按HQL查询唯一对象.
	 * @param hql
	 * @param values 数量可变的参数,按顺序绑定.
	 * @return 对象
	 */
	@SuppressWarnings("unchecked")
	public <X> X findUnique(final String hql, final Object... values) {
		return (X) createQuery(hql, values).uniqueResult();
	}
	
	/**
	 * 按HQL查询唯一对象.
	 * @param hql
	 * @param values 命名参数,按名称绑定.
	 * @return 对象
	 */
	@SuppressWarnings("unchecked")
	public <X> X findUnique(final String hql, final Map<String, ?> values) {
		return (X) createQuery(hql, values).uniqueResult();
	}
	
	/**
	 * 执行HQL进行批量修改/删除操作.
	 * @param hql
	 * @param values 数量可变的参数,按顺序绑定.
	 * @return 更新记录数.
	 */
	public int batchExecute(final String hql, final Object... values) {
		return createQuery(hql, values).executeUpdate();
	}
	

	/**
	 * 执行HQL进行批量修改/删除操作.
	 * @param hql
	 * @param values 命名参数,按名称绑定.
	 * @return 更新记录数.
	 */
	public int batchExecute(final String hql, final Map<String, ?> values) {
		return createQuery(hql, values).executeUpdate();
	}
	
	
	/**
	 * 根据查询HQL与参数列表创建Query对象.
	 * @param queryString 
	 * @param values 数量可变的参数,按顺序绑定.
	 * @return Query
	 */
	public Query createQuery(final String queryString, final Object... values) {
//		Assert.hasText(queryString, "queryString不能为空");
		Query query = getCurrentSession().createQuery(queryString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(String.valueOf(i), values[i]);
			}
		}
		return query;
	}
	
	/**
	 * 根据查询HQL与参数列表创建Query对象.
	 * 与find()函数可进行更加灵活的操作.
	 * @param queryString
	 * @param values 命名参数,按名称绑定.
	 * @return Query
	 */
	public Query createQuery(final String queryString, final Map<String, ?> values) {
//		Assert.hasText(queryString, "queryString不能为空");
		Query query = getCurrentSession().createQuery(queryString);
		if (values != null) {
			query.setProperties(values);
		}
		return query;
	}
	
	/**
	 * 根据查询SQL与参数列表创建Query对象.
	 * @param queryString
	 * @param values 数量可变的参数,按顺序绑定.
	 * @return SQLQuery
	 */
	public SQLQuery createSQLQuery(final String queryString, final Object... values){
		SQLQuery sqlQuery = getCurrentSession().createSQLQuery(queryString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				sqlQuery.setParameter(String.valueOf(i), values[i]);
			}
		}
		return sqlQuery;
	}
	
	/**
	 * 根据查询SQL与参数列表创建Query对象.
	 * @param queryString
	 * @param values 命名参数,按名称绑定.
	 * @return SQLQuery
	 */
	public SQLQuery createSQLQuery(final String queryString, final Map<String, ?> values) {
		SQLQuery sqlQuery = getCurrentSession().createSQLQuery(queryString);
		if (values != null) {
			sqlQuery.setProperties(values);
		}
		return sqlQuery;
	}
	
	/*
	 * 按Criteria查询对象列表.
	 * @param criterions 数量可变的Criterion.
	 * @return 结果集合
	 */
//	@Override
	@SuppressWarnings("unchecked")
	public List<E> find(final Criterion... criterions) {
		return createCriteria(criterions).list();
	}
	
	public List<E> find(Boolean isCache,final Criterion... criterions) {
		return createCriteria(isCache,criterions).list();
	}
	
	/**
	 * 按Criteria查询唯一对象.
	 * @param criterions 数量可变的Criterion.
	 * @return 对象
	 */
	@SuppressWarnings("unchecked")
	public E findUnique(final Criterion... criterions) {
		return (E) createCriteria(criterions).uniqueResult();
	}
	
	/**
	 * 根据Criterion条件创建Criteria.
	 * 与find()函数可进行更加灵活的操作.
	 * @param criterions 数量可变的Criterion.
	 * @return Criteria
	 */
	public Criteria createCriteria(final Criterion... criterions) {
		Criteria criteria = getCurrentSession().createCriteria(entityClass);
		for (Criterion c : criterions) {
			criteria.add(c);
		}
		return criteria;
	}
	
	public Criteria createCriteria(Boolean isCache,final Criterion... criterions) {
		Criteria criteria = getCurrentSession().createCriteria(entityClass);
		for (Criterion c : criterions) {
			criteria.add(c);
		}
		criteria.setCacheable(isCache);
		return criteria;
	}
	
	/**
	 * 初始化对象.
	 * 使用load()方法得到的仅是对象Proxy, 在传到View层前需要进行初始化.
	 * 如果传入entity, 则只初始化entity的直接属性,但不会初始化延迟加载的关联集合和属性.
	 * 如需初始化关联属性,需执行:
	 * Hibernate.initialize(user.getRoles())，初始化User的直接属性和关联集合.
	 * Hibernate.initialize(user.getDescription())，初始化User的直接属性和延迟加载的Description属性.
	 */
	public void initProxyObject(Object proxy) {
		Hibernate.initialize(proxy);
	}
	
	/**
	 * Flush当前Session.
	 */
	public void flush() {
		getCurrentSession().flush();
	}
	
	/**
	 * 为Query添加distinct transformer.
	 * 预加载关联对象的HQL会引起主对象重复, 需要进行distinct处理.
	 * @param query
	 * @return Query
	 */
	public Query distinct(Query query) {
		query.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return query;
	}
	
	/**
	 * 为Criteria添加distinct transformer.
	 * 预加载关联对象的HQL会引起主对象重复, 需要进行distinct处理.
	 * @param criteria
	 * @return Criteria
	 */
	public Criteria distinct(Criteria criteria) {
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return criteria;
	}
	
	/*
	 * 
	 * Title: update Description:
	 * 
	 * @param e
	 * 
	 * @see
	 * com.jxufe.ham.common.dao.BaseDao#update(com.jxufe.ham.bean.abstractBean.
	 * BaseBean)
	 */
	

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();

	}

	/**
	 * 取得对象的主键名.
	 * 
	 * @return 对象的主键名
	 */
	public String getIdName() {
		ClassMetadata meta = sessionFactory.getClassMetadata(entityClass);
		return meta.getIdentifierPropertyName();
	}
	
	/**
	 * 判断对象的属性值在数据库内是否唯一.
	 * 在修改对象的情景下,如果属性新修改的值(value)等于属性原来的值(orgValue)则不作比较.
	 * @param propertyName 属性name
	 * @param newValue 新值
	 * @param oldValue 旧值
	 * @return 是否唯一
	 */
	public boolean isPropertyUnique(final String propertyName, final Object newValue, final Object oldValue) {
		if (newValue == null || newValue.equals(oldValue)) {
			return true;
		}
		Object object = findUniqueBy(propertyName, newValue);
		return (object == null);
	}
}
