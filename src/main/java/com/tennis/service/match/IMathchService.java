package com.tennis.service.match;

import com.tennis.model.db.Match;
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
public interface IMathchService
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

}
