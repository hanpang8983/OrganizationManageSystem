package com.isunmoon.oa.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.isunmoon.oa.bean.Person;
import com.isunmoon.oa.bean.User;
import com.isunmoon.oa.service.PersonService;
import com.isunmoon.oa.service.UserService;
import com.isunmoon.oa.web.PageModel;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	
	private PersonService personService;
	private UserService userService;
	
	private Person person;
	private User user;
	/*
	 * 跳转到用户页面
	 */
	public String toIndex() {
		PageModel pm = personService.serchPerson();
		ActionContext.getContext().put("pm", pm);
		return "success";
	}
	/*
	 * 用户登录到后台主页
	 */
	public String login() {
		return "success";
	}
	/*
	 * 跳转到分配账号页面
	 */
	public String toDistributeAccount() {
		System.out.println("person.id=" + person.getId());
		return "success";
	}
	/*
	 * 分配账号
	 */
	public String distributeAccount() {
		System.out.println("pserosn.getId()=" + person.getId());
		try {
			String date = ServletActionContext.getRequest().getParameter("expireTime");
			System.out.println("---expireTime=" + date);
			Date expireTime = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			
			User tempUser = new User();
			tempUser.setName(user.getName());
			tempUser.setPassword(user.getPassword());
			tempUser.setExpireTime(expireTime);
			person = personService.queryPersonById(person.getId()); 
			tempUser.setPerson(person);
			
			userService.addAccountToPerson(tempUser);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return "success";
	}
	/*
	 * 删除账号
	 */
	public String deleteAccount() {
		System.out.println("---user.id=" + user.getId());
		userService.deleteAccountById(user.getId());
		return "success";
	}
	/*
	 * 跳转到修改账号页面
	 */
	public String toUpdateAccount() {
		User tempUser = userService.queryUserById(user.getId());
		List userList = new ArrayList();
		userList.add(tempUser);
		ActionContext.getContext().put("userList", userList);		
		return "success";
	}
	
	/*
	 * 更新账号
	 */
	public String updateAccount() {
		
		try {
			String date = ServletActionContext.getRequest().getParameter("expireTime");
			Date expireTime = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			
			User tempUser = userService.queryUserById(user.getId());
			tempUser.setName(user.getName());
			tempUser.setExpireTime(expireTime);
			tempUser.setPassword(user.getPassword());
			
			userService.updateUser(tempUser);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
