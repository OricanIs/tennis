package com.tennis.dao.region;

import com.tennis.model.db.Region;
import com.tennis.model.response.region.CityInfo;

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
public interface IRegionDao
{
	/**
	 * getAllRegions 获取所有的省-市信息
	 * @return
	 */
	public List<Region> getAllRegions();

	/**
	 * getAllProvince 获取所有的省份信息
	 * @return
	 */
	public List<Region> getAllProvince();

	/**
	 * getCityByProvice 根据provinceId 获取改省份下的所有城市列表
	 * @param provinceId
	 * @return
	 */
	public List<Region> getCityByProvice(int provinceId);

	/**
	 * 获取城市详情
	 * @param cityId
	 * @return
	 */
	public CityInfo getCityInfo(int cityId);

}
