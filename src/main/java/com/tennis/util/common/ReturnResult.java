package com.tennis.util.common;

import com.tennis.em.EM_GLOBAL_RESULT;
import com.tennis.model.common.ReturnModel;

import net.sf.json.JSONObject;


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
public class ReturnResult
{
	/**
	 * 构建成功的表达结果
	 *
	 * @param result
	 * @return
	 */
	public static String structReturnResult(EM_GLOBAL_RESULT em, Object result)
	{
		ReturnModel returnModel = new ReturnModel();
		returnModel.setCode(em.getCode());
		returnModel.setMsg(em.getName());
		returnModel.setReason(em.getReason());
		if(result == null)
			returnModel.setResult("");
		else
			returnModel.setResult(result);

		String responseStr = JSONObject.fromObject(returnModel).toString();
		return responseStr;
	}


}
