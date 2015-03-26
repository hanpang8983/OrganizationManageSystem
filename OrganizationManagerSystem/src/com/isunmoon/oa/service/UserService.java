package com.isunmoon.oa.service;

import com.isunmoon.oa.bean.User;

public interface UserService {
	// 给人员添加账号
	public void addAccountToPerson(User user);
	// 删除人员的账号根据id
	public void deleteAccountById(int id);
	// 查询用户根据id
	public User queryUserById(int id);
	// 更新账号
	public void updateUser(User user);
}
