package com.demo.service;

import com.demo.base.DaoSupport;
import com.demo.domain.User;

public interface UserService extends DaoSupport<User> {

	User findByLoginNameAndPassword(String loginName, String password);


}
