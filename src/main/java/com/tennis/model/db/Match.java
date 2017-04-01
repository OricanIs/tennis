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
public class Match
{

	private int id;
	private Integer defenderMainUser;
	private Integer deferderMinUser;
	private Integer challengeMainUser;
	private Integer challengeMinUser;
	private Integer state;
	private Integer playWay;
	private Integer matchType;
	private String matchProvince;
	private String matchCity;
	private Integer startTime;
	private Integer endTime;
	private Integer defenderScore;
	private Integer challengeScore;
	private Integer createTime;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Integer getDefenderMainUser()
	{
		return defenderMainUser;
	}

	public void setDefenderMainUser(Integer defenderMainUser)
	{
		this.defenderMainUser = defenderMainUser;
	}

	public Integer getDeferderMinUser()
	{
		return deferderMinUser;
	}

	public void setDeferderMinUser(Integer deferderMinUser)
	{
		this.deferderMinUser = deferderMinUser;
	}

	public Integer getChallengeMainUser()
	{
		return challengeMainUser;
	}

	public void setChallengeMainUser(Integer challengeMainUser)
	{
		this.challengeMainUser = challengeMainUser;
	}

	public Integer getChallengeMinUser()
	{
		return challengeMinUser;
	}

	public void setChallengeMinUser(Integer challengeMinUser)
	{
		this.challengeMinUser = challengeMinUser;
	}

	public Integer getState()
	{
		return state;
	}

	public void setState(Integer state)
	{
		this.state = state;
	}

	public Integer getPlayWay()
	{
		return playWay;
	}

	public void setPlayWay(Integer playWay)
	{
		this.playWay = playWay;
	}

	public Integer getMatchType()
	{
		return matchType;
	}

	public void setMatchType(Integer matchType)
	{
		this.matchType = matchType;
	}

	public String getMatchProvince()
	{
		return matchProvince;
	}

	public void setMatchProvince(String matchProvince)
	{
		this.matchProvince = matchProvince;
	}

	public String getMatchCity()
	{
		return matchCity;
	}

	public void setMatchCity(String matchCity)
	{
		this.matchCity = matchCity;
	}

	public Integer getStartTime()
	{
		return startTime;
	}

	public void setStartTime(Integer startTime)
	{
		this.startTime = startTime;
	}

	public Integer getEndTime()
	{
		return endTime;
	}

	public void setEndTime(Integer endTime)
	{
		this.endTime = endTime;
	}

	public Integer getDefenderScore()
	{
		return defenderScore;
	}

	public void setDefenderScore(Integer defenderScore)
	{
		this.defenderScore = defenderScore;
	}

	public Integer getChallengeScore()
	{
		return challengeScore;
	}

	public void setChallengeScore(Integer challengeScore)
	{
		this.challengeScore = challengeScore;
	}

	public Integer getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(Integer createTime)
	{
		this.createTime = createTime;
	}

	@Override
	public int hashCode()
	{
		int result = id;
		result = 31 * result + (defenderMainUser != null ? defenderMainUser.hashCode() : 0);
		result = 31 * result + (deferderMinUser != null ? deferderMinUser.hashCode() : 0);
		result = 31 * result + (challengeMainUser != null ? challengeMainUser.hashCode() : 0);
		result = 31 * result + (challengeMinUser != null ? challengeMinUser.hashCode() : 0);
		result = 31 * result + (state != null ? state.hashCode() : 0);
		result = 31 * result + (playWay != null ? playWay.hashCode() : 0);
		result = 31 * result + (matchType != null ? matchType.hashCode() : 0);
		result = 31 * result + (matchProvince != null ? matchProvince.hashCode() : 0);
		result = 31 * result + (matchCity != null ? matchCity.hashCode() : 0);
		result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
		result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
		result = 31 * result + (defenderScore != null ? defenderScore.hashCode() : 0);
		result = 31 * result + (challengeScore != null ? challengeScore.hashCode() : 0);
		return result;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Match match = (Match) o;

		if (id != match.id)
			return false;
		if (defenderMainUser != null ? !defenderMainUser.equals(match.defenderMainUser) : match.defenderMainUser != null)
			return false;
		if (deferderMinUser != null ? !deferderMinUser.equals(match.deferderMinUser) : match.deferderMinUser != null)
			return false;
		if (challengeMainUser != null ? !challengeMainUser.equals(match.challengeMainUser) : match.challengeMainUser != null)
			return false;
		if (challengeMinUser != null ? !challengeMinUser.equals(match.challengeMinUser) : match.challengeMinUser != null)
			return false;
		if (state != null ? !state.equals(match.state) : match.state != null)
			return false;
		if (playWay != null ? !playWay.equals(match.playWay) : match.playWay != null)
			return false;
		if (matchType != null ? !matchType.equals(match.matchType) : match.matchType != null)
			return false;
		if (matchProvince != null ? !matchProvince.equals(match.matchProvince) : match.matchProvince != null)
			return false;
		if (matchCity != null ? !matchCity.equals(match.matchCity) : match.matchCity != null)
			return false;
		if (startTime != null ? !startTime.equals(match.startTime) : match.startTime != null)
			return false;
		if (endTime != null ? !endTime.equals(match.endTime) : match.endTime != null)
			return false;
		if (defenderScore != null ? !defenderScore.equals(match.defenderScore) : match.defenderScore != null)
			return false;
		if (challengeScore != null ? !challengeScore.equals(match.challengeScore) : match.challengeScore != null)
			return false;

		return true;
	}
}
