package com.tennis.handler.wechat;


/**
 * Created by Lixiao on 11/26/2015.
 */
public class WechatCommon {

//
//    public static void sellerAnnounce(Order order){
//        TemplateMessage templateMessage = new TemplateMessage();
//        templateMessage.setUrl("http://www.swying.com/user/sellerOrderDetailPage.action?id="+order.getId());
//        templateMessage.setTouser("os_ngsxVWj3xJvKOZuUPPevhWGTE");
//        templateMessage.setTemplate_id("C5Yy5wm3-Y8_1MR2ImbpYNcjccn3Dksdwdc03nN2ro4");
//        Map<String,TemplateData> m = new HashMap<String,TemplateData>();
//        TemplateData first = new TemplateData();
//        first.setColor("#c91623");
//        first.setValue("您有新的订单要处理,请及时处理");
//        TemplateData keyword1 = new TemplateData();
//        keyword1.setColor("#173177");
//        keyword1.setValue(CommonUtil.getDate());
//        TemplateData keyword2 = new TemplateData();
//        keyword2.setColor("#173177");
//        keyword2.setValue(order.getId() + "");
//        TemplateData keyword3 = new TemplateData();
//        keyword3.setColor("#173177");
//        keyword3.setValue("宅文体");
//        TemplateData keyword4 = new TemplateData();
//        keyword4.setColor("#173177");
//        keyword4.setValue(order.getName());
//        TemplateData keyword5 = new TemplateData();
//        keyword5.setColor("#173177");
//        keyword5.setValue(order.getTel());
//        TemplateData remark = new TemplateData();
//        remark.setColor("#173177");
//        remark.setValue("总价:"+order.getTotalFee());
//        m.put("first", first);
//        m.put("keyword1", keyword1);
//        m.put("keyword2", keyword2);
//        m.put("keyword3", keyword3);
//        m.put("keyword4", keyword4);
//        m.put("keyword5", keyword5);
//        m.put("remark", remark);
//        templateMessage.setData(m);
//        String templage_message = JSONObject.fromObject(templateMessage).toString();
//        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
//        url = url.replace("ACCESS_TOKEN",AccessTokenHandler.getAccessToken());
//        JSONObject jsonObject = CommonUtil.httpsRequest(url, "POST", templage_message);
//        if(!jsonObject.get("errcode").toString().equals("0")){
//            SendMessage.getRequest2();
//        }
//    }

}
