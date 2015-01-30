package com.demo.base;

import java.util.List;
import org.apache.log4j.Level;

public interface DaoSupport<T> {
	
	void save(T entity);
	
	void delete(Long id);
	
	void update(T entity);
	
	T getById(Long id);
	
	List<T> getByIds(Long[] ids);
	
	List<T> findAll();

}
