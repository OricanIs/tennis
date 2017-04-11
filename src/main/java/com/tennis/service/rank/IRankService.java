package com.tennis.service.rank;

import com.tennis.model.common.PageResults;
import com.tennis.model.response.rank.RankModel;
import com.tennis.model.response.rank.UserRankModel;

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
public interface IRankService
{
	/**
	 * 获取用户的今日排名
	 *
	 * @param userId
	 * @return
	 */
	public RankModel getOneRank(int userId);


	/**
	 * 根据省份和城市获取列表。 做分页
	 *
	 * @param proviceId
	 * @param cityId
	 * @param page
	 * @param matchType 比赛类型 0 单打 ；1 双打 ；
	 * @param level     等级
	 * @return
	 */
	public PageResults<UserRankModel> userRankList(int userId, int proviceId, int cityId, int matchType, int level, int state, int page, int pageSize);


}
