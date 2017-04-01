package com.tennis.model.db;

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
public class Region
{

	private int id;
	private Integer pid;
	private String no;
	private String name;
	private String code;
	private String type;
	private String py;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Integer getPid()
	{
		return pid;
	}

	public void setPid(Integer pid)
	{
		this.pid = pid;
	}

	public String getNo()
	{
		return no;
	}

	public void setNo(String no)
	{
		this.no = no;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getPy()
	{
		return py;
	}

	public void setPy(String py)
	{
		this.py = py;
	}

	@Override
	public int hashCode()
	{
		int result = id;
		result = 31 * result + (pid != null ? pid.hashCode() : 0);
		result = 31 * result + (no != null ? no.hashCode() : 0);
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (code != null ? code.hashCode() : 0);
		result = 31 * result + (type != null ? type.hashCode() : 0);
		result = 31 * result + (py != null ? py.hashCode() : 0);
		return result;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Region region = (Region) o;

		if (id != region.id)
			return false;
		if (pid != null ? !pid.equals(region.pid) : region.pid != null)
			return false;
		if (no != null ? !no.equals(region.no) : region.no != null)
			return false;
		if (name != null ? !name.equals(region.name) : region.name != null)
			return false;
		if (code != null ? !code.equals(region.code) : region.code != null)
			return false;
		if (type != null ? !type.equals(region.type) : region.type != null)
			return false;
		if (py != null ? !py.equals(region.py) : region.py != null)
			return false;

		return true;
	}
}
