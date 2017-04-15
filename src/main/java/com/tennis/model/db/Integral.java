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
public class Integral
{

	private int id;
	private Integer userId;
	private Integer score;
	private Integer matchId;
	private Integer createTime;
	private String intro;
	private Integer TotalIntegral;		//用户当前总积分
	private Integer matchType;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Integer getUserId()
	{
		return userId;
	}

	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}

	public Integer getScore()
	{
		return score;
	}

	public void setScore(Integer score)
	{
		this.score = score;
	}

	public Integer getMatchId()
	{
		return matchId;
	}

	public void setMatchId(Integer matchId)
	{
		this.matchId = matchId;
	}

	public Integer getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(Integer createTime)
	{
		this.createTime = createTime;
	}

	public String getIntro()
	{
		return intro;
	}

	public void setIntro(String intro)
	{
		this.intro = intro;
	}

	public Integer getTotalIntegral()
	{
		return TotalIntegral;
	}

	public void setTotalIntegral(Integer totalIntegral)
	{
		TotalIntegral = totalIntegral;
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
		result = 31 * result + (userId != null ? userId.hashCode() : 0);
		result = 31 * result + (score != null ? score.hashCode() : 0);
		result = 31 * result + (matchId != null ? matchId.hashCode() : 0);
		result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
		return result;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Integral integral = (Integral) o;

		if (id != integral.id)
			return false;
		if (userId != null ? !userId.equals(integral.userId) : integral.userId != null)
			return false;
		if (score != null ? !score.equals(integral.score) : integral.score != null)
			return false;
		if (matchId != null ? !matchId.equals(integral.matchId) : integral.matchId != null)
			return false;
		if (createTime != null ? !createTime.equals(integral.createTime) : integral.createTime != null)
			return false;

		return true;
	}
}
