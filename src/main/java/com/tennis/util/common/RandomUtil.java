/*
 * Copyright (c) 2015-2015 by Shanghai shootbox Information Technology Co., Ltd.
 * Create: 2016/11/23 2:10:23
 * Project: viewlife
 * File: RandomUtil.java
 * Class: RandomUtil
 * Module: viewlife
 * Author: Administrator
 * Version: 1.0
 */

/*
 * Copyright (c) 2015-2015 by Shanghai shootbox Information Technology Co., Ltd.
 * Create: 2016/11/18 0:5:26
 * Project: viewlife
 * File: RandomUtil.java
 * Class: RandomUtil
 * Module: viewlife
 * Author: Administrator
 * Version: 1.0
 */

package com.tennis.util.common;

import java.util.Random;

/**
 * Author: Cavan Liu
 * Date: 2016/11/18 0018.
 */
public class RandomUtil
{
	/**
	 * @param nLen
	 * @return string
	 * @Title genRandomNum
	 * @des 按位数生成随机数
	 * @author lixiao
	 * @Date 2016年11月18日 18:51:47
	 */
	static public String genRandomNum(int nLen)
	{
		String strRandomNum = "";

		if (nLen <= 0)
			return strRandomNum;

		for (int i = 0; i < nLen; i++)
		{
			int nNum = (int) (Math.random() * 10);

			strRandomNum += nNum;
		}

		return strRandomNum;
	}

	/**
	 * 生成随机的字符串
	 *
	 * @param nLen
	 * @return
	 */
	public static String getRandomStr(int nLen)
	{
		String strBase   = "abcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
		StringBuffer strResult = new StringBuffer();
		Random random    = new Random();

		if (nLen <= 0)
			return "";


		for (int i = 0; i < nLen; i++)
		{
			strResult.append(strBase.charAt(random.nextInt(strBase.length())));

		}

		return strResult.toString();
	}

	/**
	 * 生成随机的字母
	 *
	 * @param nLen
	 * @return
	 */
	public static String getRandomLetter(int nLen)
	{
		String strBase   = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String strResult = "";
		Random random    = new Random();

		if (nLen <= 0)
			return strResult;


		for (int i = 0; i < nLen; i++)
		{
			strResult += strBase.charAt(random.nextInt(strBase.length()));

		}

		return strResult;
	}


}
