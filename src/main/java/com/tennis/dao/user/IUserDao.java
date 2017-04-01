package com.tennis.dao.user;

import com.tennis.model.db.User;

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
public interface IUserDao
{

	/**
	 * getUser 精准获取用户的id
	 * @param userId
	 * @return
	 */
	public User getUser(int userId);

	/**
	 * save 保存用户
	 * @param user
	 */
	public void saveUser(User user);

	/**
	 * update 更改用户
	 * @param user
	 */
	public void updateUser(User user);

	/**
	 * getUserByOpenid 根据openid获取用户的信息
	 * @param openid
	 * @return
	 */
	public User getUserByOpenid(String openid);

}
