package com.isunmoon.oa.service;

import java.util.List;

import com.isunmoon.oa.bean.Person;

public interface PersonService {
	// 添加人员信息
	public void add(Person person);
	// 查询所有人员信息
	public List queryPersons();
	// 根据人员id查找人员
	public Person queryPersonById(int id);
	// 根据人员id删除人员
	public void deletePersonById(int id);
	// 更细心呢人员信息
	public void updatePerson(Person person);
}
