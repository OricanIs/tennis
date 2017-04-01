package com.tennis.model.wechat;


import com.tennis.constant.wechat.WechatConfig;
import com.tennis.handler.wechat.Token;
import com.tennis.util.wechat.MenuUtil;

import java.io.UnsupportedEncodingException;

import static com.tennis.util.wechat.WechatCommonUtil.getRedirectUrlEncode;
import static com.tennis.util.wechat.WechatCommonUtil.getToken;


public class MenuManager
{

	/**
	 * 定义菜单结构
	 *
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private static Menu getMenu() throws UnsupportedEncodingException
	{

		String     URL     = "http://www.swying.com/user/weixinIndex.action";
		String     shopUrl = getRedirectUrlEncode(URL);
		ViewButton btn11   = new ViewButton();
		btn11.setName("商城中心");
		btn11.setType("view");
		btn11.setUrl(shopUrl);
	   /* ViewButton btn12 = new ViewButton();
        btn12.setName("卖书");
        btn12.setType("view");
        btn12.setUrl("http://mp.weixin.qq.com/s?__biz=MzI1MjA4ODU1MA==&mid=402766205&idx=1&sn=5e76f3d398dc40516e232294fe674aba#rd");*/
		ViewButton btn21 = new ViewButton();
		URL = "http://www.swying.com/user/weixinCart.action";
		shopUrl = getRedirectUrlEncode(URL);
		btn21.setName("我的购物车");
		btn21.setType("view");
		btn21.setUrl(shopUrl);
		ViewButton btn22 = new ViewButton();
		URL = "http://www.swying.com/user/weixinOrder.action";
		shopUrl = getRedirectUrlEncode(URL);
		System.out.println(shopUrl);
		btn22.setName("我的订单");
		btn22.setType("view");
		btn22.setUrl(shopUrl);

		ComplexButton mainBtn1 = new ComplexButton();
		mainBtn1.setName("商城中心");
		ComplexButton mainBtn2 = new ComplexButton();
		mainBtn2.setName("个人中心");
		mainBtn2.setSub_button(new Button[]{btn21, btn22});
		Menu menu = new Menu();
		menu.setButton(new Button[]{btn11, btn21, btn22});

		return menu;
	}

	public static void main(String[] args) throws UnsupportedEncodingException
	{

		// 第三方用户唯一凭证
		String appId = WechatConfig.APP_ID;
		// 第三方用户唯一凭证密钥
		String appSecret = WechatConfig.APP_SECRET;

		// 调用接口获取凭证
		Token token = getToken(appId, appSecret);

		if (null != token)
		{
			// 创建菜单
			boolean result = MenuUtil.createMenu(getMenu(), token.getAccessToken());
			String  menu   = MenuUtil.getMenu(token.getAccessToken());
			// 判断菜单创建结果
			if (result)
				System.out.println("成功");
			else
			{
				System.out.println("创建失败");
			}
		}
	}
}
