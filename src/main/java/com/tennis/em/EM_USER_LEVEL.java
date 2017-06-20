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
public enum EM_USER_LEVEL
{
	ENTRY_LEVEL(1, "entry", "入门", 0,180),
	PRIMARY_LEVEL(2, "primary", "初级", 300,370),
	MIDDLE_LEVEL(3, "middle", "中级", 450,500),
	SENIOR_LEVEL(4, "senior", "高级", 750,770),
	EXPERT_LEVEL(5, "master", "专家", 1000,1000);

	private int    index;        //序号
	private String code;         //代码
	private String name;         //名称
	private int    score;        //分数
	private int initial;

	private EM_USER_LEVEL(int index, String code, String name, int score,int initial)
	{
		this.index = index;
		this.code = code;
		this.name = name;
		this.score = score;
		this.initial = initial;
	}

	//根据类型，返回em
	public static EM_USER_LEVEL getEmByCode(String code)
	{
		//判定操作码是否为空
		if (code != null)
		{
			//遍历操作码
			for (EM_USER_LEVEL em : EM_USER_LEVEL.values())
			{
				if (em.code.equals(code))
					return em;
			}
		}

		return null;
	}

	//根据类型，返回em
	public static EM_USER_LEVEL getEmByIndex(int index)
	{
		//遍历操作码
		for (EM_USER_LEVEL em : EM_USER_LEVEL.values())
		{
			if (em.index == index)
				return em;
		}

		return null;
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

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getScore()
	{
		return score;
	}

	public void setScore(int score)
	{
		this.score = score;
	}

	public int getInitial()
	{
		return initial;
	}

	public void setInitial(int initial)
	{
		this.initial = initial;
	}
}
