package net.tfedu.login.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.tfedu.login.dao.UserMapper;
import net.tfedu.login.entity.User;
import net.tfedu.login.service.LoginService;

/**
 * 登录的service
 * @author WeiCuicui
 *
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService{

	@Resource UserMapper userMapper;
	
	/**
	 * 输入用户名、密码，登录系统
	 * @param username
	 * @param userpwd
	 */
	@Override
	public User login(String username,String userpwd){
		return userMapper.getUser(username, userpwd);
	}
}
