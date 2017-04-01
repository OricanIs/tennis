/*
 * Copyright (c) 2015-2015 by Shanghai shootbox Information Technology Co., Ltd.
 * Create: 2016/11/23 2:10:23
 * Project: viewlife
 * File: CharFilter.java
 * Class: CharFilter
 * Module: viewlife
 * Author: Administrator
 * Version: 1.0
 */

package com.tennis.web.interceptor.common;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CharFilter implements Filter
{

	private FilterConfig filterConfig = null;

	public void destroy()
	{
		this.filterConfig = null;
	}

	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		String              encoding = this.filterConfig.getInitParameter("encoding");
		HttpServletRequest  request  = (HttpServletRequest) req;
		HttpServletResponse resp     = (HttpServletResponse) response;
		request.setCharacterEncoding(encoding);
		resp.setContentType("text/html;charset=" + encoding);

		// 处理GET参数
		if (request.getMethod().equalsIgnoreCase("get") )
		{
			Map      paramMap         = req.getParameterMap();
			String[] queryStringArray = {""};

			if (request.getQueryString() != null)
			{
				String result = java.net.URLDecoder.decode(request.getQueryString(), "UTF-8");
				queryStringArray = result.split("&");
			}
			for (int i = 0; i < queryStringArray.length; i++)
			{
				queryStringArray[i] = queryStringArray[i].replaceAll("(.*)=(.*)", "$1");
			}
			Set<String> keySet = paramMap.keySet();
			for (String key : keySet)
			{
				// check where param from
				boolean isFromGet = false;
				for (String paramFromGet : queryStringArray)
				{
					if (key.equals(paramFromGet))
					{
						isFromGet = true;
					}
				}
				if (!isFromGet)
				{
					continue;
				}
				String[] paramArray = (String[]) paramMap.get(key);
				for (int i = 0; i < paramArray.length; i++)
				{
					paramArray[i] = new String(paramArray[i].getBytes("iso-8859-1"), encoding);
				}
			}
		} chain.doFilter(req, resp);
	}

	public void init(FilterConfig filterConfig) throws ServletException
	{
		this.filterConfig = filterConfig;
	}
}

