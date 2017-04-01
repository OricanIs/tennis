package com.tennis.handler.wechat;

import com.tennis.util.common.CommonUtil;
import com.tennis.constant.wechat.WechatConfig;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import java.util.Date;

/**
 * Created by Lixiao on 11/26/2015.
 */
public class AccessTokenHandler {
    public static String access_token;
    public static long refreshtoken;

    /**
     * 获取凭证access_token
     * @return
     */
    public static String getAccessToken() {
        if ("".equals(access_token)||null==access_token) {// 如果为空直接获取
            return getTokenReal();
        }

        if (tokenIsExpire()) {// 如果过期重新获取
            return getTokenReal();
        }
        return access_token;
    }

    /**
     * 实际获取access_token的方法
     * @return
     */
    protected static String getTokenReal() {
        String requestUrl = WechatConfig.TOKENURL + "?grant_type=" + WechatConfig.GRANT_TYPE + "&appid="
                + WechatConfig.APP_ID + "&secret=" + WechatConfig.APP_SECRET;
        //JsonObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
        // 发起GET请求获取凭证
        JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
        if (null != jsonObject) {
            try {
                access_token = jsonObject.getString("access_token");
            } catch (JSONException e) {
                access_token = null;
                // 获取token失败
            }
        }
        return access_token;
    }

    /**
     * 判断传递过来的参数access_token是否过期
     * @return
     */
    private  static boolean tokenIsExpire() {
        boolean flag = false;
            Date date = new Date();
            long latdate = date.getTime();
            if(latdate-refreshtoken>7000000){
                refreshtoken = latdate;
            }else{
                flag=true;
            }
        return flag;
    }


}
