package com.tennis.util.wechat;

import com.tennis.constant.wechat.WechatConfig;
import com.tennis.handler.wechat.OAuthToken;
import com.tennis.handler.wechat.Token;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import static com.tennis.util.common.CommonUtil.httpsRequest;

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
public class WechatCommonUtil
{
	// 凭证获取（GET）
	public final static String token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

	public final static  String requestMethodGet  = "GET";
	public final static  String requestMethodPost = "POST";
	//购书宝appid
	private final static String APPID             = WechatConfig.APP_ID;
	public static final  String DEF_CHATSET       = "UTF-8";
	public static final  int    DEF_CONN_TIMEOUT  = 30000;
	public static final  int    DEF_READ_TIMEOUT  = 30000;
	public static        String userAgent         = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";


	/**
	 * 获取接口访问凭证
	 *
	 * @param appid     凭证
	 * @param appsecret 密钥
	 * @return
	 */
	public static Token getToken(String appid, String appsecret)
	{
		Token  token      = null;
		String requestUrl = token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
		// 发起GET请求获取凭证
		JSONObject jsonObject = httpsRequest(requestUrl, requestMethodGet, null);

		System.out.println(jsonObject);
		if (null != jsonObject)
		{
			try
			{
				token = new Token();
				token.setAccessToken(jsonObject.getString("access_token"));
				token.setExpiresIn(jsonObject.getInt("expires_in"));
			} catch (JSONException e)
			{
				token = null;
				// 获取token失败
			}
		}
		return token;
	}


	//OAuth2.0网页授权
	public static String getOpenId(String appId, String secret, String code)
	{
		OAuthToken oAuthToken = null;
		String     requestUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
		requestUrl = requestUrl.replaceAll("APPID", appId).replace("SECRET", secret).replace("CODE", code);

		JSONObject jsonObject = httpsRequest(requestUrl, requestMethodGet, null);
		String     openId     = jsonObject.getString("openid");

		return openId;

	}

	//OAuth2.0网页授权获得用户基本信息
	public static OAuthToken getUserInfo(String accessToken, String openId)
	{
		String     requestUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
		String     url        = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
		JSONObject jsonObject = httpsRequest(url, requestMethodGet, null);
		OAuthToken authToken  = new OAuthToken();
		authToken.setOpenId(openId);
		authToken.setHeadUrl(jsonObject.getString("headimgurl"));
		authToken.setNickName(jsonObject.getString("nickname"));
		authToken.setSex(jsonObject.getInt("sex"));
		authToken.setAddr(jsonObject.getString("province") + jsonObject.getString("city"));
		return authToken;
	}

	//获得redirect_url
	public static String getRedirectUrlEncode(String redirectUrl) throws UnsupportedEncodingException
	{
		String url      = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=snsapi_base&state=123#wechat_redirect";
		String URL      = redirectUrl;
		String ENCODING = "utf-8";
		String strURL1  = URLEncoder.encode(URL, ENCODING).replace("*", "*").replace("~", "~").replace("+", " ");
		url = url.replace("REDIRECT_URI", strURL1);
		url = url.replace("APPID", APPID);
		return url;

	}

	//获得调用jssdk的Ticket
	public synchronized static String getJssdkTicket(String accessToken)
	{
		String ticket     = "";
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
		JSONObject jsonObject = httpsRequest(requestUrl, requestMethodGet, null);
		if (null != jsonObject)
		{
			try
			{
				ticket = jsonObject.getString("ticket");
			} catch (JSONException e)
			{
				ticket = null;
			}
		}
		return ticket;
	}

	public static boolean parseHttpRequestResult(JSONObject jsonObject)
	{
		boolean result = false;

		if (null != jsonObject)
		{
			int errorCode = jsonObject.getInt("errcode");
			if (0 == errorCode)
			{
				result = true;
			}
			else
			{
				result = false;
			}
		}

		return result;

	}

}
