package com.isunmoon.oa.service;

import java.util.List;

import com.isunmoon.oa.bean.Organization;


public interface OrganizationService {
	//添加机构
	public void addOrg(Organization org);
	//根据机构id加载机构实体
	public Organization queryOrgById(int id);
	//查询父机构或者子机构
	public List queryOrgsById(int id);
	//更新机构
	public void updateOrg(Organization org);
	//删除机构
	public void deleteOrgById(int id);
	
	
}
