package com.tennis.model.wechat;

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
public class QrTicket
{
	private String ticket;
	private int    expire_seconds;
	private String url;

	public String getTicket()
	{
		return ticket;
	}

	public void setTicket(String ticket)
	{
		this.ticket = ticket;
	}

	public int getExpire_seconds()
	{
		return expire_seconds;
	}

	public void setExpire_seconds(int expire_seconds)
	{
		this.expire_seconds = expire_seconds;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}
}
