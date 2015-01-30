package com.demo.domain;

import java.util.HashSet;
import java.util.Set;

public class Shop {
	private Long id;
	private String name;
	private String location;
	
	private Set<User> users = new HashSet<User>();
	private Set<Rec> recs = new HashSet<Rec>();

	//===getters and setters====
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Rec> getRecs() {
		return recs;
	}

	public void setRecs(Set<Rec> recs) {
		this.recs = recs;
	}
	
	
}
