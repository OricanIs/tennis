package com.tennis.model.response.rank;

/**
 * All rights Reserved, Designed By  lixiao
 * Copyright (c) 2017 by Shanghai lixiao
 *
 * @PROJECT_NAME: tennis
 * @author: lixiao
 * @version: V1.0
 * @Date: 2017/3/30
 * @Description:
 */
public class UserRankModel
{
	private int userId;
	private String username;
	private int provice;
	private int city;
	private int integral;
	private String provinceStr;
	private String cityStr;

	public UserRankModel()
	{
	}

	public UserRankModel(int userId, String username, int provice, int city, int integral)
	{
		this.userId = userId;
		this.username = username;
		this.provice = provice;
		this.city = city;
		this.integral = integral;
	}

	public int getUserId()
	{
		return userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public int getProvice()
	{
		return provice;
	}

	public void setProvice(int provice)
	{
		this.provice = provice;
	}

	public int getCity()
	{
		return city;
	}

	public void setCity(int city)
	{
		this.city = city;
	}

	public int getIntegral()
	{
		return integral;
	}

	public void setIntegral(int integral)
	{
		this.integral = integral;
	}

	public String getProvinceStr()
	{
		return provinceStr;
	}

	public void setProvinceStr(String provinceStr)
	{
		this.provinceStr = provinceStr;
	}

	public String getCityStr()
	{
		return cityStr;
	}

	public void setCityStr(String cityStr)
	{
		this.cityStr = cityStr;
	}
}
