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

	OK(0, "success", "success"),
	NEED_LOGIN(10000,"needLogin","需要登录"),
	ERR_STATUS(10001, "errStatus", "status abnormal"),
	ERR_PARAM(10002,"errParam","请求参数不合法"),
	NOT_FOUND(10003,"notFound","找不到用户"),
	NO_CHANCE(10004,"noChance","您的机会已用尽,或者您是休息状态"),
	CANNOT_CHALL(10005,"cannotChallenge","对手不可挑战"),
	NEED_DETAIL(10006,"needRegister","需要先完善个人信息"),
	UNDFINED_ERR(10007,"undefindErr","未知的错误"),
	NOT_BEGIN(10008,"notBegin","比赛还没开始"),
	NO_PRIVILEGE(10009,"insufficientPrivilege","请让主要负责人输入比赛成绩"),
	UPLOAD_ERR(10010,"uploadErr","上传失败"),


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
