package com.isunmoon.oa.bean;

import java.util.Set;

public class Organization {
	// id
	private int id;
	// 机构名称
	private String name;
	// 机构描述
	private String description;
	// 父机构
	private Organization parent;
	// 子机构
	private Set children;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Organization getParent() {
		return parent;
	}
	public void setParent(Organization parent) {
		this.parent = parent;
	}
	public Set getChildren() {
		return children;
	}
	public void setChildren(Set children) {
		this.children = children;
	}
}
