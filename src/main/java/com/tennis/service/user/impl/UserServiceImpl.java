package com.tennis.service.user.impl;

import com.tennis.dao.user.IUserDao;
import com.tennis.em.EM_USER_LEVEL;
import com.tennis.model.db.Match;
import com.tennis.model.db.Nation;
import com.tennis.model.db.User;
import com.tennis.model.response.match.UserMatchStatistics;
import com.tennis.model.response.region.CityInfo;
import com.tennis.model.response.user.UserInfoModel;
import com.tennis.service.match.IMathchService;
import com.tennis.service.rank.IRankService;
import com.tennis.service.region.IRegionService;
import com.tennis.service.user.IUserService;

import java.text.DecimalFormat;
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
public class UserServiceImpl implements IUserService
{

	private IUserDao       userDao;
	private IRegionService regionService;
	private IRankService   rankService;
	private IMathchService matchService;

	/**
	 * getUser 精准获取用户的id
	 *
	 * @param userId
	 * @return
	 */
	public User getUser(int userId)
	{
		return userDao.getUser(userId);
	}

	/**
	 * save 保存用户
	 *
	 * @param user
	 */
	public void saveUser(User user)
	{
		userDao.saveUser(user);

	}

	/**
	 * update 更改用户
	 *
	 * @param user
	 */
	public void updateUser(User user)
	{
		userDao.updateUser(user);

	}

	/**
	 * getUserByOpenid 根据openid获取用户的信息
	 *
	 * @param openid
	 * @return
	 */
	public User getUserByOpenid(String openid)
	{
		return userDao.getUserByOpenid(openid);
	}


	/**
	 * 获取用户的详情
	 *
	 * @param userId
	 * @return
	 */
	public UserInfoModel getUserInfo(int userId)
	{
		User user = userDao.getUser(userId);
		if (user != null)
		{
			UserInfoModel model = new UserInfoModel();
			// 获取城市信息
			CityInfo cityInfo = regionService.getCityInfo(user.getCity());
			if (cityInfo != null)
			{
				model.setProvice(cityInfo.getProvice());
				model.setCity(cityInfo.getCity());
			}
			else
			{
				model.setProvice("未知");
				model.setCity("未知");
			}
			Nation nation = regionService.getNationById(user.getNation());
			model.setNation(nation.getName());
			model.setNationFlag(nation.getImage());

			model.setAge(user.getAge());
			model.setAvatar(user.getAvatar());
			model.setBirthYear(user.getBirthday().toString());
			model.setHeight(user.getHeight().toString());
			model.setId(user.getId());
			model.setIntegral(user.getIntegral());
			model.setName(user.getName());
			model.setWeight(user.getWeight().toString());
			model.setRank(rankService.getOneRank(user.getId()).getRank());
			model.setMobile(user.getMobile());
			String sex = "未知";
			if (user.getSex() == 1)
				sex = "女";
			else
				sex = "男";
			model.setSex(sex);

			model.setPlayhand(user.getForehand() == 0 ? "右手" : "左手");
			model.setState(user.getStatus() == 0 ? "正常" : "休息");
			model.setPlayWay(user.getBackhand() == 0 ? "单反" : "双反");
			model.setCanChanllage(canChanllage(user.getId()));
			UserMatchStatistics statistics = matchService.userStatistics(user.getId());
			//统计用户的比赛数据
			if (statistics != null)
			{
				model.setGamesCount(statistics.getSingleGameCount() + statistics.getTeamGameCount());
				if (statistics.getSingleGameCount() != 0)
					model.setTeamWinningRate(intDivide(statistics.getSingleWinCount(), statistics.getSingleGameCount()));
				if (statistics.getTeamGameCount() != 0)
					model.setSingleWinningRate(intDivide(statistics.getTeamWinCount(), statistics.getTeamGameCount()));
			}
			EM_USER_LEVEL levelEm = EM_USER_LEVEL.getEmByIndex(user.getLevel());
			model.setLevel(levelEm.getName());
			return model;

		}

		return null;
	}

	/**
	 * 用户是否能挑战
	 *
	 * @param userId
	 * @return
	 */
	public boolean canChanllage(int userId)
	{
		/**
		 * ==================================
		 *
		 * 		1.	每个玩家每周最多可以挑战4次，
		 * 		2.	2周内不能重复挑战同一选手，
		 * 		3.	被挑战的玩家每个月可以拒绝2次挑战，第3次拒绝含以上每次扣5分；
		 * 		4:	玩家的状态可设置为有空或者忙碌，玩家不能挑战那些设置为忙碌的玩家
		 *
		 * ==================================
		 */

		//1：查看用户的状态
		User user = userDao.getUser(userId);
		if (user == null || user.getStatus() == 1)
			return false;

		List<Match> matches = matchService.userWeekMatchs(userId);

		//检查一周玩的次数
		if (matches.size() > 4)
			return false;

		return false;
	}
	/**
	 * 查看两个用户能不能比赛
	 * @param user1
	 * @param user2
	 * @return
	 */
	public boolean canMatch(int user1, int user2)
	{

		if (canChanllage(user1) && canChanllage(user2))
		{
			boolean b = canChanallAnotherCount(user1, user2);
			return b;

		}

		return false;

	}


	//privates
	private boolean canChanallAnotherCount(int userId, int otherUserId)
	{
		List<Match> matches = matchService.userWeekMatchs(userId);

		if (matches == null || matches.size() <= 0)
			return true;

		int count = 0;
		for (int i = 0; i < matches.size(); i++)
		{
			Match match = matches.get(i);
			if (match.getChallengeMainUser().equals(userId) || match.getChallengeMinUser().equals(userId))
			{
				if (match.getDefenderMainUser().equals(otherUserId) || match.getDeferderMinUser().equals(otherUserId))
				{
					return false;
				}
			}
			else
			{
				if (match.getChallengeMainUser().equals(otherUserId) || match.getChallengeMinUser().equals(otherUserId))
					return false;

			}

		}

		return true;

	}

	private float intDivide(int a, int b)
	{
		float         num = (float) a / b;
		DecimalFormat df  = new DecimalFormat("0.00");//格式化小数
		String        s   = df.format(num);//返回的是String类型
		return Float.valueOf(s);
	}


	//sets
	public void setUserDao(IUserDao userDao)
	{
		this.userDao = userDao;
	}

	public void setRegionService(IRegionService regionService)
	{
		this.regionService = regionService;
	}

	public void setRankService(IRankService rankService)
	{
		this.rankService = rankService;
	}

	public void setMatchService(IMathchService matchService)
	{
		this.matchService = matchService;
	}
}
