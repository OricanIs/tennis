package com.tennis.dao.region;

import com.tennis.model.db.Nation;

import java.util.List;

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
public interface INationDao
{
	/**
	 * getNations 获取国家列表
	 * @return
	 */
	public List<Nation> getNations();

	/**
	 * getNationById 根据国家id获取国家信息
	 * @param nationId
	 * @return
	 */
	public Nation getNationById(int nationId);
}
