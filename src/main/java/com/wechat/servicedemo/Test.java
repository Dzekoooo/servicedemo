package com.wechat.servicedemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wechat.servicedemo.entity.AccessToken;
import com.wechat.servicedemo.entity.TemplateData;
import com.wechat.servicedemo.entity.WxTemplate;
import com.wechat.servicedemo.util.GetAccessTokenUtil;
import com.wechat.servicedemo.util.InfoUtil;
import com.wechat.servicedemo.util.TokenThread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Test {

    private static String SEND_MESSAGE_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";

    public static void main(String[] args) {
        AccessToken token = null;

        //获取access_token
//        if (null == TokenThread.accessToken || "".equals(TokenThread.accessToken.getAccessToken())) {
//            token = GetAccessTokenUtil.getAccessToken(InfoUtil.APP_ID, InfoUtil.APP_SECRET);
//        } else {
//            token = TokenThread.accessToken;
//        }

        WxTemplate wxTemplate = new WxTemplate();

        Map<String, TemplateData> map = new HashMap<String, TemplateData>();
        TemplateData first = new TemplateData();
        first.setColor("#000000");
        first.setValue("你好啊欢迎你");
        map.put("first", first);

        TemplateData product = new TemplateData();
        product.setColor("#000000");
        product.setValue("大宝剑");
        map.put("product", product);

        TemplateData price = new TemplateData();
        price.setColor("#000000");
        price.setValue("100$");
        map.put("price", price);

        TemplateData time = new TemplateData();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        time.setColor("#000000");
        time.setValue(df.format(new Date()));
        map.put("time", time);

        TemplateData remark = new TemplateData();
        remark.setColor("#000000");
        remark.setValue("欢迎下次再来");
        map.put("remark", remark);

        wxTemplate.setTouser("o3tk61V1Okg754B3baaJdIbDY9h8");
        wxTemplate.setTopcolor("#000000");
        wxTemplate.setTemplate_id("YqZFokb3hxUuo72zCiGny4D0QuPNqVPdWa4tG-FDad8");
        wxTemplate.setData(map);

        String jsonstr = JSON.toJSONString(wxTemplate);
        System.out.println("jsonstr = " + jsonstr);



        //获取access_token
        if (null == TokenThread.accessToken || "".equals(TokenThread.accessToken.getAccessToken())) {
            token = GetAccessTokenUtil.getAccessToken(InfoUtil.APP_ID, InfoUtil.APP_SECRET);
        } else {
            token = TokenThread.accessToken;
        }

        String url = SEND_MESSAGE_URL.replace("ACCESS_TOKEN", token.getAccessToken()).replace(" ", "");
        System.out.println("url = " + url);

    }
}
