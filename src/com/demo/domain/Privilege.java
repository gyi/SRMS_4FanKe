package com.demo.domain;

import java.util.HashSet;
import java.util.Set;

public class Privilege {
	private Long id;
	private String url;
	private String name;
	private Set<Role> roles = new HashSet<Role>();
	private Privilege parent; // 上级权限
	private Set<Privilege> children = new HashSet<Privilege>(); // 下级权限

	public Privilege() {
	}

	public Privilege(Long id, String name, String url, Privilege parent) {
		this.id = id;
		this.name = name;
		this.url = url;
		this.parent = parent;
	}

	// ===getters and setters====
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Privilege getParent() {
		return parent;
	}

	public void setParent(Privilege parent) {
		this.parent = parent;
	}

	public Set<Privilege> getChildren() {
		return children;
	}

	public void setChildren(Set<Privilege> children) {
		this.children = children;
	}

}
