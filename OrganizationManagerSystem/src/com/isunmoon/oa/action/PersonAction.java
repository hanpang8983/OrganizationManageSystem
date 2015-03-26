package com.isunmoon.oa.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.isunmoon.oa.bean.Organization;
import com.isunmoon.oa.bean.Person;
import com.isunmoon.oa.service.OrganizationService;
import com.isunmoon.oa.service.PersonService;
import com.isunmoon.oa.web.PageModel;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PersonAction extends ActionSupport {
	
	private OrganizationService organizationService;
	private PersonService personService;
	
	private Person person;
	private Organization org;
	
	private int orgId;
	
	private int offset;
	
	/*
	 * 跳转到人员管理首页
	 */
	public String toIndex() {
		PageModel pm = personService.serchPerson();
		ActionContext.getContext().put("pm", pm);
		return "success";
	}
	/*
	 * 选择机构页面
	 */
	public String selectOrg() {
		List orgList = organizationService.queryOrgsById(orgId);
		ActionContext.getContext().put("orgList", orgList);
		return "success";
	}
	/*
	 * 添加人员
	 */
	public String add() {
		String sex = ServletActionContext.getRequest().getParameter("sex");
		String birthday = ServletActionContext.getRequest().getParameter("birthday");
		String orgId = ServletActionContext.getRequest().getParameter("orgId");
		
		org = new Organization();
		org = organizationService.queryOrgById(Integer.parseInt(orgId));
		
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			person.setBirthday(date);
			person.setSex(sex);
			person.setOrganization(org);
			
			personService.add(person);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List personList = personService.queryPersons();
		ActionContext.getContext().put("personList", personList);
		return "success";
	}
	/*
	 *  跳转到更新页面
	 */
	public String toUpdate() {
		
		int id = person.getId();
		System.out.println("toUpdate---id=" + id);
		person = personService.queryPersonById(id);
		
		ActionContext.getContext().put("person", person);
		return "success";
	}
	
	/*
	 * 更新人员信息
	 */
	public String update() {
		String birthday = ServletActionContext.getRequest().getParameter("birthday");
		String orgId = ServletActionContext.getRequest().getParameter("orgId");

		try {
			Person updatePerson = personService.queryPersonById(person.getId());
			updatePerson.setName(person.getName());
			updatePerson.setSex(person.getSex());
			updatePerson.setDuty(person.getDuty());
			
			System.out.println("-------" + birthday);
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			
			updatePerson.setBirthday(date);
			updatePerson.setAddress(person.getAddress());
			updatePerson.setPhone(person.getPhone());
			
			Organization organization = organizationService.queryOrgById(Integer.parseInt(orgId));
			updatePerson.setOrganization(organization);
			
			personService.updatePerson(updatePerson);
			
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.toIndex();
		return "success";
	}
	/*
	 * 删除人员
	 */
	public String delete() {
		personService.deletePersonById(person.getId());
		
		PageModel pm = personService.serchPerson();
		ActionContext.getContext().put("pm", pm);
		return "success";
	}
	
	
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Organization getOrg() {
		return org;
	}
	public void setOrg(Organization org) {
		this.org = org;
	}
	public void setOrganizationService(OrganizationService organizationService) {
		this.organizationService = organizationService;
	}
	public int getOrgId() {
		return orgId;
	}
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}


}
