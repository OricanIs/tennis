package com.tennis.dao.region.impl;

import com.tennis.dao.common.impl.GenericDaoImpl;
import com.tennis.dao.region.INationDao;
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
public class NationDaoImpl extends GenericDaoImpl<Nation,Integer> implements INationDao
{
	/**
	 * getNations 获取国家列表
	 *
	 * @return
	 */
	public List<Nation> getNations()
	{
		String sql = "select * from `nation` order by id asc";
		List<Nation> listBySQL = this.getListBySQL(sql);
		return listBySQL;
	}

	/**
	 * getNationById 根据国家id获取国家信息
	 *
	 * @param nationId
	 * @return
	 */
	public Nation getNationById(int nationId)
	{
		Nation nation = this.get(nationId);
		return nation;
	}
}
