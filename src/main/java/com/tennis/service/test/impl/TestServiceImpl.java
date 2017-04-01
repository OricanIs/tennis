package com.tennis.service.test.impl;

import com.tennis.dao.test.ITestDao;
import com.tennis.model.db.User;
import com.tennis.service.test.ITestService;

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

public class TestServiceImpl implements ITestService
{
	private ITestDao testDao;

	public void setTestDao(ITestDao testDao)
	{
		this.testDao = testDao;
	}

	/**
	 * 根据用户id获取用户
	 *
	 * @param nUserId
	 * @return
	 */
	public User getUserById(int nUserId)
	{
		return testDao.getUserById(nUserId);
	}


	/**
	 * 保存用户
	 *
	 * @param user
	 */
	public void updateUser(User user)
	{
		testDao.updateUser(user);
	}
}
