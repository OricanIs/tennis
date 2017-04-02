package com.tennis.action.app;

import com.opensymphony.xwork2.ActionSupport;
import com.tennis.em.EM_GLOBAL_RESULT;
import com.tennis.model.common.PageResults;
import com.tennis.model.response.rank.UserRankModel;
import com.tennis.service.rank.IRankService;

import org.apache.struts2.ServletActionContext;

import static com.tennis.util.common.HttpPrintWriter.responseWrite;

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
public class RankAction extends ActionSupport
{
	//页数
	private int          page;
	private IRankService rankService;
	private int          province;
	private int          city;
	private int          level;
	private int          pageSize;
	private EM_GLOBAL_RESULT SuccessEM = EM_GLOBAL_RESULT.getEmByCode(0);

	/**
	 * getRankToday 获取今日排行榜
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
	 * ===========================
	 * <p>
	 * 增加一个每日轮询的任务
	 * <p>
	 * ===========================
	 */


	//sets
	public void setPage(int page)
	{
		this.page = page;
	}

	public void setRankService(IRankService rankService)
	{
		this.rankService = rankService;
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
}
