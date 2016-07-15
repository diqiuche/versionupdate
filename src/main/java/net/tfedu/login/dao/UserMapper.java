package net.tfedu.login.dao;

import net.tfedu.login.entity.User;

import org.apache.ibatis.annotations.Param;

import net.tfedu.core.helper.CoreMapper;

public interface UserMapper extends CoreMapper<User> {
	
	/**
	 * 根据用户名和密码，查询用户信息
	 * @param username
	 * @param userpwd
	 * @return
	 */
	public User getUser(@Param("username")String username,@Param("userpwd")String userpwd);
}