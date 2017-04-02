package com.tennis.model.response.user;

/**
 * All rights Reserved, Designed By  lixiao
 * Copyright (c) 2017 by Shanghai lixiao
 *
 * @PROJECT_NAME: tennis
 * @author: lixiao
 * @version: V1.0
 * @Date: 2017/4/1
 * @Description:
 */
public class SimpleUserInfo
{
	private int id;
	private String name;
	private String avatar;
	private String mobil;

	public int getId()
	{
		return id;
	}


	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAvatar()
	{
		return avatar;
	}

	public void setAvatar(String avatar)
	{
		this.avatar = avatar;
	}

	public String getMobil()
	{
		return mobil;
	}

	public void setMobil(String mobil)
	{
		this.mobil = mobil;
	}
}
