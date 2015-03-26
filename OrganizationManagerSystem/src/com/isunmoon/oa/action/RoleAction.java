package com.isunmoon.oa.action;

import java.util.List;

import com.isunmoon.oa.bean.Role;
import com.isunmoon.oa.service.RoleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RoleAction extends ActionSupport {
	private RoleService roleService;
	
	private Role role;
	/*
	 * 跳转到角色首页
	 */
	public String toIndex() {
		List roleList = roleService.queryAllRoles();
		ActionContext.getContext().put("roleList", roleList);
		return "success";
	}
	
	/*
	 * 跳转到添加角色页面
	 */
	public String toAddRole() {
		return "success";
	}
	
	/*
	 * 添加角色
	 */
	public String addRole() {
		roleService.addRole(role);
		return "success";
	}
	
	/*
	 * 跳转到更新角色页面
	 */
	public String toUpdateRole() {
		Role tempRole = roleService.queryRoleById(role.getId());
		ActionContext.getContext().put("role", tempRole);
		return "success";
	}
	
	/*
	 * 更新角色
	 */
	public String updateRole() {
		roleService.updateRole(role);
		return "success";
	}
	
	/*
	 * 删除角色
	 */
	public String deleteRole() {
		roleService.deleteRoleById(role.getId());
		return "success";
	}
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
