package com.tennis.model.db;

/**
 * All rights Reserved, Designed By  lixiao
 * Copyright (c) 2017 by Shanghai lixiao
 *
 * @PROJECT_NAME: tennis
 * @author: lixiao
 * @version: V1.0
 * @Date: 2017/5/12
 * @Description:
 */
public class UserRelation
{

	private int id;
	private int friendId;
	private int userId;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getFriendId()
	{
		return friendId;
	}

	public void setFriendId(int friendId)
	{
		this.friendId = friendId;
	}

	public int getUserId()
	{
		return userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	@Override
	public int hashCode()
	{
		int result = id;
		result = 31 * result + friendId;
		result = 31 * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		UserRelation that = (UserRelation) o;

		if (id != that.id)
			return false;
		if (friendId != that.friendId)
			return false;
		if (userId != that.userId)
			return false;

		return true;
	}
}
