package com.tennis.em;

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
public enum  EM_MATCH_STATE
{
	MATCH_INVALID(-1,"MATCH_INVALID"),
	MATCH_CREATE(0,"CREATE_MATCH"),
	MATCH_IN_CHALLENGE(1,"IN_CHALLENGE_MATCH"),
	MATCH_OVER(2,"MATCH_OVER")
	;
	private int    index;        //序号
	private String code;         //代码



	//根据类型，返回code
	public static EM_MATCH_STATE getEmByCode(String code)
	{
		//判定操作码是否为空
		if (code != null)
		{
			//遍历操作码
			for (EM_MATCH_STATE em : EM_MATCH_STATE.values())
			{
				if (em.code.equals(code))
					return em;
			}
		}

		return null;
	}

	//根据类型，返回em
	public static EM_MATCH_STATE getEmByIndex(int index)
	{
		//遍历操作码
		for (EM_MATCH_STATE em : EM_MATCH_STATE.values())
		{
			if (em.index == index)
				return em;
		}

		return null;
	}




	EM_MATCH_STATE(int index, String code)
	{
		this.index = index;
		this.code = code;
	}

	public int getIndex()
	{
		return index;
	}

	public void setIndex(int index)
	{
		this.index = index;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}
}
