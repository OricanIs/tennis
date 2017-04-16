package com.tennis.dao.integral.impl;

import com.tennis.dao.common.impl.GenericDaoImpl;
import com.tennis.dao.integral.IIntegralDao;
import com.tennis.model.common.PageResults;
import com.tennis.model.db.Integral;
import com.tennis.util.common.DateUtil;

import java.util.Date;

/**
 * All rights Reserved, Designed By  lixiao
 * Copyright (c) 2017 by Shanghai lixiao
 *
 * @PROJECT_NAME: tennis
 * @author: lixiao
 * @version: V1.0
 * @Date: 2017/4/14
 * @Description:
 */
public class IntegralDaoImpl extends GenericDaoImpl<Integral,Integer> implements IIntegralDao
{

	/**
	 * 保存
	 *
	 * @param integral
	 */
	public void saveIntegral(Integral integral)
	{
		String sql = "insert into integral (user_id,score,match_id,create_time,intro," +
				"integral," +
				"match_type) values (?,?,?,?,?,?,?)";
		this.querySql(sql,integral.getUserId(),integral.getScore(),integral.getMatchId(),integral
				.getCreateTime(),integral.getIntro(),integral.getTotalIntegral(),integral.getMatchType());

	}

	public PageResults<Integral> record(int userId, int startTime, int endTime, int page, int pageSize)
	{
		if (startTime==0 || endTime==0){
			startTime = 1492135427;	//2017年4月15
			endTime = DateUtil.DateToTimestamp(new Date());
		}
		String hql = "from Integral where userId=? and createTime between ? and ?";
		String countHql = "select count(*) from Integral where userId=? and createTime between ? and ?";

		PageResults<Integral> pageByFetchedHql = this.findPageByFetchedHql(hql, countHql, page, pageSize, userId, startTime, endTime);


		return pageByFetchedHql;
	}
}
