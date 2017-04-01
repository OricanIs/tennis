package com.tennis.action.test;

import com.opensymphony.xwork2.ActionSupport;
import com.tennis.service.test.ITestService;

import java.util.Map;

/**
 * All rights Reserved, Designed By  lixiao
 * Copyright (c) 2017 by Shanghai lixiao
 *
 * @PROJECT_NAME: quchiba
 * @author: lixiao
 * @version: V1.0
 * @Date: 2017/1/11
 * @Description:
 */
public class TestAction extends ActionSupport
{
	private Map<String ,String> result;
	private ITestService testService;

	public void setTestService(ITestService testService)
	{
		this.testService = testService;
	}

	@Override
	public String execute() throws Exception
	{

		return SUCCESS;
	}


	public Map<String, String> getResult()
	{
		return result;
	}
}
