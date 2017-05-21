package com.tennis.action.app;

import com.tennis.model.db.Match;
import com.tennis.model.db.MatchResult;
import com.tennis.service.match.IMatchService;

import java.util.List;

/**
 * All rights Reserved, Designed By  lixiao
 * Copyright (c) 2017 by Shanghai lixiao
 *
 * @PROJECT_NAME: tennis
 * @author: lixiao
 * @version: V1.0
 * @Date: 2017/5/15
 * @Description:
 */
public class PollingAction
{
	private IMatchService matchService;

	public void setMatchService(IMatchService matchService)
	{
		this.matchService = matchService;
	}

	/**
	 * 比赛 轮询
	 */
	public void matchPolling()
	{
		//轮询包含两个
		//1.0 自动取消比赛
		System.out.println(11111);
		cancelMatchs();
		//2.0 确认比赛
		System.out.println(11111);
		autoCompleteMatchs();

	}

	/**
	 * 1.O 自清取消比赛
	 */
	private void cancelMatchs()
	{

		/**
		 *  思路 ：
		 *        1：首先查找所有符合条件的比赛
		 * 		  2：修改每个比赛的状态
		 */
		//首先查找所有符合条件的比赛
		List<Match> matchs = matchService.getOverDateMatch();
		for (int i = 0; i < matchs.size(); i++)
		{
			//修改每个比赛的状态
			Match match = matchs.get(i);
			match.setState(-1);
			matchService.update(match);

		}


	}


	/**
	 * 2.0 自动确认比赛
	 */
	private void autoCompleteMatchs()
	{

		/**
		 *  思路 ：
		 *        1：首先查找所有符合条件的比赛
		 * 		  2：查找这个比赛用户又没有确认过比赛
		 * 		  3：如果确认过比赛 - 要确认两个人输入的比赛成绩有是否一致
		 *		  4：修改比赛的状态
		 */
		//首先查找所有符合条件的比赛
		List<Match> matchs = matchService.getCompletedAndNoConfirmMatch();
		//遍历 match
		for (int i = 0; i < matchs.size(); i++)
		{
			//修改每个比赛的状态
			Match       match         = matchs.get(i);
			int         chScore       = 0;
			int         deScore       = 0;
			int         chScore1      = 0;
			int         deScore1      = 0;
			MatchResult chMatchResult = matchService.getMatchResultByUser(match.getId(), match.getChallengeMainUser());
			if (chMatchResult != null)
			{
				chScore = chMatchResult.getChallengeScore();
				deScore = chMatchResult.getDefenderScore();
			}
			MatchResult deMatchResult = matchService.getMatchResultByUser(match.getId(), match.getDefenderMainUser());
			if (deMatchResult != null)
			{
				chScore1 = deMatchResult.getChallengeScore();
				deScore1 = deMatchResult.getDefenderScore();
			}
			if (chScore==0 && deScore==0){
				if (chScore1==0 && deScore1==0){
					//比赛失效
					abnormalMatchHandle(match);
					return;
				}
				//比赛有效
				matchCompleteHandle(match,chScore1,deScore1);
				return;
			}else{

				if (chScore1==0 && deScore1==0){
					matchCompleteHandle(match,chScore,deScore);
					//比赛有效
				}else{
					//比赛失效
					abnormalMatchHandle(match);
				}
			}
		}


	}


	//比赛异常
	private void abnormalMatchHandle(Match match){

		match.setState(3);
		matchService.update(match);
	}

	//比赛完成
	private void matchCompleteHandle(Match match,int chScore,int deScore){
		//订单成功
		match.setChallengeScore(chScore);
		match.setDefenderScore(deScore);
		match.setState(2);
		matchService.update(match);
		//记录分数
		matchService.updateMatchIntegral(match);
	}


}
