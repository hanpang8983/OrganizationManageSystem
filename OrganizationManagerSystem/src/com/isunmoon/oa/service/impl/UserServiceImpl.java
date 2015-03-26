package com.isunmoon.oa.service.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.isunmoon.oa.bean.Person;
import com.isunmoon.oa.bean.User;
import com.isunmoon.oa.service.UserService;

public class UserServiceImpl extends HibernateDaoSupport implements UserService {

	@Override
	public void addAccountToPerson(User user) {
		this.getHibernateTemplate().save(user);
	}

	@Override
	public void deleteAccountById(int id) {
		User user = (User) this.getHibernateTemplate().load(User.class, id);
		this.getHibernateTemplate().delete(user);
	}

	@Override
	public User queryUserById(int id) {
		return (User) this.getHibernateTemplate().load(User.class, id);
	}

	@Override
	public void updateUser(User user) {
		this.getHibernateTemplate().update(user);
	}

}
