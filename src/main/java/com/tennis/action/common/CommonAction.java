package com.tennis.action.common;

import com.opensymphony.xwork2.ActionSupport;
import com.tennis.em.EM_GLOBAL_RESULT;

import org.apache.struts2.ServletActionContext;

import static com.tennis.util.common.HttpPrintWriter.responseWrite;

/**
 * All rights Reserved, Designed By  lixiao
 * Copyright (c) 2017 by Shanghai lixiao
 *
 * @PROJECT_NAME: tennis
 * @author: lixiao
 * @version: V1.0
 * @Date: 2017/4/4
 * @Description:
 */
public class CommonAction extends ActionSupport
{
	/**
	 * 处理用户未登录的拦截器
	 * @return
	 */
	public  String userNeedLogin(){
		responseWrite(ServletActionContext.getResponse(), EM_GLOBAL_RESULT.getEmByCode(10000),
					  null);

		return SUCCESS;
	}

	/**
	 * 处理未定义错误的拦截器
	 * @return
	 */
	public String undefindErr(){

		responseWrite(ServletActionContext.getResponse(), EM_GLOBAL_RESULT.getEmByCode(10007),
					  null);

		return SUCCESS;
	}

}
