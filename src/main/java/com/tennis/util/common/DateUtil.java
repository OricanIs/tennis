package com.tennis.util.common;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * All rights Reserved, Designed By  lixiao
 * Copyright (c) 2017 by Shanghai lixiao
 *
 * @PROJECT_NAME: tennis
 * @author: lixiao
 * @version: V1.0
 * @Date: 2017/4/1
 * @Description:
 */
public class DateUtil
{
	public final static  String DATE_YY_MM_DD          = "yyyy-MM-dd";
	public final static String DATE_YY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 当周的星期一
	 *
	 * @return
	 */

	public static Date getMondayOfThisWeek(Date date)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
		if (day_of_week == 0)
			day_of_week = 7;
		c.add(Calendar.DATE, -day_of_week + 1);
		return c.getTime();
	}

	/**
	 * 得到本周周日
	 *
	 * @return yyyy-MM-dd
	 */
	public static Date getSundayOfThisWeek(Date date)
	{

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
		if (day_of_week == 0)
			day_of_week = 7;
		c.add(Calendar.DATE, -day_of_week + 7);
		return c.getTime();
	}


	/**
	 * 格式化代码
	 *
	 * @param date
	 * @param format
	 * @return
	 */
	public static String getStringDate(Date date, String format)
	{

		SimpleDateFormat formatter  = new SimpleDateFormat(format);
		String           dateString = formatter.format(date);
		return dateString;

	}

	/**
	 * 10位时间戳转Date
	 *
	 * @param time
	 * @return
	 */
	public static Date TimestampToDate(Integer time)
	{
		long      temp = (long) time * 1000;
		Timestamp ts   = new Timestamp(temp);
		Date      date = new Date();
		try
		{
			date = ts;
			//System.out.println(date);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * Date类型转换为10位时间戳
	 *
	 * @param time
	 * @return
	 */
	public static Integer DateToTimestamp(Date time)
	{
		Timestamp ts = new Timestamp(time.getTime());

		return (int) ((ts.getTime()) / 1000);
	}


}
