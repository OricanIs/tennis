package com.tennis.dao.integral;

import com.tennis.model.common.PageResults;
import com.tennis.model.db.Integral;

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
public interface IIntegralDao
{

	/**
	 * 保存
	 * @param integral
	 */
	public void saveIntegral(Integral integral);


	public PageResults<Integral> record(int userId, int startTime, int endTime, int page, int pageSize);

}
