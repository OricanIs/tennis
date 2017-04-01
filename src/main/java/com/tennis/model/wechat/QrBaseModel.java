package com.tennis.model.wechat;

import java.util.Map;

/**
 * All rights Reserved, Designed By  lixiao
 * Copyright (c) 2017 by Shanghai lixiao
 *
 * @PROJECT_NAME: quchiba
 * @author: lixiao
 * @version: V1.0
 * @Date: 2017/1/3
 * @Description:
 */
public class QrBaseModel
{
	private String action_name;
	private int    expire_seconds;
	private Map<String,Map> action_info;


	public String getAction_name()
	{
		return action_name;
	}

	public void setAction_name(String action_name)
	{
		this.action_name = action_name;
	}

	public int getExpire_seconds()
	{
		return expire_seconds;
	}

	public void setExpire_seconds(int expire_seconds)
	{
		this.expire_seconds = expire_seconds;
	}

	public Map<String, Map> getAction_info()
	{
		return action_info;
	}

	public void setAction_info(Map<String, Map> action_info)
	{
		this.action_info = action_info;
	}
}
