package com.tennis.service.rank.impl;

import com.tennis.dao.rankToday.IRankTodayDao;
import com.tennis.model.common.PageResults;
import com.tennis.model.response.rank.RankModel;
import com.tennis.model.response.rank.UserRankModel;
import com.tennis.model.response.region.CityInfo;
import com.tennis.service.rank.IRankService;
import com.tennis.service.region.IRegionService;

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
public class RankServiceImpl implements IRankService
{
	//注入方法
	private IRankTodayDao  rankTodayDao;
	private IRegionService regionService;

	public void setRankTodayDao(IRankTodayDao rankTodayDao)
	{
		this.rankTodayDao = rankTodayDao;
	}

	public void setRegionService(IRegionService regionService)
	{
		this.regionService = regionService;
	}

	/**
	 * 获取用户的今日排名
	 *
	 * @param userId
	 * @return
	 */
	public RankModel getOneRank(int userId)
	{
		int       rankByUser = rankTodayDao.getRankByUser(userId);
		RankModel rankModel  = new RankModel();
		return rankModel;
	}

	/**
	 * 根据省份和城市获取列表。 做分页
	 *
	 * @param proviceId
	 * @param cityId
	 * @param matchType 比赛类型 0 单打 ；1 双打 ；
	 * @param level     等级
	 * @param page
	 * @return
	 */
	public PageResults<UserRankModel> userRankList(int userId, int proviceId, int cityId, int matchType, int level, int state, int page, int pageSize)
	{
		if (page <= 0)
			page = 1;
		if (pageSize <= 0)
			pageSize = 20;
		PageResults<UserRankModel> models = rankTodayDao.userRankList(userId, proviceId, cityId, matchType, level, state, page, pageSize);
		List<UserRankModel> ranks = models.getResults();
		for (int i = 0; i < ranks.size(); i++)
		{

			CityInfo cityInfo = regionService.getCityInfo(ranks.get(i).getCity());
			if (cityInfo != null)
			{
				ranks.get(i).setCityStr(cityInfo.getCity().substring(0, cityInfo.getCity().length() - 1));
				ranks.get(i).setProvinceStr(cityInfo.getProvice().substring(0, cityInfo.getProvice().length() - 1));
			}
		}


		return models;
	}
}
