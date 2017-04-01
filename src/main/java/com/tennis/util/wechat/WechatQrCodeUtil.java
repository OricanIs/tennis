package com.tennis.util.wechat;

import com.tennis.model.wechat.QrBaseModel;
import com.tennis.util.common.CommonUtil;

import net.sf.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

import static com.tennis.constant.oss.OssConfig.aliyun_oss_bluck_name;
import static com.tennis.constant.wechat.WechatConfig.QRCODE_URL;
import static com.tennis.constant.wechat.WechatConfig.SHOW_CODE;
import static com.tennis.util.common.http.DownloadFileUtil.downLoadFromUrl;
import static com.tennis.util.common.oss.OssUtil.saveBytesToAliyunOss;

/**
 * All rights Reserved, Designed By  lixiao
 * Copyright (c) 2017 by Shanghai lixiao
 *
 * @PROJECT_NAME: quchiba
 * @author: lixiao
 * @version: V1.0
 * @Date: 2017/1/3
 * @Description:
 */
public class WechatQrCodeUtil
{
	public static QrBaseModel structQrPostParam(int qrStyle, String strSceneId)
	{
		Map<String, Map>    param       = new HashMap<String, Map>();
		Map<String, String> childParam  = new HashMap<String, String>();
		QrBaseModel         qrBaseModel = new QrBaseModel();
		qrBaseModel.setExpire_seconds(604800);
		if (qrStyle == 0)
		{
			childParam.put("scene_id", strSceneId);
			qrBaseModel.setAction_name("QR_SCENE");
		}
		else
		{
			childParam.put("scene_str", strSceneId);
			qrBaseModel.setAction_name("QR_LIMIT_STR_SCENE");
		}


		param.put("scene", childParam);
		qrBaseModel.setAction_info(param);

		return qrBaseModel;
	}

	/**
	 * 获取ticket
	 *
	 * @param qrBaseModel 菜单实例
	 * @param accessToken 凭证
	 * @return true成功 false失败
	 */
	public static boolean getQrTicket(QrBaseModel qrBaseModel, String accessToken)
	{
		boolean result = false;
		String  url    = QRCODE_URL.replace("TOKEN", accessToken);
		// 将菜单对象转换成json字符串
		String jsonMenu = JSONObject.fromObject(qrBaseModel).toString();
		// 发起POST请求创建菜单
		JSONObject jsonObject = CommonUtil.httpsRequest(url, "POST", jsonMenu);

		System.out.println(jsonObject);

		return result;
	}

	/**
	 * 换取二维码
	 *
	 * @param ticket
	 */
	public static void exchangeQrCodeImage(String ticket)
	{
		String url = SHOW_CODE.replace("TICKET", ticket);

//		System.out.println(url);
//
		byte[] streamBytes = downLoadFromUrl(url, "百度1.jpg", null);
//
//		System.out.println(streamBytes);

		ByteArrayInputStream input = new ByteArrayInputStream(streamBytes);

		saveBytesToAliyunOss(aliyun_oss_bluck_name, "nihao1.jpeg", input);


	}

	public static void main(String[] args)
	{
		//		QrBaseModel qrBaseModel = structQrPostParam(1, "12");
		//
		//
		//
		//		System.out.println(JSONObject.fromObject(qrBaseModel).toString());
		//
		//		// 调用接口获取凭证
		//		Token token = getToken(WechatConfig.APP_ID, WechatConfig.APP_SECRET);
		//
		//		if (null != token)
		//		{
		//			// 创建菜单
		//			boolean result = getQrTicket(qrBaseModel,token.getAccessToken());
		//			// 判断菜单创建结果
		//			if (result)
		//				System.out.println("成功");
		//			else
		//			{
		//				System.out.println("创建失败");
		//			}
		//		}

		String ticket = "gQGH8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyZnZMVVpjQ0tmbTExMDAwMHcwN20AAgSzJGtYAwQAAAAA";

		exchangeQrCodeImage(ticket);


	}


}
