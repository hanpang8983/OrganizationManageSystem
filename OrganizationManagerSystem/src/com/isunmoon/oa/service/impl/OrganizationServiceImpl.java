package com.isunmoon.oa.service.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.isunmoon.oa.bean.Organization;
import com.isunmoon.oa.service.OrganizationService;

public class OrganizationServiceImpl extends HibernateDaoSupport implements OrganizationService {

	@Override
	public void addOrg(Organization org) {
		this.getHibernateTemplate().save(org);		
	}

	@Override
	public Organization queryOrgById(int id) {
		Organization org = (Organization) this.getHibernateTemplate().load(Organization.class, id);
		return org;
	}
	
	@Override
	public List queryOrgsById(int id) {
		if(id == 0) {
			//所有父机构
			return this.getHibernateTemplate().find("from Organization where parent=null");
		}else {
			//该机构下对应的所有子机构
			return this.getHibernateTemplate().find("from Organization where parent.id=?", id);
		}
	}

	@Override
	public void updateOrg(Organization org) {
		this.getHibernateTemplate().update(org);
	}

	@Override
	public void deleteOrgById(int id) {
		Organization org = (Organization) this.getHibernateTemplate().load(Organization.class, id);
		this.getHibernateTemplate().delete(org);
	}
	
}
