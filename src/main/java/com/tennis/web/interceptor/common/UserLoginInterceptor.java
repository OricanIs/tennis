package com.tennis.web.interceptor.common;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.tennis.model.db.User;
import com.tennis.service.user.IUserService;

import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;


/**
 * All rights Reserved, Designed By  lixiao
 * Copyright (c) 2016 by Shanghai lixiao
 *
 * @PROJECT_NAME: viewlife
 * @author: lixiao
 * @version: V1.0
 * @Date: 2016/12/19
 * @Description:
 */
public class UserLoginInterceptor implements Interceptor
{
	private IUserService userService;


	/**
	 * Allows the Interceptor to do some processing on the request before and/or after the rest of the processing of the
	 * request by the {@link ActionInvocation} or to short-circuit the processing and just return a String return code.
	 *
	 * @param invocation the action invocation
	 * @return the return code, either returned from {@link ActionInvocation#invoke()}, or from the interceptor itself.
	 * @throws Exception any system-level error, as defined in {@link Action#execute()}.
	 */
	public String intercept(ActionInvocation invocation) throws Exception
	{
		String openid = "";
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		User loginUser = (User) request.getSession().getAttribute("user");
		//判断session里有没有用户的登录信息
		if (loginUser != null)
		{

			return invocation.invoke();
		}

		//获取token

		openid = request.getParameter("openid");


		//校验token的有效性
		if (openid == null)
		{
			return "userLogin";
		}
		openid = openid.trim();
		if (openid == "")
		{

			return "userLogin";
		}
		loginUser = userService.getUserByOpenid(openid);
		//session里面保存用户
		if (loginUser == null)
		{
			System.out.println(openid);
			throw new RuntimeException();
		}
		ActionContext.getContext().getSession().put("user", loginUser);
		return invocation.invoke();
	}


	/**
	 * Called to let an interceptor clean up any resources it has allocated.
	 */
	public void destroy()
	{

	}

	/**
	 * Called after an interceptor is created, but before any requests are processed using
	 * {@link #intercept(ActionInvocation) intercept} , giving
	 * the Interceptor a chance to initialize any needed resources.
	 */
	public void init()
	{

	}


	public void setUserService(IUserService userService)
	{
		this.userService = userService;
	}
}
