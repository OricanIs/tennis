package com.tennis.util.common;

import com.tennis.em.EM_GLOBAL_RESULT;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import static com.tennis.util.common.ReturnResult.structReturnResult;

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
public class HttpPrintWriter
{

	/**
	 * getPrintWriter 获取输出通道
	 *
	 * @param response
	 * @return
	 */
	public static PrintWriter getPrintWriter(HttpServletResponse response)
	{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json; charset=utf-8");
		PrintWriter writer = null;
		try
		{
			writer = response.getWriter();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return writer;
	}

	/**
	 * closePrintWriter 关闭输出通道
	 *
	 * @param writer
	 */
	public static void closePrintWriter(PrintWriter writer)
	{
		if (writer == null)
			return;
		writer.flush();

		writer.close();
	}


	/**
	 * responseWrite 响应数据
	 * @param response
	 * @param em
	 * @param o
	 */
	public static void responseWrite(HttpServletResponse response, EM_GLOBAL_RESULT em,Object o){
		PrintWriter printWriter = getPrintWriter(response);
		String json;
		json = structReturnResult(em, o);

		printWriter.write(json);
		closePrintWriter(printWriter);
	}

}
