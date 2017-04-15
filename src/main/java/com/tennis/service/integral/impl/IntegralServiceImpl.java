package com.tennis.service.integral.impl;

import com.tennis.dao.integral.IIntegralDao;
import com.tennis.model.common.PageResults;
import com.tennis.model.db.Integral;
import com.tennis.service.integral.IIntegralService;

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
public class IntegralServiceImpl implements IIntegralService
{
	private IIntegralDao integralDao;

	public void setIntegralDao(IIntegralDao integralDao)
	{
		this.integralDao = integralDao;
	}

	/**
	 * 保存
	 *
	 * @param integral
	 */
	public void save(Integral integral)
	{
		integralDao.saveIntegral(integral);
	}

	public PageResults<Integral> record(int userId, int startTime, int endTime, int page, int pageSize)
	{
		return null;
	}
}
