package com.tennis.action.app;

import com.opensymphony.xwork2.ActionSupport;
import com.tennis.em.EM_GLOBAL_RESULT;
import com.tennis.model.db.Nation;
import com.tennis.model.db.Region;
import com.tennis.model.response.region.RegionModel;
import com.tennis.service.region.IRegionService;

import org.apache.struts2.ServletActionContext;

import java.util.ArrayList;
import java.util.List;

import static com.tennis.util.common.HttpPrintWriter.responseWrite;

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
public class RegionAction extends ActionSupport
{
	//省份id
	private int provinceId;
	private int nationId;
	private IRegionService regionService;
	private EM_GLOBAL_RESULT SuccessEM = EM_GLOBAL_RESULT.getEmByCode(0);
	private String openid;
	public void setOpenid(String openid)
	{
		this.openid = openid;
	}
	/**
	 * getProvinces 获取所有的省份信息
	 * @return
	 */
	public String getProvinces(){

		List<Region> allProvince = regionService.getAllProvince();
		List<RegionModel> regionModels = structResponseRegion(allProvince);
		responseWrite(ServletActionContext.getResponse(), SuccessEM, regionModels);
		return SUCCESS;
	}



	/**
	 * getCitys 根据省份获取相对应的所有城市
	 * @return
	 */
	public String getCitys(){
		List<Region> allCitys = regionService.getCityByProvice(provinceId);
		List<RegionModel> regionModels = structResponseRegion(allCitys);
		responseWrite(ServletActionContext.getResponse(), SuccessEM, regionModels);
		return SUCCESS;
	}

	/**
	 * getNations 获取国家列表
	 * @return
	 */
	public String getNations(){
		List<Nation> nations = regionService.getNations();
		responseWrite(ServletActionContext.getResponse(), SuccessEM, nations);
		return SUCCESS;
	}


	/**
	 * getNation 根据id获取国家
	 * @return
	 */
	public String getNation(){
		Nation nation = regionService.getNationById(nationId);
		responseWrite(ServletActionContext.getResponse(), SuccessEM, nation);
		return SUCCESS;
	}

	//private 方法

	/**
	 * 构建返回结果
	 * @param regions
	 * @return
	 */
	private List<RegionModel> structResponseRegion(List<Region> regions){

		//检测数据是否唯为空
		if(regions == null || regions.size() <=0){
			return null;
		}
		List<RegionModel> regionModels = new ArrayList<RegionModel>();
		RegionModel model;
		Region region;
		for(int i = 0; i < regions.size(); i++) {
			model = new RegionModel();
			region = regions.get(i);
			model.setId(region.getId());
			model.setName(region.getName());
			model.setType(region.getType());
			regionModels.add(model);
		}

		return regionModels;
	}


	//set 方法
	public void setProvinceId(int provinceId)
	{
		this.provinceId = provinceId;
	}

	public void setNationId(int nationId)
	{
		this.nationId = nationId;
	}

	public void setSuccessEM(EM_GLOBAL_RESULT successEM)
	{
		SuccessEM = successEM;
	}

	public void setRegionService(IRegionService regionService)
	{
		this.regionService = regionService;
	}


}
