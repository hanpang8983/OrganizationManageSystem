package com.isunmoon.oa.service.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.isunmoon.oa.bean.Person;
import com.isunmoon.oa.service.PersonService;

public class PersonServiceImpl extends HibernateDaoSupport implements PersonService {

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
	
	
}
