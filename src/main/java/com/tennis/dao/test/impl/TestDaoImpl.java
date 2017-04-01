package com.tennis.dao.test.impl;

import com.tennis.dao.common.impl.GenericDaoImpl;
import com.tennis.dao.test.ITestDao;
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
public class TestDaoImpl extends GenericDaoImpl<User,Integer> implements ITestDao
{

	/**
	 * 根据用户id获取用户
	 *
	 * @param nUserId
	 * @return
	 */
	public User getUserById(int nUserId)
	{
		User user = this.get(nUserId);

		return user;
	}

	/**
	 * 保存用户
	 * @param user
	 */
	public void updateUser(User user)
	{
		this.update(user);

	}
}
