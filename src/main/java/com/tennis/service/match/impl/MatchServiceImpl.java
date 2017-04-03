package com.tennis.service.match.impl;

import com.tennis.dao.match.IMatchDao;
import com.tennis.model.db.Match;
import com.tennis.model.response.match.PendingMatchModel;
import com.tennis.model.response.match.UserMatchStatistics;
import com.tennis.service.match.IMatchService;
import com.tennis.service.user.IUserService;
import com.tennis.util.common.DateUtil;

import java.util.ArrayList;
import java.util.Date;
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
public class MatchServiceImpl implements IMatchService
{

	private IMatchDao    matchDao;
	private IUserService userService;

	public void setMatchDao(IMatchDao matchDao)
	{
		this.matchDao = matchDao;
	}

	public void setUserService(IUserService userService)
	{
		this.userService = userService;
	}

	/**
	 * 用户比赛统计
	 *
	 * @param userId
	 * @return
	 */
	public UserMatchStatistics userStatistics(int userId)
	{
		//获取用户所有的比赛记录
		List<Match> matches = matchDao.getEffectiveMatchs(userId, 0, 0);

		return structStatistics(matches, userId);
	}

	/**
	 * 获取用户这周的比赛
	 *
	 * @param userId
	 * @return
	 */
	public List<Match> userWeekMatchs(int userId)
	{
		//构建时间戳
		Date today  = new Date();
		int  monday = DateUtil.DateToTimestamp(DateUtil.getMondayOfThisWeek(today));
		int  sunday = DateUtil.DateToTimestamp(DateUtil.getSundayOfThisWeek(today));

		List<Match> effectiveMatchs = matchDao.getEffectiveMatchs(userId, monday, sunday);
		return effectiveMatchs;
	}

	/**
	 * @param challengerUser 挑战方
	 * @param defenderUser   防守方
	 * @return
	 */
	public boolean userIsGameThisWeek(int challengerUser, int defenderUser)
	{
		return false;
	}


	//private functions
	private UserMatchStatistics structStatistics(List<Match> matches, int userId)
	{

		if (matches == null || matches.size() <= 0)
		{

			return new UserMatchStatistics(0, 0, 0, 0);
		}

		int singleGameCount = 0;
		int teamGameCount   = 0;
		int singleWinCount  = 0;
		int teamWinCount    = 0;

		for (int i = 0; i < matches.size(); i++)
		{
			Match match = matches.get(i);
			//首先确定攻守方
			if (match.getChallengeMainUser().equals(userId) || match.getChallengeMinUser().equals(userId))
			{

				//确定是否单人模式
				if (match.getChallengeMainUser() != null && match.getChallengeMinUser() != null)
				{
					teamGameCount++;
					//确定输赢
					if (match.getChallengeScore() > match.getDefenderScore())
						teamWinCount++;
				}
				else
				{
					singleGameCount++;

					if (match.getChallengeScore() > match.getDefenderScore())
						singleGameCount++;

				}

			}
			else
			{
				//确定是否单人模式
				if (match.getChallengeMainUser() != null && match.getChallengeMinUser() != null)
				{
					teamGameCount++;

					//确定输赢
					if (match.getChallengeScore() < match.getDefenderScore())
						teamWinCount++;

				}
				else
				{
					singleGameCount++;
					//确定输赢
					if (match.getChallengeScore() < match.getDefenderScore())
						singleGameCount++;

				}
			}
		}

		return new UserMatchStatistics(singleGameCount, teamGameCount, singleWinCount, teamWinCount);

	}

	/**
	 * 更新
	 *
	 * @param match
	 */
	public void update(Match match)
	{
		matchDao.update(match);
	}

	/**
	 * 保存
	 *
	 * @param match
	 */
	public void saveMatch(Match match)
	{
		matchDao.saveMatch(match);

	}

	/**
	 * 获取
	 *
	 * @param matchId
	 */
	public Match get(int matchId)
	{
		return matchDao.getMatch(matchId);

	}

	/**
	 * 获取待挑战的比赛记录
	 *
	 * @param userId
	 * @param playWay
	 * @return
	 */
	public List<PendingMatchModel> pendingMatchs(int userId, int playWay)
	{
		List<Match>             matches = matchDao.pendingMatchs(userId, playWay);
		List<PendingMatchModel> models  = new ArrayList<PendingMatchModel>();
		for (int i = 0; i < matches.size(); i++)
		{
			PendingMatchModel model = new PendingMatchModel();
			Match             match = matches.get(i);
			model.setId(match.getId());
			model.setPlayWay(playWay);
			if (playWay == 0)
			{
				model.setMainUser(userService.getMatchUserInfo(match.getChallengeMainUser()));
			}
			else
			{
				model.setMainUser(userService.getMatchUserInfo(match.getChallengeMainUser()));
				model.setMinUser(userService.getMatchUserInfo(match.getChallengeMinUser()));
			}
			Date startDate = DateUtil.TimestampToDate(match.getCreateTime());
			Date endDate   = DateUtil.TimestampToDate(match.getEndTime());
			model.setStartTime(DateUtil.getStringDate(startDate, DateUtil.DATE_YY_MM_DD_HH_MM));
			model.setEndTime(DateUtil.getStringDate(endDate, DateUtil.DATE_YY_MM_DD_HH_MM));

			models.add(model);
		}

		return models;
	}
}
