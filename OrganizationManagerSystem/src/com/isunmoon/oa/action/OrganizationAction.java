package com.isunmoon.oa.action;

import java.util.List;

import com.isunmoon.oa.bean.Organization;
import com.isunmoon.oa.service.OrganizationService;
import com.isunmoon.oa.web.PageModel;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class OrganizationAction extends ActionSupport {

	private OrganizationService organizationService;
	private int parentId;
	private int orgId;
	private Organization org;
	private String result;
	/*
	 * 跳转到机构管理页面
	 */
	public String toIndex() {
		System.out.println("Organization---toIndex()");
		System.out.println("orgId=" + orgId);
		System.out.println("parentId=" + parentId);
		
		List orgList = organizationService.queryOrgsById(orgId);
		ActionContext.getContext().put("orgList", orgList);
//		String hql = "select * from Organization where id=?";
//		PageModel pm = baseService.queryPageModel(hql, new Object[] {orgId});
//		ActionContext.getContext().put("pm", pm);
		
		return "success";
	}
	/*
	 * 跳转到添加机构页面
	 */
	public String toAdd() {
		System.out.println("OrganizationAction---toAdd()");
		System.out.println("orgId=" + orgId);
		
		return "success";
	}
	/*
	 * 添加机构
	 */
	public String add() {
		System.out.println("Organization---add()");
		System.out.println("orgId=" + orgId);
		System.out.println("org.name=" + org.getName() + "---org.escription" + org.getDescription());
		
		if(org.getName().equals("") || org.getDescription().equals("")) {
			result = "保存失败，请填写完整信息。";
			return "failed";
		}
		
		if(orgId == 0) {
			organizationService.addOrg(org);
		}else {
			Organization parentOrg = organizationService.queryOrgById(orgId);
			org.setParent(parentOrg);
			organizationService.addOrg(org);
		}
		
		List orgList = organizationService.queryOrgsById(orgId);
		ActionContext.getContext().put("orgList", orgList);
		return "success";
	}
	/*
	 * 跳转到更新机构页面
	 */
	public String toUpdate() {
		System.out.println("OrganizationAction---toUpdate()");
		System.out.println("orgId=" + orgId);
		System.out.println("parentId=" + parentId);
		
		Organization organization = organizationService.queryOrgById(orgId);
		ActionContext.getContext().put("org", organization);
		return "success";
	}
	/*
	 * 更新机构
	 */
	public String update() {
		System.out.println("OrganizationAction---update()");
		System.out.println("parentId=" + parentId);
		System.out.println("orgId=" + org.getId());
		
		Organization organization = organizationService.queryOrgById(org.getId());
		if(org.getName().equals("") && org.getDescription().equals("")) {
			result = "没有更新任何信息，无需更新。";
			
		}else {
			organization.setName(org.getName());
			organization.setDescription(org.getDescription());
			organizationService.updateOrg(organization);
		}
		
		List orgList = organizationService.queryOrgsById(parentId);
		ActionContext.getContext().put("orgList", orgList);
		result = "更新成功。";
		return "success";
	}
	/*
	 * 删除机构
	 */
	public String delete() {
		System.out.println("OrganizationAction---deleteOrg()");
		System.out.println("orgId=" + orgId + "parentId=" + parentId);
		
		organizationService.deleteOrgById(orgId);
		List orgList = organizationService.queryOrgsById(parentId);
		ActionContext.getContext().put("orgList", orgList);
		//重要点
		orgId = parentId;
		return "success";
	}



	public void setOrganizationService(OrganizationService organizationService) {
		this.organizationService = organizationService;
	}



	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public Organization getOrg() {
		return org;
	}
	public void setOrg(Organization org) {
		this.org = org;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getOrgId() {
		return orgId;
	}
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}


}
