package com.tennis.service.integral;

import com.tennis.model.common.PageResults;
import com.tennis.model.db.Integral;

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
public interface IIntegralService
{

	/**
	 * 保存
	 * @param integral
	 */
	public void save(Integral integral);


	public PageResults<Integral> record(int userId,int startTime,int endTime,int page,int pageSize);

}
