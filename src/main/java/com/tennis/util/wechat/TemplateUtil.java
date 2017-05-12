package com.tennis.util.wechat;

import com.tennis.handler.wechat.AccessTokenHandler;
import com.tennis.model.db.Match;
import com.tennis.model.db.User;
import com.tennis.model.wechat.TemplateData;
import com.tennis.model.wechat.TemplateMessage;
import com.tennis.util.common.CommonUtil;
import com.tennis.util.common.DateUtil;

import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * All rights Reserved, Designed By  lixiao
 * Copyright (c) 2017 by Shanghai lixiao
 *
 * @PROJECT_NAME: tennis
 * @author: lixiao
 * @version: V1.0
 * @Date: 2017/4/24
 * @Description:
 */
public class TemplateUtil
{
	public static void sendResultTemplate(Match match, User user, String formId)
	{
		TemplateMessage templateMessage = new TemplateMessage();
		templateMessage.setTouser(user.getOpenid());
		templateMessage.setTemplate_id("qgse1mxX0CH7-3-jWUxjVIS4mEiZjLIOQJAkoA4Izpk");
		templateMessage.setForm_id(formId);
		templateMessage.setPage("/pages/self/self");
		Map<String, TemplateData> m = new HashMap<String, TemplateData>();

		//比赛比分
		TemplateData keyword1;

		//比赛地址
		TemplateData keyword2 = new TemplateData();
		keyword2.setColor("#173177");
		keyword2.setValue(match.getMatchAddr());

		//比赛时间
		TemplateData keyword3 = new TemplateData();
		keyword3.setColor("#173177");
		keyword3.setValue(DateUtil.getStringDate(DateUtil.TimestampToDate(match.getStartTime()), DateUtil.DATE_YY_MM_DD));

		//备注
		TemplateData keyword4;
		if (match.getChallengeMainUser().equals(user.getId()) || match.getChallengeMinUser().equals(user.getId()))
		{
			keyword1 = new TemplateData();
			keyword1.setColor("#173177");
			keyword1.setValue(match.getChallengeScore() + ":" + match.getDefenderScore());


		}
		else
		{
			keyword1 = new TemplateData();
			keyword1.setColor("#173177");
			keyword1.setValue(match.getDefenderScore() + ":" + match.getChallengeScore());


		}
		keyword4 = new TemplateData();
		keyword4.setColor("#173177");
		keyword4.setValue("对方已经填写比赛成绩,请注意查看，如你在完成后七天未填写比赛成绩，以对方填写的比赛为主！");

		m.put("keyword1", keyword1);
		m.put("keyword2", keyword2);
		m.put("keyword3", keyword3);
		m.put("keyword4", keyword4);


		templateMessage.setData(m);
		String templage_message = JSONObject.fromObject(templateMessage).toString();
		String url              = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=ACCESS_TOKEN";
		url = url.replace("ACCESS_TOKEN", AccessTokenHandler.getAccessToken());
		JSONObject postStr = CommonUtil.httpsRequest(url, "POST", templage_message);
		System.out.println("===============");
		System.out.println(user.getOpenid());
		System.out.println(">>>>>>>>>>>>>>>>");
		System.out.println(formId);
		System.out.println(">>>>>>>>>>>>>>>>");
		System.out.println(postStr);
		System.out.println("===============");
	}

	public void sendGameAnnounce(Match match, User user)
	{

	}

}
