package com.tennis.em;

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
public enum EM_GLOBAL_RESULT
{

	OK(0, "SUCCESS", "success"),
	ERR_STATUS(10001, "ERR_STATUS", "status abnormal"),
	ERR_PARAM(10002,"ERR_PARAM","请求参数不合法")

	;


	private int    code;
	private String name;
	private String reason;


	private EM_GLOBAL_RESULT(int code, String name, String reason)
	{
		this.code = code;
		this.name = name;
		this.reason = reason;
	}

	//根据类型，返回em
	public static EM_GLOBAL_RESULT getEmByCode(int code)
	{
		//判定操作码是否为空

		//遍历操作码
		for (EM_GLOBAL_RESULT em : EM_GLOBAL_RESULT.values())
		{
			if (em.code == code)
				return em;
		}

		return null;
	}

	//根据名称，返回em
	public static EM_GLOBAL_RESULT getEmByName(String name)
	{
		//判定操作码是否为空

		//遍历操作码
		for (EM_GLOBAL_RESULT em : EM_GLOBAL_RESULT.values())
		{
			if (em.name == name)
				return em;
		}

		return null;
	}


	public int getCode()
	{
		return code;
	}

	public void setCode(int code)
	{
		this.code = code;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getReason()
	{
		return reason;
	}

	public void setReason(String reason)
	{
		this.reason = reason;
	}
}
