package com.demo.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import com.demo.service.PrivilegeService;
import com.opensymphony.xwork2.ActionContext;

public class User {
	private Long id;
	private String name;
	private String loginName;
	private String password;

	private Set<Rec> recs = new HashSet<Rec>();
	private Shop shop;
	private Role role;
	@Resource
	protected PrivilegeService privilegeService;

	// 判断本用户是否是超级管理员
	public boolean isAdmin() {
		return "sadmin".equals(loginName);
	}

	// 判断本用户是否有指定名称的权限
	public boolean hasPrivilegeByName(String name) {
		// 超级管理有所有的权限
		if (isAdmin()) {
			return true;
		}

		// 普通用户要判断是否含有这个权限
		for (Privilege priv : role.getPrivileges()) {
			if (priv.getName().equals(name)) {
				return true;
			}
		}

		return false;
	}

	// 判断本用户是否有指定URL的权限
	public boolean hasPrivilegeByUrl(String privUrl) {
		// 超级管理有所有的权限
		if (isAdmin()) {
			return true;
		}

		// >> 去掉后面的参数
		int pos = privUrl.indexOf("?");
		if (pos > -1) {
			privUrl = privUrl.substring(0, pos);
		}
		// >> 去掉UI后缀
		if (privUrl.endsWith("UI")) {
			privUrl = privUrl.substring(0, privUrl.length() - 2);
		}

		// 如果本URL不需要控制，则登录用户就可以使用
		Collection<String> allPrivilegeUrls = (Collection<String>) ActionContext
				.getContext().getApplication().get("allPrivilegeUrls");
		if (!allPrivilegeUrls.contains(privUrl)) {
			return true;
		} else {
			// 普通用户要判断是否含有这个权限
			for (Role role : new HashSet<Role>()) {
				for (Privilege priv : role.getPrivileges()) {
					if (privUrl.equals(priv.getUrl())) {
						return true;
					}
				}
			}
			return false;
		}
	}

	// ===getters and setters====
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Rec> getRecs() {
		return recs;
	}

	public void setRecs(Set<Rec> recs) {
		this.recs = recs;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
