package com.tennis.web.interceptor.common;


import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * All rights Reserved, Designed By  lixiao
 * Copyright (c) 2016 by Shanghai lixiao
 *
 * @PROJECT_NAME: viewlife
 * @author: lixiao
 * @version: V1.0
 * @Date: 2016/12/2
 * @Description:
 */
public class SysErrInterceptor implements Interceptor
{

	/**
	 * Allows the Interceptor to do some processing on the request before and/or after the rest of the processing of the
	 * request by the {@link ActionInvocation} or to short-circuit the processing and just return a String return code.
	 *
	 * @param invocation the action invocation
	 * @return the return code, either returned from {@link ActionInvocation#invoke()}, or from the interceptor itself.
	 * @throws Exception any system-level error, as defined in {@link Action#execute()}.
	 */
	public String intercept(ActionInvocation invocation) throws Exception
	{
		String result = null; // Action的返回值
		try {
			// 运行被拦截的Action,期间如果发生异常会被catch住
			result = invocation.invoke();
			return result;
		} catch (Exception e) {
			/**
			 * 处理异常
			 */
			String errorMsg = "出现错误信息，请查看日志！";

			/**
			 * log4j记录日志
			 */
			Log log = LogFactory
					.getLog(invocation.getAction().getClass());
			log.error(errorMsg, e);
			return "errorMsg";

		}
	}

	/**
	 * Called to let an interceptor clean up any resources it has allocated.
	 */
	public void destroy()
	{

	}

	/**
	 * Called after an interceptor is created, but before any requests are processed using
	 * {@link #intercept(ActionInvocation) intercept} , giving
	 * the Interceptor a chance to initialize any needed resources.
	 */
	public void init()
	{

	}
}
