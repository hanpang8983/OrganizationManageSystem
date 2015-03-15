package com.isunmoon.oa.action;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	

	/*
	 * 用户登陆到用户首页
	 */
	public String toIndex() {
		
		
		return "success";
	}
	
}
