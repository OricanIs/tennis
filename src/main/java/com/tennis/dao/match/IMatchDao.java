package com.tennis.dao.match;

import com.tennis.model.common.PageResults;
import com.tennis.model.db.Match;

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

}
