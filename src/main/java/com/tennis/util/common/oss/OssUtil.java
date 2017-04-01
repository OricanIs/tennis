package com.tennis.util.common.oss;

import com.aliyun.oss.OSSClient;
import com.tennis.constant.oss.OssConfig;

import java.io.ByteArrayInputStream;
import java.io.File;


/**
 * All rights Reserved, Designed By  lixiao
 * Copyright (c) 2016 by Shanghai lixiao
 *
 * @PROJECT_NAME: viewlife
 * @author: lixiao
 * @version: V1.0
 * @Date: 2016/12/21
 * @Description: 对象存储工具包
 */
public class OssUtil
{


	/**
	 * 保存文件
	 *
	 * @param strBucketName
	 * @param strFileName
	 * @param file
	 * @return
	 */
	public static boolean saveFileToAliyunOss(String strBucketName, String strFileName, File file)
	{


		return saveObject(strBucketName, strFileName, file);
	}

	/**
	 * 保存文件
	 *
	 * @param strBucketName
	 * @param strFileName
	 * @param bytes
	 * @return
	 */
	public static boolean saveBytesToAliyunOss(String strBucketName, String strFileName, ByteArrayInputStream bytes)
	{

		OSSClient ossClient = OssConfig.getAliyunClient();

		ossClient.putObject(strBucketName, strFileName, bytes);

		return true;

	}

	/**
	 * 保存文件 -->含文件夹
	 *
	 * @param strBucketName
	 * @param strFolder
	 * @param strFileName
	 * @param file
	 * @return
	 */
	public static boolean saveFileToAliyunOssWithFolder(String strBucketName, String strFolder, String strFileName, File file)
	{

		String strFolderAndFileName = strFolder + "/" + strFileName;

		return saveObject(strBucketName, strFolderAndFileName, file);
	}


	/**
	 * 保存文件 -->存储阿里云Oss服务器上
	 *
	 * @param strBucketName
	 * @param strFolderAndFileName
	 * @param file
	 * @return
	 */
	private static boolean saveObject(String strBucketName, String strFolderAndFileName, File file)
	{

		OSSClient ossClient = OssConfig.getAliyunClient();
		ossClient.putObject(strBucketName, strFolderAndFileName, file);

		return true;
	}

}
