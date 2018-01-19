package com.wechat.servicedemo.util;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.wechat.servicedemo.entity.AccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
*@Author: ZhangZhe
*@Description       获取access_token工具类
*@Date: 2018/1/19
*/
public class GetAccessTokenUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(GetAccessTokenUtil.class);

    private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    public static AccessToken getAccessToken(String appId, String appSecret) {
        AccessToken accessToken = null;
        String requestUrl = ACCESS_TOKEN_URL.replace("APPID", appId).replace("APPSECRET", appSecret).replace(" ", "");
        JSONObject jsonObject = OkHttpUtil.httpGet(requestUrl);
        // 如果请求成功
        if (null != jsonObject) {
            try {
                accessToken = new AccessToken();
                accessToken.setAccessToken(jsonObject.getString("access_token"));
                accessToken.setExpiresin(jsonObject.getInteger("expires_in"));
            } catch (JSONException e) {
                accessToken = null;
                // 获取token失败
                LOGGER.error("获取token失败 errcode:{} errmsg:{}", jsonObject.getInteger("errcode"), jsonObject.getString("errmsg"));
            }
        }
        return accessToken;
    }


}
