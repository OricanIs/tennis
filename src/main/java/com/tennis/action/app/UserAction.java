package com.tennis.action.app;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tennis.em.EM_GLOBAL_RESULT;
import com.tennis.model.db.User;
import com.tennis.model.response.user.UserInfoModel;
import com.tennis.service.user.IUserService;
import com.tennis.util.common.CommonUtil;

import org.apache.struts2.ServletActionContext;

import static com.tennis.util.common.HttpPrintWriter.responseWrite;

/**
 * All rights Reserved, Designed By  lixiao
 * Copyright (c) 2017 by Shanghai lixiao
 *
 * @PROJECT_NAME: tennis
 * @author: lixiao
 * @version: V1.0
 * @Date: 2017/3/29
 * @Description:
 */
public class UserAction extends ActionSupport implements ModelDriven<User>
{
	//设置model
	private User             user      = new User();
	private EM_GLOBAL_RESULT SuccessEM = EM_GLOBAL_RESULT.getEmByCode(0);

	public User getModel()
	{
		return user;
	}

	private IUserService userService;

	public void setUserService(IUserService userService)
	{
		this.userService = userService;
	}


	public String login()
	{
		//检查openid是否符合标准
		if (user.getOpenid() == null)
		{

			responseWrite(ServletActionContext.getResponse(), EM_GLOBAL_RESULT.getEmByName("ERR_PARAM"), null);
			return ERROR;
		}

		User findUser = userService.getUserByOpenid(user.getOpenid());

		//检查是否存在
		if (findUser == null)
		{

			responseWrite(ServletActionContext.getResponse(), EM_GLOBAL_RESULT.getEmByName("ERR_PARAM"), null);
			return ERROR;
		}

		ServletActionContext.getRequest().getSession().setAttribute("user", findUser);
		responseWrite(ServletActionContext.getResponse(), SuccessEM, null);
		return SUCCESS;
	}


	/**
	 * getUserInfo 获取用户详情
	 *
	 * @return
	 */
	public String myInfo()
	{
		//从session里面拿值
		User sessionUser = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
//		sessionUser.setId(1);
		UserInfoModel userInfo = userService.getUserInfo(1);
		if (userInfo == null)
		{
			responseWrite(ServletActionContext.getResponse(), EM_GLOBAL_RESULT.getEmByCode(10002), null);
		}
		responseWrite(ServletActionContext.getResponse(), SuccessEM, userInfo);
		return SUCCESS;
	}

	/**
	 * saveUserInfo 保存用户详情
	 *
	 * @return
	 */
	public String saveUserInfo()
	{
		userService.saveUser(user);
		responseWrite(ServletActionContext.getResponse(), SuccessEM, null);
		return SUCCESS;
	}

	/**
	 * updateUserInfo 更改用户信息
	 *
	 * @return
	 */
	public String updateUserInfo()
	{
		User findUser = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		findUser = userService.getUser(1);
		if (user.getAge() != null)
			findUser.setAge(user.getAge());

		if (user.getAvatar() != null)
			findUser.setAvatar(user.getAvatar());

		if (user.getCity() != null)
			findUser.setCity(user.getCity());

		if (user.getForehand() != null)
			findUser.setForehand(user.getForehand());

		if (user.getHeight() != null)
			findUser.setHeight(user.getHeight());

		if (user.getMobile() != null)
			findUser.setMobile(user.getMobile());

		if (user.getName() != null)
			findUser.setName(user.getName());

		if (user.getProvince() != null)
			findUser.setProvince(user.getProvince());

		if (user.getSex() != null)
			findUser.setSex(user.getSex());

		if (user.getWeight() != null)
			findUser.setWeight(user.getWeight());

		if (user.getNation() != null)
			findUser.setNation(user.getNation());

		if (user.getNationFlag() != null)
			findUser.setNationFlag(user.getNationFlag());

		if (user.getBackhand() != null)
			findUser.setBackhand(user.getBackhand());

		//保存
		userService.updateUser(findUser);

		responseWrite(ServletActionContext.getResponse(), SuccessEM, null);

		return SUCCESS;
	}

	/**
	 * otherUserinfo 获取他人用户信息
	 *
	 * @return
	 */
	public String otherUserinfo()
	{
		System.out.println(user.getId());
		UserInfoModel userInfo = userService.getUserInfo(user.getId());
		if (userInfo == null)
		{
			responseWrite(ServletActionContext.getResponse(), EM_GLOBAL_RESULT.getEmByCode(10002), null);
			return SUCCESS;
		}
		userInfo.setMobile(CommonUtil.telHandle(userInfo.getMobile()));
		responseWrite(ServletActionContext.getResponse(), SuccessEM, userInfo);
		return SUCCESS;
	}

}
