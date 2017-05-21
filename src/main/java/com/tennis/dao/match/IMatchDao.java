package com.tennis.dao.match;

import com.tennis.model.common.PageResults;
import com.tennis.model.db.Match;
import com.tennis.model.db.MatchResult;

import java.util.List;

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
public interface IMatchDao
{
	/**
	 * 根据时间获取用户的比赛记录
	 * @param userId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public PageResults<Match> getMatchs(int userId, int state, int startDate, int endDate,int page,int
			pageSize);


	/**
	 * 获取用户已经参与的场次
	 * @param userId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<Match> getEffectiveMatchs(int userId,int startDate,int endDate);


	/**
	 * 更新
	 * @param match
	 */
	public void update(Match match);

	/**
	 * 保存
	 * @param match
	 */
	public void saveMatch(Match match);

	/**
	 * 获取
	 *
	 * @param matchId
	 */
	public Match getMatch(int matchId);


	/**
	 * 获取待挑战的比赛记录
	 *
	 * @param userId
	 * @param playWay
	 * @return
	 */
	public List<Match> pendingMatchs(int userId, int playWay);



	/**
	 * 获取用户输入的比赛成绩
	 * @param matchId
	 * @param userId
	 * @return
	 */
	public MatchResult getMatchResultByUser(int matchId, int userId);

	/**
	 * 保存
	 * @param matchResult
	 */
	public void saveMatchResult(MatchResult matchResult);

	/**
	 * 更新
	 * @param matchResult
	 */
	public void updateMatchResult(MatchResult matchResult);



	/**
	 * 获取我的比赛
	 * @param userId
	 * @return
	 */
	public PageResults<Match> myMatchs(int userId,int state,int startTime,int endTime,Integer
			matchType,int page,
									   int pageSize);

	/**
	 * 获取擂台赛列表
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public PageResults<Match> avenaMatchs(int page,int pageSize);


	/**
	 * 获取过期的用户没有同意的比赛
	 *
	 * @return
	 */
	public List<Match> getOverDateMatch();

	/**
	 * 获取已经完成，但是比赛状态没更改的
	 * @return
	 */
	public List<Match> getCompletedAndNoConfirmMatch();

}
