package com.isunmoon.oa.service.impl;

import java.util.List;

import com.isunmoon.oa.bean.Person;
import com.isunmoon.oa.service.PersonService;
import com.isunmoon.oa.web.PageModel;

public class PersonServiceImpl extends BaseHibernateDao implements PersonService {

	@Override
	public void add(Person person) {
		this.getHibernateTemplate().save(person);
	}

	@Override
	public List queryPersons() {
		return this.getHibernateTemplate().find("from Person");
	}

	@Override
	public Person queryPersonById(int id) {
		Person person = (Person) this.getHibernateTemplate().load(Person.class, id);
		return person;		
	}

	@Override
	public void deletePersonById(int id) {
		Person person = (Person) this.getHibernateTemplate().load(Person.class, id);
		this.getHibernateTemplate().delete(person);
	}

	@Override
	public void updatePerson(Person person) {
		this.getHibernateTemplate().update(person);
	}

	@Override
	public PageModel serchPerson() {
		String hql = "from Person";
		return super.serchPageModel(hql);
	}
	
	
}
