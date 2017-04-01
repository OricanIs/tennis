package com.tennis.util.common.http;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * All rights Reserved, Designed By  lixiao
 * Copyright (c) 2017 by Shanghai lixiao
 *
 * @PROJECT_NAME: quchiba
 * @author: lixiao
 * @version: V1.0
 * @Date: 2017/1/4
 * @Description:
 */
public class DownloadFileUtil
{
	/**
	 * 从网络Url中下载文件
	 *
	 * @param urlStr
	 * @param fileName
	 * @param savePath
	 * @throws IOException
	 */
	public static byte[] downLoadFromUrl(String urlStr, String fileName, String savePath)
	{
		byte[] getData;
		URL    url;
		try
		{


			url = new URL(urlStr);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			//设置超时间为3秒
			conn.setConnectTimeout(3 * 1000);
			//防止屏蔽程序抓取而返回403错误
			conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

			//得到输入流
			InputStream inputStream = conn.getInputStream();
			//获取自己数组
			getData = readInputStream(inputStream);


			if (savePath != null)
			{
				//文件保存位置
				File saveDir = new File(savePath);
				if (!saveDir.exists())
				{
					saveDir.mkdir();
				}
				File             file = new File(saveDir + File.separator + fileName);
				FileOutputStream fos  = new FileOutputStream(file);
				fos.write(getData);
				if (fos != null)
				{
					fos.close();
				}
				if (inputStream != null)
				{
					inputStream.close();
				}
				return null;
			}
		} catch (Exception e)
		{
			return null;

		}

		System.out.println("info:" + url + " download success");
		return getData;

	}

	/**
	 * 从输入流中获取字节数组
	 *
	 * @param inputStream
	 * @return
	 * @throws IOException
	 */
	public static byte[] readInputStream(InputStream inputStream) throws IOException
	{
		byte[]                buffer = new byte[1024];
		int                   len    = 0;
		ByteArrayOutputStream bos    = new ByteArrayOutputStream();
		while ((len = inputStream.read(buffer)) != -1)
		{
			bos.write(buffer, 0, len);
		}
		bos.close();
		return bos.toByteArray();
	}

	public static void main(String[] args)
	{
		try
		{
			downLoadFromUrl("https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=gQGH8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyZnZMVVpjQ0tmbTExMDAwMHcwN20AAgSzJGtYAwQAAAAA", "百度1.jpg", "/Users/lixiao/Desktop/");
		} catch (Exception e)
		{
			// TODO: handle exception
		}
	}

}
