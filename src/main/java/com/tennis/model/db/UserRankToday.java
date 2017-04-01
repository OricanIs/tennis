package com.tennis.model.db;

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
public class UserRankToday
{

	private int id;
	private Integer position;
	private Integer userId;
	private Integer date;
	private Integer matchType;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Integer getPosition()
	{
		return position;
	}

	public void setPosition(Integer position)
	{
		this.position = position;
	}

	public Integer getUserId()
	{
		return userId;
	}

	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}

	public Integer getDate()
	{
		return date;
	}

	public void setDate(Integer date)
	{
		this.date = date;
	}

	public Integer getMatchType()
	{
		return matchType;
	}

	public void setMatchType(Integer matchType)
	{
		this.matchType = matchType;
	}

	@Override
	public int hashCode()
	{
		int result = id;
		result = 31 * result + (position != null ? position.hashCode() : 0);
		result = 31 * result + (userId != null ? userId.hashCode() : 0);
		result = 31 * result + (date != null ? date.hashCode() : 0);
		return result;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		UserRankToday that = (UserRankToday) o;

		if (id != that.id)
			return false;
		if (position != null ? !position.equals(that.position) : that.position != null)
			return false;
		if (userId != null ? !userId.equals(that.userId) : that.userId != null)
			return false;
		if (date != null ? !date.equals(that.date) : that.date != null)
			return false;

		return true;
	}
}
