package com.tennis.model.response.user;

/**
 * All rights Reserved, Designed By  lixiao
 * Copyright (c) 2017 by Shanghai lixiao
 *
 * @PROJECT_NAME: tennis
 * @author: lixiao
 * @version: V1.0
 * @Date: 2017/3/30
 * @Description:
 */
public class RspUserModel
{
	private int    id;
	private String avatar;
	private String name;
	private String sex;
	private String nation;
	private String nationFlag;
	private String playWay;
	private String forehand;
	private String backhand;
	private String mathType;
	private int    gamesCount;
	private float  winningRate;
	private int    integral;
	private int    rank;
	private boolean    canChanllage;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getAvatar()
	{
		return avatar;
	}

	public void setAvatar(String avatar)
	{
		this.avatar = avatar;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSex()
	{
		return sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public String getNation()
	{
		return nation;
	}

	public void setNation(String nation)
	{
		this.nation = nation;
	}

	public String getNationFlag()
	{
		return nationFlag;
	}

	public void setNationFlag(String nationFlag)
	{
		this.nationFlag = nationFlag;
	}

	public String getPlayWay()
	{
		return playWay;
	}

	public void setPlayWay(String playWay)
	{
		this.playWay = playWay;
	}

	public String getForehand()
	{
		return forehand;
	}

	public void setForehand(String forehand)
	{
		this.forehand = forehand;
	}

	public String getBackhand()
	{
		return backhand;
	}

	public void setBackhand(String backhand)
	{
		this.backhand = backhand;
	}

	public String getMathType()
	{
		return mathType;
	}

	public void setMathType(String mathType)
	{
		this.mathType = mathType;
	}

	public int getGamesCount()
	{
		return gamesCount;
	}

	public void setGamesCount(int gamesCount)
	{
		this.gamesCount = gamesCount;
	}

	public float getWinningRate()
	{
		return winningRate;
	}

	public void setWinningRate(float winningRate)
	{
		this.winningRate = winningRate;
	}

	public int getIntegral()
	{
		return integral;
	}

	public void setIntegral(int integral)
	{
		this.integral = integral;
	}

	public int getRank()
	{
		return rank;
	}

	public void setRank(int rank)
	{
		this.rank = rank;
	}

	public boolean isCanChanllage()
	{
		return canChanllage;
	}

	public void setCanChanllage(boolean canChanllage)
	{
		this.canChanllage = canChanllage;
	}
}
