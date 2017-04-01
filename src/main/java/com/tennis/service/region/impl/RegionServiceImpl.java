package com.tennis.service.region.impl;

import com.tennis.dao.region.INationDao;
import com.tennis.dao.region.IRegionDao;
import com.tennis.model.db.Nation;
import com.tennis.model.db.Region;
import com.tennis.model.response.region.CityInfo;
import com.tennis.service.region.IRegionService;

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
public class RegionServiceImpl implements IRegionService
{
	//注入dao层
	private IRegionDao regionDao;
	private INationDao nationDao;

	public void setRegionDao(IRegionDao regionDao)
	{
		this.regionDao = regionDao;
	}

	public void setNationDao(INationDao nationDao)
	{
		this.nationDao = nationDao;
	}

	/**
	 * getAllRegions 获取所有的省-市信息
	 *
	 * @return
	 */
	public List<Region> getAllRegions()
	{
		return regionDao.getAllRegions();
	}

	/**
	 * getAllProvince 获取所有的省份信息
	 *
	 * @return
	 */
	public List<Region> getAllProvince()
	{
		return regionDao.getAllProvince();
	}

	/**
	 * getCityByProvice 根据provinceId 获取改省份下的所有城市列表
	 *
	 * @param provinceId
	 * @return
	 */
	public List<Region> getCityByProvice(int provinceId)
	{
		return regionDao.getCityByProvice(provinceId);
	}

	/**
	 * getNations 获取国家列表
	 *
	 * @return
	 */
	public List<Nation> getNations()
	{
		return nationDao.getNations();
	}

	/**
	 * getNationById 根据国家id获取国家信息
	 *
	 * @param nationId
	 * @return
	 */
	public Nation getNationById(int nationId)
	{
		return nationDao.getNationById(nationId);
	}

	/**
	 * 获取城市详情
	 * @param cityId
	 * @return
	 */
	public CityInfo getCityInfo(int cityId){

		return regionDao.getCityInfo(cityId);
	}
}
