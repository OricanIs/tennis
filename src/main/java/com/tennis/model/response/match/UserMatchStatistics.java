package com.tennis.model.response.match;

/**
 * All rights Reserved, Designed By  lixiao
 * Copyright (c) 2017 by Shanghai lixiao
 *
 * @PROJECT_NAME: tennis
 * @author: lixiao
 * @version: V1.0
 * @Date: 2017/3/31
 * @Description:
 */
public class UserMatchStatistics
{
	private int singleGameCount;
	private int teamGameCount;
	private int singleWinCount;
	private int teamWinCount;


	public UserMatchStatistics()
	{
	}

	public UserMatchStatistics(int singleGameCount, int teamGameCount, int singleWinCount, int teamWinCount)
	{
		this.singleGameCount = singleGameCount;
		this.teamGameCount = teamGameCount;
		this.singleWinCount = singleWinCount;
		this.teamWinCount = teamWinCount;
	}

	public int getSingleGameCount()
	{
		return singleGameCount;
	}

	public void setSingleGameCount(int singleGameCount)
	{
		this.singleGameCount = singleGameCount;
	}

	public int getTeamGameCount()
	{
		return teamGameCount;
	}

	public void setTeamGameCount(int teamGameCount)
	{
		this.teamGameCount = teamGameCount;
	}

	public int getSingleWinCount()
	{
		return singleWinCount;
	}

	public void setSingleWinCount(int singleWinCount)
	{
		this.singleWinCount = singleWinCount;
	}

	public int getTeamWinCount()
	{
		return teamWinCount;
	}

	public void setTeamWinCount(int teamWinCount)
	{
		this.teamWinCount = teamWinCount;
	}
}
