package com.demo.view.action;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import com.demo.service.GoodService;
import com.demo.service.PrivilegeService;
import com.demo.service.RecService;
import com.demo.service.RoleService;
import com.demo.service.ShopService;
import com.demo.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	// modeldriven的支持
	protected T model;

	@SuppressWarnings("unchecked")
	public BaseAction() {
		try {
			// 通过反射获取model的真实类型
			ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class<T> clazz = (Class<T>)pt.getActualTypeArguments()[0];
			// 通过反射创建model的实例
			model = clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public T getModel() {
		return model;
	}

	// service实例的声明
	@Resource
	protected RoleService roleService;
	@Resource
	protected GoodService goodService;
	@Resource
	protected RecService recService;
	@Resource
	protected ShopService shopService;
	@Resource
	protected UserService userService;
	@Resource
	protected PrivilegeService privilegeService;
	
	//操作
	

}
