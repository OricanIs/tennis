package com.tennis.action.app;

import com.opensymphony.xwork2.ActionSupport;
import com.tennis.constant.oss.OssConfig;
import com.tennis.em.EM_GLOBAL_RESULT;
import com.tennis.util.common.DateUtil;
import com.tennis.util.common.RandomUtil;

import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.util.Date;

import static com.tennis.util.common.HttpPrintWriter.responseWrite;
import static com.tennis.util.common.oss.OssUtil.saveFileToAliyunOssWithFolder;

/**
 * All rights Reserved, Designed By  lixiao
 * Copyright (c) 2017 by Shanghai lixiao
 *
 * @PROJECT_NAME: tennis
 * @author: lixiao
 * @version: V1.0
 * @Date: 2017/4/9
 * @Description:
 */
public class UploadAction extends ActionSupport
{
	private File                file;//对应的就是表单中文件上传的那个输入域的名称
	private String              fileFileName;          //上传输入域FileName文件名
	private String              fileContentType;       //上传文件的MIME类型
	private EM_GLOBAL_RESULT SuccessEM = EM_GLOBAL_RESULT.getEmByCode(0);
	private String openid;
	public void setOpenid(String openid)
	{
		this.openid = openid;
	}


	@Override
	public String execute() throws Exception
	{
		String strUrl;


		strUrl = saveObject(file, fileContentType);
		if (strUrl != null)
		{
			responseWrite(ServletActionContext.getResponse(), SuccessEM, strUrl);
		}
		else
		{
			responseWrite(ServletActionContext.getResponse(), EM_GLOBAL_RESULT.getEmByCode(10010), null);

		}

		return SUCCESS;


	}

	//保存图片方法
	private String saveObject(File file, String strFileContentType)
	{
		String strFileType;
		String strFolder = "";
		String strName;
		String strUrl    = OssConfig.aliyun_self_domain;


		//获取图片的类型
		strFileType = getFileType(strFileContentType);
		//检验图片的大小及图片类型是否符合规格
		if (validateImageSize(file))
		{
			strFolder = OssConfig.aliyun_oss_root_path;
			strName =  DateUtil.DateToTimestamp(new Date())+ RandomUtil.genRandomNum(4) + strFileType;

			strUrl += "/"+strFolder + "/" + strName;

			try
			{
				//如果符合规格，上传图片到oss服务器
				saveFileToAliyunOssWithFolder(OssConfig.aliyun_oss_bluck_name, strFolder, strName, file);

				return strUrl;
			} catch (Exception e)
			{
				System.out.println("出错了");
				System.out.println(e);
				return null;
			}

		}

		return null;

	}

	/**
	 * 校验图片的大小
	 *
	 * @param file
	 * @return
	 */
	private boolean validateImageSize(File file)
	{
		//文件的最大成都
		long nMaxSize = 5000000;

		if (file.length() >= nMaxSize){
			System.out.println("文件太大了");
			return false;
		}



		return true;

	}

	/**
	 * 获取文件类型
	 *
	 * @param strFileContentType
	 * @return
	 */
	private String getFileType(String strFileContentType)
	{


		String strType = null;

		if (strFileContentType == null)
			return strType;

		strFileContentType = strFileContentType.trim();

		//匹配类型

		if (strFileContentType.equals("image/jpeg"))
		{

			strType = ".jpg";

		}
		else if (strFileContentType.equals("image/png"))
		{

			strType = ".png";

		}

		return strType;


	}


	public void setFile(File file)
	{
		this.file = file;
	}

	public void setFileFileName(String fileFileName)
	{
		this.fileFileName = fileFileName;
	}

	public void setFileContentType(String fileContentType)
	{
		this.fileContentType = fileContentType;
	}


}
