package com.tennis.action.app;

import com.opensymphony.xwork2.ActionSupport;
import com.tennis.em.EM_GLOBAL_RESULT;
import com.tennis.model.common.PageResults;
import com.tennis.model.db.Integral;
import com.tennis.model.db.User;
import com.tennis.service.integral.IIntegralService;

import org.apache.struts2.ServletActionContext;

import static com.tennis.util.common.HttpPrintWriter.responseWrite;

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
public class IntegralAction extends ActionSupport
{
	private IIntegralService integralService;
	private EM_GLOBAL_RESULT SuccessEM = EM_GLOBAL_RESULT.getEmByCode(0);
	private int page;
	private int pageSize;
	private int startTime;
	private int endTime;



	/**
	 * 积分列表
	 * @return
	 */
	public String integralList(){
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");

		PageResults<Integral> pageResults = integralService.record(user.getId(), startTime, endTime, page, pageSize);
		responseWrite(ServletActionContext.getResponse(), SuccessEM, pageResults);
		return SUCCESS;
	}



	public void setStartTime(int startTime)
	{
		this.startTime = startTime;
	}

	public void setEndTime(int endTime)
	{
		this.endTime = endTime;
	}

	public void setPage(int page)
	{
		this.page = page;
	}

	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}

	public void setIntegralService(IIntegralService integralService)
	{
		this.integralService = integralService;
	}


}
