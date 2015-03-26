package com.isunmoon.oa.test;

import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.isunmoon.oa.bean.Organization;
import com.isunmoon.oa.bean.Person;
import com.isunmoon.oa.service.OrganizationService;
import com.isunmoon.oa.service.PersonService;

public class InitData {
	
	private PersonService personService;
	private OrganizationService organizationService;

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	/*
	 * 添加组织
	 */
	@Test
	public void addOrgs() {
		String[] config = {"applicationContext-actions.xml", "applicationContext-commons.xml"};
		ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
		
		organizationService = (OrganizationService) ctx.getBean("organizationService");
		
		// 添加父机构
		Organization org;
		for(int i = 1; i <= 10; i++) {
			org = new Organization();
			org.setName("组织机构" + i);
			org.setDescription("这是组织机构" + i);
			org.setParent(null);
			organizationService.addOrg(org);
		}
		
		// 添加子机构
		Organization parentOrg;
		for(int i = 1; i <= 10; i++) {
			for(int j = 1; j < 10; j++) {
				org = new Organization();
				org.setName("组织机构" + i + j);
				org.setDescription("这是组织机构" + i + j);
				parentOrg = new Organization();
				parentOrg = organizationService.queryOrgById(i);
				org.setParent(parentOrg);
				organizationService.addOrg(org);
			}
		}
		
		System.out.println("Add organizations success.");
	}
	
	/*
	 * 添加100个人员
	 */
	@Test
	public void addPesrons() {
		String[] config = {"applicationContext-actions.xml", "applicationContext-commons.xml"};
		ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
		
		personService = (PersonService) ctx.getBean("personService");
		organizationService =  (OrganizationService) ctx.getBean("organizationService");
		
		// 添加人员
		Person person;
		Organization org = organizationService.queryOrgById(1);
		for(int i = 0; i < 100; i++) {
			person = new Person();
			person.setAddress("南岗区" + i + "号");
			person.setBirthday(new Date());
			person.setDuty("学生NO" + i);
			person.setName("无名" + i);
			person.setOrganization(org);
			person.setPhone("100 0000 " + i);
			if(i % 2 == 0) {
				person.setSex("女");
			}else {
				person.setSex("男");
			}
			personService.add(person);
		}
		
		System.out.println("Add person success.");
	}

}
