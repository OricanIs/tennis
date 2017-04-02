package com.tennis.dao.rankToday.impl;

import com.tennis.dao.common.impl.GenericDaoImpl;
import com.tennis.dao.rankToday.IRankTodayDao;
import com.tennis.model.common.PageResults;
import com.tennis.model.db.UserRankToday;
import com.tennis.model.response.rank.UserRankModel;

import org.hibernate.Query;
import org.hibernate.ScrollableResults;

import java.util.ArrayList;
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
public class RankTodayDaoImpl extends GenericDaoImpl<UserRankToday, Integer> implements IRankTodayDao
{

	/**
	 * @param userId
	 * @return
	 */
	public int getRankByUser(int userId)
	{
		String hql   = "select count(*) from User u where u.integral > (select integral from User u1 where u1.id=?)";
		Long   count = this.countByHql(hql, userId);
		return count.intValue() + 1;
	}

	/**
	 * 根据省份和城市获取列表。 做分页
	 *
	 * @param proviceId
	 * @param cityId
	 * @param matchType 比赛类型 0 单打 ；1 双打 ；
	 * @param level     等级
	 * @param page
	 * @return
	 */
	public PageResults<UserRankModel> userRankList(int proviceId, int cityId, int matchType, int
			level,int state, int page, int pageSize)
	{

		String hql = "select new com.tennis.model.response.rank.UserRankModel(u.id,u.name,u.province,u.city,u.integral) from User u where 1=1 ";

		String countHql = "select count(*) from User u where 1=1";

		if (proviceId != 0)
		{
			hql += " and u.province=" + proviceId;
			countHql += " and u.province=" + proviceId;
		}

		if (cityId != 0)
		{
			hql += " and u.city=" + cityId;
			countHql += " and u.city=" + cityId;
		}
		if (level != 0)
		{

			hql += " and u.level=" + level;
			countHql += " and u.level=" + level;
		}
		if(state != -1){
			hql += " and u.status=" + state;
			countHql += " and u.status=" + state;
		}


		//		hql += " and u.matchType="+matchType;
		//		countHql += " and u.matchType="+matchType;

		hql += " order by u.integral desc,u.id desc";

		PageResults<UserRankModel> rankList = findRankList(hql, countHql, page, pageSize, null);

		return rankList;
	}


	//private functions

	/**
	 * @param hql      HQL语句
	 * @param countHql 查询记录条数的HQL语句
	 * @param pageNo   下一页
	 * @param pageSize 一页总条数
	 * @param values   不定Object数组参数
	 * @return PageResults的封装类，里面包含了页码的信息以及查询的数据List集合
	 */
	private PageResults<UserRankModel> findRankList(String hql, String countHql, int pageNo, int pageSize, Object... values)
	{
		PageResults<UserRankModel> retValue = new PageResults<UserRankModel>();
		Query                      query    = this.getSession().createQuery(hql);
		if (values != null)
		{
			for (int i = 0; i < values.length; i++)
			{
				query.setParameter(i, values[i]);
			}
		}
		int currentPage = pageNo > 1 ? pageNo : 1;
		retValue.setCurrentPage(currentPage);
		retValue.setPageSize(pageSize);
		if (countHql != null)
		{
			Long count = countByHql(countHql, values);
			retValue.setTotalCount(count.intValue());

		}
		else
		{
			ScrollableResults results = query.scroll();
			results.last();
			retValue.setTotalCount(results.getRowNumber() + 1);// 设置总记录数
		}

		retValue.resetPageNo();
		List<UserRankModel> itemList = query.setFirstResult((currentPage - 1) * pageSize).setMaxResults(pageSize).list();
		if (itemList == null)
		{
			itemList = new ArrayList<UserRankModel>();
		}
		retValue.setResults(itemList);

		return retValue;
	}
}
