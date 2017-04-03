package com.tennis.model.response.match;

/**
 * All rights Reserved, Designed By  lixiao
 * Copyright (c) 2017 by Shanghai lixiao
 *
 * @PROJECT_NAME: tennis
 * @author: lixiao
 * @version: V1.0
 * @Date: 2017/4/3
 * @Description:
 */
public class PendingMatchModel
{
	private int id;
	private MatchUserInfo mainUser;
	private MatchUserInfo minUser;
	private String startTime;
	private String endTime;
	private int playWay;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public MatchUserInfo getMainUser()
	{
		return mainUser;
	}

	public void setMainUser(MatchUserInfo mainUser)
	{
		this.mainUser = mainUser;
	}

	public MatchUserInfo getMinUser()
	{
		return minUser;
	}

	public void setMinUser(MatchUserInfo minUser)
	{
		this.minUser = minUser;
	}

	public String getStartTime()
	{
		return startTime;
	}

	public void setStartTime(String startTime)
	{
		this.startTime = startTime;
	}

	public String getEndTime()
	{
		return endTime;
	}

	public void setEndTime(String endTime)
	{
		this.endTime = endTime;
	}

	public int getPlayWay()
	{
		return playWay;
	}

	public void setPlayWay(int playWay)
	{
		this.playWay = playWay;
	}
}
