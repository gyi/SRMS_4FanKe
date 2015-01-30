package com.demo.domain;

import java.util.HashSet;
import java.util.Set;

public class Good {
	private Long id;
	private String name;
	private Double price;
	
	private Set<Rec> recs =new HashSet<Rec>();

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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Set<Rec> getRecs() {
		return recs;
	}

	public void setRecs(Set<Rec> recs) {
		this.recs = recs;
	}

	
}
