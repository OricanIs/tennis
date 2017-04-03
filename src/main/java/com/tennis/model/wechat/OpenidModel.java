package com.tennis.model.wechat;

/**
 * All rights Reserved, Designed By  lixiao
 * Copyright (c) 2017 by Shanghai lixiao
 *
 * @PROJECT_NAME: tennis
 * @author: lixiao
 * @version: V1.0
 * @Date: 2017/4/3
 * @Description:
 */
public class OpenidModel
{
	private String openid;
	private String session_key;

	public OpenidModel()
	{
	}

	public OpenidModel(String openid, String session_key)
	{
		this.openid = openid;
		this.session_key = session_key;
	}

	public String getOpenid()
	{
		return openid;
	}

	public void setOpenid(String openid)
	{
		this.openid = openid;
	}

	public String getSession_key()
	{
		return session_key;
	}

	public void setSession_key(String session_key)
	{
		this.session_key = session_key;
	}
}
