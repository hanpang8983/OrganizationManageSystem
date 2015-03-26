package com.isunmoon.oa.service.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.isunmoon.oa.bean.Role;
import com.isunmoon.oa.service.RoleService;

public class RoleServiceImpl extends HibernateDaoSupport implements RoleService {

	@Override
	public List queryAllRoles() {
		return this.getHibernateTemplate().find("from Role");
	}

	@Override
	public void addRole(Role role) {
		this.getHibernateTemplate().save(role);
	}

	@Override
	public Role queryRoleById(int id) {
		return (Role) this.getHibernateTemplate().load(Role.class, id);
	}

	@Override
	public void updateRole(Role role) {
		this.getHibernateTemplate().update(role);
	}

	@Override
	public void deleteRoleById(int id) {
		Role role = this.queryRoleById(id);
		this.getHibernateTemplate().delete(role);
	}

}
