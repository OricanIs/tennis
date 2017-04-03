import com.tennis.model.wechat.OpenidModel;
import com.tennis.util.wechat.WechatCommonUtil;

import org.junit.Test;

/**
 * All rights Reserved, Designed By  lixiao
 * Copyright (c) 2017 by Shanghai lixiao
 *
 * @PROJECT_NAME: tennis
 * @author: lixiao
 * @version: V1.0
 * @Date: 2017/4/3
 * @Description:
 */
public class OpenidTest
{
	@Test
	public void accessOpenid(){
		OpenidModel model =WechatCommonUtil.getOpenId("001HAddX0BaQuZ19npbX0mnsdX0HAddi");
		System.out.println(model==null);
		if(model!=null){
			System.out.println(model);
		}
	}

}
