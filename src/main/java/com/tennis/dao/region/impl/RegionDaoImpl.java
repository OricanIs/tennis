package com.tennis.dao.region.impl;

import com.tennis.dao.common.impl.GenericDaoImpl;
import com.tennis.dao.region.IRegionDao;
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
public class RegionDaoImpl extends GenericDaoImpl<Region,Integer> implements IRegionDao
{

	/**
	 * getAllRegions 获取所有的省-市信息
	 *
	 * @return
	 */
	public List<Region> getAllRegions()
	{
		this.setEntityClass(Region.class);
		String sql = "select * from region order by id";
		List<Region> listBySQL = this.getListBySQL(sql);
		return listBySQL;
	}

	/**
	 * getAllProvince 获取所有的省份信息
	 *
	 * @return
	 */
	public List<Region> getAllProvince()
	{
//		this.setEntityClass(Region.class);
		String sql = "select * from region r where r.pid=0 order by id";
		List<Region> listBySQL = this.getListBySQL(sql);
		return listBySQL;
	}

	/**
	 * getCityByProvice 根据provinceId 获取改省份下的所有城市列表
	 *
	 * @param provinceId
	 * @return
	 */
	public List<Region> getCityByProvice(int provinceId)
	{
		this.setEntityClass(Region.class);
		String sql = "select * from region r where r.pid=? order by id desc";
		List<Region> listBySQL = this.getListBySQL(sql, provinceId);
		return listBySQL;
	}

	/**
	 * 获取城市详情
	 *
	 * @param cityId
	 * @return
	 */
	public CityInfo getCityInfo(int cityId)
	{
		String sql = "select * from region r where r.id=? or r.id = (select pid from region r1 " +
				"where r1.id=?)";
		List<Region> listBySQL = this.getListBySQL(sql, cityId,cityId);
		if(listBySQL!=null){
			CityInfo cityInfo = new CityInfo();
			for(int i = 0; i < listBySQL.size(); i++){
				if(listBySQL.get(i).getPid()==0)
					cityInfo.setProvice(listBySQL.get(i).getName());
				else
					cityInfo.setCity(listBySQL.get(i).getName());
			}
			return cityInfo;
		}
		return null;
	}
}
