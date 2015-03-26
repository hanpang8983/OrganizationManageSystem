package com.isunmoon.oa.service;

import java.util.List;

import com.isunmoon.oa.bean.Role;

public interface RoleService {
	// 查询所有角色
	public List queryAllRoles();
	// 添加角色
	public void addRole(Role role);
	// 查询角色根据id
	public Role queryRoleById(int id);
	// 更新角色
	public void updateRole(Role role);
	// 根据id删除角色
	public void deleteRoleById(int id);
}
