package com.tennis.service.match.impl;

import com.tennis.dao.match.IMatchDao;
import com.tennis.model.common.PageResults;
import com.tennis.model.db.Integral;
import com.tennis.model.db.Match;
import com.tennis.model.db.MatchResult;
import com.tennis.model.db.User;
import com.tennis.model.response.match.PendingMatchModel;
import com.tennis.model.response.match.UserMatchStatistics;
import com.tennis.service.integral.IIntegralService;
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

	private IMatchDao        matchDao;
	private IUserService     userService;
	private IIntegralService integralService;
	private final int winIntegral  = 15;
	private final int loseIntegral = 10;

	public void setMatchDao(IMatchDao matchDao)
	{
		this.matchDao = matchDao;
	}

	public void setUserService(IUserService userService)
	{
		this.userService = userService;
	}

	public void setIntegralService(IIntegralService integralService)
	{
		this.integralService = integralService;
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
			System.out.println("=============+=============");
			System.out.println(match.toString());
			System.out.println("=============+=============");
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


	/**
	 * 获取用户输入的比赛成绩
	 *
	 * @param matchId
	 * @param userId
	 * @return
	 */
	public MatchResult getMatchResultByUser(int matchId, int userId)
	{
		return matchDao.getMatchResultByUser(matchId, userId);
	}

	/**
	 * 保存
	 *
	 * @param matchResult
	 */
	public void save(MatchResult matchResult)
	{
		matchDao.saveMatchResult(matchResult);
	}

	/**
	 * 更新
	 *
	 * @param matchResult
	 */
	public void update(MatchResult matchResult)
	{
		matchDao.updateMatchResult(matchResult);
	}

	/**
	 * 获取我的比赛
	 *
	 * @param userId
	 * @return
	 */
	public PageResults<Match> myMatchs(int userId, int state, int startTime, int
			endTime,Integer matchType, int page, int pageSize)
	{
		return matchDao.myMatchs(userId, state, startTime, endTime,matchType, page, pageSize);
	}

	/**
	 * 获取擂台赛列表
	 *
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public PageResults<Match> avenaMatchs(int page, int pageSize)
	{
		return matchDao.avenaMatchs(page, pageSize);
	}

	/**
	 * 更改积分
	 *
	 * @param match
	 */
	public void updateMatchIntegral(Match match)
	{
		match = matchDao.getMatch(match.getId());
		User chMainUser = userService.getUser(match.getChallengeMainUser());
		User deMainUser = userService.getUser(match.getDefenderMainUser());
		User chMinUser  = match.getChallengeMinUser().equals(0) ? null : userService.getUser(match.getChallengeMinUser());
		User deMinUser  = match.getDefenderMinUser().equals(0) ? null : userService.getUser(match.getDefenderMinUser());
		System.out.println(match.toString());
		//更新比赛积分,首先判断比赛的状态
		if (match.getMatchType().equals(0))
		{

				if (match.getChallengeScore() > match.getDefenderScore())
				{
					if (match.getPlayWay().equals(0))
					{
						saveIntegral(chMainUser, match, winIntegral);
						saveIntegral(deMainUser, match, -loseIntegral);
					}
					else
					{

						int temp = (chMainUser.getLevel() + chMinUser.getLevel()) - (deMainUser
								.getLevel() + deMinUser.getLevel());
						saveIntegral(chMainUser, match, winIntegral+temp);
						saveIntegral(deMainUser, match, -loseIntegral + temp);
						saveIntegral(chMinUser, match, winIntegral+temp);
						saveIntegral(deMinUser, match, -loseIntegral + temp);
					}


				}
				else
				{

					if (match.getPlayWay().equals(0))
					{
						saveIntegral(chMainUser, match,  -loseIntegral);
						saveIntegral(deMainUser, match, winIntegral);
					}
					else
					{

						int temp = (deMainUser
								.getLevel() + deMinUser.getLevel()) - (chMainUser.getLevel() + chMinUser.getLevel());
						saveIntegral(chMainUser, match, -loseIntegral +temp);
						saveIntegral(deMainUser, match, winIntegral+ temp);
						saveIntegral(chMinUser, match, -loseIntegral+temp);
						saveIntegral(deMinUser, match, winIntegral+ temp);
					}

				}


		}
		else
		{
			if (match.getChallengeScore() > match.getDefenderScore())
			{
				saveIntegral(chMainUser, match, match.getIntegral());
				saveIntegral(deMainUser, match, -match.getIntegral());
				if (chMinUser != null)
				{
					saveIntegral(deMinUser, match, match.getIntegral());
				}
				if (deMinUser != null)
				{
					saveIntegral(deMinUser, match, -match.getIntegral());
				}

			}
			else
			{
				saveIntegral(chMainUser, match, -match.getIntegral());
				saveIntegral(deMainUser, match, match.getIntegral());
				if (chMinUser != null)
				{
					saveIntegral(deMinUser, match, -match.getIntegral());
				}
				if (deMinUser != null)
				{
					saveIntegral(deMinUser, match, +match.getIntegral());
				}
			}

		}

		//更新比赛类型，更改积分
	}


	//private

	private void saveIntegral(User user, Match match, int fenshu)
	{

		System.out.println(user==null);
		if (user ==null){
			return;
		}
		//更改用户积分
		userService.changeIntegral(user.getId(), fenshu);
		//创建积分
		Integral integral = new Integral();
		integral.setCreateTime(DateUtil.DateToTimestamp(new Date()));
		integral.setIntro("比赛");
		integral.setMatchId(match.getId());
		integral.setMatchType(match.getMatchType());
		integral.setScore(fenshu);
		integral.setTotalIntegral((user.getIntegral() + fenshu) < 0 ? 0 : (user.getIntegral() + fenshu));
		integral.setUserId(user.getId());
		integralService.save(integral);
	}


	/**
	 * 获取过期的用户没有同意的比赛
	 *
	 * @return
	 */
	public List<Match> getOverDateMatch()
	{
		return matchDao.getOverDateMatch();
	}

	/**
	 * 获取已经完成，但是比赛状态没更改的
	 *
	 * @return
	 */
	public List<Match> getCompletedAndNoConfirmMatch()
	{
		return matchDao.getCompletedAndNoConfirmMatch();
	}
}
