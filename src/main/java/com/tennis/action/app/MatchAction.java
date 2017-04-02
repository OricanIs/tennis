package com.tennis.action.app;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tennis.em.EM_GLOBAL_RESULT;
import com.tennis.model.common.PageResults;
import com.tennis.model.db.Match;
import com.tennis.model.db.User;
import com.tennis.model.response.match.MatchInfo;
import com.tennis.model.response.rank.UserRankModel;
import com.tennis.service.match.IMatchService;
import com.tennis.service.rank.IRankService;
import com.tennis.service.user.IUserService;
import com.tennis.util.common.DateUtil;

import org.apache.struts2.ServletActionContext;

import java.util.Date;

import static com.tennis.util.common.HttpPrintWriter.responseWrite;

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
public class MatchAction extends ActionSupport implements ModelDriven<Match>

{
	private int page;
	private int province;
	private int city;
	private int level;
	private int pageSize;
	private Match            match     = new Match();
	private EM_GLOBAL_RESULT SuccessEM = EM_GLOBAL_RESULT.getEmByCode(0);
	//注入dao
	private IUserService  userService;
	private IRankService  rankService;
	private IMatchService matchService;

	public Match getModel()
	{
		return match;
	}

	/**
	 * 排行
	 *
	 * @return
	 */
	public String rankList()
	{
		PageResults<UserRankModel> pageResults = rankService.userRankList(province, city, 0, level, 0, page, pageSize);
		responseWrite(ServletActionContext.getResponse(), SuccessEM, pageResults);
		return SUCCESS;
	}

	/**
	 * 查看比赛列表
	 *
	 * @return
	 */
	public String myGames()
	{



		return SUCCESS;
	}


	/**
	 * 填写成绩
	 *
	 * @return
	 */
	public String fillScore()
	{

		return SUCCESS;
	}

	/**
	 * 确认比赛
	 *
	 * @return
	 */
	public String confirm()
	{


		return SUCCESS;
	}

	/**
	 * 获取详情
	 * 参数：
	 * 	* id :比赛的id
	 * @return
	 */
	public String matchInfo()
	{
		User      user      = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		int       userId    = 1;
		Match     match     = matchService.get(this.match.getId());
		MatchInfo matchInfo = new MatchInfo();
		matchInfo.setMatchType(match.getMatchType());
		matchInfo.setPlayWay(match.getPlayWay());
		matchInfo.setProvince(match.getMatchProvince());
		matchInfo.setCity(match.getMatchCity());
		matchInfo.setAddr(match.getMatchAddr());
		matchInfo.setState(match.getState());
		matchInfo.setChScore(match.getChallengeScore());
		matchInfo.setDeScore(match.getDefenderScore());

		Date startDate = DateUtil.TimestampToDate(match.getCreateTime());
		Date endDate   = DateUtil.TimestampToDate(match.getEndTime());
		matchInfo.setStartTime(DateUtil.getStringDate(startDate, DateUtil.DATE_YY_MM_DD_HH_MM));
		matchInfo.setEndTime(DateUtil.getStringDate(endDate, DateUtil.DATE_YY_MM_DD_HH_MM));
		if (match.getChallengeMainUser().equals(userId) || match.getChallengeMinUser().equals(userId))
		{
			matchInfo.setCamp("ch");

		}
		else if (match.getDefenderMainUser().equals(userId) || match.getDeferderMinUser().equals(userId))
		{
			matchInfo.setCamp("de");
		}
		else
		{
			responseWrite(ServletActionContext.getResponse(), EM_GLOBAL_RESULT.getEmByCode(10002), null);
			return SUCCESS;
		}
		if(match.getChallengeMainUser() != null && !match.getChallengeMainUser().equals(0))
			matchInfo.setChMainUser(userService.getMatchUserInfo(match.getChallengeMainUser()));

		if(match.getChallengeMinUser() != null && !match.getChallengeMinUser().equals(0))
			matchInfo.setChMinUser(userService.getMatchUserInfo(match.getChallengeMinUser()));

		if(match.getDefenderMainUser() != null && !match.getDefenderMainUser().equals(0))
			matchInfo.setDeMainUser(userService.getMatchUserInfo(match.getDefenderMainUser()));

		if(match.getDeferderMinUser() != null && !match.getDeferderMinUser().equals(0))
			matchInfo.setDeMinUser(userService.getMatchUserInfo(match.getDeferderMinUser()));

		//返回结果
		responseWrite(ServletActionContext.getResponse(), SuccessEM, matchInfo);
		return SUCCESS;

	}

	/**
	 * 挑战赛  matchType = 0
	 * * 单打 playWay = 0
	 * * 双打 playWay = 0
	 * *（双打）双打只对中级（含）以上选手开放；
	 * *（双打）双打没有级别限制
	 * *（双打）基准分为赢一场得10分，输一场扣6分
	 * *（双打）无视级别 最高差3
	 * *（单打）每赢一场则获得15分，该级别分数如果达到高一级别分数，则自动升级；
	 * *（单打）输一场扣10分直至扣完当前所在级别的积分，该级别分数扣完则自动降级
	 * *（单打）只能同等级别
	 * 擂台赛：matchType = 1
	 * * 单打 playWay = 0
	 * * 双打 playWay = 0
	 * * 无视级别 最高差3
	 *
	 * @return
	 */
	public String create()
	{
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		user = userService.getUser(1);

		//首先判断 是挑战赛还是擂台赛
		if (match.getMatchType().equals(0))
		{
			//判断单双打
			if (match.getPlayWay().equals(0))
			{
				//检查能否挑战
				boolean canChallenge = userService.canChanllage(user.getId());
				if (!canChallenge)
				{

					responseWrite(ServletActionContext.getResponse(), EM_GLOBAL_RESULT.getEmByCode(10004), null);
					return SUCCESS;
				}

				//检查双方能否比赛
				canChallenge = userService.canMatch(user.getId(), match.getDefenderMainUser());
				User defenderUser = userService.getUser(match.getDefenderMainUser());
				if (!canChallenge || !defenderUser.getLevel().equals(defenderUser.getLevel()))
				{
					responseWrite(ServletActionContext.getResponse(), EM_GLOBAL_RESULT.getEmByCode(10005), null);
					return SUCCESS;
				}

				//创建比赛
				createMatch(match.getChallengeMainUser(), match.getChallengeMinUser(), match.getDefenderMainUser(), match.getDeferderMinUser(), match.getPlayWay(), match.getMatchType(), match.getMatchCity(), match.getMatchProvince(), match.getMatchAddr(), match.getIntegral(), match.getStartTime(), match.getEndTime());
				responseWrite(ServletActionContext.getResponse(), SuccessEM, null);
				return SUCCESS;
			}
			else
			{
				//检查能否挑战
				boolean canChallenge = userService.canChanllage(user.getId());
				if (!canChallenge || user.getLevel() < 2)
				{
					responseWrite(ServletActionContext.getResponse(), EM_GLOBAL_RESULT.getEmByCode(10004), null);
					return SUCCESS;
				}
				//检查双方能否比赛
				canChallenge = userService.canMatch(user.getId(), match.getDefenderMainUser());
				User defenderUser = userService.getUser(match.getDefenderMainUser());
				if (!canChallenge || defenderUser.getLevel() < 2)
				{
					responseWrite(ServletActionContext.getResponse(), EM_GLOBAL_RESULT.getEmByCode(10004), null);
					return SUCCESS;
				}
				//判断队友是否存在
				if (match.getChallengeMinUser() == null || match.getChallengeMinUser().equals(0))
				{
					responseWrite(ServletActionContext.getResponse(), EM_GLOBAL_RESULT.getEmByCode(10002), null);
					return SUCCESS;
				}
				//创建比赛
				createMatch(match.getChallengeMainUser(), match.getChallengeMinUser(), match.getDefenderMainUser(), match.getDeferderMinUser(), match.getPlayWay(), match.getMatchType(), match.getMatchCity(), match.getMatchProvince(), match.getMatchAddr(), match.getIntegral(), match.getStartTime(), match.getEndTime());
				responseWrite(ServletActionContext.getResponse(), SuccessEM, null);
				return SUCCESS;
			}
		}
		else
		{
			//判断单双打
			if (match.getPlayWay().equals(0))
			{
				createMatch(0, 0, 0, user.getId(), match.getPlayWay(), match.getMatchType(), match.getMatchCity(), match.getMatchProvince(), match.getMatchAddr(), match.getIntegral(), match.getStartTime(), match.getEndTime());
				responseWrite(ServletActionContext.getResponse(), SuccessEM, null);
				return SUCCESS;
			}
			else
			{
				//要判断用户是否存在
				User findUser = userService.getUser(match.getDeferderMinUser());
				if (findUser == null)
				{
					responseWrite(ServletActionContext.getResponse(), EM_GLOBAL_RESULT.getEmByCode(10002), null);
					return SUCCESS;
				}

				createMatch(0, 0, findUser.getId(), user.getId(), match.getPlayWay(), match.getMatchType(), match.getMatchCity(), match.getMatchProvince(), match.getMatchAddr(), match.getIntegral(), match.getStartTime(), match.getEndTime());
				responseWrite(ServletActionContext.getResponse(), SuccessEM, null);
				return SUCCESS;

			}

		}

	}


	//private function

	private void createMatch(int chMainUser, int chMinUser, int deMainUser, int deMinUser, int playWay, int matchType, String matchCity, String matchProvince, String matchAddr, int integral, int startTime, int endTime)
	{
		Match match = new Match();
		match.setState(0);
		Integer createTime = DateUtil.DateToTimestamp(new Date());
		match.setCreateTime(createTime);
		//参数
		match.setChallengeMainUser(chMainUser);
		match.setChallengeMinUser(chMinUser);
		match.setDeferderMinUser(deMinUser);
		match.setDefenderMainUser(deMainUser);
		match.setPlayWay(playWay);
		match.setMatchType(matchType);
		match.setMatchCity(matchCity);
		match.setMatchProvince(matchProvince);
		match.setMatchAddr(matchAddr);
		match.setIntegral(integral);
		match.setStartTime(startTime);
		match.setEndTime(endTime);
		match.setDefenderScore(0);
		match.setChallengeScore(0);
		matchService.saveMatch(match);

	}


	//sets

	public void setPage(int page)
	{
		this.page = page;
	}

	public void setProvince(int province)
	{
		this.province = province;
	}

	public void setCity(int city)
	{
		this.city = city;
	}

	public void setLevel(int level)
	{
		this.level = level;
	}

	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}

	public void setSuccessEM(EM_GLOBAL_RESULT successEM)
	{
		SuccessEM = successEM;
	}

	public void setUserService(IUserService userService)
	{
		this.userService = userService;
	}

	public void setRankService(IRankService rankService)
	{
		this.rankService = rankService;
	}

	public void setMatchService(IMatchService matchService)
	{
		this.matchService = matchService;
	}
}