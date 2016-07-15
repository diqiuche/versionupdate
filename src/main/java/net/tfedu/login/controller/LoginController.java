package net.tfedu.login.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.tfedu.core.exception.NoAuthorizationException;
import net.tfedu.core.helper.ControllerHelper;
import net.tfedu.core.helper.ResultJSON;
import net.tfedu.login.entity.User;
import net.tfedu.login.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Resource LoginService loginService;
	

	/**
	 * 登录，查询用户信息
	 * @return
	 */
	@RequestMapping(value = "/v1.0/getUserInfo", method=RequestMethod.GET)
	@ResponseBody
	public ResultJSON login(HttpServletRequest request,HttpServletResponse response)throws Exception{
		String username = ControllerHelper.getParameter(request, "username");
		String userpwd = ControllerHelper.getParameter(request, "userpwd");
		//根据用户名、密码，查询用户信息
		User user = loginService.login(username, userpwd);
		if(user == null){
			throw new NoAuthorizationException();
		}
		return ResultJSON.getSuccess(user);
	}
}
