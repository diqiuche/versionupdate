package net.tfedu.login.service;

import net.tfedu.login.entity.User;

public interface LoginService {

	/**
	 * 输入用户名、密码，登录系统
	 * @param username
	 * @param userpwd
	 * @return
	 */
	public User login(String username,String userpwd);
}
