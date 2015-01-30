package com.demo.service;

import java.util.Collection;
import java.util.List;

import com.demo.base.DaoSupport;
import com.demo.domain.Privilege;

public interface PrivilegeService extends DaoSupport<Privilege>{
	List<Privilege> findTopList();
	Collection<String> getAllPrivilegeUrls();
	

}
