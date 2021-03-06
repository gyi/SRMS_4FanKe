package com.demo.base;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
// ↑↑↑此注解可以被继承
@SuppressWarnings("unchecked")
public class DaoSupportImpl<T> implements DaoSupport<T> {

	@Resource
	private SessionFactory sessionFactory;
	private Class<T> clazz = null;

	public DaoSupportImpl() {
		// 使用反射技术得到T的真实类型
		ParameterizedType pt = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		// 获取当前New的对象的泛型父类类型
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0];
		// 获取第一个类型参数的真实类型
		System.out.println("clazz--->" + clazz);
	}

	/**
	 * 获取当前可用session
	 * 
	 * @return
	 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void save(T entity) {
		getSession().save(entity);

	}

	public void delete(Long id) {
		Object object = getById(id);
		if (object != null) {
			getSession().delete(object);
		}

	}

	public void update(T entity) {
		getSession().update(entity);

	}

	public T getById(Long id) {
		return (T) getSession().get(clazz, id);
	}

	public List<T> getByIds(Long[] ids) {
		if (ids == null || ids.length == 0) {
			return Collections.EMPTY_LIST;
		} else {
			return getSession().createQuery(//
					"FROM " + clazz.getSimpleName() + " WHERE id IN (:ids)").setParameterList("ids", ids).list();
				
		}
	}

	public List<T> findAll() {
		return getSession().createQuery(//
				"FROM " + clazz.getSimpleName())//
				.list();
	}

}
