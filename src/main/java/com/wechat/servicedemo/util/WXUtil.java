package com.wechat.servicedemo.util;

import com.wechat.servicedemo.entity.AccessToken;
import com.wechat.servicedemo.entity.TemplateData;
import com.wechat.servicedemo.entity.WxTemplate;

import java.util.Map;

/**
*@Author: ZhangZhe
*@Description
*@Date: 2018/1/19
*/
public class WXUtil {
    public static void sendMessage(String template_id, WxTemplate wxTemplate, Map<String, TemplateData> map) {
        AccessToken token = null;

        //获取access_token
        if (null == TokenThread.accessToken || "".equals(TokenThread.accessToken.getAccessToken())) {
            token = GetAccessTokenUtil.getAccessToken(InfoUtil.APP_ID, InfoUtil.APP_SECRET);
        } else {
            token = TokenThread.accessToken;
        }

        int result = 0;

    }


}
