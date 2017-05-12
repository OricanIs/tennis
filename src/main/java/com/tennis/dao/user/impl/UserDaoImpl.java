package com.tennis.dao.user.impl;

import com.tennis.dao.common.impl.GenericDaoImpl;
import com.tennis.dao.user.IUserDao;
import com.tennis.model.db.User;
import com.tennis.model.db.UserRelation;

import java.util.List;

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
public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements IUserDao
{

	/**
	 * getUser 精准获取用户的id
	 *
	 * @param userId
	 * @return
	 */
	public User getUser(int userId)
	{
		return this.get(userId);
	}

	/**
	 * save 保存用户
	 *
	 * @param user
	 */
	public void saveUser(User user)
	{
		this.save(user);

	}

	/**
	 * update 更改用户
	 *
	 * @param user
	 */
	public void updateUser(User user)
	{
		this.update(user);
	}

	/**
	 * getUserByOpenid 根据openid获取用户的信息
	 *
	 * @param openid
	 * @return
	 */
	public User getUserByOpenid(String openid)
	{
		String sql  = "select * from `user` u where u.openid=?";
		User   user = this.getBySQL(sql, openid);
		return user;
	}

	/**
	 * 通过手机号查询用户
	 *
	 * @param mobile
	 * @return
	 */
	public User getUserByMobile(String mobile)
	{
		String     sql   = "select * from user u where u.mobile =?";
		List<User> bySQL = this.getListBySQL(sql, mobile);
		return bySQL.isEmpty() ? null : bySQL.get(0);
	}

	public void SaveUserRelation(UserRelation relation)
	{
		String     sql   = "select * from user where id in (select user_id from user_relation where user_id=? and friend_id=?)";
		List<User> bySQL = this.getListBySQL(sql, relation.getUserId(),relation.getFriendId());
		if (bySQL.size() <= 0){
			this.getSession().save(relation);
		}
	}

	public void delRelation(UserRelation relation)
	{
		String     sql   = "delete from user_relation where user_id=? and friend_id=?";
		this.querySql(sql,relation.getUserId(),relation.getFriendId());

	}

	public List<User> getFriends(int userId)
	{
		String sql = "select * from user u where u.id in (select friend_id from user_relation where user_id=? )";
		List<User> bySQL = this.getListBySQL(sql, userId);
		return bySQL;
	}
}
