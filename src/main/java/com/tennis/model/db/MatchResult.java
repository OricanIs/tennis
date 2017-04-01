package com.tennis.model.db;

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
public class MatchResult
{

	private int id;
	private Integer matchId;
	private String challengeScore;
	private String defenderScore;
	private int userId;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Integer getMatchId()
	{
		return matchId;
	}

	public void setMatchId(Integer matchId)
	{
		this.matchId = matchId;
	}

	public String getChallengeScore()
	{
		return challengeScore;
	}

	public void setChallengeScore(String challengeScore)
	{
		this.challengeScore = challengeScore;
	}

	public String getDefenderScore()
	{
		return defenderScore;
	}

	public void setDefenderScore(String defenderScore)
	{
		this.defenderScore = defenderScore;
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
		result = 31 * result + (matchId != null ? matchId.hashCode() : 0);
		result = 31 * result + (challengeScore != null ? challengeScore.hashCode() : 0);
		result = 31 * result + (defenderScore != null ? defenderScore.hashCode() : 0);
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

		MatchResult that = (MatchResult) o;

		if (id != that.id)
			return false;
		if (userId != that.userId)
			return false;
		if (matchId != null ? !matchId.equals(that.matchId) : that.matchId != null)
			return false;
		if (challengeScore != null ? !challengeScore.equals(that.challengeScore) : that.challengeScore != null)
			return false;
		if (defenderScore != null ? !defenderScore.equals(that.defenderScore) : that.defenderScore != null)
			return false;

		return true;
	}
}
