package com.tennis.service.user;

import com.tennis.model.db.User;
import com.tennis.model.response.match.MatchUserInfo;
import com.tennis.model.response.user.UserInfoModel;

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
public interface IUserService
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

	/**
	 * 获取用户的详情
	 * @param userId
	 * @return
	 */
	public UserInfoModel getUserInfo(int userId);

	/**
	 * 用户是否能挑战
	 * @param userId
	 * @return
	 */
	public boolean canChanllage(int userId);

	/**
	 * 查看两个用户能不能比赛
	 * @param user1
	 * @param user2
	 * @return
	 */
	public boolean canMatch(int user1, int user2);

	/**
	 * 通过手机号查询用户
	 * @param mobile
	 * @return
	 */
	public User getUserByMobile(String mobile);

	/**
	 * 获取用户的userinfo
	 * @param userId
	 * @return
	 */
	public MatchUserInfo getMatchUserInfo(int userId);
}
