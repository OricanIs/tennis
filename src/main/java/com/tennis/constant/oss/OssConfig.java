package com.tennis.constant.oss;

import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.OSSClient;

/**
 * All rights Reserved, Designed By  lixiao
 * Copyright (c) 2016 by Shanghai lixiao
 *
 * @PROJECT_NAME: viewlife
 * @author: lixiao
 * @version: V1.0
 * @Date: 2016/12/21
 * @Description:
 */
public class OssConfig
{
	private static OSSClient           aliyunOssClient;
	private static ClientConfiguration aliyunClientConf;
	// endpoint以杭州为例，其它region请按实际情况填写
	public static final String aliyun_oss_endpoint          = "http://oss-cn-hangzhou.aliyuncs.com";

	public static final String aliyun_self_domain = "http://muxu.oss-cn-hangzhou.aliyuncs.com";
	//接入阿里云 oss钥匙的id
	public static final String aliyun_oss_access_key_id     = "LTAIXPuMSstHYX5d";
	//接入阿里云 oss钥匙的密码
	public static final String aliyun_oss_access_key_secret = "lhtcoqwnChIGfDg98u1EGfUGLwAMzf";

	//
	public static final String aliyun_oss_bluck_name = "muxu";

	//图片根路径
	public static final String aliyun_oss_root_path = "images";

	// 创建ClientConfiguration实例，按照您的需要修改默认参数
	private static ClientConfiguration getAliyunClientConf()
	{

		if (aliyunClientConf == null)
		{
			aliyunClientConf = new ClientConfiguration();
			aliyunClientConf.setSupportCname(true);
			// 设置OSSClient使用的最大连接数，默认1024
			aliyunClientConf.setMaxConnections(200);
			// 设置请求超时时间，默认50秒
			aliyunClientConf.setSocketTimeout(10000);
			// 设置失败请求重试次数，默认3次
			aliyunClientConf.setMaxErrorRetry(5);

		}


		return aliyunClientConf;

	}

	//获取ossClient实例
	public static OSSClient getAliyunClient()
	{
		if (aliyunOssClient == null)
		{
			aliyunOssClient = new OSSClient(aliyun_oss_endpoint, aliyun_oss_access_key_id, aliyun_oss_access_key_secret, getAliyunClientConf());

		}

		return aliyunOssClient;
	}


}
