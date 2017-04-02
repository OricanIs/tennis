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
public class MatchInfo
{
	private MatchUserInfo chMainUser;
	private MatchUserInfo chMinUser;
	private MatchUserInfo deMainUser;
	private MatchUserInfo deMinUser;
	private String province;
	private String city;
	private String addr;
	private String startTime;
	private String endTime;
	private int chScore;
	private int deScore;
	private int MatchType;
	private int playWay;
	private String camp;
	private int state;

	public MatchUserInfo getChMainUser()
	{
		return chMainUser;
	}

	public void setChMainUser(MatchUserInfo chMainUser)
	{
		this.chMainUser = chMainUser;
	}

	public MatchUserInfo getChMinUser()
	{
		return chMinUser;
	}

	public void setChMinUser(MatchUserInfo chMinUser)
	{
		this.chMinUser = chMinUser;
	}

	public MatchUserInfo getDeMainUser()
	{
		return deMainUser;
	}

	public void setDeMainUser(MatchUserInfo deMainUser)
	{
		this.deMainUser = deMainUser;
	}

	public MatchUserInfo getDeMinUser()
	{
		return deMinUser;
	}

	public void setDeMinUser(MatchUserInfo deMinUser)
	{
		this.deMinUser = deMinUser;
	}

	public String getProvince()
	{
		return province;
	}

	public void setProvince(String province)
	{
		this.province = province;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getAddr()
	{
		return addr;
	}

	public void setAddr(String addr)
	{
		this.addr = addr;
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

	public int getChScore()
	{
		return chScore;
	}

	public void setChScore(int chScore)
	{
		this.chScore = chScore;
	}

	public int getDeScore()
	{
		return deScore;
	}

	public void setDeScore(int deScore)
	{
		this.deScore = deScore;
	}

	public int getMatchType()
	{
		return MatchType;
	}

	public void setMatchType(int matchType)
	{
		MatchType = matchType;
	}

	public int getPlayWay()
	{
		return playWay;
	}

	public void setPlayWay(int playWay)
	{
		this.playWay = playWay;
	}

	public String getCamp()
	{
		return camp;
	}

	public void setCamp(String camp)
	{
		this.camp = camp;
	}

	public int getState()
	{
		return state;
	}

	public void setState(int state)
	{
		this.state = state;
	}
}
