package com.tennis.service.match;

import com.tennis.model.common.PageResults;
import com.tennis.model.db.Match;
import com.tennis.model.db.MatchResult;
import com.tennis.model.response.match.PendingMatchModel;
import com.tennis.model.response.match.UserMatchStatistics;

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
public interface IMatchService
{
	/**
	 * 用户比赛统计
	 * @param userId
	 * @return
	 */
	public UserMatchStatistics userStatistics(int userId);

	/**
	 * 获取用户这周的比赛
	 * @param userId
	 * @return
	 */
	public List<Match> userWeekMatchs(int userId);

	/**
	 *
	 * @param challengerUser 挑战方
	 * @param defenderUser 防守方
	 * @return
	 */
	public boolean userIsGameThisWeek(int challengerUser,int defenderUser);

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
	 * @param matchId
	 */
	public Match get(int matchId);


	/**
	 * 获取待挑战的比赛记录
	 * @param userId
	 * @param playWay
	 * @return
	 */
	public List<PendingMatchModel> pendingMatchs(int userId, int playWay);


	/**
	 * 获取用户输入的比赛成绩
	 * @param matchId
	 * @param userId
	 * @return
	 */
	public MatchResult getMatchResultByUser(int matchId,int userId);

	/**
	 * 保存
	 * @param matchResult
	 */
	public void save(MatchResult matchResult);

	/**
	 * 更新
	 * @param matchResult
	 */
	public void update(MatchResult matchResult);

	/**
	 * 获取我的比赛
	 * @param userId
	 * @return
	 */
	public PageResults<Match> myMatchs(int userId,int state,int page,int pageSize);


}
