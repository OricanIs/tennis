package com.tennis.service.test;

import com.tennis.model.db.User;

/**
 * All rights Reserved, Designed By  lixiao
 * Copyright (c) 2017 by Shanghai lixiao
 *
 * @PROJECT_NAME: quchiba
 * @author: lixiao
 * @version: V1.0
 * @Date: 2017/1/11
 * @Description:
 */
public interface ITestService
{

	/**
	 * 根据用户id获取用户
	 * @param nUserId
	 * @return
	 */
	public User getUserById(int nUserId);

	/**
	 * 保存用户
	 * @param user
	 */
	public void updateUser(User user);

}
