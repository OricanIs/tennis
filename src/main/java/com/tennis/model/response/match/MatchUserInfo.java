package com.tennis.model.response.match;

/**
 * All rights Reserved, Designed By  lixiao
 * Copyright (c) 2017 by Shanghai lixiao
 *
 * @PROJECT_NAME: tennis
 * @author: lixiao
 * @version: V1.0
 * @Date: 2017/4/2
 * @Description:
 */
public class MatchUserInfo
{
	private int id;
	private String name;
	private String nationFlag;
	private int rank;
	private int integral;
	private float winRate;
	private String level;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getNationFlag()
	{
		return nationFlag;
	}

	public void setNationFlag(String nationFlag)
	{
		this.nationFlag = nationFlag;
	}

	public int getRank()
	{
		return rank;
	}

	public void setRank(int rank)
	{
		this.rank = rank;
	}

	public int getIntegral()
	{
		return integral;
	}

	public void setIntegral(int integral)
	{
		this.integral = integral;
	}

	public float getWinRate()
	{
		return winRate;
	}

	public void setWinRate(float winRate)
	{
		this.winRate = winRate;
	}

	public String getLevel()
	{
		return level;
	}

	public void setLevel(String level)
	{
		this.level = level;
	}
}
